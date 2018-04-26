package lib.api.poll.com.mylibrary.client;

import android.util.Log;

//import com.poll.api.lib.utils.ConstantMethods;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

//import org.apache.http.conn.ssl.SSLSocketFactory;

import lib.api.poll.com.mylibrary.model.Common.HeaderCall;
import lib.api.poll.com.mylibrary.utils.ConstantMethods;

//import lib.poll.com.mylibrary.utils.ConstantMethods;

//import lib.poll.com.utils.ConstantMethods;

/**
 * Created by Dharmesh-PC on 4/19/2018.
 */

public class PollApi
{


   // public RegisterPhone data ;

    static InputStream is = null;
    static JSONObject jObj = null;
    static JSONArray Jarray = null;
    static String json = "";



    public JSONObject makeHTTPPOST(String url, String param, String userId, String token) // with
    {
        try {

            HttpClient client = new DefaultHttpClient();
            Log.d("Rqe Url ", url);
            Log.d("Req ", param);

            HttpPost post = null;
            try {
                post = new HttpPost(new URI(url));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return ConstantMethods.Errer_jsonobject();
            }

            Log.d("Rqe encrypted ", param);

            StringEntity stringEntity = new StringEntity(param);

            stringEntity.setContentType("application/json");
            //post.setHeader("Content-Type", "application/json");
            post.setHeader("userId", userId);
            post.setHeader("token", token);
            if (url.contentEquals("https://demo.honeyshyam.com/api/v1/Polls/ListPartnerPoll")) {
                post.setHeader("isParnter", "true");
            }
            if (url.contentEquals("https://demo.honeyshyam.com/api/v1/Polls/RefreshSecretAccessKey")) {
                post.setHeader("accessTokenKey", "3UEj4WdYfRnZFgwFvLjT96yzenG5udAkhXOYNltIANkkLO3cEOR6jVdHkQkUniEC");
                post.setHeader("refreshTokenKey ", "true");
            }

            post.setEntity(stringEntity);

            BasicHttpResponse httpResponse = (BasicHttpResponse) client
                    .execute(post);

            // res = EntityUtils.toString(httpResponse.getEntity());
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
            // is=EntityUtils.To
            // System.out.println("data Prints ok "+res);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        } catch (IOException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString().trim();
            Log.d("data prints of ", json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
            return ConstantMethods.Errer_jsonobject();
        }
        // JSONArray Jarray_1=null;
        try {
            // jObj = new JSONObject(res);
            System.out.println("Convert data...");
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            System.out.println("Gt Error");
            e.printStackTrace();
            jObj = null;
        }
        return jObj;
    }
    public JSONObject makeHTTPPOST_SSL(String url, String param, HeaderCall hdata) // with
    {
        try {

            HttpClient httpClient = createHttpClient();
            HttpPost post = null;
            Log.d("Rqe Url ", url);
            Log.d("Req ", param);

            //HttpPost post = null;
            try
            {
                post = new HttpPost(url);
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return ConstantMethods.Errer_jsonobject();
            }

            Log.d("Rqe encrypted ", param);

            StringEntity stringEntity = new StringEntity(param);

            stringEntity.setContentType("application/json");

            post.setHeader("userId",hdata.getUserid());
            post.setHeader("token",hdata.getToken());

            if (url.contentEquals("https://demo.honeyshyam.com/api/v1/Polls/ListPartnerPoll"))
            {
                post.setHeader("isParnter", "true");
            }
            if (url.contentEquals("https://demo.honeyshyam.com/api/v1/Polls/RefreshSecretAccessKey"))
            {
                post.setHeader("accessTokenKey", "3UEj4WdYfRnZFgwFvLjT96yzenG5udAkhXOYNltIANkkLO3cEOR6jVdHkQkUniEC");
                post.setHeader("refreshTokenKey ", "true");
            }
            post.setHeader("version", "1.0");

            post.setEntity(stringEntity);
            HttpResponse httpResponse = httpClient.execute(post);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

/*
            HttpClient client = new DefaultHttpClient();
            Log.d("Rqe Url ", url);
            Log.d("Req ", param);

            HttpPost post = null;
            try {
                post = new HttpPost(new URI(url));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return ConstantMethods.Errer_jsonobject();
            }

            Log.d("Rqe encrypted ", param);

            StringEntity stringEntity = new StringEntity(param);

           // stringEntity.setContentType("application/json");
            //post.setHeader("Content-Type", "application/json");
            //post.setHeader("userId", userId);
           // post.setHeader("token", token);


            post.setEntity(stringEntity);

            BasicHttpResponse httpResponse = (BasicHttpResponse) client
                    .execute(post);

            // res = EntityUtils.toString(httpResponse.getEntity());
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
            */
            // is=EntityUtils.To
            // System.out.println("data Prints ok "+res);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        } catch (IOException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString().trim();
            Log.d("data prints of ", json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
            return ConstantMethods.Errer_jsonobject();
        }
        // JSONArray Jarray_1=null;
        try {
            // jObj = new JSONObject(res);
            System.out.println("Convert data...");
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            System.out.println("Gt Error");
            e.printStackTrace();
            jObj = null;
        }
        return jObj;
    }

    public JSONArray makeHTTPPOSTArray(String url, String param, String userId, String token) // with
    {
        try {

            HttpClient client = new DefaultHttpClient();
            Log.d("Rqe Url ", url);
            Log.d("Req ", param);

            HttpPost post = null;
            try {
                post = new HttpPost(new URI(url));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return ConstantMethods.Errer_jsonarray();
            }

            Log.d("Rqe encrypted ", param);

            StringEntity stringEntity = new StringEntity(param);

            stringEntity.setContentType("application/json");
            //post.setHeader("Content-Type", "application/json");
            post.setHeader("userId", userId);
            post.setHeader("token", token);

            post.setEntity(stringEntity);

            BasicHttpResponse httpResponse = (BasicHttpResponse) client
                    .execute(post);

            // res = EntityUtils.toString(httpResponse.getEntity());
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
            // is=EntityUtils.To
            // System.out.println("data Prints ok "+res);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonarray();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonarray();
        } catch (IOException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonarray();
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonarray();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString().trim();
            Log.d("data prints of ", json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
            return ConstantMethods.Errer_jsonarray();
        }
        // JSONArray Jarray_1=null;
        try {
            // jObj = new JSONObject(res);
            System.out.println("Convert data...");
            Jarray = new JSONArray(json);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            System.out.println("Gt Error");
            e.printStackTrace();
            Jarray = null;
        }
        return Jarray;
    }

    public JSONObject makeHTTPPOSTLogin(String url, String param) // with
    {
        try {

            HttpClient client = new DefaultHttpClient();
            Log.d("Rqe Url ", url);
            Log.d("Req ", param);

            HttpPost post = null;
            try {
                post = new HttpPost(new URI(url));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return ConstantMethods.Errer_jsonobject();
            }

            Log.d("Rqe encrypted ", param);

            StringEntity stringEntity = new StringEntity(param);

            stringEntity.setContentType("application/json");
            //post.setHeader("Content-Type", "application/json");
            post.setHeader("version", "1.0");

            post.setEntity(stringEntity);

            BasicHttpResponse httpResponse = (BasicHttpResponse) client
                    .execute(post);

            // res = EntityUtils.toString(httpResponse.getEntity());
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
            // is=EntityUtils.To
            // System.out.println("data Prints ok "+res);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        } catch (IOException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString().trim();
            Log.d("data prints of ", json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
            return ConstantMethods.Errer_jsonobject();
        }
        // JSONArray Jarray_1=null;
        try {
            // jObj = new JSONObject(res);
            System.out.println("Convert data...");
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            System.out.println("Gt Error");
            e.printStackTrace();
            jObj = null;
        }
        return jObj;
    }
    public JSONObject makeHTTPPOSTLogin_SSL(String url, String param) // with
    {
        try {

            HttpClient httpClient = createHttpClient();
            HttpPost post = null;
            Log.d("Rqe Url ", url);
            Log.d("Req ", param);

            //HttpPost post = null;
            try
            {
                post = new HttpPost(url);
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return ConstantMethods.Errer_jsonobject();
            }

            Log.d("Rqe encrypted ", param);

            StringEntity stringEntity = new StringEntity(param);

            stringEntity.setContentType("application/json");
            post.setHeader("version", "1.0");

            post.setEntity(stringEntity);
            HttpResponse httpResponse = httpClient.execute(post);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        } catch (IOException e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantMethods.Errer_jsonobject();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString().trim();
            Log.d("data prints of ", json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
            return ConstantMethods.Errer_jsonobject();
        }
        // JSONArray Jarray_1=null;
        try {
            // jObj = new JSONObject(res);
            System.out.println("Convert data...");
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            System.out.println("Gt Error");
            e.printStackTrace();
            jObj = null;
        }
        return jObj;
    }

/*
    public JSONObject makeHttpRequestFor_SSL(String url, String method, String param)
    {
        // TODO Auto-generated method stub
        try {
            // check for request method
            if (method == "POST") {
                System.out.println(" In post Method");
                //DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpClient httpClient = createHttpClient();
                HttpPost httpPost = new HttpPost(url+"/");


                StringEntity stringEntity = new StringEntity(param);

                stringEntity.setContentType("application/json");
                //post.setHeader("Content-Type", "application/json");
                httpPost.setHeader("version", "1.0");

                httpPost.setEntity(stringEntity);

                //httpPost.setEntity(new UrlEncodedFormEntity(param));
                //httpPost.setS

                //Multiple
                MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

                for (int index = 0; index < param.size(); index++) {
                    if (param.get(index).getName().equalsIgnoreCase("file")) {
                        // If the key equals to "image", we use FileBody to transfer the data
                        entity.addPart(param.get(index).getName(), new FileBody(new File(param.get(index).getValue())));

                    } else {
                        // Normal string data
                        entity.addPart(param.get(index).getName(), new StringBody(param.get(index).getValue()));
                    }
                }

                httpPost.setEntity(entity);
                //Multiple

                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
                System.out.println(" In post Method");
            } else if (method == "GET") {
                // request method is GET
                DefaultHttpClient httpClient = new DefaultHttpClient();
                String paramString = URLEncodedUtils.format(param, "utf-8");
                url += "" + paramString;
                HttpGet httpGet = new HttpGet(url);
                //String basicAuth = "Basic " + new String(Base64.encode("tomcat:tomcat".getBytes(),Base64.NO_WRAP ));
                //post.setRequestProperty ("Authorization", basicAuth);
                //httpGet.setHeader("Authorization", basicAuth);
                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Error_Exception();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return Error_Exception();
        } catch (IOException e) {
            e.printStackTrace();
            return Error_Exception();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            System.out.println(" In post Method");
            json = sb.toString().trim();
            Log.e("data prints", json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
            return Error_Exception();
        }

        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
            // Jarray = new JSONArray(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
            return Error_Exception();
        }

        // return JSON String
        // return jObj;
        return jObj;

    }

*/
    public static HttpClient createHttpClient() {
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);

            MySSLSocketFactory sf = new MySSLSocketFactory(trustStore);
            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

            HttpParams params = new BasicHttpParams();
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            registry.register(new Scheme("https", sf, 443));

            ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);

            return new DefaultHttpClient(ccm, params);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }

    private static class MySSLSocketFactory extends SSLSocketFactory {
        SSLContext sslContext = SSLContext.getInstance("TLS");

        public MySSLSocketFactory(KeyStore truststore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
            super(truststore);

            TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };

            sslContext.init(null, new TrustManager[]{tm}, null);
        }

        @Override
        public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException, UnknownHostException {
            return sslContext.getSocketFactory().createSocket(socket, host, port, autoClose);
        }

        @Override
        public Socket createSocket() throws IOException {
            return sslContext.getSocketFactory().createSocket();
        }
    }

}
