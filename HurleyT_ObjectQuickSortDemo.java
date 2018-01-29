import java.io.*;
import java.util.Scanner;
/**
 * @author Timothy Hurley
 * Chpt 17 PC2
 * A program that uses the quicksort algorithm 
 * to organize an array of objects.
 * */

public class HurleyT_ObjectQuickSortDemo
{   
   public static void main(String[] args)
  {
    //An array to be sorted.
    String[] values = {"Q", "Z", "A", "200", "AA", "ZZZ", "B", "BB", "AAAA", "0"};

    System.out.println("Starting with an unsorted list: ");
    for(String element : values)
      System.out.print(element + " ");
    
    HurleyT_ObjectQuickSort.quickSort(values);
    
    System.out.println("\nNow the sorted list: ");
    for(String element : values)
      System.out.print(element + " "); 
    }
}