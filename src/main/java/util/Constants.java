package util;

public final class Constants {
    //name file
    public static final String nameFileWhereCheckWrite = "check.txt";
    public static final String nameFileWithAllProducts = "product";
    public static final String nameFileWhereDiscountCards = "src/main/resources/discount card.txt";

    //start text program
    public static final String textInsertPurchase = "INSERT itemId-quantity OR card(if its discount-card) and number this card " + '\n'
            + "example:'3-1 2-5 5-1 card-1234', where 3 - item id, 1 - quantity, 1234 - number discount card"
            + '\n' + "id - ?/quantity - ?"
            + '\n' + "if human is nave not card, push 'card-0'";

    //text in check
    public static final String textInStartCheck = "CASH RECEIPT" + '\n' + "supermarket 123" + '\n' + "12, Milkiway Galaxy/Earch" +
            '\n' + "Tel :123-456-7890" + '\n' + "CASHIER: №1520" + '\n';
    public static final String textInMiddleCheck = '\n' + "_____________________________________" +
            '\n' + "QTY  DESCRIPTION  PRICE  TOTAL" + '\n';

    //exceptions
    public static final String errorStringLine = "incorrect string";
    public static final String errorCSVLineException = "incorrect format input";
    public static final String errorNumberCard = "incorrect number card";
    public static final String errorFileNotFound = "file is not found";

    //data and time
    public static final String formatData = "dd/MM/yyyy";
    public static final String formatTime = "HH:mm:ss";
}