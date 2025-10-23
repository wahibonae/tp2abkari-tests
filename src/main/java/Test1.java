import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class Test1 {
    public static void main(String[] args) {
        String cle = System.getenv("GEMINI_KEY");

        ChatModel model = GoogleAiGeminiChatModel
                .builder()
                .apiKey(cle)
                .modelName("gemini-2.5-flash")
                .build();

        String response = model.chat("Hello there!!");

        System.out.println(response);
    }
}