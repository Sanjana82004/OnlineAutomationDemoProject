package utilities;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
public class RandomDataGenerator {

	static Random rand = new Random();

    public static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(6);
    }

    public static String getRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String getRandomEmail() {
        return getRandomString().toLowerCase() + "@gmail.com";
    }

    public static String getRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    public static String getRandomDay() {
        int day = rand.nextInt(28) + 1;  // 1–28 (safe for all months)
        return String.valueOf(day);
    }

    public static String getRandomMonth() {
        String[] months = {
            "January","February","March","April","May","June",
            "July","August","September","October","November","December"
        };
        return months[rand.nextInt(months.length)];
    }

    public static String getRandomYear() {
        int year = rand.nextInt(30) + 1985;  // 1985–2014
        return String.valueOf(year);
    }

	
	
	
	
}
