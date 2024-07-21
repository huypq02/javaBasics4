package vn.edu.cybersoft.buoi6_2.validator;

public class bai1 {
    public static  boolean validateType(int type){
        return type >= 1 && type <= 3;
    }

    public static boolean validateKm(double km){
        return km >= 0;
    }

    public static boolean validateTime(double time){
        return time >= 0;
    }
}
