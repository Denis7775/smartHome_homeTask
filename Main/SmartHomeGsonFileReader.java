package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class SmartHomeGsonFileReader {

    static SmartHome gsonRead() throws IOException{
        Gson gson = new Gson();
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get("C:\\java_examples\\Software_design\\smart-home\\smart-home-1.js")));
        }catch (IOException e){
            System.out.println("Не найден файл smart-home-1.js");
        }
        return gson.fromJson(json, SmartHome.class);
    }
}
