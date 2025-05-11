package org.example.commands;


import org.example.system.Request;
import org.example.system.ServerEnvironment;

//import static org.example.system.CollectionManager.priorityQueue;

public class Clear extends Command {
    public Clear() {
        super("clear");
    }
    @Override
    public String execute(Request request) throws IllegalAccessException {
        ServerEnvironment.getInstance().getCollectionManager().getCollection().clear();
        return "Выполнено успешно";
    }

    @Override
    public String getHelp() {
        return "очистить коллекцию";
    }
}
