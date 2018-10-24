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
public class UpdateBookInforControllerTest {
    
    public UpdateBookInforControllerTest() {
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
     * Test of checkBookNotExist method, of class UpdateBookInforController.
     */
    @Test
    public void testCheckBookNotExist() throws Exception {
        System.out.println("checkBookNotExist");
        String bookNumber = "";
        UpdateBookInforController instance = new UpdateBookInforController();
        String expResult = "";
        String result = instance.checkBookNotExist(bookNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateBookInfor method, of class UpdateBookInforController.
     */
    @Test
    public void testUpdateBookInfor() throws Exception {
        System.out.println("UpdateBookInfor");
        String bookNumber = "";
        String title = "";
        String authors = "";
        String publisher = "";
        int status = 0;
        String isbn = "";
        UpdateBookInforController instance = new UpdateBookInforController();
        int expResult = 0;
        int result = instance.UpdateBookInfor(bookNumber, title, authors, publisher, status, isbn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
