public class HurleyTennisPlayer
{
  private String playerName;
  private String country;
  
  private int rank;
  private int age;
  
  private int wins;
  private int losses;
  
  /**
   * Constructors
   * */
  
  public HurleyTennisPlayer()
  {
    playerName = null;
    country = null;
    rank = 0;
    age = 0;
    wins = 0;
    losses = 0;
  }
  
  public HurleyTennisPlayer(String nam, String cou)
  {
    playerName = nam;
    country = cou;
  }
  
  public HurleyTennisPlayer(String nam, String cou, int ran, int ag)
  {
    playerName = nam;
    country = cou;
    rank = ran;
    age = ag;
  }
  
  public HurleyTennisPlayer(String nam, String cou, int ran, int ag, int wi, int lose)
  {
    playerName = nam;
    country = cou;
    rank = ran;
    age = ag;
    wins = wi;
    losses = lose;
  }
  
  /**
   * Accessors
   * */
  
    
  public void setPlayerName(String nam)
  {
    playerName = nam;
  }
  public void setCountry(String cou)
  {
    country = cou;
  }
  public void setRank(int ran)
  {
    rank = ran;
  }
  public void setAge(int ag)
  {
    age = ag;
  }
  public void setWins(int wi)
  {
    wins = wi;
  }
  public void setLosses(int lose)
  {
    losses = lose;
  }
  
  /**
   * Mutators
   * */
  
   public String getPlayerName()
  {
    return playerName;
  }
   public String getCountry()
  {
    return country;
  }
   public int getRank()
  {
    return rank;
  }
  public int getAge()
  {
    return age;
  }
   public int getWins()
  {
    return wins;
  }
   public int getLosses()
  {
    return losses;
  }
   
   /**
    * Other methods
    * */
   
   public double calcWinPercentage()
   {
     double winPercent;
     double games;
     winPercent = 0;
     
     
     if ( getWins() + getLosses() != 0)
     {
       games = getWins() + getLosses();
       winPercent = getWins()/games;
       return winPercent;
     
        }
     else
     {
       return -1;
     }
   }
   
   public void displayPlayer()
   {
    
    {
       System.out.println("------------------------------------\n" +
                        "Tennis Player: " + playerName + "\n" +
                         "Country: " + country + "\n\n" +
                        "Current Rank: " + rank + "\n\n" +
                        "Age: " + age + "\n\n" +
                        "Wins: " + wins + "\n" +
                        "Losses: " + losses + "\n");
      if (calcWinPercentage() != -1)
      {
      System.out.printf("Winning Percentage: %.1f%%\n", (calcWinPercentage() * 100));
      System.out.println("------------------------------------\n");
      }
   
   else
   {
    System.out.println("Winning Percentage: No games played.");
    }
    }
   }
}