import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class lDeckOfCards extends JFrame

{

     private Card ldeck[];  

     private int lcurrentCard;

     private JButton ldealButton, lshuffleButton;

     private JTextField ldisplayCard;

     private JLabel lstatus;

     public lDeckOfCards()

     {

          super( "Card Dealing Program" );

          String faces[] = { "Ace", "Two", "Three", "Four",

          "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };

          String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

          ldeck = new Card[ 52 ];

          lcurrentCard = -1;

          for ( int li = 0; li < ldeck.length; li++ )

          ldeck[ li ] = new Card( faces[ li % 13 ], suits[ li / 13 ] );

          Container lc = getContentPane();

          lc.setLayout( new FlowLayout() );

          ldealButton = new JButton( "Deal card" );

          ldealButton.addActionListener( new ActionListener()

          {

              //action performed          

              public void actionPerformed( ActionEvent e )

              {

                   Card dealt = dealCard();

                   if ( dealt != null )

                   {

                        ldisplayCard.setText( dealt.toString() );

                        lstatus.setText( "Card #: " + lcurrentCard );

                   }

                   else

                   {

                        ldisplayCard.setText( "NO MORE CARDS TO DEAL" );

                        lstatus.setText( "Shuffle cards to continue" );

                   }

              }

          } );

          lc.add( ldealButton );

          lshuffleButton = new JButton( "Shuffle cards" );

          lshuffleButton.addActionListener( new ActionListener()

          {

              //action performed

              public void actionPerformed( ActionEvent e )

              {

                   ldisplayCard.setText( "SHUFFLING ..." );

                   shuffle();

                   ldisplayCard.setText( "DECK IS SHUFFLED" );

              }

          });

          lc.add( lshuffleButton );

          ldisplayCard = new JTextField( 20 );

          ldisplayCard.setEditable( false );

          lc.add( ldisplayCard );

          lstatus = new JLabel();

          lc.add( lstatus );

          setSize( 275, 120 ); // set the window size

          show(); // show the window

     }

     public void shuffle()

     {

          lcurrentCard = -1;

          for ( int li = 0; li < ldeck.length; li++ )

          {

              int lj = ( int ) ( Math.random() * 52 );

              Card temp = ldeck[ li ]; // swap

              ldeck[ li ] = ldeck[ lj ]; // the

              ldeck[ lj ] = temp; // cards

          }

          ldealButton.setEnabled( true );

     }

     public Card dealCard()

     {

          if ( ++lcurrentCard < ldeck.length )

          return ldeck[ lcurrentCard ];

          else

          {

              ldealButton.setEnabled( false );

              return null;

          }

     }

     public static void main( String args[] )

     {

          lDeckOfCards app = new lDeckOfCards();

          app.addWindowListener( new WindowAdapter()

          {

              // 1close window

              public void windowClosing( WindowEvent e )

              {

                   //exit

                   System.exit( 0 );

              }

          } );

     }

}

class Card

{

     private String lface;

     private String lsuit;

     public Card( String lf, String ls )

     {

          lface = lf;

          lsuit = ls;

     }

     public String toString()

     {

          return lface + " of " + lsuit;

     }

}

