package org.example.commands;

import org.example.model.LabWork;
import org.example.system.Client;
import org.example.system.Request;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ExecuteScript extends Command {
    private static Stack<File> stack = new Stack<>();
    Scanner in = new Scanner(System.in);
    public boolean needArguments = false;
    public ExecuteScript() {
        super("executeScript");
    }
    public boolean isNeedArguments() {
        return needArguments;
    }

    public void execute(Request request) {
        while (true){
            System.out.println("filename");
        File file = new File(in.nextLine());

        if (stack.contains(file)) {
            System.err.println("Рекурсия обнаружена");
        }

        if (file.canRead() && file.canWrite()) {
            stack.add(file);
        } else {
            System.err.println("");
        }

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(request.getArgs()[0])));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");

                if (parts[0].equals("add")) {
                    try {
                        String[] labWorkData = new String[14];
                        for (int n = 0; n < 14; n++) {
                            labWorkData[n] = parts[n + 1];
                            //System.out.println("dragonData[" + n + "]: " + lab[n]);
                        }

                        System.out.println("Отправляем данные labWork: " + Arrays.toString(labWorkData));

                        Client.sendRequest(new Request("add", new LabWork(labWorkData), labWorkData));

                    } catch (Exception e) {
                        System.out.println("Что-то не так с данными labWork: ");
                        e.printStackTrace();
                    }
                } else if (line.contains("execute_script")) {
                    File anotherFile = new File(line.split(" ")[1]);
                    if (stack.contains(anotherFile)) {
                        System.err.println("Рекурсия обнаружена");
                    }
                    if (!file.canRead()) {
                        System.err.println("Что-то не так с чтением файла: ");
                    } else {
                        Client.sendRequest(new Request("execute_script", new LabWork(), null));
                    }
                } else {
                    // String[] commandLine = line.split(" ");
                    String[] arguments = Arrays.copyOfRange(parts, 1, parts.length);
                    // System.out.println(arguments.toString());
                    String command = parts[0];
                    Client.sendRequest(new Request(command, new LabWork(), arguments));
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File can't be found");
        } catch (IOException e) {
            System.err.println("");
        }
            //request = new Request("remove_by_ID", new LabWork(), args);
    }}

    @Override
    public String getHelp() {
        return "";
    }

    public String getName() {
        return "execute_script";
    }


    public String getDescription() {
        return "executes script from file";
    }
}
