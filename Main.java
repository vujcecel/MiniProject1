/*
Mini Project 1
Group #4: Evan Vujcec, Zac Howe, Zachary Preszler, Jake Hartman
Date: 16-2-2021
*/

import java.util.Scanner;
import java.util.Random;

class Main {
  // Initialize util objects (easier to keep initialized outside function scopes)
  private static Scanner scanner = new Scanner(System.in);
  private static Random random = new Random();

  private static void playGame(int randomNum, int userNum) {
    System.out.printf("Please guess a number between 0 and %d: ", userNum);

    // Game setup
    int userGuess = scanner.nextInt();
    int numTries = 1;

    // Game loop (no need for costlier > operator (will make no difference in JVM but tuning is fun))
    while(userGuess != randomNum) {
      if (userGuess > randomNum)
        System.out.println("Guess lower!");
      else // not higher or equal no need to do additional memcmp (will make no difference in JVM but tuning is fun)
        System.out.println("Guess higher!");
      
      System.out.print("Enter your new guess: ");
      userGuess = scanner.nextInt();
      numTries++;
    }

    System.out.printf("Great, you win! It took you %d tries.%n", numTries);
  }

  public static void main(String[] args) {

    System.out.println("Welcome to the guessing game!");

    // Prompt max number ensuring no negative number causing fatal error
    int userNum = 0;
    while (!(userNum > 0)) {
      System.out.print("Please enter any positive whole number: ");
      userNum = scanner.nextInt();
    }

    int randomNum = random.nextInt(userNum); // Generate number
    System.out.println("A random number to guess has been generated");
    
    playGame(randomNum, userNum); // Start game

    scanner.close(); // Cleanup scanner (obviously unnecessary but best practices)
  }
}