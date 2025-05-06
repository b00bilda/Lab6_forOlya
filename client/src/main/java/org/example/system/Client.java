package org.example.system;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.commands.Command;
import org.example.model.LabWork;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Client {
    Socket client;
    BufferedReader reader;
    static BufferedWriter writer;

    public void start(CommandManager commandManager) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDate()).create();
        LabWork labWork = null;


        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] commandLine = line.split(" ");
            String commandName = commandLine[0];
            // String[] arguments = Arrays.copyOfRange(commandLine, 1, commandLine.length);
            Command command = commandManager.getCommandList().get(commandName);
            Request request = null;

            if (!command.isNeedArguments()) {
                request = new Request(commandName, labWork, null);
            } else {
                try {
                    command.execute(request);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            String jsonRequest = gson.toJson(request);
            try {
                client = new Socket("localhost",8080);
                InputStream is = client.getInputStream();
                reader = new BufferedReader(new InputStreamReader(is));
                OutputStream os = client.getOutputStream();
                writer = new BufferedWriter(new OutputStreamWriter(os));
                writer.write(jsonRequest);

                while (reader.readLine() != null) {
                    String responseJson = reader.readLine();
                    Response response = gson.fromJson(responseJson, Response.class);
                    System.out.println(response.getMessage());
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void sendRequest(Request request) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDate()).create();
        String jsonRequest = gson.toJson(request);
        try {
            writer.write(jsonRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
