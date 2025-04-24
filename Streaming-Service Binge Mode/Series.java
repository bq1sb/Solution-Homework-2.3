import java.util.ArrayList;
import java.util.List;

public class Series {
    private final List<Season> seasons = new ArrayList<>();

    //добавляю сезоны в сериал
    public void addSeason(Season s) {
        seasons.add(s);
    }

    //итератор по всем сезонам подряд
    public EpisodeIterator createBingeIterator() {
        return new BingeIterator(seasons);
    }

    public List<Season> getSeasons() {
        return seasons;
    }
}

