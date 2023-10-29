package COOPackage;


public class COO {

    private Integer rows;

    private Integer columns;

    private Double values;


    public COO(Integer rows, Integer columns, Double values) {
        this.rows = rows;
        this.columns = columns;
        this.values = values;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public Double getValues() {
        return values;
    }
}
