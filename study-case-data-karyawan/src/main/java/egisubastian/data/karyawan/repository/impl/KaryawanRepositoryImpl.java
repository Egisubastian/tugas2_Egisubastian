package egisubastian.data.karyawan.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import egisubastian.data.karyawan.entity.DataKaryawan;
import egisubastian.data.karyawan.repository.KaryawanRepository;

public class KaryawanRepositoryImpl implements KaryawanRepository {

    private DataSource dataSource;

    public KaryawanRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(DataKaryawan karyawan) {
        // Query
        String sql = "INSERT INTO karyawan(id_karyawan, nama, alamat, jabatan, email, jk ) VALUES (?, ?, ?, ?, ?, ?)";

        // Execute / Handle Write to Database
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set Value
            // SetString(index, value)
            statement.setInt(1, karyawan.getIdKaryawan());
            statement.setString(2, karyawan.getNama());
            statement.setString(3, karyawan.getAlamat());
            statement.setString(4, karyawan.getJabatan());
            statement.setString(5, karyawan.getEmail());
            statement.setString(6, karyawan.getJK());

            // Execute
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DataKaryawan[] getAll() {
        // Query
        String query = "SELECT id_karyawan, nama, alamat, jabatan, email, jk FROM karyawan";

        // Execute / Handle Select from Database
        try (Connection connection = dataSource.getConnection();
                java.sql.Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            // Initialize
            List<DataKaryawan> list = new ArrayList<DataKaryawan>();

            while (resultSet.next()) {
                // Initialize
                DataKaryawan dataKaryawan = new DataKaryawan();

                // Set Value
                dataKaryawan.setIdKaryawan(resultSet.getInt("id_karyawan"));
                dataKaryawan.setNama(resultSet.getString("nama"));
                dataKaryawan.setAlamat(resultSet.getString("alamat"));
                dataKaryawan.setJabatan(resultSet.getString("jabatan"));
                dataKaryawan.setEmail(resultSet.getString("email"));
                dataKaryawan.setJK(resultSet.getString("jk"));

                // Add Data to List of Data Karyawan
                list.add(dataKaryawan);
            }

            // Return List
            return list.toArray(new DataKaryawan[] {});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DataKaryawan getById(Integer id_karyawan) {
        // Query
        String query = "SELECT id_karyawan, nama, alamat, jabatan, email, jk FROM karyawan WHERE id_karyawan = ?";

        // Execute / Handle Select from Database
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            // Set Value
            statement.setInt(1, id_karyawan);

            // Execute
            try (ResultSet resultSet = statement.executeQuery();) {
                // Initialize
                DataKaryawan dataKaryawan = new DataKaryawan();

                while (resultSet.next()) {
                    // Set Value from Database
                    dataKaryawan.setIdKaryawan(resultSet.getInt("id_karyawan"));
                    dataKaryawan.setNama(resultSet.getString("nama"));
                    dataKaryawan.setAlamat(resultSet.getString("alamat"));
                    dataKaryawan.setJabatan(resultSet.getString("jabatan"));
                    dataKaryawan.setEmail(resultSet.getString("email"));
                    dataKaryawan.setJK(resultSet.getString("jk"));
                }
                // Return Data
                return dataKaryawan;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Integer id_karyawan, String nama, String alamat, String jabatan, String email, String jk) {
        // Query
        String query = "UPDATE karyawan SET nama = ?, alamat = ?, jabatan = ?, email = ?, jk = ? WHERE id_karyawan = ?";

        // Execute / Handle Update to Database
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {

            // Set Value
            statement.setString(1, nama);
            statement.setString(2, alamat);
            statement.setString(3, jabatan);
            statement.setString(4, email);
            statement.setString(5, jk);
            statement.setInt(6, id_karyawan);

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
    public boolean delete(Integer id_karyawan, String nama) {
        // Query
        String query = "DELETE FROM karyawan WHERE id_karyawan = ?";

        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {

            // Set Value
            statement.setInt(1, id_karyawan);

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