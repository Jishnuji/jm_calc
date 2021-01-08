import java.util.HashMap;

public class Arithmetic {
    private static HashMap<Integer, String> map = new HashMap<>();
    private static HashMap<String, Integer> map2 = new HashMap<>();

    private static void fillRomanAndArabic() {
        map.put(100, "C");
        map.put(90, "XC");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        map2.put("I", 1);
        map2.put("II", 2);
        map2.put("III", 3);
        map2.put("IV", 4);
        map2.put("V", 5);
        map2.put("VI", 6);
        map2.put("VII", 7);
        map2.put("VIII", 8);
        map2.put("IX", 9);
        map2.put("X", 10);
    }

    static {
        fillRomanAndArabic();
    }

    private static String toRoman(int n) {
        StringBuilder result = new StringBuilder();

        boolean negative = false;
        if (n < 0) {
            n = -n;
            negative = true;
        }

        while (n > 0) {
            for (int i = n; i > 0; i--) {
                if (map.containsKey(i)) {
                    n -= i;
                    result.append(map.get(i));
                    break;
                }
            }
        }

        if (negative) {
            result.insert(0,"-");
        }
        return result.toString();
    }
    public static int sum(int a, int b) {
        return a + b;
    }
    public static int subtract(int a, int b) {
        return a - b;
    }
    public static int multiplay(int a, int b) {
        return a * b;
    }
    public static int divide(int a, int b) {
        return a / b;
    }
    public static String sum(String a, String b) {
        int a2 = map2.get(a);
        int b2 = map2.get(b);

        int s = sum(a2, b2);
        return toRoman(s);
    }
    public static String subtract(String a, String b) {
        int a2 = map2.get(a);
        int b2 = map2.get(b);

        int s = subtract(a2, b2);
        return toRoman(s);
    }
    public static String multiplay(String a, String b) {
        int a2 = map2.get(a);
        int b2 = map2.get(b);

        int s = multiplay(a2, b2);
        return toRoman(s);
    }
    public static String divide(String a, String b) {
        int a2 = map2.get(a);
        int b2 = map2.get(b);

        int s = divide(a2, b2);
        return toRoman(s);
    }

}