import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Season implements Iterable<Episode>{
    private final List<Episode> episodes = new ArrayList<>();
    public void addEpisode(Episode e){
        episodes.add(e);
    }
        // Добавляю эпизоды в список сезона

    public EpisodeIterator createNormalIterator(){
        return new SeasonIterator(episodes);
    }
    public EpisodeIterator createReverseIterator() {
        return new ReverseSeasonIterator(episodes);
    }
        // Итератор в случайном порядке (но с фиксированным seed, чтобы можно было воспроизвести)

    public EpisodeIterator createShuffleIterator(long seed) {
        return new ShuffleSeasonIterator(episodes, seed);
    }
        // Реализую Iterable, чтобы можно было использовать for-each

    public Iterator<Episode> iterator() {
        return createNormalIterator();
    }
}



