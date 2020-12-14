import org.json.JSONObject;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileReader;

public class Settings {

    private String service;
    private String language;
    private String city;

    Settings() throws Exception {
        this.service = getJSON().getString("service");
        this.language = getJSON().getString("language");
        this.city = getJSON().getString("city");
    }

    public void setService(String service) {
        this.service = service;
        try{
            JSONObject settings = getJSON();
            settings.put("service", service);
            FileWriter fw = new FileWriter("src/main/java/settings.json");
            fw.write(settings.toString());
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setLanguage (String language) {
        this.language = language;
        try{
            JSONObject settings = getJSON();
            settings.put("language", language);
            FileWriter fw = new FileWriter("src/main/java/settings.json");
            fw.write(settings.toString());
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setCity (String city) {
        this.city = city;
        try{
            JSONObject settings = getJSON();
            settings.put("city", city);
            FileWriter fw = new FileWriter("src/main/java/settings.json");
            fw.write(settings.toString());
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void drop() {
        setCity("null");
        setService("null");
        setLanguage("en");
    }

    private JSONObject getJSON() throws Exception {
        FileReader fr = new FileReader("src/main/java/settings.json");
        Scanner scanner = new Scanner(fr);
        JSONObject settings = new JSONObject(scanner.nextLine());
        fr.close(); scanner.close();
        return settings;
        }

    public String getService() {
        return this.service;
    }

    public String getLanguage() { return this.language; }

    public String getCity() { return this.city; }
}

