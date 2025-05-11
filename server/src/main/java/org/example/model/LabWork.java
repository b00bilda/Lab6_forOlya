package org.example.model;
//import static Comand.base.CollectionManager.priorityQueue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class LabWork implements Comparable<LabWork> {
    @Override
    public int compareTo(LabWork other) {
        return this.getName().compareTo(other.getName());
    }

    private final long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private final Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double minimalPoint; //Поле может быть null, Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле может быть null
    private Person author; //Поле может быть null

    public LabWork() {
        this.id = generateUniqueLongId();
        this.creationDate = new Date();
    }

    public String ShowLabWork(LabWork labWork) {
        StringBuilder text = new StringBuilder();
        text.append("Name: " + labWork.getName());
        text.append("ID: " + labWork.getId());
        text.append("Coordinates: " + labWork.getCoordinates().getX() + " " + labWork.getCoordinates().getY());
        text.append("CreationDate: " + labWork.getCreationDate());
        text.append("MinimalPoint: " + labWork.getMinimalPoint());
        text.append("Difficulty: " + labWork.getDifficulty());
        text.append("Author: " + labWork.getAuthor().getName() + "\n   eyes: " + labWork.getAuthor().getEyeColor() + "\n   hair: " + labWork.getAuthor().getHairColor() + "\n   location: " + labWork.getAuthor().getLocation().getName() + "\n   coordinates: " + labWork.getAuthor().getLocation().getX() + " " + labWork.getAuthor().getLocation().getY() + " " + labWork.getAuthor().getLocation().getZ() + " " + "\n   nationality: " + labWork.getAuthor().getNationality() + "\n   weight: " + labWork.getAuthor().getWeight());
        return text.toString();
    }

    public long getId() {
        return id;
    }

    /*public void newId() {
        this.id = generateUniqueLongId();;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalAccessException {
        if (name == null) {
            throw new IllegalAccessException("name");
        } else {
            this.name = name;
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Double getMinimalPoint() {
        return minimalPoint;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Person getAuthor() {
        return author;
    }
    /*public class Builder{
        private final long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        private String name = "LabWork"; //Поле не может быть null, Строка не может быть пустой
        private Coordinates coordinates; //Поле не может быть null
        private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        private Double minimalPoint = 1.0; //Поле может быть null, Значение поля должно быть больше 0
        private Difficulty difficulty = Difficulty.NORMAL; //Поле может быть null
        private Person author;

        public Builder(long id) {
            this.id = id;
        }*/

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public void setMinimalPoint(Double minimalPoint) {
        this.minimalPoint = minimalPoint;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }


    public void print() {
        System.out.println("Name: " + getName());
        System.out.println("Coordinates: " + getCoordinates());
        System.out.println("CreationDate: " + getCreationDate());
        System.out.println("MinimalPoint: " + getMinimalPoint());
        System.out.println("Difficulty: " + getDifficulty());
        System.out.println("Author: " + getAuthor());
    }

    //}
    public static LabWork ReadLabWork(String string) throws IllegalAccessException {
        String[] readings = string.split(" ");
        //как задать через строку, если есть Person??
        LabWork newLabWork = null;
        newLabWork.generateUniqueLongId();


        return newLabWork;
    }

    static List<Integer> idList = new ArrayList<>();

    private static final Random random = new Random();

    @Override
    public String toString() {
        return "LabWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates.toString() +
                ", creationDate=" + creationDate.toString() +
                ", minimalPoint=" + minimalPoint +
                ", difficulty=" + difficulty +
                ", author=" + author.toString() +
                '}';
    }

    public static long generateUniqueLongId() {
        long newId;
        newId = generateRandomLongId();
        boolean flag = true;
        do {
            flag = true;
            for (int i = 0; i < idList.size(); i++) {
                if (newId == idList.get(i)) {
                    flag = false;
                }
            }
        } while (!flag);
        return newId;
    }

    private static long generateRandomLongId() {
        return Math.abs(random.nextLong());  // Генерируем неотрицательное случайное long число
    }

    /*@Override
    public int compareTo(LabWork other) {
        // Сортируем по приоритету (по возрастанию) - это naturalOrder
        return Integer.compare(this.priority, other.priority);
    }*/

}

