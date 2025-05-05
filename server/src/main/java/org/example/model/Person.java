package org.example.model;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int weight; //Значение поля должно быть больше 0
    private Color eyeColor; //Поле не может быть null
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле может быть null



    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalAccessException {
        if (name==null) {
            throw new IllegalAccessException("name");
        }
        else{
            this.name = name;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws IllegalAccessException {
        if (weight<0) {
            throw new IllegalAccessException("name");
        }
        else{
            this.weight = weight;
        }
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
