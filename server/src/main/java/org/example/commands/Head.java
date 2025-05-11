package org.example.commands;


import org.example.model.*;
import org.example.system.Request;
import org.example.system.ServerEnvironment;

import java.util.HashMap;

//import static org.example.system.CollectionManager.priorityQueue;


public class Head extends Command {
    public Head() {
        super("head");
    }

    @Override
    public String execute(Request request) throws IllegalAccessException {
        LabWork highestPriorityElement = ServerEnvironment.getInstance().getCollectionManager().getCollection().peek(); // Получаем элемент с наивысшим приоритетом
        StringBuilder text = new StringBuilder();
        if (highestPriorityElement != null) {
            text.append("Первый элемент: ");
            text.append(String.valueOf(highestPriorityElement.ShowLabWork(highestPriorityElement)));
        } else {
            text.append("Очередь пуста.");
        }
        text.append("Выполнено успешно");
        return text.toString();
    }

    @Override
    public String getHelp() {
        return "вывести первый элемент коллекции";
    }

    public static void register(HashMap<String,Command> stringCommandHashMap) {
        Head head = new Head();
        stringCommandHashMap.put(head.getName(), head);
    }
}
