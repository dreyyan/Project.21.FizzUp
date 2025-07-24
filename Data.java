import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;

public class Data {
    public static final String FILE_NAME = "data.json";

    public static void storeStrData(String keyName, String data) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

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

    public static int getIntData(String keyName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        int value = 0;

        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (Reader reader = new FileReader(FILE_NAME)) {
                Type type = new TypeToken<Map<String, Object>>(){}.getType();
                Map<String, Object> jsonData = gson.fromJson(reader, type);

                if (jsonData.containsKey(keyName)) {
                    // Since GSON parses numbers as Double by default, cast and convert
                    value = ((Number) jsonData.get(keyName)).intValue();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return value;
    }

    public static Map<String, Integer> getUpgrades() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Integer> upgrades = new HashMap<>();

        File file = new File(FILE_NAME);

        if (file.exists()) {
            try (Reader reader = new FileReader(FILE_NAME)) {
                Type type = new TypeToken<Map<String, Object>>(){}.getType();
                Map<String, Object> jsonData = gson.fromJson(reader, type);

                if (jsonData.containsKey("upgrades")) {
                    Object upgradesObj = jsonData.get("upgrades");

                    @SuppressWarnings("unchecked")
                    Map<String, Object> rawUpgrades = (Map<String, Object>) upgradesObj;

                    for (Map.Entry<String, Object> entry : rawUpgrades.entrySet()) {
                        String key = entry.getKey();
                        Number value = (Number) entry.getValue();
                        upgrades.put(key, value.intValue());
                    }
                } else {
                    System.out.println("Key 'upgrades' not found.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassCastException cce) {
                System.out.println("Failed to cast upgrades object.");
                cce.printStackTrace();
            }
        } else {
            System.out.println("File not found.");
        }

        return upgrades;
    }
    
    public static void addInventory(String itemName, int itemQuantity, String itemDescription) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
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
        jsonData.put(itemName, String.valueOf(itemQuantity));

        // Write the updated data back to the file
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(jsonData, writer);
            System.out.printf("Saved \"%s\": \"%s\"%n", itemName, itemQuantity);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("* +%d %s added to inventory *\n", itemName, itemQuantity);
    }

    public static void addPermanentInventory(String itemName, String itemDescription) {
        int itemQuantity = 1;

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Map<String, InventoryItem> jsonData = new HashMap<>();

        // Load existing data if the file exists
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (Reader reader = new FileReader(FILE_NAME)) {
                Type type = new TypeToken<Map<String, InventoryItem>>(){}.getType();
                jsonData = gson.fromJson(reader, type);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Add or update the key
        jsonData.put(itemName, new InventoryItem(itemQuantity, itemDescription));

        // Write the updated data back to the file
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(jsonData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("* received a '%s'! *\n~ %s ~\n", itemName, itemDescription);
    }
}
