import java.io.*;
import java.nio.charset.StandardCharsets;

public class DemoClass {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        System.out.println("Enter number of players");
        int playerCount = Integer.parseInt(reader.readLine());
        System.out.println("Enter Player Symbol followed by Name");
        String[] players = new String[playerCount], symbols = new String[playerCount], input;
        for(int i = 0; i < playerCount; i++) {
            input = reader.readLine().split(" ");
            symbols[i] = input[0];
            players[i] = input[1];
        }
        System.out.println("Enter board Dimensions");
        int boardSize = Integer.parseInt(reader.readLine());
        System.out.println("Play until a player wins or no valid move remains");
        Game game = new Game(boardSize, players, symbols);
        boolean gameOn = true;
        while(gameOn) {
            input = reader.readLine().split(" ");
            if(input[0].equals("exit")) {
                break;
            }
            int i = Integer.parseInt(input[0]), j = Integer.parseInt(input[1]);
            gameOn = game.play(i, j);
            if(gameOn == false) {
                System.out.println("Game Over");
            }
        }

        return;
    }
}
