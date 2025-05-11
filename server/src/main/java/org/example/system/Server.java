package org.example.system;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;



public class Server {

    public void start()  {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDate()).create();

        try {
            ServerSocket server = new ServerSocket(8080);
            while (true) {
                System.out.println("Ожидание соединения...");

                try (Socket client = server.accept()) {
                    System.out.println("успешно");
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

                    String filePath = null;
                    try {
                        filePath = reader.readLine();
                        System.out.println("название файла:" + filePath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    String delimiter = null;
                    try {
                        delimiter = reader.readLine();
                        System.out.println("разделитель" + delimiter);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    CollectionManager colmanager = new CollectionManager();

                    CSVCollectionManager manager = new CSVCollectionManager(filePath, delimiter);
                    CommandManager commandManager = new CommandManager(manager);

                    ServerEnvironment.getInstance().setCommandManager(commandManager);
                    ServerEnvironment.getInstance().setCSVCollectionManager(manager);
                    ServerEnvironment.getInstance().setCollectionManager(colmanager);

                    String json;
                    while ((json = reader.readLine()) != null) {
                        System.out.println("получен запрос: " + json);
                        Request request = gson.fromJson(json, Request.class);
                        String message = commandManager.startExecuting(request);
                        Response response = new Response(message);
                        String responseJson = gson.toJson(response);
                        writer.write(responseJson + "\n");
                        writer.flush();
                        System.out.println("отправлен ответ: " + responseJson);
                    }
                    reader.close();
                    writer.close();
                } catch (IOException e) {
                    System.err.println("чтото пошло не так");
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }

    }

}