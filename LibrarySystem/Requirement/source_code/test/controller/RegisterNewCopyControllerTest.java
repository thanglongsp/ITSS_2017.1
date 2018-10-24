/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Copy;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pnam2
 */
public class RegisterNewCopyControllerTest {
    
    public RegisterNewCopyControllerTest() {
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
     * Test of getAllCopies method, of class RegisterNewCopyController.
     */
    @Test
    public void testGetAllCopies() throws Exception {
        System.out.println("getAllCopies");
        RegisterNewCopyController instance = new RegisterNewCopyController();
        List<Copy> expResult = null;
        List<Copy> result = instance.getAllCopies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerNewCopy method, of class RegisterNewCopyController.
     */
    @Test
    public void testRegisterNewCopy() throws Exception {
        System.out.println("registerNewCopy");
        String bookNumber = "";
        int typeOfCopy = 0;
        float price = 0.0F;
        RegisterNewCopyController instance = new RegisterNewCopyController();
        int expResult = 0;
        int result = instance.registerNewCopy(bookNumber, typeOfCopy, price);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
