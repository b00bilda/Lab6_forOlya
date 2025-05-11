package org.example.commands;

import org.example.system.Request;

public class Exit extends Command {

    public Exit() {
        super("exit");
    }
    public boolean needArguments = false;
    @Override
    public void execute(Request request) {
        System.out.println("Завершение программы...");
        System.exit(0); // 0 обычно означает успешное завершение
    }

    @Override
    public String getHelp() {
        return "завершение программы (без сохранения в файл)";
    }
    public boolean isNeedArguments() {
        return needArguments;
    }
}