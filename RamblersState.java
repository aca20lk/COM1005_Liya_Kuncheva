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
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    Coords tar=rsearcher.getGoal(); // get target coordinates
    return (coordinates.getx() == tar.getx() && coordinates.gety() == tar.gety());
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors (Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    TerrainMap tmap = rsearcher.getMap();
    int[][] tmapv = tmap.getTmap();
    ArrayList<SearchState> succs = new ArrayList();
    //ArrayList<MapLink> links = map.getLinks(coordinates);
    
    Coords c = this.getCoordinates();
    int x = c.getx();
    int y = c.gety();

    int lc = 0;

    int width = tmap.getWidth();
    int depth = tmap.getDepth();

    Coords newc;

    if(x > 1 && x < width -1){
        newc = new Coords(x-1,y);
        if(tmapv[x-1][y]<=tmapv[x][y]){
            lc = 1;
        }
        else{
            lc = 1 + tmapv[x-1][y] - tmapv[x][y];
        }
        succs.add(new RamblersState(newc,lc,1));
    }
    
    if(x > 1 && x < width -1){
        newc = new Coords(x+1,y);
        if( x > 1 && x < width -1 && tmapv[x+1][y]<=tmapv[x][y]){
            lc = 1;
        }
        else{
            lc = 1 + tmapv[x+1][y] - tmapv[x][y];
        }
        succs.add(new RamblersState(newc,lc,1));
    }
    

    if(y > 1 && y < width -1){
        newc = new Coords(x,y-1);
        if( y > 1 && y < depth -1 && tmapv[x][y-1]<=tmapv[x][y]){
            lc = 1;
        }
        else{
            lc = 1 + tmapv[x][y-1] - tmapv[x][y];
        }
        succs.add(new RamblersState(newc,lc,1));
    }
    

    if(y > 1 && y < width -1){
        newc = new Coords(x,y+1);
        if( y > 1 && y < depth -1 && tmapv[x][y+1]<=tmapv[x][y]){
            lc = 1;
        }
        else{
            lc = 1 + tmapv[x][y+1] - tmapv[x][y];
        }
        succs.add(new RamblersState(newc,lc,1));
    }
    
    return succs;

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



