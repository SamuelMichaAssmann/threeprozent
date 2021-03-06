import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.PrintWriter; 
import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileReader; 
import java.io.InputStream;

public class importData {
  
  // Anfang Attribute
  private String data;
  // Ende Attribute
  
  // Anfang Methoden
  
  public static void schreibeDatei(String dateiName, String txt) { 
    PrintWriter pWriter = null; 
    try { 
      pWriter = new PrintWriter(new BufferedWriter(new FileWriter(dateiName))); 
      pWriter.println(txt); 
    } catch (IOException ioe) { 
      ioe.printStackTrace(); 
    } finally { 
      if (pWriter != null){ 
        pWriter.flush(); 
        pWriter.close(); 
      } 
    } 
  } 
  
  private static String ladeDatei(String datName) { 
    File file = new File(datName); 
    if (!file.canRead() || !file.isFile()){
      System.exit(0); 
    }
    BufferedReader in = null; 
    String txt = "";
    try { 
      in = new BufferedReader(new FileReader(datName)); 
      String zeile = null; 
      while ((zeile = in.readLine()) != null) { 
        txt+= zeile +"\n";
      } 
    } catch (IOException e) { 
      e.printStackTrace(); 
    } finally { 
      if (in != null) 
      try { 
        in.close(); 
      } catch (IOException e) { 
      } 
    } 
    return txt;
  } 
  
  public String getData() {
    gitAct();
    data = ladeDatei(".data");
    return data;
  }
  
  public void setData(String dataNeu) {
    data = dataNeu;
    schreibeDatei(".data", data);
    gitAct();
  }

  public void gitAct() {
    try {
      Runtime.getRuntime().exec( "cmd /c akdata.bat" );
    } catch(Exception e) {
      System.out.println("An Error corrupted!");
    }// end of try
  }

  // Ende Methoden
} // end of importData

