import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Read_JSON_gson {
    public static void main(String[] args) throws IOException {
        //tao dong doc(stream reader)
        Reader reader = Files.newBufferedReader(Paths.get("employee.json"));


        //tao doi tuong jsonObject(gson)
        JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

        //details
        System.out.println(parser.get("id").getAsLong());
        System.out.println(parser.get("name").getAsString());
        System.out.println(parser.get("email").getAsString());
        System.out.println(parser.get("age").getAsLong());



        //details address

        JsonObject address = parser.get("address").getAsJsonObject();
        System.out.println(address.get("street").getAsString());
        System.out.println(address.get("city").getAsString());
        System.out.println(address.get("zipcode").getAsLong());


        //read project
        for (JsonElement projcet : parser.get("projects").getAsJsonArray()) {
            JsonObject obj  = projcet.getAsJsonObject();
            System.out.println(obj.get("title").getAsString());
            System.out.println(obj.get("budget").getAsLong());
        }
    }
}
