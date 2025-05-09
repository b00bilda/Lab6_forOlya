package org.example.commands;


import org.example.model.LabWork;
import org.example.system.Request;

import java.util.Iterator;

import static org.example.system.CollectionManager.priorityQueue;


public class Show extends Command {
    public Show() {
        super("show");
    }

    @Override
    public void execute(Request request) {
        Iterator<LabWork> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
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
    /*public void ShowLabWork(LabWork labWork){
        System.out.println(labWork.getId());
        System.out.println(labWork.getName());
        System.out.println(labWork.getCoordinates());
        System.out.println(labWork.getCreationDate());
        System.out.println(labWork.getMinimalPoint());
        System.out.println(labWork.getDifficulty());
        System.out.println(labWork.getAuthor());
    }*/
}
