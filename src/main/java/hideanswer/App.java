/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hideanswer;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("Registering Bot");
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            String botToken = System.getenv("HIDEANSWER_BOT_TOKEN");
            botsApi.registerBot(new HideAnswerBot(botToken));
            System.out.println("Successfully registered.");
        } catch (TelegramApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getGreeting(){
        return "Hello from HideAnswerBot App";
    }
}
