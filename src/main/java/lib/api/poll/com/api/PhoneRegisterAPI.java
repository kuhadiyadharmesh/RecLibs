package lib.api.poll.com.api;

import android.util.Log;



import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import lib.api.poll.com.ApiClient;
import lib.api.poll.com.RecordingApi;
import lib.api.poll.com.model.RegisterPhone;
import lib.api.poll.com.model.RegisterPhone_Response;

/**
 * Created by Dharmesh-PC on 1/9/2018.
 */

public class PhoneRegisterAPI
{
    public RegisterPhone data ;
    private RecordingApi recordingApi;

    public PhoneRegisterAPI(RegisterPhone data)
    {
        this.data= data;
        recordingApi = new RecordingApi();
    }

    public RegisterPhone_Response RegisterPhoneCall()
    {
        Log.e("new method called","new called");

        if (data.getPhonenumber()=="")
            return new RegisterPhone_Response("please enter phonenumber");
        if(data.getToken().equals(""))
            return new RegisterPhone_Response("please enter valid token");

        ArrayList<NameValuePair> param = new  ArrayList<NameValuePair>();
        param.add(new BasicNameValuePair("phone", data.getPhonenumber()));
        param.add(new BasicNameValuePair("token", data.getToken()));



       // String call_response = "";//CallService();

        JSONObject jobj = null;
        RegisterPhone_Response response_data  = new RegisterPhone_Response();

        jobj =  recordingApi.makeHttpRequestFor_SSL(ApiClient.BasePath+"register_phone","POST",param);
        if(jobj == null)
        {
            response_data = new RegisterPhone_Response("Something wrong ");
        }
        else
        {try
        {if (jobj.getString("status").equals("ok"))
        {response_data.setStatus(true);
            response_data.setMsg(jobj.getString("msg"));
            response_data.setPhone(jobj.getString("phone"));

            return response_data;
        }
        else
        {
            response_data.setStatus(false);
            response_data.setMsg(jobj.getString("msg"));
            return  response_data;
        }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        }
        return  response_data;
    }
}
