package vn.edu.cybersoft.buoi6_1;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class bai4 {
    public static void main(String[] args) {
        try {
            System.out.println("Nhap vao so nguyen:");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            double result = num;
            while (true) {
                System.out.println("Nhap toan tu:");
                System.out.println("1. +");
                System.out.println("2. -");
                System.out.println("3. *");
                System.out.println("4. /");
                System.out.println("0. exit");
                int operator = scanner.nextInt();
                if (operator == 0) { // exit game
                    break;
                }
                result = calculator(result, operator, scanner);
            }
            scanner.close();// close scanner
            System.out.println("Ket qua: " + result);
        } catch (Exception e) {
            if (e instanceof InputMismatchException){
                System.out.println("Vui long nhap so nguyen");
            }
            if (e instanceof ArithmeticException){
                System.out.println("Loi chia cho 0");
            }
            System.out.println("err: " + e.getMessage());
        }

    }

    private static double calculator(double result, int operator, Scanner scanner) {
        switch (operator) {
            case 1:
                System.out.println("Nhap vao tiep so nguyen:");
                return result + scanner.nextInt();
            case 2:
                System.out.println("Nhap vao tiep so nguyen:");
                return result - scanner.nextInt();
            case 3:
                System.out.println("Nhap vao tiep so nguyen:");
                return result * scanner.nextInt();
            case 4:
                System.out.println("Nhap vao tiep so nguyen:");
                return result / scanner.nextInt();
            default:
                System.out.println("Vui long nhap toan tu hop le");
                return result;
        }
    }
}
