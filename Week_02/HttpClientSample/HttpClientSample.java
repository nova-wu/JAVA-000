import org.apache.http.client.fluent.Request;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

public class HttpClientSample {

    public static void main(String[] args) throws Exception {

        String url = "http://localhost:8801/";
        HttpResponse response = Request.Get(url).execute().returnResponse();
        int statusCode = response.getStatusLine().getStatusCode();
        if(HttpStatus.SC_OK <= statusCode && HttpStatus.SC_MULTIPLE_CHOICES >= statusCode) {
            HttpEntity entity = response.getEntity();
            System.out.println("请求的响应为：" + (entity != null ? EntityUtils.toString(entity) : null));
        } else {
            System.out.println("请求未成功，Http 状态码为：" + statusCode);
        }
    }

}
