package org.example.commands;



import org.example.model.*;
import org.example.system.*;

import java.util.Iterator;
import java.util.Scanner;

import static org.example.system.CollectionManager.priorityQueue;

public class RemoveAnyByAuthor extends Command implements ReaderCreator {
    public RemoveAnyByAuthor() {
        super("remove_any_by_author");
    }
    @Override
    public String execute(Request request) throws IllegalAccessException {
        System.out.println("Введите автора");
        Person author = new Person();
        author.setName(request.getArgs()[0]);
        int selectedWeight = 0;

        while (selectedWeight == 0) {
            System.out.println("Введите вес: ");
            try {
                selectedWeight = Integer.parseInt(request.getArgs()[1]);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод веса. Пожалуйста, введите еще раз");
            }
        }
        author.setWeight(selectedWeight);

        Color selectedEyeColor = null;
            try {
                selectedEyeColor = Color.valueOf(request.getArgs()[2]);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод цвета. Пожалуйста, введите еще раз");
            }
        author.setEyeColor(selectedEyeColor);

        Color selectedHairColor = null;

            try {
                selectedHairColor = Color.valueOf(request.getArgs()[3]);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод цвета. Пожалуйста, введите еще раз");
            }
        author.setHairColor(selectedHairColor);

        Country selectedCountry = null;

            try {
                selectedCountry = Country.valueOf(request.getArgs()[4]);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Некорректный ввод национальности. Пожалуйста, введите еще раз");
            }

        author.setNationality(selectedCountry);

        author.setLocation(new Location(Integer.parseInt(request.getArgs()[5]), Float.parseFloat(request.getArgs()[6]), request.getArgs()[7]));


        Iterator<LabWork> iterator = priorityQueue.iterator();
        //priorityQueue.removeIf(labWork -> labWork.getAuthor() == author);
        boolean removed = false;
        while (iterator.hasNext()) {
            LabWork labWork = iterator.next();
            if (!removed && labWork.getAuthor() == author) {
                iterator.remove();
                removed = true;
            }
        }
        return "Выполнено успешно";
    }

    @Override
    public String getHelp() {
        return "удалить из коллекции один элемент, значение поля author которого эквивалентно заданному";
    }
}
