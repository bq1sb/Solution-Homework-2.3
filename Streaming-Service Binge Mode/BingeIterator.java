import java.util.Iterator;
import java.util.List;

public class BingeIterator implements EpisodeIterator{
    private final Iterator<Season> seasonIterator;
    private EpisodeIterator currentEpisodeIterator;
    public BingeIterator(List<Season> seasons){
        this.seasonIterator = seasons.iterator();
        advanceSeason();
    }
    private void advanceSeason(){
        if (seasonIterator.hasNext()) {
            currentEpisodeIterator = seasonIterator.next().createNormalIterator();
        }else {
            currentEpisodeIterator = null;
        }
    }
    public boolean hasNext(){
        while (currentEpisodeIterator != null){
            if (currentEpisodeIterator.hasNext()) return true;
            advanceSeason();
        }
        return false;
    }
    public Episode next(){
        return currentEpisodeIterator.next();
    }
}
