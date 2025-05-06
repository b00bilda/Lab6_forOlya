package org.example.commands;

import org.example.system.Request;

import java.util.Scanner;

import static org.example.system.CollectionManager.removeByID;

public class RemoveById extends Command {
    public RemoveById() {
        super("remove_by_id");
    }
    @Override
    public String execute(Request request) throws IllegalAccessException {
        removeByID(Long.parseLong(request.getArgs()[0]));
        return "Выполнено успешно";
    }

    @Override
    public String getHelp() {
        return " удалить элемент из коллекции по его id";
    }
}
