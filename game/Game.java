package game;
import java.util.ArrayList;
import java.util.Random;
public class Game{
 	public static String pass = "00";
 	public static String send = "01";
 	public static String receive = "02";
 	public static String match = "03";
 	public static String end = "04";
 	public static String loser = "05";
 	public static String[] card = {"H","D","S","C"};
 	public static String[] numbers = {"01","02","03","04","05","06","07","08","09","10","11","12","13"};

  public static String[][] starts(int count){
    Random rand = new Random();
    int random;
    ArrayList<String> cards = new ArrayList<String>(count*4);
    String[][] players = new String[count][];
    for(int i=0;i<count;i++){
      players[i] = new String[4];
    }
    String c;
    for(int i=0;i<count;i++){
      for(int j=0;j<4;j++){
        c = numbers[i];
        c= c.concat(card[j]);
        cards.add(c);
      }
    }
    for(int i=0;i<count;i++){
      for(int j=0;j<4;j++){
        random = rand.nextInt(cards.size());
        players[i][j] = cards.get(random);
        cards.remove(random);
      }
    }
    return(players);
  }
    	
}
