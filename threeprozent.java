/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 19.08.2020
 * @author 
 */

public class threeprozent {
  
  public static void main(String[] args) {
    selector s = new selector();
    s.importData();
    System.out.println(s.toString());
    s.ranklist();
    System.out.println(s.linkToString());
    s.getStartPlayer().getNextPlayer().setScore(10000);
    s.ranklist();
    System.out.println(s.linkToString());
    
  } // end of main
  
} // end of threeprozent

