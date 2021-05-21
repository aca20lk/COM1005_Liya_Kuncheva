import java.util.*;

public class RamblersSearch extends Search {

  private TerrainMap map; //map we're searching
  private Coords goal; //goal coordinate

  public TerrainMap getMap(){
    return map;
  }
  public Coords getGoal(){
    return goal;
  }

  public RamblersSearch(TerrainMap m, /*String g*/Coords g){
    map=m;
    goal=g;
  }
}