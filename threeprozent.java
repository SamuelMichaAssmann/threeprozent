import java.util.*;

public class threeprozent {
  public static void main(String[] args) {
    selector s = new selector();
    s.importData();
    s.scorePlayer();
    s.ranklist();
    System.out.println(s.linkToString());
    s.initGame();
  } // end of main
} // end of threeprozent

