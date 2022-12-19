package beans;

import byn.Byn;
import byn.Rounding;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    Byn bynDiscount = new Byn(0);
    private final Product product;
    private int numbers;

    public Purchase() {
        this.product = null;
    }

    public Purchase(Product product, int numbers) {
        this.product = product;
        this.numbers = numbers;
    }

    public Product getProduct() {
        return product;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public Byn getBynDiscount() {
        return bynDiscount;
    }

    public void setBynDiscount(Byn bynDiscount) {
        this.bynDiscount = bynDiscount;
    }

    public Byn getCost() {//возвращает стоимость товара и стоимость скидки, если товар дисконтный
        //Cost cost = new Cost();

        List<Byn> costAndCostDiscount = new ArrayList<>();
        Byn byn = new Byn(product.getPrice()).mul(numbers);
       // cost.setCost(byn);
//        costAndCostDiscount.add(byn);
        if (numbers > 5 && product.isPromotionalItem()) {
            byn = new Byn(product.getPrice().mul(numbers).mul(0.9, Rounding.ROUND, 0));//!!!!проверить
            bynDiscount = new Byn(product.getPrice().mul(numbers).mul(0.1, Rounding.ROUND, 0));
        }
        return byn;
    }

    public String discount() {
        String discount = "";
        if (product.isPromotionalItem() && numbers > 5) {
            discount = "(" + bynDiscount + " discount purchase)";
        }
        return discount;
    }



    @Override
    public String toString() {
        return numbers + "  " + product.getName() + "  " +
                product.getPrice() + "  " + getCost() + "  " +  " " + discount();
    }
}







