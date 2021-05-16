public class Player {
    private String name;
    private String symbol;
    Player(String player, String symbol) {
        this.setName(player);
        this.setSymbol(symbol);
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}
