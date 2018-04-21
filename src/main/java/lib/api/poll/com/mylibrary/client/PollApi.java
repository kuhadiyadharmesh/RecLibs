package lib.api.poll.com.mylibrary.client;

import android.util.Log;

//import com.poll.api.lib.utils.ConstantMethods;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
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
import java.io.File;
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
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

//import org.apache.http.conn.ssl.SSLSocketFactory;

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
            try {
                post = new HttpPost(url);
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

            //BasicHttpResponse httpResponse = (BasicHttpResponse) client
             //       .execute(post);

            HttpResponse httpResponse = httpClient.execute(post);

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
    /**
     * Created by Dharmesh-PC on 4/19/2018.
     */
/*
    public static class ApiInfo
    {
        public static String webUrl = "https://demo.honeyshyam.com/api/v1/";


        public static String register_api = webUrl + "Polls/Registration";
        //public static final int register_type = 101;

        public static String VerifyEmail_api = webUrl + "Polls/VerifyEmail";
        //public static final int VerifyEmail_type = 102;

        public static String login_api = webUrl + "Polls/Login";
        //public static final int login_type = 103;

        public static String LogOut_api = webUrl + "Polls/LogOut";
        //public static final int LogOut_type = 104;

        public static String DeleteUser_api = webUrl + "Polls/DeleteUser";
        //public static final int DeleteUser_type = 105;

        public static String GetBalance_api = webUrl + "Polls/GetBalance";
        //public static final int GetBalance_type = 106;

        public static String ViewProfile_api = webUrl + "Polls/ViewProfile";
        //public static final int ViewProfile_type = 107;

        public static String PostAuth_api = webUrl + "Polls/PostAuth";
        //public static final int PostAuth_type = 108;

        public static String ReSendVerifyEmail_api = webUrl + "Polls/ReSendVerifyEmail";
        //public static final int ReSendVerifyEmail_type = 109;

        public static String VerifyPhone_api = webUrl + "Polls/VerifyPhone";
        //public static final int VerifyPhone_type = 110;

        public static String ResendVerifyCode_api = webUrl + "Polls/ResendVerifyCode";
        //public static final int ResendVerifyCode_type = 111;

        public static String MakeCall_api = webUrl + "Polls/MakeCall";
        //public static final int MakeCall_type = 112;

        public static String GetPollCounters_api = webUrl + "Polls/GetPollCounters";
        //public static final int GetPollCounters_type = 113;

        public static String GetMyPolls_api = webUrl + "Polls/GetMyPolls";
        //public static final int GetMyPolls_type = 114;

        public static String GetPollById_api = webUrl + "Polls/GetPollById";
        //public static final int GetPollById_type = 115;

        public static String GetMyAllPolls_api = webUrl + "Polls/GetMyAllPolls";
        //public static final int GetMyAllPolls_type = 116;

        public static String GetPollResult_api = webUrl + "Polls/GetPollResult";
        //public static final int GetPollResult_type = 117;

        public static String CreateTextPoll_api = webUrl + "Polls/CreateTextPoll";
        //public static final int CreateTextPoll_type = 118;

        public static String GetEmployeeFilterCount_api = webUrl + "Polls/GetEmployeeFilterCount";
        //public static final int GetEmployeeFilterCount_type = 119;

        public static String CreateBestTextPoll_api = webUrl + "Polls/CreateBestTextPoll";
        //public static final int CreateBestTextPoll_type = 120;

        public static String CreateSingleImagePoll_api = webUrl + "Polls/CreateSingleImagePoll";
        //public static final int CreateSingleImagePoll_type = 121;

        public static String BestImagePoll_api = webUrl + "Polls/BestImagePoll";
        //public static final int BestImagePoll_type = 122;

        public static String DeleteDraftPoll_api = webUrl + "Polls/DeleteDraftPoll";
        //public static final int DeleteDraftPoll_type = 123;

        public static String UploadFile_api = webUrl + "Polls/UploadFile?";
        //public static final int UploadFile_type = 124;

        public static String GetWorkerDetails_api = webUrl + "Polls/GetWorkerDetails";
        //public static final int GetWorkerDetails_type = 125;

        public static String ChangePassword_api = webUrl + "Polls/ChangePassword";
        //public static final int ChangePassword_type = 126;

        public static String ResetPasswordRequest_api = webUrl + "Polls/ResetPasswordRequest";
        //public static final int ResetPasswordRequest_type = 127;

        public static String ResetPassword_api = webUrl + "Polls/ResetPassword";
        //public static final int ResetPassword_type = 128;

        public static String ViewPublicProfile_api = webUrl + "Polls/ViewPublicProfile";
        //public static final int ViewPublicProfile_type = 129;

        public static String GetListPublicProfile_api = webUrl + "Polls/GetListPublicProfile";
        //public static final int GetListPublicProfile_type = 130;

        public static String DeleteProfilePic_api = webUrl + "Polls/DeleteProfilePic?";
        //public static final int DeleteProfilePic_type = 131;

        public static String UpdateProfile_api = webUrl + "Polls/UpdateProfile";
        //public static final int UpdateProfile_type = 132;

        public static String ThumbsUpDown_api = webUrl + "Polls/ThumbsUpDown";
        //public static final int ThumbsUpDown_type = 133;

        public static String GetFileDetails_api = webUrl + "Polls/GetFileDetails";
        //public static final int GetFileDetails_type = 134;

        public static String ExtendExpireTime_api = webUrl + "Polls/ExtendExpireTime";
        //public static final int ExtendExpireTime_type = 135;

        public static String ExpirePoll_api = webUrl + "Polls/ExpirePoll";
        //public static final int ExpirePoll_type = 136;

        public static String UpdatePublishedPoll_api = webUrl + "Polls/UpdatePublishedPoll";
        //public static final int UpdatePublishedPoll_type = 137;

        public static String GetPaymentPlans_api = webUrl + "Polls/GetPaymentPlans";
        //public static final int GetPaymentPlans_type = 138;

        public static String GetAllFilterCategories_api = webUrl + "Polls/GetAllFilterCategories";
        //public static final int GetAllFilterCategories_type = 139;

        public static String GetAllFilters_api = webUrl + "Polls/GetAllFilters";
        //public static final int GetAllFilters_type = 140;

        public static String GetFilterOptions_api = webUrl + "Polls/GetFilterOptions";
        //public static final int GetFilterOptions_type = 141;

        public static String GetFilterOptionsList_api = webUrl + "Polls/GetFilterOptionsList";
        //public static final int GetFilterOptionsList_type = 142;

        public static String FullFilterViewByPollId_api = webUrl + "Polls/FullFilterViewByPollId";
        //public static final int FullFilterViewByPollId_type = 143;

        public static String FilterViewByPollId_api = webUrl + "Polls/FilterViewByPollId";
        //public static final int FilterViewByPollId_type = 144;

        public static String GetQuestions_api = webUrl + "Polls/GetQuestions";
        //public static final int GetQuestions_type = 145;

        public static String GetFilterDataCount_api = webUrl + "Polls/GetFilterDataCount";
        //public static final int GetFilterDataCount_type = 146;

        public static String DeletePoll_api = webUrl + "Polls/DeletePoll";
        //public static final int DeletePoll_type = 147;

        public static String GetCategories_api = webUrl + "Polls/GetCategories";
        //public static final int GetCategories_type = 148;

        public static String GetPublicPollByQuery_api = webUrl + "Polls/GetPublicPollByQuery";
        //public static final int GetPublicPollByQuery_type = 149;

        public static String GetAllDepartment_api = webUrl + "Polls/GetAllDepartment";
        //public static final int GetAllDepartment_type = 150;

        public static String GetPollStatus_api = webUrl + "Polls/GetPollStatus";
        //public static final int GetPollStatus_type = 151;

        public static String GetEducations_api = webUrl + "Polls/GetEducations";
        //public static final int GetEducations_type = 152;

        public static String SaveBillingAgreement_api = webUrl + "Polls/SaveBillingAgreement";
        //public static final int SaveBillingAgreement_type = 153;

        public static String CancelBillingAgreement_api = webUrl + "Polls/CancelBillingAgreement";
        //public static final int CancelBillingAgreement_type = 154;

        public static String GetMyBillingAgreement_api = webUrl + "Polls/GetMyBillingAgreement";
        //public static final int GetMyBillingAgreement_type = 155;

        public static String RefreshSecretAccessKey_api = webUrl + "Polls/RefreshSecretAccessKey";
        //public static final int RefreshSecretAccessKey_type = 156;

        public static String GetUserFullContact_api = webUrl + "Polls/GetUserFullContact";
        //public static final int GetUserFullContact_type = 157;

        public static String GetLoginHistory_api = webUrl + "Polls/GetLoginHistory";
        //public static final int GetLoginHistory_type = 158;

        public static String ViewNotificationsPreference_api = webUrl + "Polls/ViewNotificationsPreference";
        //public static final int ViewNotificationsPreference_type = 159;

        public static String RegisterNotifications_api = webUrl + "Polls/RegisterNotifications";
        //public static final int RegisterNotifications_type = 160;

        public static String ListPartnerPoll_api = webUrl + "Polls/ListPartnerPoll";
        //public static final int ListPartnerPoll_type = 161;

        public static String Countries_api = webUrl + "Polls/Countries";
        //public static final int Countries_type = 162;

        public static String StatesByCountry_api = webUrl + "Polls/StatesByCountry";
        //public static final int StatesByCountry_type = 163;

        public static String CitiesByState_api = webUrl + "Polls/CitiesByState";
        //public static final int CitiesByState_type = 164;

        public static String SaveRemoteImage_api = webUrl + "Polls/SaveRemoteImage";
        //public static final int SaveRemoteImage_type = 165;

        public static String MetaTags_api = webUrl + "Polls/MetaTags";
        //public static final int MetaTags_type = 166;

        public static String GetMetaTags_api = webUrl + "Polls/GetMetaTags?";
        //public static final int GetMetaTags_type = 167;

        public static String UploadBase64File_api = webUrl + "Polls/UploadBase64File";
        //public static final int UploadBase64File_type = 168;

        //-----------PublicPoll--------------------

        public static String GetPublic_api = webUrl + "PublicPoll/GetPublic";
        //public static final int GetPublic_type = 200;

        public static String pp_ViewPublicProfile_api = webUrl + "PublicPoll/ViewPublicProfile";
        //public static final int pp_ViewPublicProfile_type = 201;

        public static String pp_ListPublicUsers_api = webUrl + "PublicPoll/ListPublicUsers";
        //public static final int pp_ListPublicUsers_type = 202;

        public static String pp_GetPollResult_api = webUrl + "PublicPoll/GetPollResult";
        //public static final int pp_GetPollResult_type = 203;

        //-----------------------Pay---------------------------------
        public static String pay_BillingHistory_api = webUrl + "Pay/BillingHistory";
        //public static final int pay_BillingHistory_type = 251;

        public static String pay_BillingInvoice_api = webUrl + "Pay/BillingInvoice";
        //public static final int pay_BillingInvoice_type = 252;


        //-----------------------CheckIn---------------------------------
        public static String CheckinLocation_api = webUrl + "CheckIn/CheckinLocation";
        //public static final int CheckinLocation_type = 300;

        public static String PostLocation_api = webUrl + "CheckIn/PostLocation";
        //public static final int PostLocation_type = 301;


        // for Google & Stripe
        public static String call_VerifyPayment = webUrl + "Pay/VerifyPayment";
        // for paypal
        public static String call_ChargePayment = webUrl + "Pay/ChargePayment";
        public static String call_GetAccessToken = webUrl + "pay/GetAccessToken";

        /*


        // GCM Register SNS
        //1051258820342
        public static String SENDER_ID = "1051258820342";

        // Stripe Configuration
        public static String STRIPE_PUBLISHABLE_KEY = "pk_test_8xGCqmogZ9SU2cASjc5RJ6Oq";
        // public static String STRIPE_API_KEY = "sk_test_4Dtv9Qs1VNNAy6ch2R1vFyPI";
    //	public static  String STRIPE_PUBLISHABLE_KEY = "pk_test_GSuF29JhfineTTLtcbtty45e";
    //	public static String  STRIPE_API_KEY = "sk_test_hi9zwmC5ccOuUohVSrPWC9ji";

        // paypal Configuration
        public static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;
        ///public static final String CONFIG_CLIENT_Secret = "EDIX5gKYz1d1yYcdw_8PJGHwDwNziDme7Y_mvbQ7Nf_AnW872p6MYLikbMorBEOWB6UcsBt4Z6qgMhtN";
        public static final String CONFIG_CLIENT_Secret = "EGiXsRU33ECRF3nk07-1I621hNNyXG1rkhlCLrCezGFv6W1dPiWy5wsaXW9YKU6bD-YjHbK4ekhGdESe";  //client new client_secret
        //public static final String CONFIG_CLIENT_ID = "AY07jDOI2iu9bdkWfE-7sWzQ1O8iDNzzTXV-arO1f3K_qgO0EoUsT91C5iTmwQQ-sX6md0xaVvb-WBbt";
        public static final String CONFIG_CLIENT_ID = "AXC7X5OwaWB8ZzB-fEqgZuRnd6z0aqbIffoA3f9QpjAHgos3eRYy1lCqndFvdgz5ND9WkybRhC-h6-AL"; //client new client_id
        public static final String CONFIG_RETURN_HOST = "demo.honeyshyam.com";//WebBrowser_Activity Line no : 56

        // Google Play payment Configuration
        // pollaccess@gmail.com access
        public static final String LICENSE_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkp2PVcMCcgdgB5BN4issV96vIQrJgrRoGpMoPk8A1IxjvMbknCfOiqinweL2bDgXsgRzX9vJe2cS+8JIAUZXg0V/gvlCrdi+svp4nw6L1IW+8y/xd6GBNaO66WpdDHniHr6zEBap2/swvH6EmwjKm9Y+pCXsbn8+CClkle9f7Iz0UbAGoDh5piowTIIK4Pp4GGxCRTNSBzTDuagnqgRAM7LJtllbpr8nyh8BQgguc4+2jPbO5EJP7znfHj1jZRIPHAaGQdgc0scKmnJPxrAS60HN9od3SZevAo8vW0CXJWfLT3pIraAr7HAXnSdqylHikdeGca5YPATr8Z3n9o0t0wIDAQAB";
        public static final String MERCHANT_ID = "03178884379567414245";//
    // kuhadiyadharmesh@gmail.com access
        //public static final String LICENSE_KEY ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmRgod29nUin3+91GVhDeIuWvNLiqfM/7CRpE/UijwVTFwSOdXhVXoTZ+2hHKfHX8gUEpyxFVdYhxXDYVO+u29Uy9/HodzHQ7LxyVeHavo/MjStbH0yJW2607urOpekqUq9cb/p1Ns74bW5yrtD+bz1OVZX3mganwAXCNryGdVxzip2NimCvn6SCHbc44mNSyJ4Y7xcBLZGa2K2Mlz9x1DaAbzfKUK9uEY1e10OQnqhr4q5syej31aqSg8UbCnuXi46fOj90AxfrwRWN6OQpiLOmVBvOwthPR8iOnRM1aaeyd5tx/Aa+x2J2IwhtSwEoWIkzRTMTvK05EGea5dFfsUQIDAQAB"; // PUT YOUR MERCHANT KEY HERE;
        // public static final String MERCHANT_ID = "12909099112937192994";//

        // hitesh6662@gmail.com access
    //    public static final String LICENSE_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsaHzW3eMVCS6zyO9gZoXjDKBYKSR7TzJ28XW+zZbAGBmM6XWgxOwDNi+6xOMpu/HBw41N9LXVzHRKrm7MTg8vHqFSsYX52tffcuJ1jPGuUgj65zRwkFh/VswjQphg4JIzR8Bwyeve+aB1ZQOVktuWTlRqZfnGmdkeuKIIuAB+BZttmVAD3BkfHa5q0mRI+mRcmoZpJlPpcUZuG6GQH8i8TWQvMLh5Qv6i8HDamnGlfygd84RNddHL6FTIEnkBqO2nMKvDAoTH1+gRqWRsXS4kAM8dH0UDXmbK+we6xYCJ5CqWWKkGVGF/QAMkDVXE6uE+R9TnL05o+kO2JG87G0rlwIDAQAB";
    //    public static final String MERCHANT_ID = "08369514835662437753";//

        // Error Code
        public static final String error = "ErrorCode";
        public static final String error_code = "16842757";
    }

    */
}
