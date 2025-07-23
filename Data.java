import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;

public class Data {
    public static final String FILE_NAME = "data.json";

    public static void storeStrData(String keyName, String data) {
        Gson gson = new Gson();
        Map<String, String> jsonData = new HashMap<>();

        // Load existing data if the file exists
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (Reader reader = new FileReader(FILE_NAME)) {
                Type type = new TypeToken<Map<String, String>>(){}.getType();
                jsonData = gson.fromJson(reader, type);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Add or update the key
        jsonData.put(keyName, data);

        // Write the updated data back to the file
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(jsonData, writer);
            System.out.printf("Saved \"%s\": \"%s\"%n", keyName, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}
