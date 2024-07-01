import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsultor {
    public Currency findCurrency(String baseCurrencyCode, String targetCurrencyCode, double mountToConvert){
        URI address = URI.create("https://v6.exchangerate-api.com/v6/acec45d624201db133a4727b/pair/"+
                baseCurrencyCode+"/"+targetCurrencyCode+"/"+mountToConvert);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Currency.class);
        } catch (Exception e) {
            throw new RuntimeException("Currency not found");
        }
    }
}
