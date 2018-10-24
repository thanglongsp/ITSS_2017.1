package controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.junit.Assert.assertEquals;

class UpdateBorrowedBookInfoControllerTest {
    UpdateBorrowedBookInfoController controller;
    @BeforeEach
    void setUp() {
        controller = new UpdateBorrowedBookInfoController();
    }

    @AfterEach
    void tearDown() {
    }

    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Test
    void testUpdateState() throws SQLException, ClassNotFoundException {
        //So dong bi anh huong boi update
        System.out.println("Update state test");
        int result = 1;
        assertEquals(controller.updateState(1, "it9999", 1), result);
    }

}