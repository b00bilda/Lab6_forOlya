package org.example.system;


import org.example.model.*;

import java.util.Scanner;

public interface ReaderCreator {
    /*public default LabWork LabworkReaderCreator() throws IllegalAccessException{

        return
    }*/

    public default Person personReaderCreator(String args[]) throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        Person personNew = new Person();
        System.out.println("Введите информацию о человеке: ");
        System.out.println("Введите имя: ");
        args[0] = in.nextLine();
        personNew.setName(args[0]);
        int selectedWeight = 0;

        while (selectedWeight == 0) {
            System.out.println("Введите вес: ");
            try {
                args[1] = in.nextLine();
                selectedWeight = Integer.parseInt(args[1]);
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
                args[2] = in.nextLine();
                selectedEyeColor = Color.valueOf(args[2]);
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
                args[3] = in.nextLine();
                selectedHairColor = Color.valueOf(args[3]);
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
                args[4] = in.nextLine();
                selectedCountry = Country.valueOf(args[4]);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод национальности. Пожалуйста, введите еще раз");
            }
        }
        personNew.setNationality(selectedCountry);

        System.out.println("Введите местоположение: ");

        Location locationNew = new Location();
        System.out.println("Введите название места: ");
        args[5] = in.nextLine();
        locationNew.setName(args[5]);
        long x;
        while (true) {
            System.out.print("x = ");
            try {
                args[6] = in.nextLine();
                x = Long.parseLong(args[6]);
                break; // Выход из цикла, если ввод успешен
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
            }
        }
        locationNew.setX(x);
        int y;
        while (true) {
            System.out.print("y = ");
            try {
                args[7] = in.nextLine();
                y = Integer.parseInt(args[7]);
                break; // Выход из цикла, если ввод успешен
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
            }
        }
        locationNew.setY(y);
        float z;
        while (true) {
            System.out.print("z = ");
            try {
                args[8] = in.nextLine();
                z = Float.parseFloat(args[8]);
                break; // Выход из цикла, если ввод успешен
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
            }
        }
        locationNew.setZ(z);



        personNew.setLocation(locationNew);
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
