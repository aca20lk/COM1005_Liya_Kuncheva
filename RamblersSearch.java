import java.util.*;

public class RamblersSearch extends Search {

  private TerrainMap map; //map we're searching
  private String goal; //goal coordinate

  public TerrainMap getMap(){
    return map;
  }
  public String getGoal(){
    return goal;
  }

  public RamblersSearch(TerrainMap m, String g){
    map=m;
    goal=g;
  }
}