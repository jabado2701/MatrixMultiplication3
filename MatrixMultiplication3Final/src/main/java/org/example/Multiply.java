package org.example;

import CCSPackage.CCS;
import CRSPackage.CRS;
import SizePackage.Size;

public class Multiply {

    public double[][] multiply(CRS crs, CCS ccs, Size size){
        double[][] finalMatrix= new double[size.getNumRows()][size.getNumColumns()];
        for (int i = 0; i < size.getNumRows(); i++) {
            for (int j = 0; j < size.getNumColumns(); j++) {
              int ii = crs.getRowptr().get(i);
              int iEnd = crs.getRowptr().get(i+1);
              int jj = ccs.getColptr().get(j);
              int jEnd = ccs.getColptr().get(j+1);
              double S = 0;
              while(ii < iEnd && jj < jEnd) {
                int aa = crs.getColumns().get(ii);
                int bb = ccs.getRows().get(jj);
                if(aa == bb) {
                    S += crs.getValues().get(ii) * ccs.getValues().get(jj);
                    ii++;
                    jj++;
                    } else if(aa < bb) {
                    ii++;
                    } else {
                    jj++;
                }
              }
              if (S != 0) {
                finalMatrix[i][j] = S;
              }
            }
        }
        return finalMatrix;
    }
}
