package egisubastian.pencatatan.buku.util;

import java.util.Scanner;

public class InputUtil {

    // Scanner
    private static Scanner scanner = new Scanner(System.in);

    public static String input(String info) {
        System.out.println(info + " : ");

        String data = scanner.nextLine();
        
        return data;
    }
}