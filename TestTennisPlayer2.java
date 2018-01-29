public class TestTennisPlayer2
{
  public static void main(String[] args)
  {
    HurleyTennisPlayer tp1 = new HurleyTennisPlayer();
    HurleyTennisPlayer tp2 = new HurleyTennisPlayer("Nick Kyrgios", "Australia");
    HurleyTennisPlayer tp3 = new HurleyTennisPlayer("Andy Murray", "Great Britain", 1, 30);
    HurleyTennisPlayer tp4 = new HurleyTennisPlayer("Novak Djokovic", "Serbia", 4, 30, 28, 7);
    
    tp1.displayPlayer();
    tp2.displayPlayer();
    tp3.displayPlayer();
    tp4.displayPlayer();
    
    
   
    
  }
}