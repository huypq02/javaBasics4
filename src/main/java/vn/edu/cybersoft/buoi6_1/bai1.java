package vn.edu.cybersoft.buoi6_1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class bai1 {
    final static int MAX = 3;
    public static void main(String[] args) {
        try {
            System.out.printf("Nhap vao %d so:\n", MAX);
            Scanner sc = new Scanner(System.in);
            double[] num = new double[MAX];
            for (int i = 0; i < MAX; i++){
                num[i] = sc.nextDouble();
            }
            sc.close();

            double max = num[0];
            for (int i = 0; i < MAX; i++){
                max = max(max, num[i]);
            }

            System.out.println("So lon nhat la: " + max);
        } catch (Exception e) {
            if (e instanceof InputMismatchException) {
                System.out.println("Vui long nhap so nguyen");
            }
            System.out.println("err: " + e.getMessage());
        }
    }

    public static double max(double a, double b) {
        return a > b ? a : b;
    }
}
