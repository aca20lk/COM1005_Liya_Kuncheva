import java.util.*;

public class RamblersState extends SearchState{

  //coordinates for this state
  private Coords coordinates;

  //constructor
  //A* - has estRemCost now
  public RamblersState(Coords c, int lc, int rc){
    coordinates=c;
    localCost=lc;
    estRemCost=rc;
  }
  //accessors
  public Coords getCoordinates(){
    return coordinates;
  }

  // goalPredicate
  public boolean goalPredicate(Search searcher) {
    RamblersSearch rsearcher = (RamblersSeacrh) searcher;
    Coords tar=rsearcher.getGoal(); // get target coordinates
    return (coordinates.getx() == tar.getx() && coordinates.gety() == tar.gety());
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors (Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    TerrainMap map = rsearcher.getMap();
    ArrayList<SearchState> succs = new ArrayList();
    
  }

  // sameState
  public boolean sameState(SearchState s2) {
    RamblersState rs2= (RamblersState) s2;
    Coords rc = rs2.getCoordinates();
    return (coordinates.getx() == rc.getx() && coordinates.gety() == rc.gety());
  }

  // toString
  public String toString () {
    return ("Rambler's State: "+coordinates);
  }
}



