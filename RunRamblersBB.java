import java.util.*;

public class RunRamblersBB {
  public static void main(String[] arg) {

    TerrainMap map1 = new TerrainMap("tmc.pgm");
    //map1.mapFromFile("map1.csv");
    //map1.estsFromFile("map1_ests.csv"); // get the A* estimates
    // System.out.println(map1.toString());
    // System.out.println(map1.getLinks("Start"));

    RamblersSearch searcher = new RamblersSearch(map1, "(7,2)");
    SearchState initState = (SearchState) new RamblersState("(0,0)", 0, 0);

    // change from search1 - specify strategy

    // System.out.println(res_df);
    //String res_bf = searcher.runSearch(initState, "depthFirst");
    //System.out.println(res_bf);
    // String res_bb = searcher.runSearch(initState, "branchAndBound");
    // System.out.println(res_bb);

    String res_bb = searcher.runSearch(initState, "BB");
    System.out.println(res_bb);
  }
}