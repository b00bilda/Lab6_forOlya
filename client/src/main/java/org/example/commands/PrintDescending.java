package org.example.commands;

import org.example.model.LabWork;
import org.example.system.Request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import static org.example.system.CollectionManager.priorityQueue;

public class PrintDescending extends Command {
    public PrintDescending() {
        super("print_descending");
    }

    @Override
    public void execute(Request request) throws IllegalAccessException {
        // Создаем копию PriorityQueue.  Так как используется naturalOrder(),
        // нам не нужно передавать компаратор.
        PriorityQueue<LabWork> queueCopy = new PriorityQueue<>(priorityQueue);

        // Преобразуем в ArrayList для сортировки
        List<LabWork> reversedQueue = new ArrayList<>(queueCopy);

        // Сортируем ArrayList в обратном порядке.  Теперь LabWork должен implements Comparable
        reversedQueue.sort(Collections.reverseOrder());

        System.out.println("Элементы в порядке убывания: ");
        for (LabWork labWork : reversedQueue) {
            labWork.ShowLabWork(labWork);
            System.out.println();
        }
        System.out.println("Выполнено успешно");
    }
    public boolean needArguments = false;
    @Override
    public String getHelp() {
        return "";
    }
    public boolean isNeedArguments() {
        return needArguments;
    }
}
