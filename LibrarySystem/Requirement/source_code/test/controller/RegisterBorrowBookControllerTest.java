/*
 *  @author: Trịnh Thiên Long
 *  @created date:
 *  @last modified date:
 */
package controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author longdragon
 */
public class RegisterBorrowBookControllerTest {
    
    public RegisterBorrowBookControllerTest() {
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
     * Test of register method, of class RegisterBorrowBookController.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        String bookNumber = "";
        RegisterBorrowBookController instance = new RegisterBorrowBookController();
        int expResult = 0;
        int result = instance.register(bookNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
