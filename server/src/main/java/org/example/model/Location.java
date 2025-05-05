package org.example.model;

public class Location {
    private long x;
    private Integer y; //Поле не может быть null
    private Float z; //Поле не может быть null
    private String name; //Поле не может быть null

    /*public Location(Integer y, Float z, String name) {
        this.y = y;
        this.z = z;
        this.name = name;
    }*/

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Float getZ() {
        return z;
    }

    public void setZ(Float z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
