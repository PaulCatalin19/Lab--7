import java.util.HashSet;
import java.util.Set;

public class Board {
    private final Set<String> words = new HashSet<>();

    public synchronized void addWord(Player player, String word) {
        this.words.add(word);
        System.out.println(player.getName() + ": " + word);
    }

    @Override
    public String toString() {
        return words.toString();
    }
}
