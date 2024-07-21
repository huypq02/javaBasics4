package vn.edu.cybersoft.buoi6_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class bai3 {
    final static int MAX = 3;
    public static void main(String[] args) {
        try {
            System.out.printf("Vui long nhap %d so:\n", MAX);
            Scanner sc = new Scanner(System.in);
            List<Double> num = new ArrayList<>();
            for (int i = 0; i < MAX; i++){
                num.add(sc.nextDouble());
            }
            sc.close();

            System.out.printf("Tong %d so do nguoi nhap vao la: %2f", MAX, sumAll(num));
        } catch (Exception e) {
            if (e instanceof InputMismatchException){
                System.out.println("Vui long nhap so nguyen");
            }
            System.out.println("err: " + e.getMessage());
        }
    }

    public static double sumAll(List<Double> num) {
        double sum = 0;
        for (int i = 0; i < num.size(); i++){
            sum += num.get(i);
        }
        return sum;
    }
}
