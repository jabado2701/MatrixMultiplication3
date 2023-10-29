package Testers;

import CCSPackage.CCS;
import CRSPackage.CRS;
import SizePackage.GetSize;
import SizePackage.Size;
import org.example.Reader;

import java.io.IOException;

public class FormatTester {

    public void formatTest() throws IOException {
        Reader reader = new Reader();
        GetSize getSize = new GetSize();
        Size size = new Size(getSize.getSize().getNumRows(), getSize.getSize().getNumColumns());
        
        CRS crs = new CRS(reader.getCOOList(), size);
        CCS ccs = new CCS(reader.getCOOList(), size);

        System.out.println("CRS");

        System.out.println("Values=" + crs.getValues());
        System.out.println("Columns=" + crs.getColumns());
        System.out.println("Rowptr=" + crs.getRowptr());


        System.out.println("\n");
        System.out.println("--------------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------------");
        System.out.println("\n");

        System.out.println("CCS");
        System.out.println("Values=" + ccs.getValues());
        System.out.println("Rows=" + ccs.getRows());
        System.out.println("Colptr=" + ccs.getColptr());

    }

}
