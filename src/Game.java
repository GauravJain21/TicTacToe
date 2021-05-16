import java.util.Vector;

public class Game {
    private Vector<Player> players;
    private Board board;
    private int nextPlayer;
    Game(int boardSize, String[] players, String[] symbols) {
        nextPlayer = 0;
        board = new Board(boardSize);
        this.players = new Vector<Player>(players.length);
        for(int i = 0; i < players.length; i++) {
            Player currentPlayer = new Player(players[i], symbols[i]);
            this.players.add(i, currentPlayer);
        }
    }

    public boolean play(int i, int j) {
        i--;
        j--;
        String playerName = players.get(nextPlayer).getName();
        String playerSymbol = players.get(nextPlayer).getSymbol();
        Result validMove = board.play(i, j, playerName, playerSymbol);
        if(validMove == Result.VALID) {
            nextPlayer = (nextPlayer + 1)%players.size();
        }
        return validMove != Result.END_GAME;
    }

}
