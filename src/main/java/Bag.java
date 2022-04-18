import java.util.*;

public class Bag {
    private final Queue<Tile> letters = new LinkedList<>();

    public Bag() {
        final Random rand = new Random();
        for (char c = 'a'; c < 'z'; c++) {
            for(int i=0;i<10;i++)
                letters.add(new Tile(c, rand.nextInt(1,10)));
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            extracted.add(letters.poll());
        }
        return extracted;
    }

}
