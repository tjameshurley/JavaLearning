/**
 * @author Timothy Hurley
 * Chpt 17 PC2
 * A class that uses the quicksort algorithm 
 * to organize an array of objects.
 * */
public class HurleyT_ObjectQuickSort
{
  /**
   * The quickSort method accepts an array to be sorted and
   * uses calls to doQuickSort, partition, and swap methods.
   * @param array An array to be sorted.
   * */
  public static void quickSort(Comparable[] array)
  {
    doQuickSort(array, 0, array.length - 1);
  }
 
  /**
   * The doQuickSort method calls partition and swap methods to 
   * sort the array passed to it.
   * @param array An array of type Comparable to be sorted.
   * @param start An integer value for the starting subscript.
   * @param end An integer value for the ending subscript.
   * */ 
  private static void doQuickSort(Comparable[] array, int start, int end)
  {
    int pivotPoint;
    
    if (start < end)
    {
      pivotPoint = partition(array, start, end);
      
      doQuickSort(array, start, pivotPoint - 1);
      
      doQuickSort(array, pivotPoint +1, end);
    }
  }
 
  /**
   * The partition method finds the pivot value and 
   * arranges the vlues array so the left side of the 
   * array is less than the right.
   * @param array The array to be sorted.
   * @param start The starting subscript of the array.
   * @param end The ending subscript of the array.
   * @return endOfLeftList An int value for the end of the left list.
   * */
  private static int partition(Comparable[] array, int start, int end)
  {
    Comparable pivotValue;
    int endOfLeftList;
    int mid;
    
    mid = (start + end) / 2;
    
    swap(array, start, mid);
    
    pivotValue = array[start];
    
    endOfLeftList = start;
    
    for(int scan = start +1; scan <= end; scan++)
    {
      if(array[scan].compareTo(pivotValue) < 0)
      {
        endOfLeftList++;
        swap(array, endOfLeftList, scan);
      }
    }
   
     swap(array, start, endOfLeftList);
    
     return endOfLeftList;
      }
  /*
   * The swap method exchanges the vlues in the provided subscripts.
   * @param array The array to be sorted.
   * @param a The subscript of the first value to be exchanged.
   * @param a The subscript of the second value to be exchanged.
   * */
  private static void swap(Comparable[] array, int a, int b)
  {
    Comparable temp;
    
    temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
  
}
   