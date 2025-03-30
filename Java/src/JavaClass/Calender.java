package JavaClass;

import java.util.Scanner;

public class Calender {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter start day: ");
        int startDay = sc.nextInt();

        System.out.print("Enter days in month: ");
        int daysInMonth = sc.nextInt();

        System.out.printf("%-7s%-7s%-7s%-7s%-7s%-7s%-7s\n", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

        for(int i = 1; i < startDay; i++) {
            System.out.print("       ");
        }
        int currentDay = startDay;
        int dayCount = 1;


        for (int i = 1; i < dayCount; i++) {
            System.out.println("   ");
        }
        while(dayCount <= daysInMonth) {
            if (currentDay == 7) {
                System.out.printf("\033[31m%-7d\033[0m", dayCount);
            }
            else if(currentDay == 6){
                 
            }
            else {
                System.out.printf("%-7d", dayCount);
            }

            dayCount++;

            if(currentDay == 7) {
                System.out.println();
                currentDay = 1;
            }else {
                currentDay++;
            }
        }
        if(currentDay != 1){
            System.out.println();
        }
    }
}
