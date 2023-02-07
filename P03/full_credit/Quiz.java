import java.util.Scanner;
import java.util.ArrayList;

public class Quiz{

    public Quiz(ArrayList<Question> questions){
        loadQuiz();
    }

    public double takeQuiz(){
        loadQuiz();
        for(int i : questions){
            System.out.println(questions.get(i));

            System.out.println("\n" + "Your answer? ");
            answerChoice = s.nextLine();

            if (checkAnswer(answerChoice))
            correctAnswers++;
    
        }
        return correctAnswers;
    }

    private void loadQuiz(){
        answerChoices1.add("1) 13 Billion Years Old");
        answerChoices1.add("2) 2 Million Years Old");
        answerChoices1.add("3) 2 Billion Years Old");
        answerChoices1.add("4) 20 Billion Years Old");

        answerChoices2.add("1) Green");
        answerChoices2.add("2) Blue");
        answerChoices2.add("3) Purple");
        answerChoices2.add("4) Red");

        questions.add("How old is the Earth?", answerChoices1, 1);
        questions.add("What color is the sky?", answerChoices2, 2);
    }

    private ArrayList<Question> questions = new ArrayList<>();

    private ArrayList<String> answerChoices1 = new ArrayList<>();
    private ArrayList<String> answerChoices2 = new ArrayList<>();

    private Scanner s = new Scanner(System.in);
    private int answerChoice;

    private double correctAnswers;
}