package com.yohoyes.poem.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yohoyes.poem.model.Poem;
import org.litepal.tablemanager.Connector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadPoem {

    public static void readPoems(InputStream inputStream) throws IOException{
        Connector.getDatabase();

        BufferedReader read = new BufferedReader(new InputStreamReader(inputStream));
        while (read.ready()) {
            String line = read.readLine();
            Poem poem = parseJSON(line);
            poem.save();
        }
    }

    public static Poem parseJSON(String jsonData) {
        Gson gson = new Gson();
        return gson.fromJson(jsonData,new TypeToken<Poem>(){}.getType());
    }
}
