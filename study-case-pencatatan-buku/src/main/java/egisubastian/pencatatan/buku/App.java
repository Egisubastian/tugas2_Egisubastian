package egisubastian.pencatatan.buku;

import javax.sql.DataSource;

import egisubastian.pencatatan.buku.repository.BookRepository;
import egisubastian.pencatatan.buku.repository.impl.BookRepositoryImpl;
import egisubastian.pencatatan.buku.service.BookService;
import egisubastian.pencatatan.buku.service.impl.BookServiceImpl;
import egisubastian.pencatatan.buku.util.DatabaseUtil;
import egisubastian.pencatatan.buku.view.BookView;

public class App {
    public static void main(String[] args) {
        // Datasource
        DataSource dataSource = DatabaseUtil.getDataSource();

        // Set Datasource
        BookRepository bookRepository = new BookRepositoryImpl(dataSource);
        BookService bookService = new BookServiceImpl(bookRepository);

        // View
        BookView bookView = new BookView(bookService);

        // Show Menu
        bookView.showMenu();
    }
}