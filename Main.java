/*
Mini Project 1
Group #_: Evan Vujcec, 
Date: (whatever date you turn it in)
*/

import java.util.Scanner;
import java.util.Random;

class Main {
  // Initialize util objects
  private static Scanner scanner = new Scanner(System.in);
  private static Random random = new Random();

  private static void playGame(int randomNum, int userNum) {
    System.out.printf("Please guess a number between 0 and %d: ", userNum);

    // Game setup
    int userGuess = scanner.nextInt();
    int numTries = 0;

    while(userGuess != randomNum) {
      numTries++;
      if (userGuess > randomNum) {
        System.out.println("Guess lower!");
      }
      else {
        System.out.println("Guess higher!");
      }
      System.out.print("Enter your new guess: ");
      userGuess = scanner.nextInt();
    }

    System.out.printf("Great, you win! It took you %d tries.", numTries);
  }

  public static void main(String[] args) {

    System.out.println("Welcome to the guessing game!");

    // Prompt max number (exclusive)
    System.out.print("Please enter any positive whole number: ");
    int userNum = scanner.nextInt();

    int randomNum = random.nextInt(userNum); // Generate number
    System.out.println("A random number to guess has been generated");

    playGame(randomNum, userNum);

    scanner.close();
  }
}