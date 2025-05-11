package org.example.system;


import org.example.commands.Command;
import org.example.model.*;
import org.example.model.Difficulty;

import java.util.Scanner;



public class Add extends Command {
    public Add() {
        super("add");
    }

    public boolean needArguments = true;


    public void execute(Request request) throws IllegalAccessException {
        // LabWork labworkNew = new LabWork();
        String[] labWorkData = new String[14];
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        labWorkData[0] = in.nextLine();

        System.out.println("Введите координаты местоположения:");
        float x1;
        while (true) {
            System.out.print("x = ");
            try {
                String input = in.nextLine();
                x1 = Float.parseFloat(input);
                break; // Выход из цикла, если ввод успешен
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
            }
        }
        labWorkData[1] = String.valueOf(x1);
        float y1;
        while (true) {
            System.out.print("y = ");
            try {
                String input = in.nextLine();
                y1 = Float.parseFloat(input);
                break; // Выход из цикла, если ввод успешен
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
            }
        }
        labWorkData[2] = String.valueOf(y1);
        //labworkNew.setCoordinates(coordinateReaderCreator());

        double minpoint;
        while (true) {
            System.out.println("Введите Минимальный Пойнт: ");
            try {
                String input = in.nextLine();
                minpoint = Float.parseFloat(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число double");
            }
        }
        labWorkData[3] = String.valueOf(minpoint);

        Difficulty selectedDifficulty = null;
        while (selectedDifficulty == null) {
            System.out.println("Введите сложность: ");
            for (Difficulty difficulty : Difficulty.values()) {
                System.out.println(difficulty);
            }

            try {
                String line = in.nextLine();
                selectedDifficulty = Difficulty.valueOf(line);
                labWorkData[4] = line;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод сложности. Пожалуйста, введите еще раз");
            }
        }

        // Person personNew = new Person();
        System.out.println("Введите информацию о человеке: ");
        System.out.println("Введите имя: ");
        labWorkData[5] = in.nextLine();
        int selectedWeight = 0;

        while (selectedWeight == 0) {
            System.out.println("Введите вес: ");
            try {
                selectedWeight = Integer.parseInt(in.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод веса. Пожалуйста, введите еще раз");
            }
        }
        labWorkData[6] = String.valueOf(selectedWeight);


        Color selectedEyeColor = null;

        while (selectedEyeColor == null) {
            System.out.println("Введите цвет глаз: ");
            for (Color color : Color.values()) {
                System.out.println(color);
            }

            try {
                String line = in.nextLine();
                selectedEyeColor = Color.valueOf(line);
                labWorkData[7] = line;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод цвета. Пожалуйста, введите еще раз");
            }
        }

        Color selectedHairColor = null;

        while (selectedHairColor == null) {
            System.out.println("Введите цвет волос: ");
            for (Color color : Color.values()) {
                System.out.println(color);
            }
            try {
                String line = in.nextLine();
                selectedHairColor = Color.valueOf(line);
                labWorkData[8] = line;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод цвета. Пожалуйста, введите еще раз");
            }
        }

        Country selectedCountry = null;

        while (selectedCountry == null) {
            System.out.println("Введите национальность: ");
            for (Country country : Country.values()) {
                System.out.println(country);
            }

            try {
                String line = in.nextLine();
                selectedCountry = Country.valueOf(line);
                labWorkData[9] = line;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод национальности. Пожалуйста, введите еще раз");
            }
        }


        System.out.println("Введите местоположение: ");
        System.out.println("Введите название места: ");
        labWorkData[10] = in.nextLine();
        long x;
        while (true) {
            System.out.print("x = ");
            try {
                String input = in.nextLine();
                x = Long.parseLong(input);
                break; // Выход из цикла, если ввод успешен
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
            }
        }
        labWorkData[11] = String.valueOf(x);
        int y;
        while (true) {
            System.out.print("y = ");
            try {
                String input = in.nextLine();
                y = Integer.parseInt(input);
                break; // Выход из цикла, если ввод успешен
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
            }
        }
        labWorkData[12] = String.valueOf(y);
        float z;
        while (true) {
            System.out.print("z = ");
            try {
                String input = in.nextLine();
                z = Float.parseFloat(input);
                break; // Выход из цикла, если ввод успешен
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
            }
        }
        labWorkData[13] = String.valueOf(z);

        System.out.println("Выполнено успешно");
        LabWork labWork = new LabWork(labWorkData);
        request.setLabWork(labWork);

        System.out.println("Реквест обновлен: " + request.toString());
    }



    public String getHelp() {
        return "добавляет новый labwork в коллекцию";
    }

   /* public static void register(HashMap<String,Command> stringCommandHashMap) {
        Add add = new Add();
        stringCommandHashMap.put(add.getName(), help);
    }*/
   public boolean isNeedArguments() {
       return needArguments;
   }
}
