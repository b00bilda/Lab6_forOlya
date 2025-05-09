package org.example.commands;

import org.example.model.*;
import org.example.system.Request;

import java.util.Iterator;
import java.util.Scanner;

import static org.example.system.CollectionManager.priorityQueue;


public class UpdateId extends Command{
    public UpdateId() {
        super("update_id");
    }
    String[] args;
    @Override
    public void execute(Request request) throws IllegalAccessException {
        System.out.println("Введите id: ");
        Scanner in = new Scanner(System.in);
        long id;
        while (true) {
            System.out.println("Введите ID: ");
            try {
                args[1] = in.nextLine();
                id = Long.parseLong(args[1]);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число long");
            }
        }
        boolean f = false;
        Iterator<LabWork> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            LabWork lb = iterator.next();
            long currentId = lb.getId();

            if (currentId == id) {
                f = true;
                System.out.println("Введите имя: ");
                //while...
                args[2] = in.nextLine();
                lb.setName(args[2]);

                Coordinates coordinatesNew = new Coordinates();
                System.out.println("Введите координаты местоположения:");
                float x;
                while (true) {
                    System.out.print("x = ");
                    try {
                        args[3] = in.nextLine();
                        x = Float.parseFloat(args[3]);
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
                        args[4] = in.nextLine();
                        y = Float.parseFloat(args[4]);
                        break; // Выход из цикла, если ввод успешен
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
                    }
                }
                coordinatesNew.setY(y);


                lb.setCoordinates(coordinatesNew);
                double minpoint;
                while (true) {
                    System.out.println("Введите Минимальный Пойнт: ");
                    try {
                        args[5] = in.nextLine();
                        minpoint = Float.parseFloat(args[5]);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число double");
                    }
                }
                lb.setMinimalPoint(minpoint);
                Difficulty selectedDifficulty = null;
                while (selectedDifficulty == null) {
                    System.out.println("Введите сложность: ");
                    for (Difficulty difficulty : Difficulty.values()) {
                        System.out.println(difficulty);
                    }

                    try {
                        args[6] = in.nextLine();
                        selectedDifficulty = Difficulty.valueOf(args[6]);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: Некорректный ввод сложности. Пожалуйста, введите еще раз");
                    }
                }

                Person personNew = new Person();
                System.out.println("Введите информацию о человеке: ");
                System.out.println("Введите имя: ");
                args[7]= in.nextLine();
                personNew.setName(args[7]);
                int selectedWeight = 0;

                while (selectedWeight == 0) {
                    System.out.println("Введите вес: ");
                    try {
                        args[8] = in.nextLine();
                        selectedWeight = Integer.parseInt(args[8]);
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
                        args[9]= in.nextLine();
                        selectedEyeColor = Color.valueOf(args[9]);
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
                        args[10] = in.nextLine();
                        selectedHairColor = Color.valueOf(args[10]);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: Некорректный ввод цвета. Пожалуйста, введите еще раз");
                    }
                }
                personNew.setHairColor(selectedHairColor);

                Country selectedCountry = null;

                while (selectedCountry == null) {
                    System.out.println("Введите национальность: ");
                    for (Country country : Country.values()) {
                        System.out.println(country);
                    }

                    try {
                        args[11] = in.nextLine();
                        selectedCountry = Country.valueOf(args[11]);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: Некорректный ввод национальности. Пожалуйста, введите еще раз");
                    }
                }
                personNew.setNationality(selectedCountry);

                System.out.println("Введите местоположение: ");

                Location locationNew = new Location();
                System.out.println("Введите название места: ");
                locationNew.setName(in.nextLine());
                long x1=0;
                while (true) {
                    System.out.print("x = ");
                    try {
                        args[12] = in.nextLine();
                        x1 = Long.parseLong(args[12]);
                        break; // Выход из цикла, если ввод успешен
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
                    }
                }
                locationNew.setX(x1);
                int y1;
                while (true) {
                    System.out.print("y = ");
                    try {
                        args[13] = in.nextLine();
                        y1 = Integer.parseInt(args[13]);
                        break; // Выход из цикла, если ввод успешен
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
                    }
                }
                locationNew.setY(y1);
                float z;
                while (true) {
                    System.out.print("z = ");
                    try {
                        args[14] = in.nextLine();
                        z = Float.parseFloat(args[14]);
                        break; // Выход из цикла, если ввод успешен
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
                    }
                }
                locationNew.setZ(z);


                personNew.setLocation(locationNew);


                lb.setAuthor(personNew);
                break;
            }
            /*try {
                f=true;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: такого id нет. Пожалуйста, введите еще раз");
            }*/
        }
        //update_id(Long.parseLong(in.nextLine()));
        System.out.println("Выполнено успешно");
    }

    @Override
    public String getHelp() {
        return "изменяет поля объекта из коллекции по id";
    }
}
