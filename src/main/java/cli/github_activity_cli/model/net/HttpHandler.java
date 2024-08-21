package cli.github_activity_cli.model.net;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpHandler {
   private String url = "https://api.github.com/users/";
   private HttpClient client;
   private HttpResponse<String> res = null;

   public HttpHandler () {
      this.client = HttpClient.newHttpClient();
   }

   public HttpResponse<String> req(String username, String path) {
      try {
         HttpRequest req = HttpRequest.newBuilder()
            .uri(new URI(url + username + path))
            .build();

         res = client.send(req, HttpResponse.BodyHandlers.ofString());
         if (res.statusCode() != 200) 
            throw new IOException("failed-to-fetch-data");
      } catch (URISyntaxException | IOException | InterruptedException e) {
         e.printStackTrace();
      }
      return res;
   }
}
