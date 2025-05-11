package org.example.system;

public class ServerEnvironment {
    public static ServerEnvironment environment;

    CollectionManager collectionManager;
    CommandManager commandManager;
    CSVCollectionManager fileManager;

    public static ServerEnvironment getInstance() {
        if (environment == null) {
            environment = new ServerEnvironment();
        }
        return environment;
    }

    private ServerEnvironment() {}

    public CollectionManager getCollectionManager() {
        return collectionManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public CSVCollectionManager getFileManager() {
        return fileManager;
    }


    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public void setFileManager(CSVCollectionManager fileManager) {
        this.fileManager = fileManager;
    }
}
