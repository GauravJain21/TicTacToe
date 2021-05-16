
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
enum Result {
    VALID, INVALID, END_GAME
}
public class Board {
    private int boardSize;
    ArrayList<ArrayList<Cell>> cells;
    int fillCount = 0;
    Board(int boardSize) {
        this.boardSize = boardSize;
        fillCount = 0;
        cells = new ArrayList<ArrayList<Cell>>(Collections.nCopies(boardSize, null));
        for(int i = 0; i < boardSize; i++) {
            cells.set(i, new ArrayList<Cell>(Collections.nCopies(boardSize,null)));
            for(int j = 0; j < boardSize; j++) {
                cells.get(i).set(j, new Cell());
            }
        }
        print();
    }
    public void print() {
        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                System.out.printf(cells.get(i).get(j).getSymbol() + " ");
            }
            System.out.println();
        }
    }
    public boolean bounded(int i, int j) {
        return (i >= 0 && i < boardSize && j >= 0 && j < boardSize);
    }
    public Result play(int i, int j, String player, String symbol) {
        if(fillCount == boardSize*boardSize) {
            System.out.println("Game Over");
            fillCount++;
            return Result.END_GAME;
        }
        if(fillCount > boardSize*boardSize) {
            System.out.println("Over the limit");
            return Result.END_GAME;
        }
        if(bounded(i, j) == false) {
            System.out.println("Invalid Move. Enter again");
            return Result.INVALID;
        }
        if(cells.get(i).get(j).getSymbol().equals("-") == false) {
            System.out.println("Cell already filled. Enter again");
            return Result.INVALID;
        }
        fillCount++;
        cells.get(i).get(j).setSymbol(symbol);
        boolean gameWon = checkWinPattern(i, j);
        print();
        //System.out.println("Are you serious?");
        if(gameWon) {
            System.out.println(player + " won the game");
        }
        return Result.VALID;
    }
    public boolean checkWinPattern(int i, int j) {
        boolean won = false;
        won |= sameRow(i, j);
        won |= sameCol(i, j);
        if(i == j) {
            won |= sameLeftDiagonal();
            won |= sameRightDiagonal();
        }
        return won;
    }
    public boolean sameRow(int i, int j) {
        String symbol = cells.get(i).get(j).getSymbol();
        for(int index = 0; index < boardSize; index++) {
            if(cells.get(i).get(index).getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }
    public boolean sameCol(int i, int j) {
        String symbol = cells.get(i).get(j).getSymbol();
        for(int index = 0; index < boardSize; index++) {
            if(cells.get(index).get(j).getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }
    public boolean sameLeftDiagonal() {
        String symbol = cells.get(0).get(0).getSymbol();
        for(int index = 0; index < boardSize; index++) {
            if(cells.get(index).get(index).getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }
    public boolean sameRightDiagonal() {
        String symbol = cells.get(0).get(boardSize - 1).getSymbol();
        for(int index = 0; index < boardSize; index++) {
            if(cells.get(index).get(boardSize - 1 - index).getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }
}
