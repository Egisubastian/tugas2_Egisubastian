package egisubastian.data.karyawan.service.impl;

import egisubastian.data.karyawan.entity.DataKaryawan;
import egisubastian.data.karyawan.repository.KaryawanRepository;
import egisubastian.data.karyawan.service.KaryawanService;

public class KaryawanServiceImpl implements KaryawanService {

    private KaryawanRepository karyawanRepository;

    public KaryawanServiceImpl(KaryawanRepository karyawanRepository) {
        this.karyawanRepository = karyawanRepository;
    }

    @Override
    public void add(Integer id_karyawan, String nama, String alamat, String jabatan, String email, String jk) {
        // Initialize
        DataKaryawan dataKaryawan = new DataKaryawan(id_karyawan, nama, alamat, jabatan, email, jk);

        // Add Karyawan
        karyawanRepository.add(dataKaryawan);

        // Return
        System.out.println("New Data Karyawan Added Successfully : " + dataKaryawan.getNama());
    }

    @Override
    public void getAll() {
        // Initialize
        DataKaryawan[] list = karyawanRepository.getAll();

        // Return
        for (DataKaryawan dataKaryawan : list) {
            System.out.println(String.format("(%d) %s -- (%s - %s - %s - %s)", dataKaryawan.getIdKaryawan(),
                    dataKaryawan.getNama(), dataKaryawan.getAlamat(), dataKaryawan.getJabatan(), dataKaryawan.getEmail(),
                    dataKaryawan.getJK()));
        }
    }

    @Override
    public void getById(Integer id_karyawan) {
        // Get Data
        DataKaryawan dataKaryawan = karyawanRepository.getById(id_karyawan);

        // Return
        if (dataKaryawan.getIdKaryawan() != null) {
            System.out.println(String.format("(%d) %s -- (%s - %s - %s - %s)", dataKaryawan.getIdKaryawan(),
                    dataKaryawan.getNama(), dataKaryawan.getAlamat(), dataKaryawan.getJabatan(), dataKaryawan.getEmail(),
                    dataKaryawan.getJK()));
        } else {
            System.out.println("Data Karyawan Not Found!");
        }

    }

    @Override
    public void update(Integer id_karyawan, String nama, String alamat, String jabatan, String email, String jk) {
        // Initialize
        DataKaryawan dataKaryawan = new DataKaryawan(id_karyawan, nama, alamat, jabatan, email, jk);
        DataKaryawan exist = karyawanRepository.getById(id_karyawan);
        // Update Data Karyawan
        boolean success = karyawanRepository.update(id_karyawan, nama, alamat, jabatan, email, jk);

        // Return
        if (exist == null) {
            System.out.println("Data Karyawan Is not Existed!");
            return;
        }

        if (!nama.equals(exist.getNama())) {
            exist.setNama(nama);
        }
        if (!alamat.equals(exist.getAlamat())) {
            exist.setAlamat(alamat);
        }
        if (jabatan != null && !jabatan.equals(exist.getJabatan())) {
            exist.setJabatan(jabatan);
        }
        if (!email.equals(exist.getEmail())) {
            exist.setEmail(email);
        }
        if (!jk.equals(exist.getJK())) {
            exist.setJK(jk);
        }

        if (success) {
            System.out.println(String.format("Successfully Updated Data Karyawan : (%d) %s -- (%s - %s - %s - %s)",
                    dataKaryawan.getIdKaryawan(),
                    dataKaryawan.getNama(), dataKaryawan.getAlamat(), dataKaryawan.getJabatan(), dataKaryawan.getEmail(),
                    dataKaryawan.getJK()));
        } else {
            System.out.println(String.format("Failed to Update Data Karyawan : (%d) -- %s",
                    dataKaryawan.getIdKaryawan(), dataKaryawan.getNama()));
        }
    }

    @Override
    public void delete(Integer id_karyawan, String nama) {
        // Delete Data
        DataKaryawan dataKaryawan = karyawanRepository.getById(id_karyawan);
        boolean success = karyawanRepository.delete(id_karyawan, nama); // true or false

        if (success == true) {
            // Return
            System.out.println("Data Karyawan Deleted Successfully : " + dataKaryawan.getNama());
        } else {
            // Return
            System.out.println("Failed to Deleted Data Karyawan : Data Not Exist!");
        }
    }

}