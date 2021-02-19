import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите два числа от 1 до 10 и поставьте между ними знак +, -, / или *");

        String text = in.nextLine();
        text = text.trim();
/** Извлекаем знак арифметического действия и проверяем, чтобы он был один**/
        char sign = ' ';
        int plus = 0, minus = 0, mult = 0, div = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '+') {
                plus++;
                sign = '+';
            }
            if (text.charAt(i) == '-') {
                minus++;
                sign = '-';
            }
            if (text.charAt(i) == '*') {
                mult++;
                sign = '*';
            }
            if (text.charAt(i) == '/') {
                div++;
                sign = '/';
            }
        }

        int total = plus + minus + mult + div;
        if (total != 1) {
            System.out.println("Ошибка. В примере должна быть указан один знак арифметического действия");
            throw new Exception();
        }
/** Ищем числа слева и справа от знака арфметического действия*/
        int indexOfSign = text.indexOf(sign);
        String leftSide = text.substring(0, indexOfSign);
        leftSide = leftSide.trim();
        String rightSide = text.substring(++indexOfSign);
        rightSide = rightSide.trim();

        if (leftSide.indexOf(' ') != -1 || rightSide.indexOf(' ') != -1) {
            System.out.println("Ошибка. Должны быть введены ровно два числа");
            throw new Exception();
        }
/** Проверяем на наличие арабских чисел*/
        boolean arabic = false;
        int a = 0, b = 0;

        try {
            a = Integer.parseInt(leftSide);
            b = Integer.parseInt(rightSide);

            arabic = true;

        } catch (NumberFormatException e) { }
/** Проверяем, входят ли числа в требуемый диапазон. Если да, то вызываем соответсвующий метод арифметического вычисления*/
        if (arabic) {
            if (a > 10 || a < 1 || b > 10 || b < 1) {
                System.out.println("Ошибка. Число должно быть от 1 до 10");
                throw new Exception();
            }
            switch (sign) {
                case '+':
                    System.out.println(Arithmetic.sum(a, b));
                    break;
                case '-':
                    System.out.println(Arithmetic.subtract(a, b));
                    break;
                case '*':
                    System.out.println(Arithmetic.multiplay(a, b));
                    break;
                case '/':
                    System.out.println(Arithmetic.divide(a, b));
                    break;
            }
            System.exit(0);
        }
/** Проверяем на наличие римских чисел*/
        Set<String> romansSet = new HashSet<>();
        romansSet.add("I");
        romansSet.add("II");
        romansSet.add("III");
        romansSet.add("IV");
        romansSet.add("V");
        romansSet.add("VI");
        romansSet.add("VII");
        romansSet.add("VIII");
        romansSet.add("IX");
        romansSet.add("X");

        if (!(romansSet.contains(leftSide) && romansSet.contains(rightSide))) {
            System.out.println("Ошибка. Введенные символы должны быть арабскими или римскими числами от 1(I) до 10(X)");
            throw new Exception();
        }

        String a2 = leftSide;
        String b2 = rightSide;
/** Выполняем арифметическое действие с римскими цифрами*/
        switch (sign) {
            case '+' -> System.out.println(Arithmetic.sum(a2, b2));
            case '-' -> System.out.println(Arithmetic.subtract(a2, b2));
            case '*' -> System.out.println(Arithmetic.multiplay(a2, b2));
            case '/' -> System.out.println(Arithmetic.divide(a2, b2));
        }
    }
}
