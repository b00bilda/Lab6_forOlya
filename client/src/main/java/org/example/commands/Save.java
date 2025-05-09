package org.example.commands;


import org.example.system.CSVCollectionManager;
import org.example.system.Request;

public class Save extends Command {

    private final CSVCollectionManager csvCollectionManager;

    public Save(CSVCollectionManager csvCollectionManager) {
        super("save");
        this.csvCollectionManager = csvCollectionManager;
    }

    @Override
    public void execute(Request request) throws IllegalAccessException {
        csvCollectionManager.saveDataToFile(false); // false = перезапись
        System.out.println("Коллекция сохранена в файл.");
    }

    @Override
    public String getHelp() {
        return "сохранить коллекцию в файл";
    }
}