import java.util.List;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running = true;

    public Player(String name) { this.name = name; }

    private boolean submitWord() {
        String word=new String("");

        List<Tile> extracted = game.getBag().extractTiles(7);

        if (extracted.isEmpty()) {
            return false;
        }
        for (Tile tile : extracted) {
            word = word+tile.getLetter();
        }

        game.getBoard().addWord(this, word);

        return true;
    }
    @Override
    public void run() {
        while(running){
            submitWord();
        }
    }

    public String getName() {
        return name;
    }

    public void setGame(Game game) {
        this.game=game;
    }
}
