/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author pnam2
 */
public class UpdateCopyInforControllerTest {
    
    public UpdateCopyInforControllerTest() {
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
     * Test of checkCopyNotExist method, of class UpdateCopyInforController.
     */
    @Test
    public void testCheckCopyNotExist() throws Exception {
        System.out.println("checkCopyNotExist");
        String sequence = "";
        String bookNumber = "";
        UpdateCopyInforController instance = new UpdateCopyInforController();
        String expResult = "";
        String result = instance.checkCopyNotExist(sequence, bookNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateCopyInfor method, of class UpdateCopyInforController.
     */
    @Test
    public void testUpdateCopyInfor() throws Exception {
        System.out.println("UpdateCopyInfor");
        int sequenceNumber = 0;
        String bookNumber = "";
        int typeOfCopy = 0;
        float price = 0.0F;
        int status = 0;
        UpdateCopyInforController instance = new UpdateCopyInforController();
        int expResult = 0;
        int result = instance.UpdateCopyInfor(sequenceNumber, bookNumber, typeOfCopy, price, status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
