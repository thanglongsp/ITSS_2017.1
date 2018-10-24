import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HePT2Test {
    private HePT2 test;

    @BeforeEach
    public void setUp() {
        test = new HePT2();
    }

    @Test
    public void testDetXCal() {
        double result = 3*2-4;
        assertEquals(result, test.DetXCal(1,2,3,4));
    }

    @Test
    public void testDetYCal() {
        double result = 4-3*2;
        assertEquals(result, test.DetYCal(1,2,3,4));
    }

    @Test
    public void testDetCal() {
        double result = 5*9-8*6;
        assertEquals(result, test.DetYCal(5,6,8,9));
    }

    @Test
    public void testGiaiHe() {
        double[] result = new double[]{8d/3d, 7d/9d};
        assertArrayEquals(result, test.giaiHe(1,3,5,5,6,18));
    }

}