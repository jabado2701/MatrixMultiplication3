package org.example;

import COOPackage.COO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static final String filePath = "src/main/resources/arc130.mtx";

    public List<COO> getCOOList() throws IOException {
        // Open the MTX file using a BufferedReader
        List<COO> cooList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        // Read the dimensions of the matrix
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("%")) {
                // Skip comments indicated by lines starting with '%'
                continue;
            }
            String[] parts = line.trim().split("\\s+");
            if (parts.length >= 2) {
                break;
            }
        }

        // Read and populate the matrix from the file
        while ((line = reader.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length >= 3) {
                int row = Integer.parseInt(parts[0]) - 1; // Subtract 1 to adjust for 0-based indexing
                int col = Integer.parseInt(parts[1]) - 1; // Subtract 1 to adjust for 0-based indexing
                double value = Double.parseDouble(parts[2]);
                cooList.add(new COO(row, col, value));
            }
        }
        reader.close();
        return cooList;
    }
}