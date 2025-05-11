package org.example.commands;

import org.example.model.LabWork;
import org.example.system.Request;

import java.util.Scanner;

import static org.example.system.CollectionManager.removeByID;

public class RemoveById extends Command {
    public boolean needArguments = true;
    String[] args;

    public RemoveById() {
        super("Remove by ID");
    }

    public void execute(Request request) throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите ID: ");
            try {
                args[0] = in.nextLine();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число long");
            }
        }
        request = new Request("remove_by_ID", new LabWork(), args);
    }

    @Override
    public String getHelp() {
        return " удалить элемент из коллекции по его id";
    }
    public boolean isNeedArguments() {
        return needArguments;
    }
}
