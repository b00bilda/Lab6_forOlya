package org.example.commands;


import org.example.model.LabWork;
import org.example.system.Request;

import java.util.Scanner;

import static org.example.system.CollectionManager.priorityQueue;


public class RemoveLower extends Command{
    public RemoveLower(){
        super("remove_lower");
    }
    private boolean needArguments = true;
    String[] args;
    @Override
    public void execute(Request request) {
        long id;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите id элемента, элементы меньшие которого хотите удалить");
            try {
                args[0] = in.nextLine();
                id = Long.parseLong(args[0]);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат числа. Пожалуйста, введите число long");
            }
        }
        request = new Request("removeLower", new LabWork(), args);

    }

    @Override
    public String getHelp() {
        return "удалить из коллекции все элементы, меньшие, чем заданный";
    }
    public boolean isNeedArguments() {
        return needArguments;
    }
}
