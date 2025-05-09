package org.example.system;


import org.example.model.*;

import java.util.Scanner;

public interface ReaderCreator {
    /*public default LabWork LabworkReaderCreator() throws IllegalAccessException{

        return
    }*/

    public default Person personReaderCreator(String weight, String eyeColor, String hairColor, String country, String xl, String yl, String zl, String namel) throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        Person personNew = new Person();
        System.out.println("Введите информацию о человеке: ");
        System.out.println("Введите имя: ");
        personNew.setName(in.nextLine());
        int selectedWeight = 0;

        while (selectedWeight == 0) {
            System.out.println("Введите вес: ");
            try {
                selectedWeight = Integer.parseInt(weight);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод веса. Пожалуйста, введите еще раз");
            }
        }
        personNew.setWeight(selectedWeight);


        Color selectedEyeColor = null;

        while (selectedEyeColor == null) {
            System.out.println("Введите цвет глаз: ");
            for (Color color : Color.values()) {
                System.out.println(color);
            }

            try {
                selectedEyeColor = Color.valueOf(eyeColor);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод цвета. Пожалуйста, введите еще раз");
            }
        }
        personNew.setEyeColor(selectedEyeColor);

        Color selectedHairColor = null;

        while (selectedHairColor == null) {
            System.out.println("Введите цвет волос: ");
            for (Color color : Color.values()) {
                System.out.println(color);
            }

            try {
                selectedHairColor = Color.valueOf(hairColor);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод цвета. Пожалуйста, введите еще раз");
            }
        }
        personNew.setHairColor(selectedHairColor);

        Country selectedCountry = null;

        while (selectedCountry == null) {
            System.out.println("Введите национальность: ");
            for (Country countryy : Country.values()) {
                System.out.println(countryy);
            }

            try {
                selectedCountry = Country.valueOf(country);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод национальности. Пожалуйста, введите еще раз");
            }
        }
        personNew.setNationality(selectedCountry);

        System.out.println("Введите местоположение: ");
        personNew.setLocation(locationReaderCreator(xl, xl, zl, namel));
        return personNew;
    }
    public default Location locationReaderCreator(String x, String y, String z, String name) throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        Location locationNew = new Location(Long.parseLong(x), Integer.parseInt(y), Float.parseFloat(z), name);
        return locationNew;
    }
    public default Coordinates coordinateReaderCreator() throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        Coordinates coordinatesNew = new Coordinates();
        System.out.println("Введите координаты местоположения:");
        float x;
        while (true) {
            System.out.print("x = ");
            try {
                String input = in.nextLine();
                x = Float.parseFloat(input);
                break; // Выход из цикла, если ввод успешен
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
            }
        }
        coordinatesNew.setX(x);
        float y;
        while (true) {
            System.out.print("y = ");
            try {
                String input = in.nextLine();
                y = Float.parseFloat(input);
                break; // Выход из цикла, если ввод успешен
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
            }
        }
        coordinatesNew.setY(y);
        return coordinatesNew;
    }
}
