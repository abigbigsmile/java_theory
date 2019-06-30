package design_pattern.blueBridgeCup;


public class ThownPhone {
    public static void main(String[] args) {
        System.out.println(DroppingPhone(3, 1000));
    }

    private static long DroppingPhone(long phone, long floors) {
        long times = 1;
        while (DroppingMax(phone, times) < floors) {
            ++times;
        }
        return times;
    }

    private static long DroppingMax(long phone, long times) {
        if (phone == 1) {
            return times;
        }

        if (phone >= times) {
            return (long) Math.pow(2, times) - 1;
        }

        return DroppingMax(phone, times - 1) + DroppingMax(phone - 1, times - 1) + 1;
    }
}


