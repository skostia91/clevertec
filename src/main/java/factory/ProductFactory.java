package factory;

import beans.Product;
import byn.Byn;
import exception.CSVLineException;


public class ProductFactory {
    public static Product createProduct(String filesLine) throws CSVLineException {
        String[] stringsFromFile = filesLine.split(";");
        Product product = null;

        try {
            int id = Integer.parseInt(stringsFromFile[0]);
            String name = stringsFromFile[1];
            Byn price = new Byn(Integer.parseInt(stringsFromFile[2]));
            boolean discount = false;
            if (Integer.parseInt(stringsFromFile[3]) == 1) {
                discount = true;
            }
            product = new Product(id, name, price, discount);
        } catch(RuntimeException e) {
        throw new CSVLineException(e, filesLine);
        }   return product;
    }
}