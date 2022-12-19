package beans;

import byn.Byn;

public final class Product {
    private final int idItem;
    private final String name;
    private final Byn price;
    private final boolean promotionalItem;

    public Product() {
        this(0, "", null, false);
    }

    public Product(int idItem, String name, Byn price, boolean promotionalItem) {
        this.idItem = idItem;
        this.name = name;
        this.price = price;
        this.promotionalItem = promotionalItem;
    }

    public int getIdItem() {
        return idItem;
    }

    public Byn getPrice() {
        return new Byn(price);
    }

    public boolean isPromotionalItem() {
        return promotionalItem;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "beans.Product{" +
                "idItem=" + idItem +
                ", name=" + name +
                ", price=" + price +
                ", promotionalItem=" + promotionalItem +
                '}';
    }
}
