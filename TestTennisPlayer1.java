public class TestTennisPlayer1
{
  public static void main(String[] args)
  {
    HurleyTennisPlayer tp1 = new HurleyTennisPlayer();
    HurleyTennisPlayer tp2 = new HurleyTennisPlayer();
    
    tp1.setPlayerName("Andy Murray");
    tp1.setCountry("Great Britain");
    
    tp1.setRank(1);
    tp1.setAge(30);
    
    tp1.setWins(21);
    tp1.setLosses(9);
    
    tp2.setPlayerName("Rafael Nadal");
    tp2.setCountry("Spain");
    
    tp2.setRank(2);
    tp2.setAge(31);
    
    tp2.setWins(43);
    tp2.setLosses(6);
    
    System.out.println("Player 1 name: " + tp1.getPlayerName());
    System.out.println("Player 1 country: " + tp1.getCountry());
    System.out.println("Player 1 rank: " + tp1.getRank());
    System.out.println("Player 1 age: " + tp1.getAge());
    System.out.println("Player 1 wins: " + tp1.getWins());
    System.out.println("Player 1 losses: " + tp1.getLosses());
    System.out.println();
    System.out.println("Player 2 name: " + tp2.getPlayerName());
    System.out.println("Player 2 country: " + tp2.getCountry());
    System.out.println("Player 2 rank: " + tp2.getRank());
    System.out.println("Player 2 age: " + tp2.getAge());
    System.out.println("Player 2 wins: " + tp2.getWins());
    System.out.println("Player 2 losses: " + tp2.getLosses());
    
  }
}