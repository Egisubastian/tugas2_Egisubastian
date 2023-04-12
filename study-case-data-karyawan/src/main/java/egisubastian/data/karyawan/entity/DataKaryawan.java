package egisubastian.data.karyawan.entity;

public class DataKaryawan {
    

// Atribut
    private Integer id_karyawan;
    private String nama;
    private String alamat;
    private String jabatan;
    private String email;
    private String jk;

    // Constructor
    public DataKaryawan() {
    }

    public DataKaryawan(Integer id_karyawan, String nama, String alamat, String jabatan, String email, String jk) {
        this.id_karyawan = id_karyawan;
        this.nama = nama;
        this.alamat = alamat;
        this.jabatan = jabatan;
        this.email = email;
        this.jk = jk;
    }

    public DataKaryawan(String nama, String alamat, String jabatan, String email, String jk) {
        this.nama = nama;
        this.alamat = alamat;
        this.jabatan = jabatan;
        this.email = email;
        this.jk = jk;
    }

    // Getter
    public Integer getIdKaryawan() {
        return id_karyawan;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getJabatan() {
        return jabatan;
    }

    public String getEmail() {
        return email;
    }

    public String getJK() {
        return jk;
    }

    // Setter
    public void setIdKaryawan(Integer id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan ;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJK(String jk) {
        this.jk = jk;
    }

  
}