package egisubastian.pencatatan.buku.service;

public interface BookService {

    // Add
    public void add(String title, String author, Integer year);

    // Get All
    public void getAll();

    // Get By Id
    public void getById(Integer id);

    // Update
    public void update(Integer id, String title, String author, Integer year);

    // Delete
    public void delete(Integer id);
}