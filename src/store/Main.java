package store;


import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static double totalAmount;// загальна сума
    static double sumDiscount;// сума знижки
    static double sumPaid;// сума до оплати

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total purchase amount: ");
        totalAmount = scanner.nextDouble();
        scanner.close();

        // Виклик метода
        calcTotalPurAmount();
        calcSumDiscount();
        calcSumPaid();
    }

    // метод реалізує - Виведення загальна суми покупки
    private static void calcTotalPurAmount() {
        sumDiscount = calcSumDiscount();
        sumPaid = calcSumPaid();

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Total purchase amount: " + df.format(totalAmount));
        System.out.println("Amount of discount: " + df.format(sumDiscount));
        System.out.println("Amount to be paid: " + df.format(sumPaid));
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

}
