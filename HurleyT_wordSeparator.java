import java.util.Scanner;
  
/**Timothy Hurley
 * Assignment 2 Programming Challenge 9.14
 * */
  
 public class HurleyT_wordSeparator
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter a sentence without spaces and capitalize each word:");
    String userString = keyboard.nextLine();
    
    //Create copy of string for reference to its length.
    String letters1 = userString;
    
    //Create a StringBuilder object.
    StringBuilder letters = new StringBuilder(userString);
    
    //For loop to search and replace the uppercase characters with a space and
    //convert them to lowercase.
    for (int index = 1; index < letters1.length(); index++)
    {
      char ch = letters.charAt(index);
      if (Character.isUpperCase(ch))
        {
       char c = letters.charAt(index);
       char word= Character.toLowerCase(c);
       letters.replace(index,index+1, " " + word);
       index++;
         }
     }
    //Print the modified StringBuilder object.
     System.out.println(letters);
  }
 }



   