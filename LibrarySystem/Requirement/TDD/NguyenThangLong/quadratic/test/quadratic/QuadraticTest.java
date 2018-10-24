/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadratic;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thanglongsp
 */
public class QuadraticTest {
    
    public QuadraticTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Quadratic method, of class Quadratic.
     */
    @Test
    public void testQuadratic() {
        System.out.println("Quadratic");
        double a = 1;
        double b = 1;
        double c = -2;
        Quadratic instance = new Quadratic();
        instance.Quadratic(a, b, c);
    }
    
}
