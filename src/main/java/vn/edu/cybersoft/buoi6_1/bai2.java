package vn.edu.cybersoft.buoi6_1;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class bai2 {
    public static void main(String[] args) {
        try{
            System.out.println("Nhap vao so nguyen:");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            scanner.close();
            if (isEven(num)) {
                System.out.println("So chan");
            } else {
                System.out.println("So le");
            }
        } catch (Exception e) {
            if (e instanceof NoSuchElementException) {
                System.out.println("Vui long nhap so nguyen");
            }
            System.out.println("err: " + e.getMessage());
        }
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
