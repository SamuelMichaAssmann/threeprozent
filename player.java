import java.util.*;

public class player{
  
  // Anfang Attribute
  private String id;
  private double time;
  private player nextPlayer;
  private double precision;
  private double change;
  private int level;
  private double score;
  private double endscore;
  // Ende Attribute
  
  public player(String id, double time, double precision, double change, double score, player nextPlayer) {
    this.id =id;
    this.time = time;
    this.precision = precision;
    this.change = change;
    this.score = score;
    this.nextPlayer = nextPlayer;
  }

  // Anfang Methoden
  
  public String getId() {
    return id;
  }

  public void setId(String idNeu) {
    id = idNeu;
  }
  
  public double getTime() {
    return time;
  }

  public void setTime(double timeNeu) {
    time = timeNeu;
  }

  public double getPrecision() {
    return precision;
  }

  public void setPrecision(double precisionNeu) {
    precision = precisionNeu;
  }

  public double getChange() {
    return change;
  }

  public void setChange(double changeNeu) {
    change = changeNeu;
  }
  
  public double getLevel() {
    return level;
  }

  public void setLevel(int levelNeu) {
    level = levelNeu;
  }

  public player getNextPlayer() {
    return nextPlayer;
  }

  public void setNextPlayer(player nextPlayerNeu) {
    nextPlayer = nextPlayerNeu;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double scoreNeu) {
    score = scoreNeu;
  }
  
  public double getEndscore() {
    return endscore;
  }

  public void setEndscore(double endscoreNeu) {
    endscore = endscoreNeu;
  }
  
  public String toString() {
    return id + " (" + Integer.toString(level) + ") - Score: " + Double.toString(endscore);
  }

  // Ende Methoden
} // end of player

