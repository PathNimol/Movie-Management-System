package Quizes;

import java.util.Scanner;

public class Country {
    String countryName;
    int population;
    String capital;
    String currency;

    String getInformation(String name, int population, String capital, String currency){
        this.countryName = name;
        this.population = population;
        this.capital = capital;
        this.currency = currency;
        return (name + ", " + population + " millions people, " + "capital " + capital + " currency " + currency);
    }

    public static void main(String[] args) {
        Country country = new Country();

        System.out.println(country.getInformation("Cambodia", 17, "Phnom Penh", "Reil"));
        System.out.println();
        System.out.println(country.getInformation("UK", 70, "London", "Pound"));
        System.out.println();
        System.out.println(country.getInformation("Thailand", 60, "Bangkok", "Pound"));
    }
}
