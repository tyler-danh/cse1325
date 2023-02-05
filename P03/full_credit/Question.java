import java.util.ArrayList;

public class Question{
    private static int nextQuestionNumber = 1;
    private final int questionNumber;

    private String question;
    private ArrayList<String> answers = new ArrayList<>();
    private int rightAnswer;

    public int answer;

    public Question(String question, ArrayList<String> answers, int rightAnswer){
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;

        questionNumber = nextQuestionNumber++;

        if(rightAnswer < answers || rightAnswer > answers)
        throw new IllegalArgumentException("rightAnswer should be btween 1-4");

    }

    public boolean checkanswer(int answer){
        
    }

    @Override
    public String toString(){
        return question + "\n" + answers;
    }
}