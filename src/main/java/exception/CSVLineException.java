package exception;

public class CSVLineException extends Exception {
    private String csvLine;

    public CSVLineException(Exception exception, String csvLine) {
        super(exception);
        this.csvLine = csvLine;
    }

    public CSVLineException(String cause, String csvLine) {
        super(cause);
        this.csvLine = csvLine;
    }

    @Override
    public String toString() {
        return csvLine + ";" + getMessage();
    }
}
