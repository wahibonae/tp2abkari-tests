import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.googleai.GoogleAiEmbeddingModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.store.embedding.CosineSimilarity;

import java.time.Duration;

public class Test3 {
    public static void main(String[] args) {
        String cle = System.getenv("GEMINI_KEY");

        EmbeddingModel embeddingModel = GoogleAiEmbeddingModel.builder()
                .apiKey(cle)
                .modelName("gemini-embedding-001")
                .taskType(GoogleAiEmbeddingModel.TaskType.SEMANTIC_SIMILARITY)
                .outputDimensionality(300)
                .timeout(Duration.ofMillis(600))
                .build();

        String text1 = "The cat sits on the mat";
        String text2 = "A cat is sitting on the mat";

        Response<Embedding> response1 = embeddingModel.embed(text1);
        Response<Embedding> response2 = embeddingModel.embed(text2);

        Embedding embed1 = response1.content();
        Embedding embed2 = response2.content();

        double similarity = CosineSimilarity.between(embed1, embed2);

        System.out.println("Similarité cosinus = " + similarity);

    }
}