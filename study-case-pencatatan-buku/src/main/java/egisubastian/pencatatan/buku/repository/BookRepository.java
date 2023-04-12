package egisubastian.pencatatan.buku.repository;

import egisubastian.pencatatan.buku.entity.Book;

public interface BookRepository {

    // Add
    public void add(Book book);

    // Get All
    public Book[] getAll();

    // Get By Id
    public Book getById(Integer id);

    // Update
    public boolean update(Integer id, String title, String author, Integer year);

    // Delete
    public boolean delete(Integer id);

}