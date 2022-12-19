package factory;

import exception.CSVLineException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiscountCardFactoryTest {
    String x ;
    int y ;
    String empty = "";

    @Before
    public void setUp() {
        x = "3425";
        y = 3425;
    }

    @Test
    public void discountStringFactory() throws CSVLineException {
        assertEquals("value is equals", y, Integer.parseInt(x));
    }

    @Test
    public void discountStringFactory1() {
    }
}