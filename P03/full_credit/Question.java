public class Question{
    private int nextQuestionNumber = 1;
    private int questionNumber;

    private String question;
    private String[] answers = new String[4];
    private int rightAnswer;

    public Question(String question, String[] answers, int rightAnswer){
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }
}