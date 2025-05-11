package org.example.commands;



import org.example.model.*;
import org.example.system.Request;

import java.util.Iterator;

import static org.example.system.CollectionManager.priorityQueue;


public class Show extends Command {
    public Show() {
        super("show");
    }

    @Override
    public String execute(Request request) {
        Iterator<LabWork> iterator = priorityQueue.iterator();
        StringBuilder text = new StringBuilder();
        while (iterator.hasNext()) {
            LabWork labWork = iterator.next();
            text.append(labWork.toString() + "\n");
            System.out.println();
            }
        return text.toString();
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
