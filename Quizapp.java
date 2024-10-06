import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

class Quizapp {
    public static void main(String[] args) {
        int score = 0;
        int answered = 0;
        int incorrect = 0;

        Scanner scanner = new Scanner(System.in);
        Timer timer;

        String questions[] = {
            "1. Who was the captain of the Indian cricket team when they won the ICC T20 World Cup in 2007?",
            "2. Who is the first Indian cricketer to score a double century in One Day Internationals (ODI)?",
            "3. Who is the highest wicket-taker for India in Test cricket?",
            "4. Which Indian cricketer is known as the \"Haryana Hurricane\"?",
            "5. Who is the first Indian cricketer to take a hat-trick in Test cricket?"
        };

        String correctAnswers[] = {
            "a", 
            "c", 
            "a", 
            "a", 
            "a"  
        };

        String choices[] = {
            "a) MS Dhoni\nb) Virat Kohli\nc) Sourav Ganguly",
            "a) Virender Sehwag\nb) Rohit Sharma\nc) Sachin Tendulkar",
            "a) Anil Kumble\nb) Ravichandran Ashwin\nc) Harbhajan Singh",
            "a) Kapil Dev\nb) Mohinder Amarnath\nc) Yuvraj Singh",
            "a) Harbhajan Singh\nb) Zaheer Khan\nc) Ravindra Jadeja"
        };

        System.out.println("                                                  CRIC QUIZ                                                             ");
        System.out.println("========================================================================================================================");

        for (int question = 0; question < questions.length; question++) {
            final int currentQuestion = question;
            boolean[] answeredWithinTime = {false}; 

            timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    System.out.println("Time's up for question " + (currentQuestion + 1) + "!\n");
                    answeredWithinTime[0] = true; 
                }
            }, 20000);

            System.out.println(questions[question]);
            System.out.println();
            System.out.println(choices[question]);
            System.out.println();
            System.out.println("Enter your option (a/b/c): ");

            String option = scanner.next();

            
            timer.cancel();

            
            if (answeredWithinTime[0]) {
                System.out.println("You did not answer in time! The correct answer is option " + correctAnswers[currentQuestion] + ".\n");
                incorrect++;
            } else {
                if (option.equalsIgnoreCase(correctAnswers[currentQuestion])) {
                    System.out.println("Correct answer!\n");
                    score += 20;
                    answered++;
                } else {
                    System.out.println("Sorry, your answer is wrong! The correct answer is option " + correctAnswers[currentQuestion] + ".\n");
                    incorrect++;
                }
            }
        }

        System.out.println("Your final score: " + score + " / 100\n");
        System.out.println("Your performance in this quiz game is: correct answered = " + answered + ", wrongly answered = " + incorrect + ".\n");

        if (answered == 5 || answered == 4) {
            System.out.println("You are a great Indian cricket team fan!");
        } else {
            System.out.println("You want to study about the Indian cricket team to get full marks in this quiz game!");
        }

        scanner.close();
    }
}
