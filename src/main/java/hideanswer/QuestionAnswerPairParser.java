package hideanswer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionAnswerPairParser {

    Pattern answerHeaderPattern;

    QuestionAnswerPairParser(String answerHeaderPattern) {
        this.answerHeaderPattern = Pattern.compile(answerHeaderPattern);
    }

    QuestionAnswerPair parse(String body, int questionHeaderStartPosition, int questionHeaderEndPosition) throws Exception {
        QuestionAnswerPair pair = new QuestionAnswerPair(body);
        
        pair.setQuestionHeaderStartPosition(questionHeaderStartPosition);
        pair.setQuestionHeaderEndPosition(questionHeaderEndPosition);
        pair.setQuestionContentStartPosition(questionHeaderEndPosition);
        Matcher answerHeaderMatcher = answerHeaderPattern.matcher(body);
        if (!answerHeaderMatcher.find()) {
            throw new Exception("Question must have an answer");
        }

        pair.setQuestionContentEndPosition(answerHeaderMatcher.start());
        pair.setAnswerHeaderStartPosition(answerHeaderMatcher.start());
        pair.setAnswerHeaderEndPosition(answerHeaderMatcher.end());
        pair.setAnswerContentStartPosition(answerHeaderMatcher.end());
        pair.setAnswerContentEndPosition(body.length());

        return pair;
    }
}
