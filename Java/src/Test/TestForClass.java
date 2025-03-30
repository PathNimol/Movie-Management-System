import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;

public class TestForClass {
    public static void main(String[] args) {
        // Color codes for console output
        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String blue = "\u001B[34m";
        String green = "\u001B[32m";

        // Cell style for center alignment in tables
        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);

        // Tables for displaying seat layout and movie information
        Table tSeat = new Table(5, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.ALL);
        Table t = new Table(7, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.ALL);

        // Set column widths for the movie information table
        t.setColumnWidth(0, 5, 10);
        t.setColumnWidth(1, 30, 50);
        t.setColumnWidth(2, 30, 50);
        t.setColumnWidth(3, 30, 50);
        t.setColumnWidth(4, 30, 50);
        t.setColumnWidth(5, 30, 50);
        t.setColumnWidth(6, 30, 50);

        // Set column widths for the seat layout table
        tSeat.setColumnWidth(0, 30, 30);
        tSeat.setColumnWidth(1, 30, 30);
        tSeat.setColumnWidth(2, 30, 30);
        tSeat.setColumnWidth(3, 30, 30);
        tSeat.setColumnWidth(4, 30, 30);

        // Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Variables for managing movie and seat data
        boolean isInserted = false; // Flag to check if movies have been inserted
        boolean isBooking = false; // Flag to check if a booking has been made
        boolean seats[][]; // 2D array to track seat availability
        int seatBooked[]; // Array to store booked seats

        int countAdd = 0, numberHall, seatEachHall, bookOption, option;
        int Id = 0;

        String numOfHall, seatPerHall;
        String nameOfMovie[]; // Array to store movie names
        String typeOfMovie[]; // Array to store movie types
        String durationOfMovie[]; // Array to store movie durations
        int[] isAvailable; // Array to track available seats per hall
        int[] unavailable; // Array to track unavailable seats per hall

        // Cinema setup phase
        System.out.println("---------Setting up Cinema---------");

        // Loop to get the number of halls in the cinema
        while (true) {
            System.out.print("=> Enter number of Hall in Cinema: ");
            numOfHall = sc.nextLine();
            if (numOfHall.matches("^[1-9][0-9]*$")) { // Validate input is a positive integer
                numberHall = Integer.parseInt(numOfHall);
                nameOfMovie = new String[numberHall];
                typeOfMovie = new String[numberHall];
                durationOfMovie = new String[numberHall];
                break;
            } else {
                System.out.println(red + "Number of hall is allowed only number and more than 0!" + reset);
            }
        }

        // Loop to get the number of seats in each hall
        while (true) {
            System.out.print("=> Enter number of Seat in each Hall: ");
            seatPerHall = sc.nextLine();
            if (seatPerHall.matches("^[0-9]+$") && Integer.parseInt(seatPerHall) >= 50) { // Validate input is a number and at least 50
                seatEachHall = Integer.parseInt(seatPerHall);
                seats = new boolean[numberHall][seatEachHall];
                isAvailable = new int[numberHall];
                unavailable = new int[numberHall];
                for (int i = 0; i < numberHall; i++) {
                    for (int j = 0; j < seatEachHall; j++) {
                        seats[i][j] = true; // All seats are initially available
                    }
                    isAvailable[i] = seatEachHall; // Initialize available seats count
                    unavailable[i] = 0; // Initialize unavailable seats count
                }
                break;
            } else {
                System.out.println(red + "Number of seat is allowed only number and 50 seats up!" + reset);
            }
        }

        // Main menu loop
        while (true) {
            System.out.println("======================| Movie Management |======================");
            System.out.println(blue + "1- Insert Movie" + reset);
            System.out.println(blue + "2- Check & Booking Movie" + reset);
            System.out.println(blue + "3- Check Ticket" + reset);
            System.out.println(blue + "4- Reset Hall" + reset);
            System.out.println(blue + "5- Set row to show record" + reset);
            System.out.println(red + "6- Exit" + reset);
            System.out.println("------------------------------------------------");
            System.out.print("=> Choose option (1-6): ");
            String optionStr = sc.nextLine();

            if (optionStr.matches("^[1-6]$")) { // Validate input is between 1 and 6
                option = Integer.parseInt(optionStr);

                if (option == 1) {
                    // Insert Movie
                    while (true) {
                        System.out.println("--------Insert Movie-----------");
                        if (countAdd >= numberHall) { // Check if all halls are filled
                            System.out.println(red + "Unavailable hall to insert more movies!" + reset);
                            System.out.println("<<<<<<<<<<<<<<<<<<<<- Press any key to continue ->>>>>>>>>>>>>>>>>>>>");
                            sc.nextLine();
                            break;
                        }
                        for (int i = countAdd; i < numberHall; i++) {
                            System.out.print("Enter movie name: ");
                            nameOfMovie[i] = sc.nextLine();

                            // Validate movie type input
                            while (true) {
                                System.out.print("Enter movie type: ");
                                typeOfMovie[i] = sc.nextLine();

                                if (typeOfMovie[i].matches("^[a-zA-Z ]+$")) { // Validate input is text only
                                    break;
                                } else {
                                    System.out.println(red + "Type of Movie is allowed to input only text!" + reset);
                                }
                            }

                            // Validate movie duration input
                            while (true) {
                                System.out.print("Enter movie duration (minutes): ");
                                durationOfMovie[i] = sc.nextLine();

                                if (durationOfMovie[i].matches("^(60|[7-9][0-9]|1[0-7][0-9]|180)$")) { // Validate duration is between 60 and 180 minutes
                                    int duration = Integer.parseInt(durationOfMovie[i]);
                                    break;
                                } else {
                                    System.out.println(red + "Duration allowed to input only number and duration between 60 min - 180 min!" + reset);
                                }
                            }

                            isInserted = true; // Set flag to indicate movies have been inserted

                            System.out.println(green + "Movie " + reset + blue + nameOfMovie[i] + reset + green + " have been insert successfully ✔" + reset);
                            countAdd++;
                        }
                    }
                } else if (option == 2) {
                    // Check & Booking Movie
                    if (isInserted) { // Check if movies have been inserted
                        t = new Table(7, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.ALL);
                        t.setColumnWidth(0, 5, 10);
                        t.setColumnWidth(1, 30, 50);
                        t.setColumnWidth(2, 30, 50);
                        t.setColumnWidth(3, 30, 50);
                        t.setColumnWidth(4, 30, 50);
                        t.setColumnWidth(5, 30, 50);
                        t.setColumnWidth(6, 30, 50);

                        // Table headers with color formatting
                        String idColor = (green + "ID" + reset);
                        String nameColor = (green + "Movie Name  " + reset);
                        String typeColor = (green + "Type" + reset);
                        String durationColor = (green + "Duration" + reset);
                        String hallColor = (green + "Hall" + reset);
                        String availableColor = (green + "Available" + reset);
                        String unavailableColor = (green + "Unavailable" + reset);

                        t.addCell("Display All Movie", numberStyle, 7); // Main header

                        // Add headers to the table
                        t.addCell(idColor, numberStyle);
                        t.addCell(nameColor, numberStyle);
                        t.addCell(typeColor, numberStyle);
                        t.addCell(durationColor, numberStyle);
                        t.addCell(hallColor, numberStyle);
                        t.addCell(availableColor, numberStyle);
                        t.addCell(unavailableColor, numberStyle);

                        // Add movie data to the table
                        for (int i = 0; i < numberHall; i++) {
                            t.addCell(String.valueOf(i + 1), numberStyle);
                            t.addCell(nameOfMovie[i], numberStyle);
                            t.addCell(typeOfMovie[i], numberStyle);
                            t.addCell(durationOfMovie[i], numberStyle);
                            t.addCell(String.valueOf(i + 1), numberStyle);
                            t.addCell(String.valueOf(isAvailable[i]), numberStyle);
                            t.addCell(String.valueOf(unavailable[i]), numberStyle);
                        }
                        System.out.println(t.render());

                        // Booking options
                        System.out.println("1- Book ticket\t\t2- First\t\t3- Next\t\t4- Previous\t\t5- Last\t\t " + red + "6- Exit" + reset);
                        System.out.print("Choose an option: ");
                        String bookOpt = sc.nextLine();

                        if (bookOpt.matches("^[1-6]+$")) { // Validate input is between 1 and 6
                            bookOption = Integer.parseInt(bookOpt);
                            if (bookOption == 1) {
                                // Book ticket
                                String[] bookedMovie = new String[numberHall];
                                String[] bookedSeat = new String[numberHall];
                                boolean[] isBookedHall = new boolean[numberHall];
                                System.out.println("===========| Booking Ticket |===========");

                                System.out.print("Enter movie ID: ");
                                String id = sc.nextLine();
                                if (id.matches("^[1-9]+$")) { // Validate input is a positive integer
                                    Id = Integer.parseInt(id);
                                    if (Id >= 1 && Id <= numberHall) { // Validate hall ID is within range

                                        // Display seat layout for the selected hall
                                        String screen = ("\\uD83D\uDCFASCREEN HALL #" + id + "\uD83D\uDCFA");
                                        tSeat.addCell(screen, numberStyle, 5);

                                        for (int j = 0; j < seatEachHall; j++) {
                                            String unavailableSeat = red + "( - )" + (j + 1) + reset;
                                            String availableSeat = green + "( + )" + (j + 1) + reset;

                                            if (seats[Id - 1][j]) {
                                                tSeat.addCell(availableSeat, numberStyle);
                                            } else {
                                                tSeat.addCell(unavailableSeat, numberStyle);
                                            }
                                        }
                                        System.out.println(tSeat.render());

                                        // Loop for booking seats
                                        backMenu:
                                        while (true) {
                                            System.out.print("Choose seats that you want to book (e.g: 1, 2, 3, 4) : ");
                                            String seatStr = sc.nextLine();
                                            bookMoreSeat:
                                            if (seatStr.matches("^\\d+(\\s*,\\s*\\d+)*$")) { // Validate input is a list of numbers
                                                String[] arrayOfBookingSeat = seatStr.split(",");
                                                seatBooked = new int[arrayOfBookingSeat.length];
                                                for (int i = 0; i < arrayOfBookingSeat.length; i++) {
                                                    seatBooked[i] = Integer.parseInt(arrayOfBookingSeat[i].trim());
                                                }
                                                isBooking = true;

                                                // Validate seat numbers
                                                for (String seat : arrayOfBookingSeat) {
                                                    int seatNum = Integer.parseInt(seat.trim());

                                                    if (seatNum < 1 || seatNum > seatEachHall) {
                                                        System.out.println(red + "Invalid seat number " + reset);
                                                        isBooking = false;
                                                        break;
                                                    }
                                                    if (!seats[Id - 1][seatNum - 1]) {
                                                        System.out.println(red + "Seat " + seatNum + " is already booked!" + reset);
                                                        isBooking = false;
                                                        break;
                                                    }
                                                }

                                                if (isBooking) {
                                                    // Mark selected seats as unavailable
                                                    for (String seat : arrayOfBookingSeat) {
                                                        int seatNum = Integer.parseInt(seat.trim());
                                                        seats[Id - 1][seatNum - 1] = false; // Mark seat as unavailable
                                                        isAvailable[Id - 1]--;
                                                        unavailable[Id - 1]++;
                                                    }

                                                    // Store booking information
                                                    bookedMovie[Id - 1] = nameOfMovie[Id - 1];
                                                    bookedSeat[Id - 1] = seatStr;
                                                    isBookedHall[Id - 1] = true;

                                                    // Update seat layout display
                                                    tSeat = new Table(5, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.ALL);
                                                    tSeat.addCell(screen, numberStyle, 5);
                                                    for (int j = 0; j < seatEachHall; j++) {
                                                        String unavailableSeat = red + "( - )" + (j + 1) + reset;
                                                        String availableSeat = green + "( + )" + (j + 1) + reset;
                                                        if (seats[Id - 1][j]) {
                                                            tSeat.addCell(availableSeat, numberStyle);
                                                        } else {
                                                            tSeat.addCell(unavailableSeat, numberStyle);
                                                        }
                                                    }
                                                    System.out.println(tSeat.render());
                                                    System.out.println("=============================================================");
                                                    System.out.println("||    " + green + "     Booking seat " + seatStr + " successfully ✔  " + reset + "      ||");
                                                    System.out.println("=============================================================");

                                                    tSeat = new Table(5, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.ALL);
                                                    tSeat.setColumnWidth(0, 30, 30);
                                                    tSeat.setColumnWidth(1, 30, 30);
                                                    tSeat.setColumnWidth(2, 30, 30);
                                                    tSeat.setColumnWidth(3, 30, 30);
                                                    tSeat.setColumnWidth(4, 30, 30);
                                                    while (true) {
                                                        System.out.print("\nDo you want to booking more seat? (Y/N) : ");
                                                        String comfirmMs = sc.nextLine();
                                                        if (comfirmMs.matches("^[Yy]$")) {
                                                            break bookMoreSeat;
                                                        } else if (comfirmMs.matches("^[Nn]$")) {
                                                            break backMenu;
                                                        } else {
                                                            System.out.println("Invalid confirmation. Please choose (Y or N)!");
                                                        }
                                                    }
                                                }
                                            } else {
                                                System.out.println(red + "Invalid input " + seatStr + " is not a valid seat number!" + reset);
                                            }
                                        }
                                    } else {
                                        System.out.println("Invalid hall ID.");
                                    }
                                }
                            }
                        } else {
                            System.out.println(red + "Invalid option!" + reset);
                        }
                    } else {
                        System.out.println("No data to showing, please insert movie first!");
                    }
                } else if (option == 3) {
                    // Check Ticket
                    if (isBooking) {
                        System.out.println("==========| Your tickets has been booked!|=============");

                        System.out.println("Hall #");
                        System.out.println("Movie name ");
                        System.out.println("Seat book ");
                    } else {
                        System.out.println("No booking data! Please booking first!");
                    }
                } else if (option == 4) {
                    // Reset Hall
                    if (isInserted && isBooking) {
                        while (true) {
                            System.out.print("Do you want to reset all hall with all seats available? (Y/N) :");
                            String comfirm = sc.nextLine();
                            if (comfirm.matches("^[Yy]$")) {
                                // Reset all seats to available
                                for (int i = 0; i < numberHall; i++) {
                                    for (int j = 0; j < seatEachHall; j++) {
                                        seats[i][j] = true;
                                    }
                                    isAvailable[i] = seatEachHall; // Reset available seats count
                                    unavailable[i] = 0; // Reset unavailable seats count
                                }
                                isBooking = false; // Reset booking flag
                                System.out.println(green + "=======| Hall was reset successfully |=========" + reset);
                                break;
                            } else if (comfirm.matches("^[Nn]$")) {
                                break;
                            } else {
                                System.out.println("Invalid confirmation. Please choose (Y or N)!");
                            }
                        }
                    } else {
                        System.out.println("No data for reset hall!");
                    }
                } else if (option == 5) {
                    // Set row to show record
                    if (isInserted) {
                        System.out.println("=================================================");
                        System.out.println("   " + green + "     Set row to show movie record ✔  " + reset + "      ");
                        System.out.println("==================================================");
                        System.out.println("Enter number ");
                    } else {
                        System.out.println("No data for setting the record!");
                    }
                } else if (option == 6) {
                    // Exit the program
                    System.out.println("Thank you for visiting us!");
                    System.exit(0);
                } else {
                    System.out.println(red + "Invalid option!" + reset);
                }
            } else {
                System.out.println(red + "Invalid option!" + reset);
            }
        }
    }
}