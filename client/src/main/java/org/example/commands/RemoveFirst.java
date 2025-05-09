package org.example.commands;
import org.example.system.Request;

import static org.example.system.CollectionManager.priorityQueue;

public class RemoveFirst extends Command {
    public RemoveFirst() {
        super("remove first");
    }
    @Override
    public void execute(Request request) throws IllegalAccessException {
        priorityQueue.poll();
        System.out.println("Выполнено успешно");
    }

    @Override
    public String getHelp() {
        return "удалить первый элемент из коллекции";
    }
}
