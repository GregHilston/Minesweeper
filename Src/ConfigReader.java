import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {
    static ConfigReader instance = null;
    String fileName = "Res/settings.conf";

    private ConfigReader() {
        // Purposefully left empty to override public default constructor
    }

    public static ConfigReader getInstance() {
        if(instance == null) {
            instance = new ConfigReader();
        }
        return instance;
    }

    /**
     * Looks up a key and returns the value form the settings.conf file
     * @param key key to lookuo
     * @param defaultValue value to use if key cannot be found or file cannot be read
     * @return key to use
     */
    public int readVariable(String key, int defaultValue) {
        try {
            FileReader fileReader = new FileReader(this.fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null) {
                if(line.contains(key)) {
                    return Integer.parseInt(line.split("=")[1]);
                }
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

        return defaultValue;
    }
}