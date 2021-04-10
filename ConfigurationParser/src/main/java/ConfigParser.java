import java.io.*;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * authour: Bandipo Taiye OLusayo
 * Organization: Decagon Institute
 */

public class ConfigParser {

    private final Map<String, String> configMap = new HashMap<String, String>();
    private File file;


    /**
     * @param filePath: the file path to be read
     */
    public ConfigParser(String filePath) {
        File newFile = new File(filePath);

        if (newFile.canRead()) {
            this.file = newFile;
            configReader();

        } else {
            System.out.println("Not a file");
        }


    }


    public void configReader() {

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(this.file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringReadSplit(line);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * @param line the String result from the bufferReader
     */
    public void stringReadSplit(String line) {

        if (line.contains("=")) {
            String[] stringSplitArray = line.split("=");
            configMap.put(stringSplitArray[0], stringSplitArray[1]);

        }
    }

    /**
     * @param key: the key to be read from the files
     * @return : returns the key : value pair
     */
    public String configKey(String key) {
        if (configMap.containsKey(key)) {
            return MessageFormat.format("{0} : {1}", key, configMap.get(key));
        }

        return MessageFormat.format(" \" {0} \" is not a key in the file ", key);
    }



    /**
     *
     * @return: returns The key:value pair of the Map
     */

    public Map<String, String> getConfigMap() {
        return configMap;
    }
}

