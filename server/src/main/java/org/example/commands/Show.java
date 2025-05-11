package org.example.commands;



import org.example.model.*;
import org.example.system.Request;
import org.example.system.ServerEnvironment;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

//import static org.example.system.CollectionManager.priorityQueue;


public class Show extends Command {
    public Show() {
        super("show");
    }

    @Override
    public String execute(Request request) {
        System.out.println("do show");
        StringBuilder text = new StringBuilder();
        PriorityQueue<LabWork> priorityQueue = ServerEnvironment.getInstance().getCollectionManager().getCollection();

        for (LabWork labWork : priorityQueue) {
            text.append(labWork.toString()).append("\n");
        }
        System.out.println(text);
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
