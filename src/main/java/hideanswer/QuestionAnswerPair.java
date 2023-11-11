package hideanswer;

public class QuestionAnswerPair {

    private String body;

    private int questionHeaderStartPosition;
    private int questionHeaderEndPosition;
    private int questionContentStartPosition;
    private int questionContentEndPosition;

    private int answerHeaderStartPosition;
    private int answerHeaderEndPosition;
    private int answerContentStartPosition;
    private int answerContentEndPosition;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getQuestionHeaderStartPosition() {
        return questionHeaderStartPosition;
    }

    public void setQuestionHeaderStartPosition(int questionHeaderStartPosition) {
        this.questionHeaderStartPosition = questionHeaderStartPosition;
    }

    public int getQuestionHeaderEndPosition() {
        return questionHeaderEndPosition;
    }

    public void setQuestionHeaderEndPosition(int questionHeaderEndPosition) {
        this.questionHeaderEndPosition = questionHeaderEndPosition;
    }

    public int getQuestionHeaderLength() {
        return questionHeaderEndPosition - questionHeaderStartPosition;
    }

    public int getQuestionContentStartPosition() {
        return questionContentStartPosition;
    }

    public void setQuestionContentStartPosition(int questionContentStartPosition) {
        this.questionContentStartPosition = questionContentStartPosition;
    }

    public int getQuestionContentEndPosition() {
        return questionContentEndPosition;
    }

    public void setQuestionContentEndPosition(int questionContentEndPosition) {
        this.questionContentEndPosition = questionContentEndPosition;
    }

    public int getQuestionContentLength() {
        return questionContentEndPosition - questionContentStartPosition;
    }

    public int getAnswerHeaderStartPosition() {
        return answerHeaderStartPosition;
    }

    public void setAnswerHeaderStartPosition(int answerHeaderStartPosition) {
        this.answerHeaderStartPosition = answerHeaderStartPosition;
    }

    public int getAnswerHeaderEndPosition() {
        return answerHeaderEndPosition;
    }

    public void setAnswerHeaderEndPosition(int answerHeaderEndPosition) {
        this.answerHeaderEndPosition = answerHeaderEndPosition;
    }

    public int getAnswerHeaderLength() {
        return answerHeaderEndPosition - answerHeaderStartPosition;
    }

    public int getAnswerContentStartPosition() {
        return answerContentStartPosition;
    }

    public void setAnswerContentStartPosition(int answerContentStartPosition) {
        this.answerContentStartPosition = answerContentStartPosition;
    }

    public int getAnswerContentEndPosition() {
        return answerContentEndPosition;
    }

    public void setAnswerContentEndPosition(int answerContentEndPosition) {
        this.answerContentEndPosition = answerContentEndPosition;
    }

    public int getAnswerContentLength(){
        return answerContentEndPosition - answerContentStartPosition;
    }

    QuestionAnswerPair(String body) {
        this.body = body;
    }

}
