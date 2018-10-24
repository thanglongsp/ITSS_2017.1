import java.sql.SQLException;
import java.util.List;

class SearchBookForm extends View {
    private String query;
    private final SearchBookController controller;

    /**
     * Khoi tao form va set controller
     */
    public SearchBookForm() {
        this.controller = new SearchBookController();
    }

    /**
     * Hien thi form tim kiem sach
     */
    void draw() {
        Form form = new Form();
        form.addField("Keyword", query);
        form.display();
        Button btn = new Button("Search");
        btn.display();
    }

    /**
     * Hien thi thong tin cua tung cuon sach
     *
     * @param books cuon sach can duoc hien thi thong tin
     */
    void displayBookInformation(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            display(books.get(i).getBookNumber());
            display(books.get(i).getTitle());
            display(books.get(i).getAuthors());
            display(books.get(i).getPublisher());
            display(books.get(i).getIsbn());
        }
    }

    /**
     * Tim kiem sach
     */

    void searchBooks() {
        //Kiem tra xem truong du lieu da duoc nhap chua, neu chua thi hien thi thong bao loi
        if (!controller.checkInputField()) {
            displayErrorMessage("Input required.");
            return;
        }
        try {
            // Neu khong tim thay sach, hien thi thong bao khong co sach
            List<Book> books = controller.searchBooksFromDb(query);
            if (books == null || books.size() == 0) {
                displayErrorMessage("Book not found.");
            }
            // Neu tim thay sach thi hien thi thong tin tung cuon
            else {
                displayBookInformation(books);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}