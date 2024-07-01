import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    public void saveJson(Currency currency) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("Logger.txt");
        writer.write("Log número: "+"1");
        writer.write(gson.toJson(currency));
        writer.close();
    }
}
