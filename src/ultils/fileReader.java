package ultils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fileReader {

    public static List<String> inputFileToStringList(String path) {
        List<String> inputList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = br.readLine()) != null) {
                inputList.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputList;
    }

    public static List<Integer> readInputAsIntegers(String path) {

        ArrayList<Integer> inputs = new ArrayList<>();

        try {
            File file = new File(path);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                inputs.add(Integer.parseInt(data));
            }
        } catch (FileNotFoundException e) {
            return null;
        }
        return inputs;
    }

}
