package egisubastian.data.karyawan.service;

public interface KaryawanService {
    
    // Add
    public void add(Integer id_karyawan, String nama, String alamat, String jabatan, String email, String jk);

    // Get All
    public void getAll();

    // Get By Id
    public void getById(Integer id_karyawan);

    // Update
    public void update(Integer id_karyawan, String nama, String alamat, String jabatan , String email, String jk);

    // Delete
    public void delete(Integer id_karyawan, String nama);
}