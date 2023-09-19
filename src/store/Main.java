package store;


import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static double totalAmount;// загальна сума
    static double sumDiscount;// сума знижки
    static double sumPaid;// сума до оплати

    public static void main(String[] args) {


        // Виклик метода
        enter();
        calcTotalPurAmount();
        calcSumDiscount();
        calcSumPaid();
        rounded();
    }

    // Введення суми покупки
    private static void enter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total purchase amount: ");
        totalAmount = scanner.nextDouble();
        scanner.close();
    }

    // метод реалізує - Виведення загальна суми покупки
    private static void calcTotalPurAmount() {
        sumDiscount = calcSumDiscount();
        sumPaid = calcSumPaid();

    }

    //  метод реалізує - Розраховує знижку
    private static double calcSumDiscount() {
        if (totalAmount <= 5000) {
            sumDiscount = totalAmount * 0.05;
        } else if (totalAmount > 5000 && totalAmount <= 10000) {
            sumDiscount = totalAmount * 0.10;
        } else if (totalAmount > 10000) {
            sumDiscount = totalAmount * 0.15;
        }
        return sumDiscount;

    }

    //  метод реалізує - Рахує суму до сплати після застосування знижки
    private static double calcSumPaid() {
        sumDiscount = calcSumDiscount();
        return totalAmount - sumDiscount;

    }

    // Округлення та виведення розрахунків
    private static void rounded() {
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Total purchase amount: " + df.format(totalAmount) + "\n" +
                "Amount of discount: " + df.format(sumDiscount) + "\n" +
                "Amount to be paid: " + df.format(sumPaid));
    }

}
