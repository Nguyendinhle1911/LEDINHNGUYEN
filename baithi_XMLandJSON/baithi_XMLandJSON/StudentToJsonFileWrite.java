package baithi_XMLandJSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentToJsonFileWrite {
    public static void writeStudentToJsonFile(List<Student> Students, String filePath) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter writer = new FileWriter(filePath);
        gson.toJson(Students, writer);
        writer.close();
    }
}
