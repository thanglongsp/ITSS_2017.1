package controller;

import org.junit.AfterEach;
import org.junit.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.junit.Assert.assertEquals;


class SearchBookControllerTest {
    SearchBookController controller;
    @BeforeEach
    void setUp() {
        controller = new SearchBookController();
    }

    @AfterEach
    void tearDown() {
    }

    /**
     *
     */

    @Test
    void testSearchBooks() throws SQLException, ClassNotFoundException {
        // So ket qua tra ve voi title co tu khoa "co"
        System.out.println("search books test");
        int result = 2;
        assertEquals(result, controller.searchBooks("co").size());
    }

}