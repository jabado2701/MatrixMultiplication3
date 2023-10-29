package SizePackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class GetSize {

    public static final String filePath = "src/main/resources/arc130.mtx";

    public Size getSize() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        int numRows = 0;
        int numCols = 0;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("%")) {
                continue;
            }
            String[] parts = line.trim().split("\\s+");
            if (parts.length >= 2) {
                numRows = Integer.parseInt(parts[0]);
                numCols = Integer.parseInt(parts[1]);
                break;
            }
        }
        return (new Size(numRows, numCols));
    }
}
