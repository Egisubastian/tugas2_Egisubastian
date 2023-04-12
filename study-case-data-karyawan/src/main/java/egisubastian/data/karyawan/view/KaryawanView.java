package egisubastian.data.karyawan.view;

import egisubastian.data.karyawan.service.KaryawanService;
import egisubastian.data.karyawan.util.InputUtil;

public class KaryawanView {

    // Karyawan Service
    private KaryawanService karyawanService;

    public KaryawanView(KaryawanService karyawanService) {
        this.karyawanService = karyawanService;
    }

    // Login Menu
    public void loginMenu() {
        while (true) {
            System.out.println("========== LOGIN MENU ==========");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");

            String input = InputUtil.input("Choose >");

            if (input.equals("1")) {
                loginAdmin();
            } else if (input.equals("2")) {
                loginUser();
            } else if (input.equals("3")) {
                break;
            }
        }
    }

    // Show Menu
    public void mainMenu() {
        while (true) {
            System.out.println("========== MAIN MENU ==========");
            System.out.println("1. Insert Data Karyawan");
            System.out.println("2. Update Data Karyawan");
            System.out.println("3. Show Data Karyawan");
            System.out.println("4. Show Data By Id");
            System.out.println("5. Delete Data Karyawan");
            System.out.println("X. Exit");
            System.out.println("===============================");

            String input = InputUtil.input("Choose >");

            if (input.equals("1")) {
                insertDataKaryawan();
            } else if (input.equals("2")) {
                updateDataKaryawan();
            } else if (input.equals("3")) {
                showDataKaryawan();
            } else if (input.equals("4")) {
                showByIdKaryawan();
            } else if (input.equals("5")) {
                deleteDataKaryawan();
            } else if (input.equals("X")) {
                loginAdmin();
            } else {
                System.out.println("Option doesn't recognized");
            }
        }
    }

    public void loginAdmin() {
        // Menu
        System.out.println("========== LOGIN ADMIN ==========");

        // Initialize
        int attempt = 3;

        // Get Data and Return
        while (attempt > 0) {

            System.out.println("Username : Admin");
            String password = InputUtil.input("Insert Admin Password");

            if (password.equals("admin")) {
                mainMenu();
            } else {
                attempt--;
                System.out.println("Invalid Password. Please Try Again.");
                System.out.println("You have " + attempt + " attempt(s) left.");
            }
        }

        if (attempt == 0) {
            System.out.println("Too Many Invalid Login. Please try again later.");
        } else {
            loginMenu();
        }
    }

    public void loginUser() {
        // Menu
        System.out.println("========== LOGIN USER ==========");

        // Get Data and Return
        while (true) {

            String username = InputUtil.input("Username");
            String password = InputUtil.input("Password");

            if (username.equals("egis") && password.equals("egi123")) {
                System.out.println("========== DATA USER ==========");
                Integer id_karyawan = 1;
                karyawanService.getById(Integer.valueOf(id_karyawan));
                break;

            } else {
                System.out.println("Login Failed. Please Try Again.");
            }
        }

    }

    public void insertDataKaryawan() {

        // Menu
        System.out.println("======= INSERT DATA KARYAWAN =======");

        // Get Data Input
        String id_karyawan = InputUtil.input("ID Karyawan");
        String nama = InputUtil.input("Nama Karyawan");
        String alamat = InputUtil.input("Alamat Karyawan");
        String jabatan = InputUtil.input("jabatan karyawan");
        String email = InputUtil.input("Email Karyawan");
        String jk = InputUtil.input("Jenis Kelamin (Laki-laki/Perempuan)");

        // Add Data
        karyawanService.add(Integer.valueOf(id_karyawan), nama, alamat, jabatan , email, jk);
    }

    public void updateDataKaryawan() {

        // Menu
        System.out.println("===== UPDATE DATA KARYAWAN =====");

        // Get Data Input
        String id_karyawan = InputUtil.input("ID Karyawan");
        String nama = InputUtil.input("Nama Karyawan");
        String alamat = InputUtil.input("Alamat Karyawan");
        String jabatan = InputUtil.input("jabatan karyawan");
        String email = InputUtil.input("Email Karyawan");
        String jk = InputUtil.input("Jenis Kelamin (Laki-laki/Perempuan)");

        try {
            // Update Data
            karyawanService.update(Integer.valueOf(id_karyawan), nama, alamat, jabatan, email, jk);
        } catch (NumberFormatException ex) {
            // Return
            System.out.println(String.format("ID Karyawan (%d) Does Not Exist In The Database!", id_karyawan));
            return;
        }
    }

    public void showDataKaryawan() {

        // Menu
        System.out.println("======== DATA KARYAWAN ========");

        // Get Data
        karyawanService.getAll();
    }

    public void showByIdKaryawan() {

        // Menu
        System.out.println("===== DATA KARYAWAN BY ID =====");

        // Get Data Input
        String id_karyawan = InputUtil.input("ID Karyawan");
        System.out.println("======== DATA KARYAWAN ========");

        // Get Data
        karyawanService.getById(Integer.valueOf(id_karyawan));
    }

    public void deleteDataKaryawan() {

        // Menu
        System.out.println("======= DELETE DATA KARYAWAN =======");

        // Get Data Input
        String id_karyawan = InputUtil.input("ID Karyawan");

        // Confirmation
        System.out.println("This Data Karyawan Will be Deleted? (y/n)");

        String confirm = InputUtil.input("Your input >");

        if (confirm.equals("y")) {
            karyawanService.delete(Integer.valueOf(id_karyawan), null);
        } else {
            System.out.println("Operation Canceled");
        }
    }
}
