package hideanswer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestSplitter {

    private Pattern questionHeaderPattern;
    private String answerHeaderPatternText;

    public RequestSplitter(String questionHeaderPatternText, String answerHeaderPatternText) {
        this.questionHeaderPattern = Pattern.compile(questionHeaderPatternText);
        this.answerHeaderPatternText = answerHeaderPatternText;
    }

    public List<QuestionAnswerPair> split(String requestText) throws Exception {
        List<QuestionAnswerPair> pairs = new ArrayList<QuestionAnswerPair>();
        Matcher questionHeaderMatcher = questionHeaderPattern.matcher(requestText);

        if (!questionHeaderMatcher.find()) {
            throw new Exception("There should be at least one question with header matching pattern "
                    + questionHeaderPattern.pattern());
        }

        int currentQuestionHeaderStartPosition = questionHeaderMatcher.start();
        int currentQuestionHeaderEndPosition = questionHeaderMatcher.end();

        QuestionAnswerPairParser pairParser = new QuestionAnswerPairParser(answerHeaderPatternText);

        while (questionHeaderMatcher.find()) {
            String currentPairBody = requestText.substring(currentQuestionHeaderStartPosition,
                    questionHeaderMatcher.start());
            pairs.add(pairParser.parse(currentPairBody, 0,
                    currentQuestionHeaderEndPosition - currentQuestionHeaderStartPosition));
            currentQuestionHeaderStartPosition = questionHeaderMatcher.start();
            currentQuestionHeaderEndPosition = questionHeaderMatcher.end();
        }

        String lastPairBody = requestText.substring(currentQuestionHeaderStartPosition);
        pairs.add(pairParser.parse(lastPairBody, 0,
                currentQuestionHeaderEndPosition - currentQuestionHeaderStartPosition));
        return pairs;
    }

}
