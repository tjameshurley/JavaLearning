import java.util.Scanner;


public class HurleyTennisWinArray
{
  public static void main(String[] args)
  {
    String name;
    int years;
    int firstYear;
    
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("What is the tennis player's name?");
    name = keyboard.nextLine();
    
    System.out.println("How many years has " + name + " been playing" +
                       " competitively?");
    years = keyboard.nextInt();
    int[] wins = new int[years];
    
    System.out.println("What year did the player begin playing competitively?");
    firstYear = keyboard.nextInt();
    
    
    
    for (int index = 0;  index < years; index++)
    {
      System.out.println("Enter wins for year " + (firstYear + index) + ":");
      wins[index] = keyboard.nextInt();
    }
    
    printWins(name, firstYear, wins);
    
  }
    public static void printWins(String n, int fYear, int[] array)
    {
      System.out.println(n + "'s wins:");
      
      for (int index = 0; index < array.length; index++)
      {
      System.out.println("Year: " + (fYear + index) + " Wins: " + array[index]);
      }
     }
      
  }

    
  