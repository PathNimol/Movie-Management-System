import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String BLUE = "\u001B[32m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        System.out.println("\n\n\uD83D\uDE8D\uD83D\uDE8D\uD83D\uDE8D\uD83D\uDE8D| SETUP CHAIR IN BUS |\uD83D\uDE8D\uD83D\uDE8D\uD83D\uDE8D\uD83D\uDE8D\n");

        while (true) {
            System.out.print("\uD83D\uDC49  Enter the Seats \uD83E\uDE91 of bus between 25-45: ");
            String seatInput = input.nextLine();

            if (Pattern.matches("^(2[5-9]|3[0-9]|4[0-5])$", seatInput)) {
                int vSeat = Integer.parseInt(seatInput); //parse to set as length
                boolean[] booked = new boolean[vSeat]; //boolean of array

                int available = vSeat, unavailable = 0;

                while (true) {
                    System.out.println("\tBus \uD83D\uDE8C Information For " + seatInput + " Seats");

                    for (int i = 0; i < vSeat; i++) {
                        if (booked[i]) {
                            System.out.print(RED + "(-) " + RESET + i + "\t");
                        } else {
                            System.out.print(BLUE + "(+) " + RESET + i + "\t");
                        }
                        if ((i + 1) % 5 == 0) {
                            System.out.println();
                        }
                    }
                    System.out.println();
                    System.out.println(RED + "(-)" + RESET + " Unavailable: " + RED + unavailable + RESET + "\t\t" + GREEN + "(+) " + RESET + " Available: " + GREEN + available + RESET);

                    System.out.print("Do you want to book a chair (Y/N)❓ : ");
                    String confirm = input.nextLine();

                    if (confirm.matches("^[Yy]$")) {
                        System.out.print("Enter Chair number to book: ");
                        int chairNumber = input.nextInt();
                        input.nextLine();

                        if (chairNumber >= 0 && chairNumber < vSeat && !booked[chairNumber]) {
                            System.out.print("Are you sure you want to book chair number " + chairNumber + " (Y/N)❓ : ");
                            String confirmation = input.nextLine();

                            if (confirmation.matches("^[Yy]$")) {
                                booked[chairNumber] = true;
                                unavailable++;
                                available--;
                                System.out.println(GREEN + "✔ Seat number " + chairNumber + " has been booked successfully." + RESET);
                            } else {
                                System.out.println(RED + "❌ Booking of chair number " + chairNumber + " has been cancelled." + RESET);
                            }
                        } else {
                            System.out.println(RED + "❌ Invalid or already booked chair number!" + RESET);
                        }
                    } else if (confirm.matches("^[Nn]$")) {
                        System.out.println("Thanks for visiting \uD83D\uDE4F\uD83C\uDFFD\uD83D\uDE1C");
                        return;  // Exit both loops
                    } else {
                        System.out.println("Wrong input! You can only choose (Y/y) or (N/n).");
                    }
                }
            } else {
                System.out.println("Numbers of chairs cannot be letters! Please input a number between 25-45 \uD83D\uDE4F\uD83C\uDFFD");
            }
        }
    }
}