package org.example.commands;

import org.example.model.LabWork;
import org.example.system.Request;

import java.util.Iterator;
import java.util.Scanner;

import static org.example.system.CollectionManager.priorityQueue;

public class CountGreaterThanMinimalPoint extends Command {
    public CountGreaterThanMinimalPoint() {
        super("count_greater_than_minimal_point");
    }
    private boolean needArguments = true;
    String args[];
    @Override
    public void execute(Request request) throws IllegalAccessException {
//        System.out.println("Введите значение минимального пойнта: ");
        Scanner in = new Scanner(System.in);
        args[0]= in.nextLine();
        double minpoint = Double.parseDouble(args[0]);
        request = new Request("countGreaterThanMinimalPoint", new LabWork(), args);
    }

    @Override
    public String getHelp() {
        return "вывести количество элементов, значение поля minimalPoint которых больше заданного";
    }
    public boolean isNeedArguments() {
        return needArguments;
    }
}
