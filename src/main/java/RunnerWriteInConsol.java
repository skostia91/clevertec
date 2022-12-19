import beans.Purchase;
import byn.*;
import exception.CSVLineException;
import factory.DiscountCardFactory;
import factory.StringFactory;
import util.Constants;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static util.Constants.*;

//передача покупок идёт через аргументы
public class RunnerWriteInConsol {
    public static void main(String[] args) {
        String string = args[0];
        String nameFileDiscountCard = args[1];

        String[] stringLine = string.split(" card-");

        List<Purchase> purchaseList = null;
        try {
            purchaseList = StringFactory.stringFactory(stringLine[0]);
        } catch (CSVLineException e) {
            System.err.println(errorStringLine);
        }

        String text = textInStartCheck;
        StringBuffer stringBuffer = new StringBuffer(text);

        SimpleDateFormat formatterData = new SimpleDateFormat(formatData);
        SimpleDateFormat formatterTime = new SimpleDateFormat(formatTime);
        Date date = new Date();
        Date time = new Date();
        stringBuffer.append("Date: " + formatterData.format(date) +
                '\n' + "Time: " + formatterTime.format(time) + textInMiddleCheck);

        Byn costAllPurchase = new Byn(0);
        Byn costAllDiscount = new Byn(0);
        Byn discountInCard = null;//скидка на карте дисконтной
        try {
            discountInCard = new Byn(DiscountCardFactory.discountStringFactory(stringLine[1], nameFileDiscountCard));

        costAllPurchase.sub(discountInCard);////вычитаем из обшей суммы скидку

        for (Purchase purchases : purchaseList) {
            costAllPurchase.add(purchases.getCost());
            costAllDiscount.add(purchases.getBynDiscount());

            stringBuffer.append(purchases.toString() + '\n');
        }
        stringBuffer.append("______________________" +
                '\n' + "Discount on product " + costAllDiscount +
                '\n' + "Discount on card    " + discountInCard + //вывело правильно
                '\n' + "Total all purchases " + costAllPurchase +
                '\n' + '\n' + "thanks for choosing us");
        System.out.println(stringBuffer);

        } catch (CSVLineException e) {
            System.err.println(Constants.errorCSVLineException);
        }
    }
}