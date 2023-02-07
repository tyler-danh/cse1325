import java.util.ArrayList;
import java.util.Scanner;

public class Question{
    private static int nextQuestionNumber = 1;
    private final int questionNumber;

    private String question;
    private ArrayList<String> answers = new ArrayList<>();
    private int rightAnswer;

    public int answer;
    public double correctAnswers = 0;

    public Question(String question, ArrayList<String> answers, int rightAnswer){
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;

        questionNumber = nextQuestionNumber++;

        if(rightAnswer < 1 || rightAnswer > answers.size())
        throw new IllegalArgumentException("rightAnswer should be between 1-4!");

    }

    public boolean checkAnswer(int answer){
        if (answer==rightAnswer){
            correctAnswers++;
            return true;
        }
        else
        return false;
    }

    @Override
    public String toString(){
        return questionNumber + question + "\n" + answers;
    }
}