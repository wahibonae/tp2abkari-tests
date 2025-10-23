import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.model.input.Prompt;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        String cle = System.getenv("GEMINI_KEY");

        PromptTemplate template = PromptTemplate.from("""
                Translate the following text to {{language}}:
                
                {{content}}
                
                Please provide a natural, fluent translation that maintains the original meaning and tone.
                """);

        ChatModel model = GoogleAiGeminiChatModel
                .builder()
                .apiKey(cle)
                .modelName("gemini-2.5-flash")
                .build();

        Prompt prompt = template.apply(Map.of(
            "language", "spanish",
            "content", "Bonjour! Comment ça va?"
        ));

        String response = model.chat(prompt.text());

        System.out.println(response);
    }
}