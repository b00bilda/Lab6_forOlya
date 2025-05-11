package org.example.commands;



import org.example.model.*;
import org.example.system.*;

import java.util.Iterator;
import java.util.Scanner;

//import static org.example.system.CollectionManager.priorityQueue;


public class UpdateId extends Command implements ReaderCreator {
    public UpdateId() {
        super("update_id");
    }
    @Override
    public String execute(Request request) throws IllegalAccessException {
        long id = Long.parseLong(request.getArgs()[0]);

        boolean f = false;
        Iterator<LabWork> iterator = ServerEnvironment.getInstance().getCollectionManager().getCollection().iterator();
        while (iterator.hasNext()) {
            LabWork lb = iterator.next();
            long currentId = lb.getId();

            if (currentId == id) {
                f = true;
                lb.setName(request.getArgs()[1]);

                Coordinates coordinatesNew = new Coordinates();
                float x=0;
                    try {
                        String input = request.getArgs()[2];
                        x = Float.parseFloat(input);
                        break; // Выход из цикла, если ввод успешен
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
                    }

                coordinatesNew.setX(x);
                float y=0;
                    try {
                        String input = request.getArgs()[3];
                        y = Float.parseFloat(input);
                        break; // Выход из цикла, если ввод успешен
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число с плавающей точкой (например, 3.14).");
                    }
                                coordinatesNew.setY(y);


                lb.setCoordinates(coordinateReaderCreator());
                double minpoint=0;
                    try {
                        String input = request.getArgs()[4];
                        minpoint = Float.parseFloat(input);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число double");
                    }

                lb.setMinimalPoint(minpoint);
                Difficulty selectedDifficulty = null;

                    try {
                        selectedDifficulty = Difficulty.valueOf(request.getArgs()[5]);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: Некорректный ввод сложности. Пожалуйста, введите еще раз");
                    }

                lb.setAuthor(personReaderCreator(request.getArgs()[6], request.getArgs()[7], request.getArgs()[8], request.getArgs()[9], request.getArgs()[10], request.getArgs()[11], request.getArgs()[12], request.getArgs()[13]));
                break;
            }
            /*try {
                f=true;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: такого id нет. Пожалуйста, введите еще раз");
            }*/
        }
        //update_id(Long.parseLong(in.nextLine()));
        return "Выполнено успешно";
    }

    @Override
    public String getHelp() {
        return "изменяет поля объекта из коллекции по id";
    }
}
