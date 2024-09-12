package caseStudy;

import java.util.Scanner;
import java.util.Random;

public class DiceRollingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Step 1: Ask for the target number of rounds
        int targetRounds;
        do {
            System.out.print("Enter the Number of Rounds: ");
            targetRounds = scanner.nextInt();
        } while (targetRounds < 1 || targetRounds > 99);

        // Initialize points for the players
        int player1Points = 0;
        int player2Points = 0;
        int player3Points = 0;

        // Table header
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("| ROUND | DICE1 | DICE2 | DICE3 | TOTAL1| TOTAL2| TOTAL3|");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+");

        // Play the game for the target number of rounds
        for (int round = 1; round <= targetRounds; round++) {
            // Step 3: Each player rolls the dice
            int player1Roll = random.nextInt(6) + 1;
            int player2Roll = random.nextInt(6) + 1;
            int player3Roll = random.nextInt(6) + 1;

            // Step 4, 5, 6: Handle different roll cases and calculate points
            if (player1Roll == player2Roll && player2Roll == player3Roll) {
                // All three players get the same number
                player1Points += player1Roll;
                player2Points += player2Roll;
                player3Points += player3Roll;
            } else if (player1Roll != player2Roll && player2Roll != player3Roll && player1Roll != player3Roll) {
                // All players get different numbers
                player1Points += player1Roll;
                player2Points += player2Roll;
                player3Points += player3Roll;
            } else {
                // Two players get the same number
                if (player1Roll == player2Roll) {
                    if (player1Roll > player3Roll) {
                        player1Points += 2 * player1Roll;
                        player2Points += 2 * player2Roll;
                    }
                    player3Points += player3Roll;
                } else if (player2Roll == player3Roll) {
                    if (player2Roll > player1Roll) {
                        player2Points += 2 * player2Roll;
                        player3Points += 2 * player3Roll;
                    }
                    player1Points += player1Roll;
                } else {
                    if (player1Roll > player2Roll) {
                        player1Points += 2 * player1Roll;
                        player3Points += 2 * player3Roll;
                    }
                    player2Points += player2Roll;
                }
            }

            // Step 7: Print the current round, dice rolls, and total points
            System.out.printf("|   %2d  |   %d   |   %d   |   %d   |   %d   |   %d   |   %d   |\n",
                    round, player1Roll, player2Roll, player3Roll, player1Points, player2Points, player3Points);
            System.out.println("+-------+-------+-------+-------+-------+-------+-------+");
        }

        scanner.close();
    }
}