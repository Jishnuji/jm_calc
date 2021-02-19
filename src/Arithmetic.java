import java.util.HashMap;

public class Arithmetic {
    private static HashMap<Integer, String> map = new HashMap<>() {{
        put(100, "C");
        put(90, "XC");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
        put(0, "0");
    }};
    private static HashMap<String, Integer> map2 = new HashMap<>() {{
        put("I", 1);
        put("II", 2);
        put("III", 3);
        put("IV", 4);
        put("V", 5);
        put("VI", 6);
        put("VII", 7);
        put("VIII", 8);
        put("IX", 9);
        put("X", 10);
    }};

    /** Конвертируем полученный результат в римскую цифру */
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
    /** Выполняем арифметические действия с араюскими числами */
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
    /** Выполняем арифметические действия с римскими числами */
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
