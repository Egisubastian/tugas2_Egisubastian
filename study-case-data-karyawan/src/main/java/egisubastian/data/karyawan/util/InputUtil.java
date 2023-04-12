package egisubastian.data.karyawan.util;

import java.util.Scanner;

public class InputUtil {
        // Scanner
        private static Scanner scanner = new Scanner(System.in);
    
        public static String input(String info) {
            System.out.println(info + " : ");
    
            String data = scanner.nextLine();
            
            return data;
        }
    
        public static Integer inputInt(String info) {
            System.out.println(info + " : ");
    
            Integer data = scanner.nextInt();
            
            return data;
        }
}
