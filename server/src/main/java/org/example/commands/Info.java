package org.example.commands;



import org.example.model.*;
import org.example.system.Request;

import java.util.Queue;

import static org.example.system.CollectionManager.*;


public class Info extends Command {

    public Info() {
        super("info");
    }

    @Override
    public String execute(Request request) throws IllegalAccessException {
        Queue<LabWork> collection = getCollection();
        StringBuilder text = new StringBuilder();
        text.append(("Тип коллекции: " + collection.getClass().getName()) + "\n");
        //System.out.println("Дата инициализации: " + (collection.getinitializationDate != null ? initializationDate : "Неизвестно"));
        text.append("Количество элементов: " + getSize() + "\n");

        text.append("Первый элемент (по приоритету):" + "\n");
        LabWork firstElement = getFirst();
        if (firstElement != null) {
            text.append(firstElement.toString());
        } else {
            text.append("Коллекция пуста.");
        }
        return text.toString();
    }

    @Override
    public String getHelp() {
        return "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}