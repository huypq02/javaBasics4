package vn.edu.cybersoft.buoi6_2;

import java.util.InputMismatchException;
import java.util.Scanner;

import static vn.edu.cybersoft.buoi6_2.validator.bai1.*;

public class bai1 {
    final static String[] TYPE = {"GrabCar", "GrabSUV", "GrabBlack"};

    final static double T1 = 3; // minutes
    final static double LV1 = 1; // km
    final static double LV2 = 19; // km

    // Constants for GrabCar
    final static double BASE_RATE_GRAB1 = 8_000;
    final static double TIER_1_RATE_GRAB1 = 7_500;
    final static double TIER_2_RATE_GRAB1 = 7_000;
    final static double WAITING_TIME_RATE_GRAB1 = 2_000;

    // Constants for GrabSUV
    final static double BASE_RATE_GRAB2 = 9_000;
    final static double TIER_1_RATE_GRAB2 = 8_500;
    final static double TIER_2_RATE_GRAB2 = 8_000;
    final static double WAITING_TIME_RATE_GRAB2 = 3_000;

    // Constants for GrabBlack
    final static double BASE_RATE_GRAB3 = 10_000;
    final static double TIER_1_RATE_GRAB3 = 9_500;
    final static double TIER_2_RATE_GRAB3 = 9_000;
    final static double WAITING_TIME_RATE_GRAB3 = 3_500;

    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);

            System.out.printf("Vui long nhap 1 trong %d loai grab: \n", TYPE.length);
            for (int i = 0; i < TYPE.length; i++){
                System.out.printf("%d. %s\n", i+1, TYPE[i]);
            }

            int type = sc.nextInt();
            if (!validateType(type)){
                System.out.println("Vui long nhap loai grab hop le");
                return;
            }

            System.out.println("Vui long nhap so km: ");
            double km = sc.nextDouble();
            if (!validateKm(km)){
                System.out.println("Vui long nhap so km >= 0");
                return;
            }

            System.out.println("Vui long nhap thoi gian cho (phut): ");
            double time = sc.nextDouble();
            if (!validateTime(time)){
                System.out.println("Vui long nhap thoi gian cho >= 0");
                return;
            }

            sc.close(); // close scanner

            System.out.println("Hoa don chi tiet nhu sau:");
            System.out.printf("Loai grab: %s\n", TYPE[type-1]);
            System.out.printf("So km: %2f (km)\n", km);
            System.out.printf("Thoi gian cho: %2f (phut)\n", time);
            System.out.printf("Tong tien: %2f (VND)\n", calculatePrice(type, km, time));
        } catch (Exception e) {
            if(e instanceof InputMismatchException){
                System.out.println("Vui long nhap so nguyen");
            }
            System.out.println("err: " + e.getMessage()); // log error message
        }
    }

    // calculate price
    public static double calculatePrice(int type, double km, double time){
        double price = 0;
        switch (type){
            case 1:
                price = BASE_RATE_GRAB1 * min(km, LV1)
                        + TIER_1_RATE_GRAB1 * min(max(km - LV1, 0), LV2-LV1)
                        + TIER_2_RATE_GRAB1 * max(km - LV2, 0)
                        + WAITING_TIME_RATE_GRAB1 * isValidTime(time , T1);
                break;
            case 2:
                price = BASE_RATE_GRAB2 * min(km, LV1)
                        + TIER_1_RATE_GRAB2 * min(max(km - LV1, 0), LV2-LV1)
                        + TIER_2_RATE_GRAB2 * max(km - LV2, 0)
                        + WAITING_TIME_RATE_GRAB2 * isValidTime(time , T1);
                break;
            case 3:
                price = BASE_RATE_GRAB3 * min(km, LV1)
                        + TIER_1_RATE_GRAB3 * min(max(km - LV1, 0), LV2-LV1)
                        + TIER_2_RATE_GRAB3 * max(km - LV2, 0)
                        + WAITING_TIME_RATE_GRAB3 * isValidTime(time , T1);
                break;
            default:
                System.out.println("Vui long nhap loai grab hop le");
                break;
        }
        return price;
    }

    // find valid time and return 1 if time > T1, else return 0
    public static int isValidTime(double a, double b) {
        return a > b ? 1 : 0;
    }

    // find max value
    public static double max(double a, double b) {
        return a > b ? a : b;
    }

    // find min value
    public static double min(double a, double b) {
        return a < b ? a : b;
    }

}
