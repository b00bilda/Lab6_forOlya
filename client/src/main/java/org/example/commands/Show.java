package org.example.commands;


import org.example.model.LabWork;
import org.example.system.Request;

import java.util.Iterator;

import static org.example.system.CollectionManager.priorityQueue;


public class Show extends Command {
    public Show() {
        super("show");
    }
    public boolean needArguments = false;
    @Override
    public void execute(Request request) {
        System.out.println("do show");
        Iterator<LabWork> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println("while show");
            LabWork labWork = iterator.next();
            labWork.ShowLabWork(labWork);
            System.out.println();
            System.out.println("Выполнено успешно");
        }
    }

    @Override
    public String getHelp() {
        return "выводит в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
    public boolean isNeedArguments() {
        return needArguments;
    }
}
