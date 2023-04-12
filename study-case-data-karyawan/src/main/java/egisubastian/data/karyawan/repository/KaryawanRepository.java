package egisubastian.data.karyawan.repository;

import egisubastian.data.karyawan.entity.DataKaryawan;

public interface KaryawanRepository {
   // Add
   public void add(DataKaryawan karyawan);

   // Get All
   public DataKaryawan[] getAll();

   // Get By Id
   public DataKaryawan getById(Integer id_karyawan);

   // Update
   public boolean update(Integer id_karyawan, String nama, String alamat, String jabatan, String email, String jk);

   // Delete
   public boolean delete(Integer id_karyawan, String nama); 
}
