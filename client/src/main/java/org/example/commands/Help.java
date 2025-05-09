package org.example.commands;


import org.example.system.Request;

import static org.example.system.CommandManager.commandList;

public class Help extends Command {
    public Help() {
        super("help");
    }
    @Override
    public void execute(Request request) {
        commandList.forEach((key, command) -> {
            System.out.println(key + ": " + command.getHelp());
        });
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
