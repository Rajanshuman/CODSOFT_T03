# CODSOFT_T04
Repository contain the third task of codsoft java programming internship.  
# Creating a simple quiz in Java involves designing a program that can present a series of questions to the user and evaluate their responses. Here is an example of how to create a simple quiz program in Java

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static int score = 0;
    private static int time = 20; // time in seconds
    private static boolean timeUp = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Questions and answers
        String[] questions = {
            "What is the capital of France?",
            "What is the largest planet in our solar system?",
            "Which is the red planet in our solar system?",
            "Which is the tallest animal?",
            "Which team won the ICC T20 Worldcup 2024?"
        };

        String[] answers = {
            "Paris",
            "Jupiter",
            "Mars",
            "Giraffe",
            "India"
        };

        // Start the quiz
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            startTimer();
            String userAnswer = scanner.nextLine();
            stopTimer();

            if (!timeUp) {
                if (userAnswer.equalsIgnoreCase(answers[i])) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect. The correct answer is " + answers[i]);
                }
            } else {
                System.out.println("Time's up! The correct answer is " + answers[i]);
            }

            timeUp = false;
        }

        System.out.println("Quiz over. Your final score is " + score + "/" + questions.length);
    }

    private static void startTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
                System.out.println("Time's up!");
            }
        }, time * 1000);
    }

    private static void stopTimer() {
        // You can't actually stop a Timer in Java, but we can set timeUp to false
        // to prevent the "Time's up!" message from being printed.
        timeUp = false;
    }
}


In this example, the program uses a Scanner object to get input from the user and a score variable to keep track of the user's score. The program presents two multiple-choice questions to the user, reads their input, and evaluates their responses. Finally, the program displays the user's final score.

This is a simple example of a quiz program in Java, and there are many ways to extend and improve upon it. For example, you could add more questions, use a database to store the questions and answers, or implement a time limit for answering each question.
