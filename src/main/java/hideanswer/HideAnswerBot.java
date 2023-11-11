package hideanswer;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HideAnswerBot extends TelegramLongPollingBot {

    HideAnswerBot() {
        super("6563993858:AAHcRyYsTnH3xdLLY01kKL1SC5mpoohJ4u8");
    }

    @Override
    public String getBotUsername() {
        return "HideAnswerBot";
    }

    // @Override
    // public String getBotToken() {
    // return "6563993858:AAHcRyYsTnH3xdLLY01kKL1SC5mpoohJ4u8";
    // }

    @Override
    public void onUpdateReceived(Update update) {

        try {
            var msg = update.getMessage();
            var user = msg.getFrom();

            String requestText = msg.getText();

            RequestSplitter splitter = new RequestSplitter("Вопрос \\d*\\:", "Ответ\\:");
            List<QuestionAnswerPair> pairs = splitter.split(requestText);

            for (QuestionAnswerPair pair : pairs) {
                List<MessageEntity> messageEntities = new ArrayList<MessageEntity>();
                MessageEntity questionFormatEntity = MessageEntity.builder()
                        .type("bold")
                        .offset(pair.getQuestionHeaderStartPosition())
                        .length(pair.getQuestionHeaderLength())
                        .build();
                messageEntities.add(questionFormatEntity);

                MessageEntity answerHeaderFormatEntity = MessageEntity.builder()
                        .type("bold")
                        .offset(pair.getAnswerHeaderStartPosition())
                        .length(pair.getAnswerHeaderLength())
                        .build();
                messageEntities.add(answerHeaderFormatEntity);

                MessageEntity answerContentFormatEntity = MessageEntity.builder()
                        .type("spoiler")
                        .offset(pair.getAnswerContentStartPosition())
                        .length(pair.getAnswerContentLength())
                        .build();
                messageEntities.add(answerContentFormatEntity);

                SendMessage replyMesssage = SendMessage.builder()
                        .chatId(user.getId().toString())
                        .text(pair.getBody())
                        .entities(messageEntities)
                        .build();
                execute(replyMesssage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
