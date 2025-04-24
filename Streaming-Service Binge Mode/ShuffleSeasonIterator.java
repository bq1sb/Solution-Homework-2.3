import java.util.*;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private final List<Episode> shuffled;
    private final Iterator<Episode> iterator;

    // Копирую список и перемешиваю с заданным seed
    public ShuffleSeasonIterator(List<Episode> episodes, long seed) {
        shuffled = new ArrayList<>(episodes);
        Collections.shuffle(shuffled, new Random(seed));
        this.iterator = shuffled.iterator();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Episode next() {
        return iterator.next();
    }
}
