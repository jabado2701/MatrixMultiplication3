package CRSPackage;

import SizePackage.Size;
import COOPackage.COO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CRS {

    private final List<COO> COOList;

    private final Size size;

    private List<Integer> rowptr = new ArrayList<>();

    private List<Integer> columns = new ArrayList<>();

    private List<Double> values = new ArrayList<>();

    public List<Integer> getRowptr() {
        return rowptr;
    }

    public List<Integer> getColumns() {
        return columns;
    }

    public List<Double> getValues() {
        return values;
    }

    public CRS(List<COO> COOList, Size size) {
        this.COOList = COOList;
        this.size = size;
        getCRS();
    }

    private void getCRS() {

        COOList.sort(Comparator.comparing(COO::getRows).thenComparing(COO::getColumns));

        this.rowptr.add(0);
        this.columns.add(COOList.get(0).getColumns());
        this.values.add(COOList.get(0).getValues());

        int row_count = 0;

        for (int i = 1; i < COOList.size(); i++) {
            this.columns.add(COOList.get(i).getColumns());
            this.values.add(COOList.get(i).getValues());

            for (; row_count < COOList.get(i).getRows(); row_count++) {
                this.rowptr.add(i);
            }
        }

        for (; row_count < this.size.getNumRows(); row_count++) {
            this.rowptr.add(COOList.size());
        }
    }
}
