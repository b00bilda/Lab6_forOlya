package org.example.commands;


import org.example.system.*;

public class Save extends Command {

    private final CSVCollectionManager csvCollectionManager;

    public Save(CSVCollectionManager csvCollectionManager) {
        super("save");
        this.csvCollectionManager = csvCollectionManager;
    }

    @Override
    public String execute(Request request) throws IllegalAccessException {
        csvCollectionManager.saveDataToFile(false); // false = перезапись
        return "Коллекция сохранена в файл.";
    }

    @Override
    public String getHelp() {
        return "сохранить коллекцию в файл";
    }
}