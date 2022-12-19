package factory;

import exception.CSVLineException;
import exception.NonPositiveArgsException;
import util.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DiscountCardFactory {
    public static int discountStringFactory(String line) throws CSVLineException {
        Map<Integer, Integer> map = new HashMap<>();
        int numberCardPurchase = Integer.parseInt(line);
        int numberCard = 0;
        int discount = 0;
        int discountReturn = 0;

        try (Scanner scanner = new Scanner(new File(Constants.nameFileWhereDiscountCards))) {
            while (scanner.hasNext()) {
                try {
                    numberCard = scanner.nextInt();//номер карты будет ключом
                    discount = scanner.nextInt();//скидка, будет значением
                    if (numberCard < 0 || discount < 0) {
                        throw new NonPositiveArgsException();
                    }
                    map.put(numberCard, discount);//вот у нас маленькая бд в мапе с ключом по номеру карты
                } catch (NumberFormatException e) {
                    throw new CSVLineException(Constants.errorNumberCard, line);
                }
            }
            //2. достаём из нашей бд скидку и возвращаем
            if (!map.containsKey(numberCardPurchase)) {
                System.err.println("card is not found");
            } else {
                discountReturn = map.get(numberCardPurchase);
            }
        } catch (FileNotFoundException e) {
            System.err.println(Constants.errorFileNotFound + " " + Constants.nameFileWhereDiscountCards);
        }
        return discountReturn;
    }

    public static int discountStringFactory(String line, String fileName) throws CSVLineException {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("line" + line);

        int numberCardPurchase = Integer.parseInt(line);
        int numberCard = 0;
        int discount = 0;
        int discountReturn = 0;

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                try {
                    numberCard = scanner.nextInt();//номер карты будет ключом
                    discount = scanner.nextInt();//скидка, будет значением
                    if (numberCard < 0 || discount < 0) {
                        throw new NonPositiveArgsException();
                    }
                    map.put(numberCard, discount);//вот у нас маленькая бд в мапе с ключом по номеру карты
                } catch (NumberFormatException e) {
                    throw new CSVLineException(Constants.errorNumberCard, line);
                }
            }
            //2. достаём из нашей бд скидку и возвращаем
            if (!map.containsKey(numberCardPurchase)) {
                System.err.println("card is not found");
            } else {
                discountReturn = map.get(numberCardPurchase);
            }
        } catch (FileNotFoundException e) {
            System.err.println(Constants.errorFileNotFound + " " + Constants.nameFileWhereDiscountCards);
        }
        return discountReturn;
    }
}