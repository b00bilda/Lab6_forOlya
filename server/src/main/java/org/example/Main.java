package org.example;

import org.example.system.CSVCollectionManager;
import org.example.system.CommandManager;
import org.example.system.Server;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Server server = new Server();

        server.start();

    }
}