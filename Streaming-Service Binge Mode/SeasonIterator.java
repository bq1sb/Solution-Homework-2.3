import java.util.List;

public class SeasonIterator implements EpisodeIterator{
    private final List<Episode> episodes;
    private int index = 0;
    public SeasonIterator(List<Episode> episodes){
        this.episodes = episodes;
    }
    public boolean hasNext(){
        return index < episodes.size();
    }
    public Episode next(){
        return episodes.get(index++);
    }
}
