package org.example.commands;


import org.example.model.LabWork;
import org.example.system.Request;

import java.util.HashMap;

import static org.example.system.CollectionManager.priorityQueue;


public class Head extends Command {
    public Head() {
        super("head");
    }

    @Override
    public void execute(Request request) throws IllegalAccessException {
        LabWork highestPriorityElement = priorityQueue.peek(); // Получаем элемент с наивысшим приоритетом
        if (highestPriorityElement != null) {
            System.out.println("Первый элемент: ");
            highestPriorityElement.ShowLabWork(highestPriorityElement);
        } else {
            System.out.println("Очередь пуста.");
        }
        System.out.println("Выполнено успешно");
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
