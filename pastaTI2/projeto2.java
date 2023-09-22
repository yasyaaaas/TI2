import com.azure.ai.textanalytics.*;
import com.azure.ai.textanalytics.models.*;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.Context;
import java.util.Arrays;
import java.util.List;

public class projeto2 {
    public static void main(String[] args) {
        String endpoint = "https://projetotisegundo.cognitiveservices.azure.com/";
        String apiKey = "07f73871642c4cbcb35d865eb0585663";

        TextAnalyticsClient client = new TextAnalyticsClientBuilder()
                .apiKey(new AzureKeyCredential(apiKey))
                .endpoint(endpoint)
                .buildClient();

        // Textos para análise de sentimento
        List<String> texts = Arrays.asList(
                "Eu amo este produto! É incrível.",
                "Não gostei da qualidade do serviço.",
                "O atendimento ao cliente é excelente.");

        // Executar análise de sentimento
        AnalyzeSentimentResultCollection sentimentResults = client.analyzeSentimentBatchWithResponse(
                texts, new AnalyzeSentimentBatchOptions().setIncludeStatistics(true), Context.NONE).getValue();

        for (AnalyzeSentimentResult result : sentimentResults) {
            System.out.println("Texto: " + result.getText());
            System.out.println("Sentimento: " + result.getDocumentSentiment().getSentiment());
            System.out.println("Pontuação: " + result.getDocumentSentiment().getScore());
            System.out.println();
        }
    }
}