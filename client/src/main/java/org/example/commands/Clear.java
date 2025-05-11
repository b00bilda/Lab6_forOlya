package org.example.commands;


import org.example.system.Request;

import static org.example.system.CollectionManager.priorityQueue;

public class Clear extends Command {
    public Clear() {
        super("clear");
    }
    public boolean needArguments = false;
    @Override
    public void execute(Request request) throws IllegalAccessException {
        priorityQueue.clear();
        System.out.println("Выполнено успешно");
    }

    @Override
    public String getHelp() {
        return "очистить коллекцию";
    }
    public boolean isNeedArguments() {
        return needArguments;
    }
}
