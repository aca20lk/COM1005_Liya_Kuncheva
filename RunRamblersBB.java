import java.util.*;

public class RunRamblersBB {
  public static void main(String[] arg) {

    TerrainMap map1 = new TerrainMap("tmc.pgm");
    Coords goalc = new Coords(7,2);
    Coords startc = new Coords(0,0);
    // System.out.println(map1.toString());
    // System.out.println(map1.getLinks("Start"));

    RamblersSearch searcher = new RamblersSearch(map1, goalc);
    SearchState initState = (SearchState) new RamblersState(startc, 0, 0);

    String res_bb = searcher.runSearch(initState, "BB");
    System.out.println(res_bb);
  }
}