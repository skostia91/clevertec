package beans;

import exception.CSVLineException;
import factory.ProductFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductList {
    private List<Product> productList;

    public ProductList() {
        this.productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "beans.ProductList{" +
                "productList=" + productList +
                '}';
    }

    public ProductList(String file) {
        final String PACKAGE = "src/main/resources/";
        final String EXT = ".txt";
        this.productList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(PACKAGE + file + EXT))) {
            while (scanner.hasNextLine()) {
                String filesLine = scanner.nextLine();
                try {
                    productList.add(ProductFactory.createProduct(filesLine));
                }
                catch (CSVLineException e) {
                    System.err.println(e);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("File " + file + " not found");
        }
    }
}
