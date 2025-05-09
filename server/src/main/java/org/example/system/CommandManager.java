package org.example.system;

import org.example.commands.*;
import org.example.commands.Exit;
import org.example.commands.PrintDescending;
import org.example.commands.RemoveById;

import java.util.HashMap;

public final class CommandManager {
    public static HashMap<String, Command> commandList = new HashMap<>();

    public CommandManager(CSVCollectionManager csvCollectionManager) {
        commandList.put("help", new Help());
        commandList.put("show", new Show());
        commandList.put("info", new Info());
        commandList.put("add", new Add());
        commandList.put("update_by_id", new UpdateId());
        commandList.put("remove_by_id", new RemoveById());
        commandList.put("clear", new Clear());
        commandList.put("save", new Save(csvCollectionManager)); // Передаем CSVCollectionManager
        commandList.put("execute_script", new ExecuteScript());
        commandList.put("exit", new Exit());
        commandList.put("remove_first", new RemoveFirst());
        commandList.put("head", new Head());
        commandList.put("remove_lower", new RemoveLower());
        commandList.put("remove_any_by_author", new RemoveAnyByAuthor());
        commandList.put("count_greater_than_minimal_point", new CountGreaterThanMinimalPoint());
        commandList.put("print_descending", new PrintDescending());
    }

    public HashMap<String, Command> getCommandList() {
        return commandList;
    }

    public String startExecuting(Request request) {
        if (commandList.containsKey(request.getMessage())) {
            if (request.getMessage().equals("add")) {
                CollectionManager.add(request.getLabWork());
            } else {
                Command command = commandList.get(request.getMessage());
                try {
                    return command.execute(request);
                } catch (IllegalAccessException e) {
                    return "";
                }
            }
        } else {
            return "Такой команды не существует";
        }
    }
}