import java.util.List;

public class Book extends Model{
    private int bookNumber;
    private String title;
    private String publisher;
    private String authors;
    private String isbn;
    private List<Copy> copies;
    /**
     * Khoi tao doi tuong cua lop Book
     * @param bookNumber    ma so cua sach
     * @param title         tieu de sach
     * @param publisher     nha xuat ban sach
     * @param authors       cac tac gia cua sach
     * @param isbn          ma ISBN cua sach
     * @param copies        thong tin ve cac ban copy cua sach
     * @return              object cua lop Book
     */

    public Book(int bookNumber, String title, String publisher, String authors, String isbn, List<Copy> copies) {
        this.bookNumber = bookNumber;
        this.title = title;
        this.publisher = publisher;
        this.authors = authors;
        this.isbn = isbn;
        this.copies = copies;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }
}
