package cn.tj.fnzi.rest.activiti;

import it.sauronsoftware.base64.Base64;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.junit.Test;

public class Test001 extends BaseTest {

    // @Test
    // public void test001() throws Exception {
    //
    // DefaultHttpClient httpClient = new DefaultHttpClient();
    // HttpPost postRequest = new
    // HttpPost("http://localhost:8080/activiti-rest/service/login");
    //
    // StringEntity input = new
    // StringEntity("{\"userId\":\"kermit\",\"password\":\"kermit\"}");
    // input.setContentType("application/json");
    // postRequest.setEntity(input);
    //
    // HttpResponse response = httpClient.execute(postRequest);
    //
    // BufferedReader br = new BufferedReader(new
    // InputStreamReader((response.getEntity().getContent())));
    //
    // String output;
    // System.out.println("Output from Server .... \n");
    //
    // while ((output = br.readLine()) != null) {
    // System.out.println(output);
    // }
    //
    // httpClient.getConnectionManager().shutdown();
    //
    // }

    @Test
    public void test002() throws Exception {
        try {
            // String getUsersUrl =
            // "http://localhost:8080/activiti-rest/service/identity/users";
//            String getTablesUrl = "http://localhost:8080/activiti-rest/service/management/tables";
            String getTablesUrl = "http://localhost:8080/activiti-rest/service/management/tables/ACT_RE_PROCDEF";
            String authorization = "Basic " + Base64.encode("kermit:kermit", "utf-8");

            String ret = Request.Get(getTablesUrl).addHeader("Authorization", authorization).execute().returnContent().asString();

            System.out.println(ret);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//     @Test
//     public void testBase64() {
//     System.out.println(Base64.encode("kermit:kermit", "utf-8"));
//     
//     System.out.println(Base64.decode("a2VybWl0Omtlcm1pdA==", "utf-8"));
//     }
}
