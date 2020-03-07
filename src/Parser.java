import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Parser for getting files from files
 */
public class Parser {

    static int[][] parse(String path) throws IOException {
        List<String> allLines = Files.readAllLines(Paths.get(path));

        int raws = 0;
        List<String> validStringItems = new ArrayList<>();

        for (int i = 0; i < allLines.size(); i++) {
            // replace all none numeric values to "";
            String validString = allLines.get(i).replaceAll("\\D+", "");
            if (!validString.equals("")) {
                raws++;
                // collect valid lines
                validStringItems.add(validString);
            }
        }

        int[][] resultArray = new int[raws][];

        // put int[] array to resultArray
        for (int i = 0; i < raws; i++) {
            resultArray[i] = stringToIntegerArray(validStringItems.get(i));
        }

        // display result array
        for (int i = 0; i < resultArray.length; i++) {
            System.out.println(Arrays.toString(resultArray[i]));
        }

        return resultArray;

    }

    /**
     * Converts string To integer
     */
    static int[] stringToIntegerArray(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Character.getNumericValue(s.charAt(i));
        }
        return arr;
    }

}