package org.example.system;



import org.example.model.*;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CSVCollectionManager {
    private List<LabWork> dataCollection; // Коллекция для хранения LabWork
    private String filePath;
    private String delimiter;

    public CSVCollectionManager() {
        this.filePath = filePath;
        this.delimiter = delimiter;
        this.dataCollection = new ArrayList<>();
        loadDataFromFile();
    }

    public List<LabWork> getDataCollectionLabWork() {
        return dataCollection;
    }

    private void loadDataFromFile() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath), Charset.forName("UTF-8"));
            scanner.useDelimiter(System.lineSeparator());

            // Пропускаем строку заголовка
            if (scanner.hasNext()) {
                scanner.next();
            }

            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] values = line.split(delimiter);

                if (values.length == 14) { // Ожидаем 14 значений
                    try {
                        String name = values[0];
                        float coordinatesX = Float.parseFloat(values[1]);
                        float coordinatesY = Float.parseFloat(values[2]);
                        Double minimalPoint = Double.parseDouble(values[3]);
                        Difficulty difficulty = Difficulty.valueOf(values[4]);

                        String personName = values[5];
                        int weight = Integer.parseInt(values[6]);
                        Color eyeColor = Color.valueOf(values[7]);
                        Color hairColor = (values[8].isEmpty()) ? null : Color.valueOf(values[8]);
                        Country nationality = (values[9].isEmpty()) ? null : Country.valueOf(values[9]);

                        Long locationX = Long.parseLong(values[10]);
                        Integer locationY = Integer.parseInt(values[11]);
                        Float locationZ = Float.parseFloat(values[12]);
                        String locationName = values[13];

                        // Создаем объект Coordinates
                        Coordinates coordinates = new Coordinates();
                        coordinates.setX(coordinatesX);
                        coordinates.setY(coordinatesY);

                        // Создаем объект Location
                        Location location = new Location(locationX, locationY, locationZ, locationName);
                        /*location.setX(locationX);
                        location.setY(locationY);
                        location.setZ(locationZ);
                        location.setName(locationName);*/

                        // Создаем объект Person
                        Person person = new Person();
                        person.setLocation(location);
                        person.setName(personName);
                        person.setWeight(weight);
                        person.setEyeColor(eyeColor);
                        person.setHairColor(hairColor);
                        person.setNationality(nationality);

                        LabWork labWork = new LabWork();
                        labWork.setName(name);
                        labWork.setCoordinates(coordinates);
                        labWork.setAuthor(person);
                        labWork.setDifficulty(difficulty);
                        labWork.setMinimalPoint(minimalPoint);

                        dataCollection.add(labWork);

                    } catch (NumberFormatException e) {
                        System.err.println("Ошибка преобразования числа: " + e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.err.println("Неверное значение enum или нарушение ограничения: " + e.getMessage());
                    } catch (IllegalAccessException e) {
                        System.err.println("Ошибка установки поля: " + e.getMessage());
                    } catch (Exception e) {
                        System.err.println("Общая ошибка при чтении данных: " + e.getMessage());
                    }
                } else {
                    System.err.println("Неверное количество столбцов в строке: " + line);
                }
            }
            System.out.println("Данные успешно загружены из файла: " + filePath);
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден: " + filePath);
        } catch (NoSuchElementException e) {
            System.err.println("Ошибка: Некорректный формат данных в файле: " + filePath);
        } catch (Exception e) {
            System.err.println("Произошла ошибка при чтении файла " + filePath + ": " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public boolean saveDataToFile(boolean appendToFile) {
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(filePath, appendToFile));

            // Записываем строку заголовка
            String header = "name,coordinatesX,coordinatesY,weight,eyeColor,hairColor,nationality,locationX,locationY,locationZ,locationName" + System.lineSeparator();
            bos.write(header.getBytes(Charset.forName("UTF-8")));

            for (LabWork labWork : dataCollection) {
                StringBuilder sb = new StringBuilder();
                sb.append(labWork.getName()).append(delimiter);
                sb.append(labWork.getCoordinates().getX()).append(delimiter);
                sb.append(labWork.getCoordinates().getY()).append(delimiter);
                sb.append(labWork.getMinimalPoint()).append(delimiter);
                sb.append(labWork.getDifficulty()).append(delimiter);
                sb.append(labWork.getAuthor().getName()).append(delimiter);
                sb.append(labWork.getAuthor().getWeight()).append(delimiter);
                sb.append(labWork.getAuthor().getEyeColor()).append(delimiter);
                sb.append(labWork.getAuthor().getHairColor()).append(delimiter);
                sb.append(labWork.getAuthor().getNationality()).append(delimiter);
                sb.append(labWork.getAuthor().getLocation().getX()).append(delimiter);
                sb.append(labWork.getAuthor().getLocation().getY()).append(delimiter);
                sb.append(labWork.getAuthor().getLocation().getZ()).append(delimiter);
                sb.append(labWork.getAuthor().getLocation().getName()).append(delimiter);

                sb.append(System.lineSeparator());

                byte[] bytes = sb.toString().getBytes(Charset.forName("UTF-8"));
                bos.write(bytes);
            }
            System.out.println("Данные успешно записаны в файл: " + filePath);
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Невозможно создать/открыть файл для записи: " + filePath);
            return false;
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода при записи в файл: " + e.getMessage());
            return false;
        } catch (SecurityException e) {
            System.err.println("Ошибка: Отсутствуют права доступа для записи в файл: " + filePath);
            return false;
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка при записи в файл: " + e.getMessage());
            return false;
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при закрытии BufferedOutputStream: " + e.getMessage());
                }
            }
        }
    }
}