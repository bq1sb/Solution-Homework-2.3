public class Main {
    public static void main(String[] args){
        Series series = new Series();
        Season S1 = new Season();
        S1.addEpisode(new Episode("S1E1", 1300));
        S1.addEpisode(new Episode("S1E2",1400));

        Season S2 = new Season();
        S2.addEpisode(new Episode("S2E1", 1200));
        S2.addEpisode(new Episode("S2E2",1100));

        series.addSeason(S1);
        series.addSeason(S2);

        System.out.println("Normal");
        for (Episode e : S1) System.out.println(e);

        System.out.println("Reverse");
        EpisodeIterator rev = S1.createReverseIterator();
        while (rev.hasNext()) System.out.println(rev.next());

        System.out.println("Shuffle");
        EpisodeIterator shuf = S1.createShuffleIterator(42);
        while (shuf.hasNext()) System.out.println(shuf.next());

        System.out.println("Binge");
        EpisodeIterator binge = series.createBingeIterator();
        while (binge.hasNext()) System.out.println(binge.next());
    }
}
