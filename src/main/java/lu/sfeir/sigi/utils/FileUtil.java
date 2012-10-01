package lu.sfeir.sigi.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<String> readFromClassPath(String resource) {
        List<String> result = new ArrayList<String>();
        BufferedReader reader = getBufferedReader(resource);

        return readRessource(result, reader);
    }


    public static List<String> readFromClassPath(InputStream input) {
        List<String> result = new ArrayList<String>();
        BufferedReader reader =  new BufferedReader(new InputStreamReader(input));

        return readRessource(result, reader);
    }

    public static List<String> readFromFile(String filePath) {
        List<String> result = new ArrayList<String>();
        BufferedReader reader = getBufferedReader(new File(filePath));

        return readRessource(result, reader);
    }



    private static List<String> readRessource(List<String> result, BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeIfNotNull(reader);
        }
        return result;
    }

    private static void closeIfNotNull(BufferedReader reader) {
        try {
            if(reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedReader getBufferedReader(String resource) {
        InputStream input = ClassLoader.getSystemResourceAsStream(resource);
        return new BufferedReader(new InputStreamReader(input));
    }

    private static BufferedReader getBufferedReader(File file) {
        try {
            return new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
