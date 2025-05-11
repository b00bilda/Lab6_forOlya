package org.example.commands;


import org.example.model.LabWork;
import org.example.system.Request;

import java.util.Queue;

import static org.example.system.CollectionManager.*;


public class Info extends Command {

    public Info() {
        super("info");
    }

    @Override
    public void execute(Request request) throws IllegalAccessException {
        Queue<LabWork> collection = getCollection();
        System.out.println("Тип коллекции: " + collection.getClass().getName());
        //System.out.println("Дата инициализации: " + (collection.getinitializationDate != null ? initializationDate : "Неизвестно"));
        System.out.println("Количество элементов: " + getSize());

        System.out.println("Первый элемент (по приоритету):");
        LabWork firstElement = getFirst();
        if (firstElement != null) {
            System.out.println(firstElement.toString());
        } else {
            System.out.println("Коллекция пуста.");
        }
    }
    public boolean needArguments = false;
    @Override
    public String getHelp() {
        return "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
    public boolean isNeedArguments() {
        return needArguments;
    }
}