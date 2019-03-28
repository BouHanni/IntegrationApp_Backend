package Utils;

import java.util.ArrayList;



public class Constants {
    public static final String ENERGY = "energy_100g";
    public static final String FAT = "saturated-fat_100g";
    public static final String SUGAR = "sugars_100g";
    public static final String SALT = "salt_100g";
    public static final String FIBER = "fiber_100g";
    public static final String PROTEINS = "proteins_100g";

    public static String[] getNegatives(){
        return new String[]{ENERGY, FAT, SUGAR, SALT};
    }

    public static String[] getPositives(){
        return new String[] {FIBER, PROTEINS};
    }
}
