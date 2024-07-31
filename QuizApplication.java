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