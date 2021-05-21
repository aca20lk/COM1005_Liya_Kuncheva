import java.util.*;

public class RamblersState extends SearchState{

  //coordinates for this state
  private String coordinates;

  //constructor
  //A* - has estRemCost now
  public RamblersState(String cname, int lc, int rc){
    coordinates=cname;
    localCost=lc;
    estRemCost=rc;
  }
  //accessors
  public String getCoordinates(){
    return coordinates;
  }


  // goalPredicate
  public boolean goalPredicate(Search searcher) {
    RamblersSearch msearcher = (RamblersSeacrh) searcher;
    String tar=msearcher.getGoal(); // get target coordinates
    return (coordinates.compareTo(tar)== 0);
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors (Search searcher) {
    RamblersSearch msearcher = (RamblersSearch) searcher;
    TerrainMap map = msearcher.getMap();
    ArrayList<MapLink> links = map.getLinks(coordinates);
    ArrayList<SearchState> succs = new ArrayList();

    // loop over the links from my coordinates
    for (MapLink l: links){
    	String scoordinates;
      if (coordinates.compareTo(l.getCoordinates1()) == 0) {
        scoordinates = l.getCoordinates2();
      }
      else {
        scoordinates = l.getCoordinates1();
      }
      succs.add(new RamblersState(scoordinates,l.getCost(), map.estbetween(scoordinates,msearcher.getGoal())));
    }
    return succs;
  }

  // sameState
  public boolean sameState(SearchState s2) {
    RamblersState ms2= (RamblersState) s2;
    return (coordinates.compareTo(ms2.getCoordinates())==0);
  }

  // toString
  public String toString () {
    return ("Map State: "+coordinates);
  }
}



