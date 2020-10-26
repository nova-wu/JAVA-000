
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Headers;

import java.io.IOException;

public class OkHttpSample {

    private final OkHttpClient client = new OkHttpClient();

    public void run() throws Exception {

        String url = "https://www.nteport.com/nsw/info/info-type!getNewsByColms.action?num=6&cols=2c90984756249fc1015624ac1f0d0002";

        Request request = new Request.Builder()
            .url(url)
            .build();

        try (Response response = client.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }

            System.out.println(response.body().string());
        }
    }

    public static void main(String[] args) throws Exception {

        new OkHttpSample().run();
    }

}
