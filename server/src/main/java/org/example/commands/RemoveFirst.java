package org.example.commands;
import org.example.system.Request;
import org.example.system.ServerEnvironment;

import java.util.Scanner;

//import static org.example.system.CollectionManager.priorityQueue;

public class RemoveFirst extends Command {
    public RemoveFirst() {
        super("remove first");
    }
    @Override
    public String execute(Request request) throws IllegalAccessException {
        ServerEnvironment.getInstance().getCollectionManager().getCollection().poll();
        return "Выполнено успешно";
    }

    @Override
    public String getHelp() {
        return "удалить первый элемент из коллекции";
    }
}
