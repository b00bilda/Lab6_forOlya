package org.example;

import org.example.system.CSVCollectionManager;
import org.example.system.Client;
import org.example.system.CommandManager;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Main {
    public static void main(String[] args){
//        if (args.length != 2) {
//            System.out.println("Wrong argument");
//            return;
//        }
//        String host = "127.0.0.1";
//        int port = 6651;


        CSVCollectionManager manager = new CSVCollectionManager();
        CommandManager commandManager = new CommandManager(manager);
        Client client = new Client();
        client.start(commandManager);
    }
}