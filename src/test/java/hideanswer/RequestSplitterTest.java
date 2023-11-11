package hideanswer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RequestSplitterTest {
    @Test
    void splitRequestTest() {

        String request1 = "Вопрос 1:Вопрос 1\nОтвет:Ответ 1";
        RequestSplitter splitter = new RequestSplitter("Вопрос \\d*\\:", "Ответ\\:");
        List<QuestionAnswerPair> pairs;
        try {
            pairs = splitter.split(request1);
            assertEquals(1, pairs.size());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
