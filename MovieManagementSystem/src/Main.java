import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Color
        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String blue = "\u001B[34m";
        String green = "\u001B[32m";
        String orange = "\u001B[38;5;214m";

        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table tSeat = new Table(5, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.ALL);
        Table t = new Table(7, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.ALL);
        t.setColumnWidth(0, 5, 10);
        t.setColumnWidth(1, 30, 50);
        t.setColumnWidth(2, 30, 50);
        t.setColumnWidth(3, 30, 50);
        t.setColumnWidth(4, 30, 50);
        t.setColumnWidth(5, 30, 50);
        t.setColumnWidth(6, 30, 50);

        tSeat.setColumnWidth(0, 30, 30);
        tSeat.setColumnWidth(1, 30, 30);
        tSeat.setColumnWidth(2, 30, 30);
        tSeat.setColumnWidth(3, 30, 30);
        tSeat.setColumnWidth(4, 30, 30);

        Scanner sc = new Scanner(System.in);

        boolean isInserted = false;
        boolean isBooking = false;
        boolean seats[][];

        int seatBooked [];
        int countAdd = 0;
        int numberHall;
        int seatEachHall;
        int bookOption;
        int option;
        int Id= 0;
        int[] isAvailable;
        int[] unavailable;

        String numOfHall;
        String seatPerHall;
        String nameOfMovie[];
        String typeOfMovie[];
        String durationOfMovie[];
        String comfirm;
        String bookOpt;


        System.out.println("\n //\\\\__//\\\\__//\\\\__//\\\\__//\\\\__//\\\\__//\\\\_//\\\\ \n" +
                "//                                           \\\\ \n" +
                "\\\\       " + green + "       SETTING UP CINEMA    " + reset + "        // \n" +
                "//                                           \\\\ \n" +
                "\\\\                                           // \n" +
                "  \\\\//\\\\//  \\\\//  \\\\//  \\\\//  \\\\//  \\\\//  \\\\// \n");

        while(true) {
            System.out.print("=> Enter number of Hall in Cinema: ");
            numOfHall = sc.nextLine();
            if (numOfHall.matches("^[1-9][0-9]*$")) { //Not correct validation yet
                numberHall = Integer.parseInt(numOfHall);
                nameOfMovie = new String[numberHall];
                typeOfMovie = new String[numberHall];
                durationOfMovie = new String[numberHall];
                break;
            }
            else {
                System.out.println(red + "Number of hall is allowed only number and more then 0!" + reset);
            }
        }

        while(true) {
            System.out.print("=> Enter number of Seat in each Hall: ");
            seatPerHall = sc.nextLine();
            if (seatPerHall.matches("^[0-9]+$") && Integer.parseInt(seatPerHall) >= 50) {
                seatEachHall = Integer.parseInt(seatPerHall);
                seats = new boolean[numberHall][seatEachHall];
                isAvailable = new int[numberHall];
                unavailable = new int[numberHall];
                seats = new boolean[numberHall][seatEachHall];
                for (int i = 0; i < numberHall; i++) {
                    for (int j = 0; j < seatEachHall; j++) {
                        seats[i][j] = true;
                    }
                    isAvailable[i] = seatEachHall;
                    unavailable[i] = 0;
                }
                break;
            }
            else {
                System.out.println(red + "Number of seat is allowed only number and 50 seats up!" + reset);
            }
        }

        while (true) {
            System.out.println(" ______________________________________________________\n" +
                    "(__   ____________________________________________   __)\n" +
                    "   | |                                            | |\n" +
                    "   | |                                            | |\n" +
                    "   | |                                            | |\n" +
                    "   | |         " + green + "CINEMA MANAGEMENT SYSTEM" + reset + "           | |\n" +
                    "   | |                                            | |\n" +
                    "   | |                                            | |\n" +
                    " __| |____________________________________________| |__\n" +
                    "(______________________________________________________)\n");

            System.out.println(blue + "1- Insert Movie" + reset);
            System.out.println(blue + "2- Check & Booking Movie" + reset);
            System.out.println(blue + "3- Check Ticket" + reset);
            System.out.println(blue + "4- Reset Hall" + reset);
            System.out.println(blue + "5- Set row to show record" + reset);
            System.out.println(red + "6- Exit" + reset);
            System.out.println("----------------------------------------------------------------");
            System.out.print(orange + "\n=> Choose option (1-6): " + reset);
            String optionStr = sc.nextLine();

            menu:
            if (optionStr.matches("^[1-6]$")) {
                option = Integer.parseInt(optionStr);

                switch (option) {
                    case 1:

                        while (true) {
                            if (countAdd >= numberHall) {
                                System.out.println(red + "❌ Unavailable hall to insert more movie ❌" + reset + "\n");
                                System.out.print(orange + "\n <<<<<<<<<<<<<<< Press any key to continue >>>>>>>>>>>>>>>\n" + reset);
                                sc.nextLine();
                                break;
                            }


                            System.out.println("\n==================================================");
                            System.out.println("           " + green + "         INSERT MOVIE     " + reset + "         ");
                            System.out.println("==================================================\n");
                            for (int i = countAdd; i < numberHall; i++) {
                                while(true){
                                    System.out.print("Enter movie name: ");
                                    nameOfMovie[i] = sc.nextLine();
                                    if(nameOfMovie[i].matches("^.+$")){
                                        break;
                                    }
                                    else {
                                        System.out.println("\n" + red + "Please input movie name!" + reset + "\n");
                                    }
                                }


                                while (true) {
                                    System.out.print("Enter movie type: ");
                                    typeOfMovie[i] = sc.nextLine();

                                    if (typeOfMovie[i].matches("^[a-zA-Z ]+$")) {
                                        break;
                                    } else {
                                        System.out.println(red + "Type of Movie is allowed to input only text!" + reset + "\n");
                                    }
                                }

                                while (true) {
                                    System.out.print("Enter movie duration (minutes): ");
                                    durationOfMovie[i] = sc.nextLine();

                                    if (durationOfMovie[i].matches("^(6[0-9]|[7-9][0-9]|1[0-7][0-9]|180)$")) {
                                        break;
                                    } else {
                                        System.out.println("\n" + red + "Duration allowed to input only number and duration between 60 min - 180 min!" + reset + "\n");
                                    }
                                }

                                isInserted = true;

                                System.out.println("\n" + green + "Movie " + reset + blue + nameOfMovie[i] + reset + green + " will be show in hall #" + (i + 1) + reset + "\n");
                                while (true) {
                                    System.out.print(orange + "Do you to insert more movie? (Y/N) : " + reset);
                                    comfirm = sc.nextLine();
                                    if (comfirm.matches("^[Yy]$")) {
                                        break ;
                                    } else if (comfirm.matches("^[Nn]$")) {
                                        break menu;
                                    } else {
                                        System.out.println(red + "Invalid confirmation. Please choose (Y or N)!" + reset);
                                    }
                                }
                                countAdd++;
                            }
                        }
                        break;

                    case 2:
                        if (isInserted == true) {
                            t = new Table(7, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.ALL);
                            t.setColumnWidth(0, 5, 10);
                            t.setColumnWidth(1, 30, 50);
                            t.setColumnWidth(2, 30, 50);
                            t.setColumnWidth(3, 30, 50);
                            t.setColumnWidth(4, 30, 50);
                            t.setColumnWidth(5, 30, 50);
                            t.setColumnWidth(6, 30, 50);

                            String idColor = (blue + "ID" + reset);
                            String nameColor = (blue + "Movie Name  " + reset);
                            String typeColor = (blue + "Type" + reset);
                            String durationColor = (blue + "Duration" + reset);
                            String hallColor = (blue + "Hall" + reset);
                            String availableColor = (green + "Available" + reset);
                            String unavailableColor = (red + "Unavailable" + reset);

                            t.addCell("Display All Movie", numberStyle, 7); //Main Head

                            //Head
                            t.addCell(idColor, numberStyle);
                            t.addCell(nameColor, numberStyle);
                            t.addCell(typeColor, numberStyle);
                            t.addCell(durationColor, numberStyle);
                            t.addCell(hallColor, numberStyle);
                            t.addCell(availableColor, numberStyle);
                            t.addCell(unavailableColor, numberStyle);

                            for (int i = 0; i < countAdd ; i++) {

                                t.addCell(String.valueOf(i + 1), numberStyle);
                                t.addCell(nameOfMovie[i], numberStyle);
                                t.addCell(typeOfMovie[i], numberStyle);
                                t.addCell(durationOfMovie[i], numberStyle);
                                t.addCell(String.valueOf(i + 1), numberStyle);
                                t.addCell(String.valueOf(isAvailable[i]), numberStyle);
                                t.addCell(String.valueOf(unavailable[i]), numberStyle);
                            }

                            System.out.println(t.render());

                            System.out.println(blue + "1- Book ticket\t\t2- First\t\t3- Next\t\t4- Previous\t\t5- Last\t\t " + reset + red + "6- Exit" + reset + "\n");

                            while (true){
                                System.out.print("Choose an option: ");
                                bookOpt = sc.nextLine();
                                if (bookOpt.matches("^[1-6]+$")){
                                    bookOption = Integer.parseInt(bookOpt);
                                    break;
                                }
                                else {
                                    System.out.println(red + "Invalid option! Please choose a valid option (1-6)!" + reset);
                                }
                            }
                            switch (bookOption){
                                case 1:
                                    String[] bookedMovie = new String[numberHall];
                                    String[] bookedSeat = new String[numberHall];
                                    boolean[] isBookedHall = new boolean[numberHall];

                                    System.out.println("===========| Booking Ticket |===========");

                                    System.out.print("Enter movie ID: ");
                                    String id = sc.nextLine();
                                    if (id.matches("^[1-9]+$")) {
                                        Id = Integer.parseInt(id);
                                        if (Id >= 1 && Id <= numberHall) {

                                            String screen = ("\uD83D\uDCFASCREEN HALL #" + id);
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
                                            backMenu:
                                            while (true) {
                                                System.out.print("Choose seats that you want to book (e.g: 1, 2, 3, 4) : ");
                                                String seatStr = sc.nextLine();
                                                bookMoreSeat:
                                                if (seatStr.matches("^\\d+(\\s*,\\s*\\d+)*$")) {
                                                    String[] arrayOfBookingSeat = seatStr.split("\\s*,\\s*");

                                                    for (int i = 0; i < arrayOfBookingSeat.length; i++) {
                                                        for (int j = i + 1; j < arrayOfBookingSeat.length; j++) {
                                                            if (arrayOfBookingSeat[i].equals(arrayOfBookingSeat[j])) {
                                                                System.out.println(red + "Cannot book duplicate seats!" + reset);
                                                                continue backMenu;
                                                            }
                                                        }
                                                    }

                                                    seatBooked = new int[arrayOfBookingSeat.length];
                                                    for (int j = 0; j < arrayOfBookingSeat.length; j++) {
                                                        seatBooked[j] = Integer.parseInt(arrayOfBookingSeat[j].trim());
                                                    }
                                                    isBooking = true;

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
                                                        for (String seat : arrayOfBookingSeat) {
                                                            int seatNum = Integer.parseInt(seat.trim());
                                                            seats[Id - 1][seatNum - 1] = false; // Mark seat as unavailable
                                                            isAvailable[Id - 1]--;
                                                            unavailable[Id - 1]++;
                                                        }

                                                        bookedMovie[Id - 1] = nameOfMovie[Id - 1];
                                                        bookedSeat[Id - 1] = seatStr;
                                                        isBookedHall[Id - 1] = true;

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
                                                            comfirm = sc.nextLine();
                                                            if (comfirm.matches("^[Yy]$")) {
                                                                break bookMoreSeat;
                                                            } else if (comfirm.matches("^[Nn]$")) {
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
                                            System.out.println(red + "Invalid hall ID." + reset);
                                        }
                                    }
                                    break;

                                case 2:
                                    //Move to the first display of movie
                                    break;

                                case 3:
                                    //Move to the next display of movie
                                    break;

                                case 4:

                                    //Move to the page just leave
                                    break;

                                case 5:
                                    //Move to the last display of movie
                                    break;

                                case 6:
                                    break menu;

                                default:
                                    System.out.println(red + "Invalid option!" + reset);
                            }

                        }
                        else {
                            System.out.println(red + "No data to showing, please insert movie first!" + reset);
                            System.out.print(orange + "\n <<<<<<<<<<<<<<< Press any key to continue >>>>>>>>>>>>>>>\n" + reset);
                            sc.nextLine();
                        }
                        break;

                    case 3:
                        if (isBooking) {
                            System.out.println("==========| Your tickets have been booked! |=============");

                            for (int i = 0; i < numberHall; i++) {
                                boolean hallDisplayed = false;
                                StringBuilder bookedSeats = new StringBuilder();

                                for (int j = 0; j < seatEachHall; j++) {
                                    if (!seats[i][j]) {
                                        if (!hallDisplayed) {
                                            System.out.println("Hall #" + (i + 1));
                                            System.out.println("\t" + nameOfMovie[i]);
                                            System.out.print("Seat: ");
                                            hallDisplayed = true;
                                        }
                                        if (bookedSeats.length() > 0) {
                                            bookedSeats.append(", ");
                                        }
                                        bookedSeats.append(j + 1);
                                    }
                                }

                                if (hallDisplayed) {
                                    System.out.println(bookedSeats);
                                }
                            }
                        }
                        else {
                            System.out.println(red + "No booking data! Please booking first!" + reset);
                            System.out.print(orange + "\n <<<<<<<<<<<<<<< Press any key to continue >>>>>>>>>>>>>>>\n" + reset);
                            sc.nextLine();
                        }
                        break;

                    case 4:
                        if (isInserted && isBooking) {
                            while (true) {
                                System.out.print(orange + "Do you want to reset all hall with all seats available? (Y/N) :" + reset);
                                comfirm = sc.nextLine();
                                if (comfirm.matches("^[Yy]$")) {
                                    for (int i = 0; i < numberHall; i++) {
                                        for (int j = 0; j < seatEachHall; j++) {
                                            seats[i][j] = true;
                                        }
                                        isAvailable[i] = seatEachHall; // Reset available seats
                                        unavailable[i] = 0; // Reset unavailable seats
                                    }
                                    isBooking = false;
                                    System.out.println(green + "Hall was reset successfully ✅" + reset);
                                    break;
                                } else if (comfirm.matches("^[Nn]$")) {
                                    break;
                                } else {
                                    System.out.println(red + "Invalid confirmation. Please choose (Y or N)!" + reset);
                                }
                            }
                        } else {
                            System.out.println(red + "No data to reset!" + reset);
                            System.out.print(orange + "\n <<<<<<<<<<<<<<< Press any key to continue >>>>>>>>>>>>>>>\n" + reset);
                            sc.nextLine();
                        }
                        break;

                    case 5:
                        if (isInserted) {
                            System.out.println("=================================================");
                            System.out.println("   " + green + "     Set row to show movie record ✔  " + reset + "      ");
                            System.out.println("==================================================");
                            System.out.println("Enter number ");
                        } else {
                            System.out.println(red + "No data cannot set row to show movie!" + reset);
                            System.out.print(orange + "\n <<<<<<<<<<<<<<< Press any key to continue >>>>>>>>>>>>>>>\n" + reset);
                            sc.nextLine();
                        }
                        break;

                    case 6:
                        System.out.println("Thank for visited us. See you next time \uD83D\uDE4F\uD83C\uDFFD\uD83D\uDC99");
                        System.exit(0);
                    default:
                        System.out.println(red + "Invalid option!" + reset);
                }
            }
            else {
                System.out.println(red + "Invalid option!" + reset);
            }
        }
    }
}