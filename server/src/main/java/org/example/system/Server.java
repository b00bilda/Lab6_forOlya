package org.example.system;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import static org.example.system.CommandManager.startExecuting;

public class Server {

    public void start()  {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDate()).setPrettyPrinting().create();

        try {
            ServerSocket server = new ServerSocket(8080);
            while (true) {
                System.out.println("Ожидание соединения...");

                try (Socket client = server.accept()) {
                    System.out.println("успешно");
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    String filePath = reader.readLine();
                    String delimiter = reader.readLine();
                    CSVCollectionManager manager = new CSVCollectionManager(filePath, delimiter);
                    while (reader.readLine() != null) {
                        String json = reader.readLine().toString();
                        Request request = gson.fromJson(json, Request.class);
                        String message = startExecuting(request);
                        Response response = new Response(message);
                        String responseJson = gson.toJson(response);
                        writer.write(responseJson);
                    }
                    reader.close();
                    writer.close();
                } catch (IOException e) {
                    e.getMessage();
                }
                server.close();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

}
