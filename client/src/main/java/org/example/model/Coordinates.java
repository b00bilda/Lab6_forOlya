package org.example.model;

public class Coordinates {
    private float x=0; //Значение поля должно быть больше -204
    private float y=0;

   /* public Coordinates(float x, float y) {
        this.x = x;
        this.y = y;
    }*/

    public Coordinates() {
    }

    public Coordinates(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) throws IllegalAccessException{
        if (x<=-204) {
            throw new IllegalAccessException("name");
        }
        else{
            this.x = x;
        }
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
