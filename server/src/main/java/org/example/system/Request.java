package org.example.system;

import org.example.model.LabWork;

public class Request {
    String message;
    LabWork labWork;
    String[] args;

    public Request(String message, LabWork labWork, String[] args) {
        this.message = message;
        this.labWork = labWork;
        this.args = args;
    }

    public String getMessage() {
        return message;
    }

    public LabWork getLabWork() {
        return labWork;
    }

    public String[] getArgs() {
        return args;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLabWork(LabWork labWork) {
        this.labWork = labWork;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}
