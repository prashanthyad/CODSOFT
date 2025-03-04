package com.codsoft;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 100;
    public static final int MAX_ATTEMPTS = 6; // Fixed to match the displayed message
    public static final int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain;

        do {
            int totalScore = 0;

            System.out.println("\n🎉 WELCOME TO THE NUMBER GUESSING GAME 🎉\n");
            System.out.println("Total Rounds: " + MAX_ROUNDS);
            System.out.println("Attempts per Round: " + MAX_ATTEMPTS);
            System.out.println("Guess the number between " + MIN_RANGE + " and " + MAX_RANGE + "\n");

            for (int round = 1; round <= MAX_ROUNDS; round++) {
                Random random = new Random();
                int number = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
                int attemptsLeft = MAX_ATTEMPTS;

                System.out.println("\n🔵 Round " + round + " - Let's begin!\n");

                while (attemptsLeft > 0) {
                    System.out.print("Enter your guess: ");

                    // Validate input
                    if (!sc.hasNextInt()) {
                        System.out.println("⚠ Invalid input! Please enter a number.");
                        sc.next(); // Clear the invalid input
                        continue;
                    }

                    int guessNumber = sc.nextInt();
                    attemptsLeft--;

                    if (guessNumber == number) {
                        int roundScore = attemptsLeft + 1; // Higher score for fewer attempts
                        totalScore += roundScore;
                        System.out.println("🎉 Correct! You guessed the number in " + (MAX_ATTEMPTS - attemptsLeft) + " attempts. Round score: " + roundScore);
                        break;
                    } else if (guessNumber < number) {
                        System.out.println("🔼 Too low! Attempts left: " + attemptsLeft);
                    } else {
                        System.out.println("🔽 Too high! Attempts left: " + attemptsLeft);
                    }
                }

                if (attemptsLeft == 0) {
                    System.out.println("❌ Out of attempts! The number was: " + number);
                }
            }

            System.out.println("\n🎯 Game Over! Your total score: " + totalScore);

            // Ask if the user wants to play again
            System.out.print("\n🔄 Do you want to play again? (yes/no): ");
            String response = sc.next().toLowerCase();
            playAgain = response.startsWith("y");

        } while (playAgain);

        System.out.println("\n👋 Thanks for playing! Goodbye!");
        sc.close();
    }
}
