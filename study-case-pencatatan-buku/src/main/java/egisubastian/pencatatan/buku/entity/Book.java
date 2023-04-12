package egisubastian.pencatatan.buku.entity;

public class Book {

    // Atribut
    private Integer id;
    private String title;
    private String author;
    private Integer year;

    // Constructor
    public Book() {
    }

    public Book(Integer id, String title, String author, Integer year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getter
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    // Setter
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}