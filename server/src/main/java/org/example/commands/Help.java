package org.example.commands;


import org.example.system.Request;

import static org.example.system.CommandManager.commandList;

public class Help extends Command {
    public Help() {
        super("help");
    }
    @Override
    public String execute(Request request) {
        StringBuilder text = new StringBuilder();
        commandList.forEach((key, command) -> {
            text.append(String.valueOf(key) + ": " + String.valueOf(command.getHelp()));
        });
        return text.toString();
    }

    @Override
    public String getHelp() {
        return "выводит справку по доступным командам";
    }

   /* public static void register(HashMap<String,Command> stringCommandHashMap) {
        Help help = new Help();
        stringCommandHashMap.put(help.getName(), help);
    }*/
}
