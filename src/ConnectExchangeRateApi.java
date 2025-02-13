import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectExchangeRateApi {

    Chave chave = new Chave();

    public MoedasDados fazConversao (String baseCode,
                                     String targetCode,
                                     String amount){
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/" +
                chave.getChave() +
                "/pair/"+
                baseCode + "/" +
                targetCode + "/" +
                amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

//            return response.body();
            return new Gson().fromJson(response.body(), MoedasDados.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
