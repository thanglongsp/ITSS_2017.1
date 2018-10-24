/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Book;
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
public class RegisterNewBookControllerTest {
    
    public RegisterNewBookControllerTest() {
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
     * Test of getAllBooks method, of class RegisterNewBookController.
     */
    @Test
    public void testGetAllBooks() throws Exception {
        System.out.println("getAllBooks");
        RegisterNewBookController instance = new RegisterNewBookController();
        List<Book> expResult = null;
        List<Book> result = instance.getAllBooks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkBook method, of class RegisterNewBookController.
     */
    @Test
    public void testCheckBook() throws Exception {
        System.out.println("checkBook");
        String bookNumber = "";
        RegisterNewBookController instance = new RegisterNewBookController();
        String expResult = "";
        String result = instance.checkBook(bookNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerNewBooks method, of class RegisterNewBookController.
     */
    @Test
    public void testRegisterNewBooks() throws Exception {
        System.out.println("registerNewBooks");
        String bookNumber = "";
        String title = "";
        String publisher = "";
        String authors = "";
        String isbn = "";
        RegisterNewBookController instance = new RegisterNewBookController();
        int expResult = 0;
        int result = instance.registerNewBooks(bookNumber, title, publisher, authors, isbn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
