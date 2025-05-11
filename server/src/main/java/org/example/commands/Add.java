package org.example.commands;

import org.example.system.Request;

import static org.example.system.CollectionManager.priorityQueue;

public class Add extends Command {
    public Add() {
        super("add");
    }
    @Override
    public String execute(Request request) throws IllegalAccessException {

        return "Выполнено успешно";
    }

    @Override
    public String getHelp() {
        return "add";
    }
}
