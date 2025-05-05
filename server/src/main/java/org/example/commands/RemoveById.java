package org.example.commands;

import org.example.system.Request;

import java.util.Scanner;

import static org.example.system.CollectionManager.removeByID;

public class RemoveById extends Command {
    public RemoveById() {
        super("remove_by_id");
    }

    public String execute(Request request) throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        long id;
        while (true) {
            System.out.println("Введите ID: ");
            try {
                String input = in.nextLine();
                id = Long.parseLong(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число long");
            }
        }
        removeByID(id);
        return "Выполнено успешно";
    }

    @Override
    public String getHelp() {
        return " удалить элемент из коллекции по его id";
    }
}
