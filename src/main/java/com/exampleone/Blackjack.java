package com.exampleone;

import java.util.Scanner;

public class Blackjack {


    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to the blackjack table.");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();

        double playerMoney = 200.00;

        while (playerMoney > 0) {
            System.out.println("You have $" + playerMoney + ". How much would you like to bet?");
            double playerBet = Double.valueOf(userInput.nextLine());
            if (playerBet > playerMoney) {
                System.out.println("You don't have that much to bet.");
                break;
            }

            boolean endRound = false;

            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            while (true) {
                System.out.println("Your Hand: ");
                System.out.println(playerDeck.toString());
                System.out.println("Your deck is valued at: " + playerDeck.cardsValue());
                System.out.println("\nDealer card showing: " + dealerDeck.getCard(0).toString());

                System.out.println("Would you like to (1)Hit or (2)Stand?");
                int response = Integer.valueOf(userInput.nextLine());

                if (response == 1) {
                    playerDeck.draw(playingDeck);
                    System.out.println("You drew a: " + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
                    if (playerDeck.cardsValue() > 21) {
                        System.out.println("BUST! Cards = " + playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;
                    }
                }
                if (response == 2) {
                    break;
                }
            }

            System.out.println("\nDealer's Cards: " + dealerDeck.toString());

            while ((dealerDeck.cardsValue() < 17) && (endRound == false)) {
                dealerDeck.draw(playingDeck);
                System.out.println("Dealer drew: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
            }

            System.out.println("\nDealer's cards = " + dealerDeck.cardsValue());

            if ((dealerDeck.cardsValue() > 21) && (endRound == false)) {
                System.out.println("Dealer busts. You win!");
                playerMoney += playerBet;
                endRound = true;
            } else if ((playerDeck.cardsValue() > dealerDeck.cardsValue()) && (endRound == false)) {
                System.out.println("You win!");
                playerMoney += playerBet;
                endRound = true;
            } else if ((playerDeck.cardsValue() < dealerDeck.cardsValue()) && (endRound == false)) {
                System.out.println("You lose.");
                playerMoney -= playerBet;
                endRound = true;
            } else if (endRound == false) {
                System.out.println("Push");
                endRound = true;
            }


            System.out.println("\nYou: " + playerDeck.cardsValue() + "  Dealer: " + dealerDeck.cardsValue());

            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            System.out.println("End of hand.");
        }
        System.out.println("You're broke. GTFO!");

        userInput.close();
    }

}
