package org.example.commands;


import org.example.system.Request;

import static org.example.system.CollectionManager.priorityQueue;

public class Clear extends Command {
    public Clear() {
        super("clear");
    }
    @Override
    public String execute(Request request) throws IllegalAccessException {
        priorityQueue.clear();
        return "Выполнено успешно";
    }

    @Override
    public String getHelp() {
        return "очистить коллекцию";
    }
}
