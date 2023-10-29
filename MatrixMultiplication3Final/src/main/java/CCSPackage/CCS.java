package CCSPackage;

import SizePackage.Size;
import COOPackage.COO;

import java.util.ArrayList;
import java.util.List;

public class CCS {

    private final List<COO> COOList;

    private final Size size;

    private List<Integer> colptr = new ArrayList<>();


    private List<Integer> rows = new ArrayList<>();

    private List<Double> values = new ArrayList<>();

    public List<Integer> getColptr() {
        return colptr;
    }

    public List<Integer> getRows() {
        return rows;
    }

    public List<Double> getValues() {
        return values;
    }

    public CCS(List<COO> COOList, Size size) {
        this.COOList = COOList;
        this.size = size;
        getCCS();
    }

    private void getCCS() {

        this.colptr.add(0);
        this.rows.add(this.COOList.get(0).getRows());
        this.values.add(this.COOList.get(0).getValues());

        int col_count = 0;

        for (int i = 1; i < this.COOList.size(); i++) {
            this.rows.add(this.COOList.get(i).getRows());
            this.values.add(this.COOList.get(i).getValues());

            for (; col_count < this.COOList.get(i).getColumns(); col_count++) {
                this.colptr.add(i);
            }
        }

        for (; col_count < this.size.getNumColumns(); col_count++) {
            this.colptr.add(this.COOList.size());
        }
    }
}
