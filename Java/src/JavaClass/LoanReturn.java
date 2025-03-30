package JavaClass;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;

public class LoanReturn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Loan Amounts: ");
        double loanAmount  = sc.nextDouble();

        System.out.print("Number of Year: ");
        double numOfYear = sc.nextDouble();

        System.out.print("Annual Interest Rate(%): ");
        double annualInterestRate = sc.nextDouble();

        double monthlyRate = annualInterestRate / 12 / 100;
        double totalPayment = numOfYear * 12;
        double monthlyPayment = loanAmount * (monthlyRate * Math.pow(1 + monthlyRate, totalPayment)) / (Math.pow(1 + monthlyRate, totalPayment) - 1);

        double balance = loanAmount;
        LocalDate startDate = LocalDate.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("E dd-MM-yyyy");
        System.out.printf("%-5s%-15s%-10s%-10s%-10s\n", "#", "Date", "Interest", "Principal", "Balance");

        for (int i = 1; i <= totalPayment; i++) {
            double interest = balance * monthlyRate;
            double principal = monthlyPayment - interest;

            balance -= principal;

            LocalDate date = startDate.plusMonths(i);
            DayOfWeek day = date.getDayOfWeek();
            if (day == DayOfWeek.SATURDAY) {
                date= date.plusDays(2);
            } else if (day == DayOfWeek.SUNDAY) {
                date = date.plusDays(1); // Skip to Monday
            }

            System.out.printf("%-5d%-15s%-10.2f%-10.2f%-10.2f\n", i, date.format(formatDate), interest, principal, balance);
        }
    }
}
