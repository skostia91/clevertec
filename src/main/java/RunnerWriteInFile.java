import beans.Purchase;
import byn.Byn;
import exception.CSVLineException;
import factory.DiscountCardFactory;
import factory.StringFactory;
import util.Constants;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static util.Constants.*;
import static util.Constants.formatTime;
import static util.Constants.textInMiddleCheck;

//передача данных происходит через консоль
//запись чека происходит на файл check.txt
public class RunnerWriteInFile {
    public static void main(String[] args) {
        String string;
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println(Constants.textInsertPurchase);
            string = scanner.nextLine();
        }

        String[] stringLine = string.split(" card-");

        List<Purchase> purchaseList = null;
        try {
            purchaseList = StringFactory.stringFactory(stringLine[0]);
        } catch (CSVLineException e) {
            System.err.println(errorStringLine);
        }

        try(FileWriter writer = new FileWriter(nameFileWhereCheckWrite, false)) {
            String text = textInStartCheck;

            writer.write(text);
            SimpleDateFormat formatterData = new SimpleDateFormat(formatData);
            SimpleDateFormat formatterTime = new SimpleDateFormat(formatTime);
            Date date = new Date();
            Date time = new Date();
            writer.append("Date: " + formatterData.format(date) +
                    '\n' + "Time: "  + formatterTime.format(time) + textInMiddleCheck);


            Byn costAllPurchase = new Byn(0);
            Byn costAllDiscount = new Byn(0);
            Byn discountInCard = new Byn(DiscountCardFactory.discountStringFactory(stringLine[1]));//скидка на карте дисконтной

            costAllPurchase.sub(discountInCard);////высчитаем из обшей суммы скидку

            for (Purchase purchases: purchaseList) {
                costAllPurchase.add(purchases.getCost());
                costAllDiscount.add(purchases.getBynDiscount());

                writer.append(purchases.toString() + '\n');
            }
            writer.append("______________________" +
                    '\n' + "Discount on product " + costAllDiscount +
                    '\n' + "Discount on card    " + discountInCard + //вывело правильно
                    '\n' + "Total all purchases " + costAllPurchase +
                    '\n' + '\n' +         "thanks for choosing us");
            writer.flush();
        }
        catch(IOException ex) {
            System.err.println("error");
        } catch (CSVLineException e) {
            System.err.println("incorrect line");
        }
    }
}