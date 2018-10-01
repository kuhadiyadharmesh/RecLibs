package lib.api.poll.com.api;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import lib.api.poll.com.ApiClient;
import lib.api.poll.com.RecordingApi;
import lib.api.poll.com.model.Setting.UpdateUser;
import lib.api.poll.com.model.Setting.UpdateUser_Response;

/**
 * Created by Dharmesh-PC on 1/13/2018.
 */

public class UpdateUserAPI
{
    private UpdateUser data ;
    private RecordingApi recordingApi;
    public UpdateUserAPI(UpdateUser data)
    {
        this.data = data ;
        recordingApi = new RecordingApi();
    }
    public UpdateUser_Response UpdateUserCall()
    {
        //Validation
        if(data.getApi_key().equals(""))
            return new UpdateUser_Response("Please set ApiKey");
        if(data.getApp().equals(""))
            return new UpdateUser_Response("Please set is free or paid");

        // Set parameter
        ArrayList<NameValuePair> param = new  ArrayList<NameValuePair>();
        param.add(new BasicNameValuePair("api_key",data.getApi_key()));
        param.add(new BasicNameValuePair("app",data.getApp()));


        JSONObject jobj = null ;
        jobj = recordingApi.makeHttpRequestFor_SSL(ApiClient.BasePath+"update_user","POST",param);
        UpdateUser_Response response_data  = null;

        if(jobj == null)
        {
            response_data = new UpdateUser_Response("Something Wrong");
        }
        else
        {
            try
            {
                if (jobj.getString("status").equals("ok"))
                {
                    response_data = new UpdateUser_Response(true,jobj.getString("msg"));
                    return response_data;
                }
                else
                {
                    response_data = new UpdateUser_Response(jobj.getString("msg"));
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
