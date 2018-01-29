import java.util.Random;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Timothy Hurley
 * Programming challenge chpt 13 PC9
 * Program presents images of 2 dice and a button that
 * simulates rolling the 2 dice.
 * */
  
public class HurleyT_DiceSimulator extends JFrame
{
  //Array holding images for the faces of a six sided die.
  private String images[] = {"Die1.png","Die2.png","Die3.png","Die4.png",
    "Die5.png","Die6.png"};
  private JPanel dicePanel;
  private JPanel buttonPanel;
  private JButton rollButton;
  private JLabel imageLabel1 = new JLabel();
  private JLabel imageLabel2 = new JLabel();
  private ImageIcon die1;
  private ImageIcon die2;
  private HurleyT_Die dice = new HurleyT_Die(6);
  
  //Constructor.
  public HurleyT_DiceSimulator()
  {
    setTitle("Dice Simulator");
   
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    setLayout(new GridLayout(2,1));
      
    //Centers window on desktop.
    setLocationRelativeTo(null);
    
    buildDicePanel();
    buildButtonPanel();

    add(dicePanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
    
    pack();
    
    setVisible(true);
  }
/**
 * Method buildDicePanel()
 * adds two random images from the array to the panel.
 * */
private void buildDicePanel()
{
  dicePanel = new JPanel();
  
  dice.roll();
  die1 = new ImageIcon(images[dice.getValue()]);
 
  dice.roll();
  die2 = new ImageIcon(images[dice.getValue()]);
  
  imageLabel1.setIcon(die1);
  imageLabel2.setIcon(die2);
  
  dicePanel.add(imageLabel1);
  dicePanel.add(imageLabel2);
}
/**
 * Method buildButtonPanel adds a button to the 
 * panel and action listner to the button.
 * */
private void buildButtonPanel()
{
  buttonPanel = new JPanel();
  
  rollButton = new JButton("Roll the Dice!!!");
  
  rollButton.addActionListener(new ButtonListener());
  
  buttonPanel.add(rollButton);
}
/**
 * Action listener that calls the Die class's roll method
 * and generates a new random image to set.
 * */
private class ButtonListener implements ActionListener
{
  public void actionPerformed(ActionEvent e)
  {
    dice.roll();
    die1 = new ImageIcon(images[dice.getValue()]);
    
    dice.roll();
    die2 = new ImageIcon(images[dice.getValue()]);
    
    imageLabel1.setIcon(die1);
    imageLabel2.setIcon(die2);
  }
}

/**
   The Die class simulates a six-sided die.
*/

public class HurleyT_Die
{
   private int sides;   // Number of sides
   private int value;   // The die's value
   
   /**
      The constructor performs an initial
      roll of the die.
      @param numSides The number of sides for this die.
   */
   
   public HurleyT_Die(int numSides)
   {
      sides = numSides;
      roll();
   }
   
   /**
      The roll method simlates the rolling of
      the die.
   */
   
   public void roll()
   {
      // Create a Random object.
      Random rand = new Random();
      
      // Get a random value for the die.
      value = rand.nextInt(sides) + 1;
   }
   
   /**
      getSides method
      @return The number of sides for this die.
   */
   
   public int getSides()
   {
      return sides;
   }
   
   /**
      getValue method
      @return The value of the die.
   */
   
   public int getValue()
   {
      return value;
   }
}
//Main method demonstarting the program.
public static void main(String[] args)
{
  new HurleyT_DiceSimulator();
}
}