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
    @Override
    public String execute(Request request) throws IllegalAccessException {
//        System.out.println("Введите значение минимального пойнта: ");
//        Scanner in = new Scanner(System.in);
        double minpoint = Double.parseDouble(request.getArgs()[0]);
        Iterator<LabWork> iterator = priorityQueue.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            LabWork labWork = iterator.next();
            if (labWork.getMinimalPoint() > minpoint) {
                count++;
            }
        }
        if (count == 0) {
            return "Элементов с бо'льшими минимальными пойнтами нет";
        }
        else {
            return String.valueOf(count);
        }
    }

    @Override
    public String getHelp() {
        return "вывести количество элементов, значение поля minimalPoint которых больше заданного";
    }
}
