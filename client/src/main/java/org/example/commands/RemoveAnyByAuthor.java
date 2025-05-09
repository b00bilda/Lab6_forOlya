package org.example.commands;


import org.example.model.*;
import org.example.system.ReaderCreator;
import org.example.system.Request;

import java.io.IOException;
import java.util.Iterator;

import static org.example.system.CollectionManager.priorityQueue;

public class RemoveAnyByAuthor extends Command implements ReaderCreator {
    public RemoveAnyByAuthor() {
        super("remove_any_by_author");
    }
    private boolean needArguments = true;
    String args[] = new String[20];
    @Override
    public void execute(Request request) throws IllegalAccessException {
        System.out.println("Введите автора");



        Person author;
            author = personReaderCreator(new String[]{args[20]});
        Iterator<LabWork> iterator = priorityQueue.iterator();
        //priorityQueue.removeIf(labWork -> labWork.getAuthor() == author);
        boolean removed = false;
        while (iterator.hasNext()) {
            LabWork labWork = iterator.next();
            if (!removed && labWork.getAuthor() == author) {
                iterator.remove();
                removed = true;
            }
        }
        System.out.println("Выполнено успешно");
        request = new Request("removeAnyByAuthor", new LabWork(), args);
    }



    @Override
    public String getHelp() {
        return "удалить из коллекции один элемент, значение поля author которого эквивалентно заданному";
    }
}
