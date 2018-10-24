/*
 *  @author: Trịnh Thiên Long
 *  @created date:
 *  @last modified date:
 */
package controller;

import entity.Card;
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
public class CardControllerTest {
    
    public CardControllerTest() {
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
     * Test of initInformationForUpdate method, of class CardController.
     */
    @Test
    public void testInitInformationForUpdate() throws Exception {
        System.out.println("initInformationForUpdate");
        String cardId = "";
        CardController instance = new CardController();
        Card expResult = null;
        Card result = instance.initInformationForUpdate(cardId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeStatus method, of class CardController.
     */
    @Test
    public void testChangeStatus() throws Exception {
        System.out.println("changeStatus");
        int cardId = 0;
        int status = 0;
        CardController instance = new CardController();
        instance.changeStatus(cardId, status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CardController.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        int cardId = 0;
        String name = "";
        String expiredDateString = "";
        CardController instance = new CardController();
        int expResult = 0;
        int result = instance.update(cardId, name, expiredDateString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
