package Testers;

import CCSPackage.CCS;
import CRSPackage.CRS;
import SizePackage.GetSize;
import SizePackage.Size;
import org.example.Multiply;
import org.example.Reader;

import java.io.IOException;
import java.util.Arrays;

public class MultiplicationTester {

    public void multiplicationTest() throws IOException {
        Reader reader = new Reader();
        GetSize getSize = new GetSize();
        Size size = new Size(getSize.getSize().getNumRows(), getSize.getSize().getNumColumns());

        CRS crs = new CRS(reader.getCOOList(), size);
        CCS ccs = new CCS(reader.getCOOList(), size);

        Multiply multiply = new Multiply();
        double [][] test = multiply.multiply(crs, ccs, size);
        System.out.println(Arrays.deepToString(test));
    }
}
