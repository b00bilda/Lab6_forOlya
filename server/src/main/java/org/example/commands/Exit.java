package org.example.commands;

import org.example.system.Request;

public class Exit extends Command {

    public Exit() {
        super("exit");
    }

    @Override
    public String execute(Request request) {
        System.exit(0); // 0 обычно означает успешное завершение
        return "";
    }

    @Override
    public String getHelp() {
        return "завершение программы (без сохранения в файл)";
    }
}