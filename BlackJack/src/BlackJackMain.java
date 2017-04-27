/* 
 * Blackjack
 * by Jack Zhang
 */

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BlackJackMain {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome to Blackjack by Jack Zhang");
        // Creating a deck
        Deck cards = new Deck();
        int playerSum, dealerSum, bet, totalDinero = 500, choice, numAces = 0, numAcesDealer = 0;
        //hit or stay choice and string array
        String[] hitStayOption = {"HIT", "STAY"};
        //this is for the getPanel method
        BlackJackMain main = new BlackJackMain();

        //actual game
        do {
            //gets bet between 0 and totalDinero
            do {
                bet = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to bet? You have $" + totalDinero));
            } while ((bet <= 0) || (bet > totalDinero));
            // Dealing cards and adding each card to an arraylist of images
            //the if statements keep track of the number of aces on each side to possibly be subtracted later
            Card c1 = cards.DealCard();
            Card c2 = cards.DealCard();
            ArrayList<ImageIcon> playerCardImages = new ArrayList<ImageIcon>();
            playerCardImages.add(cards.getIcon(c1));
            playerCardImages.add(cards.getIcon(c2));
            if (c1.getCardValue() == 11) {
                numAces++;
            }
            if (c2.getCardValue() == 11) {
                numAces++;
            }
            Card dealerCard1 = cards.DealCard();
            Card dealerCard2 = cards.DealCard();
            ArrayList<ImageIcon> dealerCardImages = new ArrayList<ImageIcon>();
            dealerCardImages.add(cards.getIcon(dealerCard1));
            dealerCardImages.add(cards.getIcon(dealerCard2));
            if (dealerCard1.getCardValue() == 11) {
                numAcesDealer++;
            }
            if (dealerCard2.getCardValue() == 11) {
                numAcesDealer++;
            }
            //this card is for everytime someone hits
            Card hitCard;
            //addings sums
            dealerSum = dealerCard1.getCardValue() + dealerCard2.getCardValue();
            playerSum = c1.getCardValue() + c2.getCardValue();
            //in case of double aces on deal
            if (playerSum == 22) {
                playerSum = 12;
            }
            if (dealerSum == 22) {
                dealerSum = 12;
            }

            //most of these joptionpanes have main.getPanel(...) which accesses below method to show the cards
            
            //show player cards and dealers visible card
            JOptionPane.showMessageDialog(null, main.getPanel("You have " + playerSum, playerCardImages), "Player Card Total: " + playerSum, JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, main.getPanel("Dealer shows " + dealerCard1, cards.getIcon(dealerCard1), cards.getFaceDown()),
                    "Player Card Total: " + playerSum + "     Dealer shows: " + dealerCard1, JOptionPane.PLAIN_MESSAGE);
            
            //this is to keep player from going to the hit or stay option if they start with 21
            if (playerSum < 21) {
                choice = JOptionPane.showOptionDialog(null, main.getPanel("Your total: " + playerSum + "    Dealer shows: " + dealerCard1, cards.getIcon(c1), cards.getIcon(c2)), 
                        "Hit or Stay?", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, hitStayOption, hitStayOption[1]);
            } else {
                choice = 1;
            }
            
            //displays hit or stay options and adds cards to arraylist of imageicons
            while ((choice == 0) && (playerSum < 21)) {
                hitCard = cards.DealCard();
                //adds hitcard to playerCardImages arraylist
                playerCardImages.add(cards.getIcon(hitCard));
                playerSum += hitCard.getCardValue();
                //keep track of aces
                if (hitCard.getCardValue() == 11) {
                    numAces++;
                }
                //if player has aces but went over 21, this will subtract ten as if one of the aces were worth 1 not 11
                //it also subtracts an ace to keep track in case player gets multiple aces
                if ((playerSum > 21) && (numAces > 0)) {
                    playerSum -= 10;
                    numAces--;
                }
                
                JOptionPane.showMessageDialog(null, main.getPanel("You got:   " + hitCard, playerCardImages), "Total " + playerSum, JOptionPane.PLAIN_MESSAGE);
                
                if (playerSum < 21) {
                    choice = JOptionPane.showOptionDialog(null, main.getPanel("Your total: " + playerSum + "    Dealer shows: " + dealerCard1, playerCardImages), 
                            "Hit or Stay?", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, hitStayOption, hitStayOption[1]);
                }
            }
            
            //after player goes, dealer shows his second card
            JOptionPane.showMessageDialog(null, main.getPanel("Dealer reveals his cards.  He has a total of " + dealerSum, cards.getIcon(dealerCard1), cards.getIcon(dealerCard2)), 
                    "Player Card Total: " + playerSum + "     Dealer Card Total: " + dealerSum, JOptionPane.PLAIN_MESSAGE);
            //dealer will continue hitting if the player has not busted and the dealer has under 17
            //this while loop is similar to the players hit loop where aces are kept track of and the arraylist of imageicons is updated
            while ((dealerSum < 17) && (playerSum < 22)) {
                hitCard = cards.DealCard();
                //adds hitCard to dealerCardImages arraylist
                dealerCardImages.add(cards.getIcon(hitCard));
                dealerSum += hitCard.getCardValue();
                //aces and busting prevention
                if (hitCard.getCardValue() == 11) {
                    numAcesDealer++;
                }
                if ((dealerSum > 21) && (numAcesDealer > 0)) {
                    dealerSum -= 10;
                    numAcesDealer--;
                }
                JOptionPane.showMessageDialog(null, main.getPanel("Dealer hits and gets..." + hitCard, dealerCardImages), 
                        "Player Card Total: " + playerSum + "     Dealer Card Total: " + dealerSum, JOptionPane.PLAIN_MESSAGE);
            }
            
            //These if/elseif statements tell who wins and adds/subtracts bet based on winner
            if (dealerSum == 21) {
                JOptionPane.showMessageDialog(null, "Dealer has 21.  Dealer Wins\nDealer total: " + dealerSum + "\nYour total: " + playerSum);
                totalDinero -= bet;
            } else if (playerSum == 21) {
                JOptionPane.showMessageDialog(null, "You have 21.  You Win!\nDealer total: " + dealerSum + "\nYour total: " + playerSum);
                totalDinero += bet;
            } else if (playerSum > 21) {
                JOptionPane.showMessageDialog(null, "You busted.  Dealer Wins\nDealer total: " + dealerSum + "\nYour total: " + playerSum);
                totalDinero -= bet;
            } else if (dealerSum > 21) {
                JOptionPane.showMessageDialog(null, "Dealer busted.  You Win\nDealer total: " + dealerSum + "\nYour total: " + playerSum);
                totalDinero += bet;
            } else if (playerSum > dealerSum) {
                JOptionPane.showMessageDialog(null, "Your cards are greater.  You Win\nDealer total: " + dealerSum + "\nYour total: " + playerSum);
                totalDinero += bet;
            } else if (playerSum == dealerSum) {
                JOptionPane.showMessageDialog(null, "Dealer wins the tie.\nDealer total: " + dealerSum + "\nYour total: " + playerSum);
                totalDinero -= bet;
            } else {
                JOptionPane.showMessageDialog(null, "Dealer's cards are greater.  Dealer Wins\nDealer total: " + dealerSum + "\nYour total: " + playerSum);
                totalDinero -= bet;
            }
            
            //You are only allowed to play again if your totalDinero is positive
            if (totalDinero > 0) {
                JOptionPane.showMessageDialog(null, "You have $" + totalDinero);
                choice = JOptionPane.showConfirmDialog(null, "Play Again?", "?", JOptionPane.YES_NO_OPTION);
            }
        } while ((choice == JOptionPane.YES_OPTION) && (totalDinero > 0));

        //displays totalDinero or no money
        if (totalDinero > 0) {
            JOptionPane.showMessageDialog(null, "You are leaving with $" + totalDinero);
        } else {
            JOptionPane.showMessageDialog(null, "You ran out of money!!!");
            JOptionPane.showMessageDialog(null, "Game Over");
        }

    }

    //the methods below is a JPanel with message s and images in parameters to be displayed inside a JOptionPane
    //the first one exists for the facedown card of the dealer
    private JPanel getPanel(String s, ImageIcon i1, ImageIcon i2) {
        JPanel panel = new JPanel();
        JLabel l1 = new JLabel(i1);
        JLabel l2 = new JLabel(i2);
        JLabel message = new JLabel(s);
        panel.add(l1);
        panel.add(l2);
        panel.add(message);
        return panel;
    }
    //same as the above method but with arraylist parameters to be dynamic with hitcard
    private JPanel getPanel(String s, ArrayList<ImageIcon> i) {
        JPanel panel = new JPanel();
        for (int n = 0; n < i.size(); n++) {
            JLabel l = new JLabel(i.get(n));
            panel.add(l);
        }
        JLabel message = new JLabel(s);
        panel.add(message);
        return panel;
    }

}
