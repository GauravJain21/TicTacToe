public class Cell {
    private String symbol;

    Cell(String symbol) {
        this.symbol = symbol;
    }

    Cell() {
        symbol = "-";
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isEmpty() {
        return symbol.equals("-");
    }

}
