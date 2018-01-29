/**
 * Timothy Hurley
 * Chpt 20 PC 2
   The LinkedList1 class implements a Linked list.
*/
public class LinkedList1
{
/**
   The Node class stores a list element
   and a reference to the next node.
*/  
private class Node
{
  String value;
  Node next;
  
/**
   Constructor.
   @param val The element to store in the node.
   @param n The reference to the successor node.
*/  
Node(String val, Node n)
  {
   value = val;
   next = n;
  }
  
/**
   Constructor.
   @param val The element to store in the node.
*/  
Node(String val)
  {
   // Call the other (sister) constructor.
   this(val, null);
  }
}

Node first; // list head

private Node last; // last element in list

/**
   Constructor.
*/

public LinkedList1()
{
first = null;

last = null;
}

/**
   The isEmpty method checks to see
   if the list is empty.
   @return true if list is empty,
   false otherwise.
*/
public boolean isEmpty()
{
return first == null;
} 

/**
   The size method returns the length of the list.
   @return The number of elements in the list.
*/
public int size()
{
   int count = 0;

   Node p = first;

   while (p != null)
   {
   // There is an element at p

   count ++;

   p = p.next;

   }
   return count;
}

/**
   The add method adds an element to
   the end of the list.
   @param e The value to add to the
   end of the list.
*/  
public void add(String e)
{
if (isEmpty())
{
first = new Node(e);

last = first;
}
else
{
// Add to end of existing list

last.next = new Node(e);

last = last.next;
}
}
Node reverse(Node node) {

Node previous = null;

Node curr = node;

Node next = null;

while (curr != null) {

next = curr.next;

curr.next = previous;

previous = curr;

curr = next;
}
node = previous;
return node;
}

/**
   The add method adds an element at a position.
   @param e The element to add to the list.
   @param index The position at which to add
   the element.
   @exception IndexOutOfBoundsException When
   index is out of bounds.
*/  
public void add(int index, String e)
{
   if (index < 0 || index > size())
   {
   String message = String.valueOf(index);

   throw new IndexOutOfBoundsException(message);
   }

   // Index is at least 0

   if (index == 0)
   {
   // New element goes at beginning
   first = new Node(e, first);

   if (last == null)

   last = first;

   return;
   }

   // Set a reference pred to point to the node that

   // will be the predecessor of the new node

   Node pred = first;

   for (int k = 1; k <= index - 1; k++)
   {
    pred = pred.next;
   }

   // Splice in a node containing the new element

   pred.next = new Node(e, pred.next);

   // Is there a new last element ?

   if (pred.next.next == null)

   last = pred.next;
}
  
/**
   The toString method computes the string
   representation of the list.
   @return The string form of the list.
*/  
public String toString()
{

StringBuilder strBuilder = new StringBuilder();
  
// Use p to walk down the linked list

Node p = first;

  while (p != null)
    {
    strBuilder.append(p.value + "\n");

     p = p.next;

    }

return strBuilder.toString();

}
  
/**
   The remove method removes the element at an index.
   @param index The index of the element to remove.
   @return The element removed.
   @exception IndexOutOfBoundsException When index is out of bounds.
*/
public String remove(int index)
{
   if (index < 0 || index >= size())
   {
   String message = String.valueOf(index);

   throw new IndexOutOfBoundsException(message);
   }

   String element; // The element to return

   if (index == 0)
   {

      // Removal of first item in the list

      element = first.value;

      first = first.next;

      if (first == null)

      last = null;
   }
   else
   {
// To remove an element other than the first,
// find the predecessor of the element to
// be removed.

    Node pred = first;

   // Move pred forward index - 1 times

  for (int k = 1; k <= index -1; k++)

        pred = pred.next;

   // Store the value to return

   element = pred.next.value;

  
   // Route link around the node to be removed

   pred.next = pred.next.next;

  
// Check if pred is now last

 if (pred.next == null)
    last = pred;
   }
   return element;
   }

/**
   The remove method removes an element.
   @param element The element to remove.
   @return true if the remove succeeded,
   false otherwise.
*/
public boolean remove(String element)
{
   if (isEmpty())

   return false;

   if (element.equals(first.value))
   {

// Removal of first item in the list

first = first.next;

if (first == null)

last = null;

return true;
   }  

// Find the predecessor of the element to remove

Node pred = first;

while (pred.next != null && !pred.next.value.equals(element))
{
pred = pred.next;
}

// pred.next == null OR pred.next.value is element

if (pred.next == null)
return false;

// pred.next.value is element

pred.next = pred.next.next;

  
// Check if pred is now last

if (pred.next == null)

last = pred;

return true;
}

 /**
   * The reverse method reverses the order of the Nodes in the linked list it is given.
   * @param sourceList A linked list.
   * @return void  
   * */
 public static void reverseList(LinkedList1 sourceList)
 {
   if(sourceList.size()<=1)
   {
    return;
   }
   Node nearNode = sourceList.first;
   
   Node midNode, farNode;
   
   midNode = nearNode.next;
   
   farNode = midNode.next;
   
   nearNode.next = null;
   
   while(farNode!=null)
   {
    midNode.next = nearNode;
    
    nearNode = midNode;
    
    midNode = farNode;
    
    farNode = farNode.next;
   }
   
   midNode.next = nearNode;
   
   sourceList.first = midNode;
}
 
/**The sort method performs a type of merge sorting algorithm on the linked list
  * @param head The first Node in the linked list.
  * @return sorted A Node after sorting.
  * */
public Node sortLinkedList(Node head)
{
   
      if(head==null || head.next==null)
      {
       return head;
      }        

      Node middle = findMiddle(head);

      Node Middle = middle.next;

      middle.next = (null);

      Node l = sortLinkedList(head);

      Node r = sortLinkedList(Middle);

      Node sorted = merge(l, r);
   
      return sorted;
 }

/**
 * The merge method goes through comparing the values in each node.
 * @param a A Node in the linked list.
 * @param b A Node in the linked list.
 * @return temp A Node representing the middle Node after sorting.
 * */
private Node merge(Node a, Node b)
 {
      if(a==null)

       return b;

     
      if(b==null)

       return a;

      Node temp = null;
     
      if(a.value.compareTo(b.value)<0)
      {
       temp=a;

       temp.next = (merge(a.next, b));
      }
      else
      {
       temp=b;

       temp.next = (merge(a, b.next));
      }
      return temp;
}

/** 
 * The findMiddle method searchs through the linked list and returns the middle Node.
 * @param head The first Node in the linked list.
 * @return curr The middle Node.
 * */     
private Node findMiddle(Node head)
{
      if(head==null)
      {
       return head;
      }
  
      Node curr=head;

      Node temp=head;
    
      while(temp!=null && temp.next!=null && temp.next.next!=null)
      {
          curr = curr.next;

          temp = temp.next.next;   
      }
      return curr;
 }

}
