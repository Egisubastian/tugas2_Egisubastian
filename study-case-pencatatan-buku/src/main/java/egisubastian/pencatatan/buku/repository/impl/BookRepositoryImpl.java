package egisubastian.pencatatan.buku.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import egisubastian.pencatatan.buku.entity.Book;
import egisubastian.pencatatan.buku.repository.BookRepository;

public class BookRepositoryImpl implements BookRepository {

    private DataSource dataSource;

    public BookRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Book book) {
        // Query
        String sql = "INSERT INTO book(title, author, year) VALUES (?, ?, ?)";

        // Execute / Handle Write to Database
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set Value
            // SetString(index, value)
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());

            // Execute
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book[] getAll() {
        // Query
        String query = "SELECT id, title, author, year FROM book";

        // Execute / Handle Select from Database
        try (Connection connection = dataSource.getConnection();
                java.sql.Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            // Initialize
            List<Book> list = new ArrayList<Book>();

            while (resultSet.next()) {
                // Initialize
                Book book = new Book();

                // Set Value
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setYear(resultSet.getInt("year"));

                // Add Book to List of Book
                list.add(book);
            }

            // Return List
            return list.toArray(new Book[] {});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book getById(Integer id) {
        // Query
        String query = "SELECT id, title, author, year FROM book WHERE id = ?";

        // Execute / Handle Select from Database
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            // Set Value
            statement.setInt(1, id);

            // Execute
            try (ResultSet resultSet = statement.executeQuery();) {
                // Initialize
                Book book = new Book();

                while (resultSet.next()) {
                    // Set Value from Database
                    book.setId(resultSet.getInt("id"));
                    book.setTitle(resultSet.getString("title"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setYear(resultSet.getInt("year"));
                }
                // Return Book
                return book;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Integer id, String title, String author, Integer year) {
        // Query
        String query = "UPDATE book SET title = ?, author = ?, year = ? WHERE id = ?";

        // Execute / Handle Update to Database
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {

            // Set Value
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setInt(3, year);
            statement.setInt(4, id);

            // Execute
            int success = statement.executeUpdate();

            if (success > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        // Query
        String query = "DELETE FROM book WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {

            // Set Value
            statement.setInt(1, id);

            // Execute
            int success = statement.executeUpdate();

            if (success > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}