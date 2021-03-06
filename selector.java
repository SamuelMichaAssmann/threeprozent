import java.util.*;

public class selector {
  
  // Anfang Attribute
  private ArrayList<player> playerlist = new ArrayList<player>();
  private player startPlayer = null;
  private player currentPlayer = null;
  // Ende Attribute
  
  // Anfang Methoden
  public void scorePlayer() {
    for (player p: playerlist) {
      double score = (p.getPrecision() + p.getChange()) * 1/p.getTime() * p.getScore() * 10 ;
      p.setEndscore(score);
    } // end of for
  }
  
  public void initGame() {
    try {
      Runtime.getRuntime().exec( "cmd /c CircleKlicker.py" );
    } catch(Exception e) {
      System.out.println("An Error corrupted!");
    }// end of try
  }
  
  public void ranklist() {
    startPlayer = null;
    for (player p: playerlist) {
      insertPlayer(p);
    } // end of for
  }
  
  public void insertPlayer(player p) {
    if (startPlayer == null || startPlayer.getScore()  <= p.getScore()) { 
      p.setNextPlayer(startPlayer); 
      startPlayer = p; 
    } 
    else { 
      currentPlayer = startPlayer;
      while (currentPlayer.getNextPlayer() != null && currentPlayer.getNextPlayer().getScore() > p.getScore()){
        currentPlayer = currentPlayer.getNextPlayer();
      } 
      p.setNextPlayer(currentPlayer.getNextPlayer()); 
      currentPlayer.setNextPlayer(p);
    } 
  }
  
  public void importData() {
    String data = new importData().getData();
    String[] s = data.split(";");
    for (int i = 0; i < s.length; i++) {
      player p = initPlayer(s[i]);
      setPlayerlist(p);
    }
  } 
  
  public player initPlayer(String data) {
    String[] d = data.split(",");
    player p = new player(d[0], Double.parseDouble(d[1]), Double.parseDouble(d[2]), Double.parseDouble(d[3]), Double.parseDouble(d[4]), null);            
    // (time, precision, change, level, score, null)
    return p;
  }
  
  public void setPlayerlist(player playerlistNeu) {
    playerlist.add(playerlistNeu);
  }
  
  public ArrayList<player> getPlayerlist() {
    return playerlist;
  }
  
  public player getStartPlayer() {
    return startPlayer;
  }
  
  public void setStartPlayer(player startPlayerNeu) {
    startPlayer = startPlayerNeu;
  }
  
  public player getCurrentPlayer() {
    return currentPlayer;
  }
  
  public void setCurrentPlayer(player currentPlayerNeu) {
    currentPlayer = currentPlayerNeu;
  }
  
  public String toString() {
    return playerlist.toString();
  }
  
  public String linkToString() {
    currentPlayer = startPlayer;
    if (startPlayer == null) {                                                       
      String leer = "[]";                                                       
      return leer;
    } // end of if
    else {
      String s = "[";
      for (currentPlayer = startPlayer; currentPlayer.getNextPlayer()!= null; currentPlayer = currentPlayer.getNextPlayer() ) {   
        s = s + currentPlayer.toString() + " ";
      } // end of for
      s = s + currentPlayer.toString() + "]";
      return s;
    } // end of if-else
  }
  
  // Ende Methoden
} // end of selector
    
