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
import java.util.List;
import java.util.Scanner;

public class Client {
    Socket client;
    BufferedReader reader;
    static PrintWriter writer;

    public void start(CommandManager commandManager) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDate()).create();
        LabWork labWork = null;

        try {
            client = new Socket("localhost",8080);
            InputStream is = client.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));
            OutputStream os = client.getOutputStream();
            writer = new PrintWriter(new OutputStreamWriter(os), true);
        } catch (IOException e) {
            e.getMessage();
        }


        System.out.println("Введите путь к файлу CSV: ");
        String filePath = scanner.nextLine();
        writer.println(filePath);
        System.out.println("введен путь: " + filePath);


        System.out.println("Введите разделитель: ");
        String delimiter = scanner.nextLine();
        System.out.println("введен разделитель: " + delimiter);
        writer.println(delimiter);

        //CSVCollectionManager manager = new CSVCollectionManager(filePath, delimiter);

        // Получаем коллекцию LabWork из CSVCollectionManager
        //List<LabWork> labWorks = manager.getDataCollectionLabWork();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] commandLine = line.split(" ");
            String commandName = commandLine[0];
            // String[] arguments = Arrays.copyOfRange(commandLine, 1, commandLine.length);
            Command command = commandManager.getCommandList().get(commandName);

            Request request = new Request(commandName, labWork, null);
            try {
                if (command.isNeedArguments()) {
                    command.execute(request);  // Теперь execute изменит данные внутри request
                }
            } catch (IllegalAccessException e) {
                e.getMessage();
            }


//            if (!command.isNeedArguments()) {
//                request = new Request(commandName, labWork, null);
//            } else {
//                try {
//                    command.execute(request);
//                    continue;
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }

            String jsonRequest = gson.toJson(request);

            try {
                writer.println(jsonRequest);

                System.out.println("ждем");

                // Чтение ответа от сервера
                String responseJson;
                while ((responseJson = reader.readLine()) != null) {
                    if (responseJson.trim().isEmpty()) {
                        continue;  // Пропускаем пустые строки
                    }

                    System.out.println("Ответ от сервера: " + responseJson);
                    Response response = gson.fromJson(responseJson, Response.class);
                    System.out.println("Ответ получен:");
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
        writer.println(jsonRequest);
    }
}