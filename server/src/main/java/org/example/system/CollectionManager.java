package org.example.system;


import org.example.model.LabWork;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CollectionManager implements ReaderCreator {
    public PriorityQueue<LabWork> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());
    public PriorityQueue<LabWork> getCollection(){
        return priorityQueue;
    }
    public void add(LabWork labWork){
        priorityQueue.add(labWork);
    }



    public void remove(LabWork labWork){
        priorityQueue.remove(labWork);
    }

    public void removeByID(long idToRemove){
        priorityQueue.removeIf(item -> item.getId() == idToRemove);
    }

    public int getSize() {
        return priorityQueue.size();
    }

    public LabWork getFirst() {
        if (priorityQueue.isEmpty()) {
            return null;
        }
        return priorityQueue.peek(); // peek() retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    }

}
