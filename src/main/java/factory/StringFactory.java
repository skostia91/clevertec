package factory;

import beans.Product;
import beans.ProductList;
import beans.Purchase;
import exception.CSVLineException;
import util.Constants;

import java.util.*;

public class StringFactory {
    public static List stringFactory(String line) throws CSVLineException {
        ProductList productList = new ProductList(Constants.nameFileWithAllProducts);
        List<Purchase> purchaseList = new ArrayList<>();
        try {
            String[] strings = line.split(" ");

            for (int i = 0; i < strings.length; i++) {
                String[] stringIdAndQuantity = strings[i].split("-");
                Product product = productList.getProductList().get(Integer.parseInt(stringIdAndQuantity[0]));
                int numbers = Integer.parseInt(stringIdAndQuantity[1]);
                Purchase purchase = new Purchase(product, numbers);
                purchaseList.add(purchase);
            }
            return purchaseList;
        } catch (NumberFormatException e) {
            throw new CSVLineException(Constants.errorCSVLineException, line);
        } catch(RuntimeException e) {
            throw new CSVLineException(e, line);
        }
    }
}