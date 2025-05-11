package org.example.commands;



import org.example.model.*;
import org.example.system.Request;
import org.example.system.ServerEnvironment;

import java.util.Queue;

import static org.example.system.CollectionManager.*;
import static org.example.system.ServerEnvironment.environment;


public class Info extends Command {

    public Info() {
        super("info");
    }

    @Override
    public String execute(Request request) throws IllegalAccessException {
        Queue<LabWork> collection = ServerEnvironment.getInstance().getCollectionManager().getCollection();
        StringBuilder text = new StringBuilder();
        text.append(("Тип коллекции: " + collection.getClass().getName()) + "\n");
        //System.out.println("Дата инициализации: " + (collection.getinitializationDate != null ? initializationDate : "Неизвестно"));
        text.append("Количество элементов: " + ServerEnvironment.getInstance().getCollectionManager().getSize() + "\n");

        text.append("Первый элемент (по приоритету):" + "\n");
        LabWork firstElement = ServerEnvironment.getInstance().getCollectionManager().getFirst();
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