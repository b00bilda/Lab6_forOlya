package org.example.commands;

import org.example.system.Request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import org.example.model.*;

import static org.example.system.CollectionManager.priorityQueue;

public class PrintDescending extends Command {
    public PrintDescending() {
        super("print_descending");
    }

    @Override
    public String execute(Request request) throws IllegalAccessException {
        StringBuilder text = new StringBuilder();
        // Создаем копию PriorityQueue.  Так как используется naturalOrder(),
        // нам не нужно передавать компаратор.
        PriorityQueue<LabWork> queueCopy = new PriorityQueue<>(priorityQueue);

        // Преобразуем в ArrayList для сортировки
        List<LabWork> reversedQueue = new ArrayList<>(queueCopy);

        // Сортируем ArrayList в обратном порядке.  Теперь LabWork должен implements Comparable
        reversedQueue.sort(Collections.reverseOrder());

        System.out.println("Элементы в порядке убывания: ");
        for (LabWork labWork : reversedQueue) {
            text.append(labWork.toString() + "\n");
        }
        System.out.println("Выполнено успешно");
        return text.toString();
    }

    @Override
    public String getHelp() {
        return "";
    }
}
