package lib.api.poll.com.api;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import lib.api.poll.com.ApiClient;
import lib.api.poll.com.RecordingApi;
import lib.api.poll.com.model.Common.Settings;
import lib.api.poll.com.model.Setting.GetSetting;
import lib.api.poll.com.model.Setting.GetSetting_Response;

/**
 * Created by Dharmesh-PC on 1/12/2018.
 */

public class GetSettingAPI
{
    private GetSetting data ;
    private RecordingApi recordingApi;

    public GetSettingAPI(GetSetting data)
    {
        this.data = data ;
        recordingApi = new RecordingApi();
    }

    public GetSetting_Response GetSettingCall()
    {
        //Validation
        if(data.getApi_key().equals(""))
            return new GetSetting_Response("Please set ApiKey");
//        if(data.getFile().equals(""))
//            return new UpdateProfilePicure_Response("Please select file");

        // Set parameter
        ArrayList<NameValuePair> param = new  ArrayList<NameValuePair>();
        //param.add(new BasicNameValuePair("file",data.getFile()));
        param.add(new BasicNameValuePair("api_key",data.getApi_key()));
        //param.add(new BasicNameValuePair("data",data.getData()));

        JSONObject jobj = null ;
        jobj = recordingApi.makeHttpRequestFor_SSL(ApiClient.BasePath+"get_settings","POST",param);
        GetSetting_Response response_data  = null;

        if(jobj == null)
        {
            response_data = new GetSetting_Response("Something Wrong");
        }
        else
        {
            try
            {
                if (jobj.getString("status").equals("ok"))
                {
                    Settings settings = new Settings(jobj.getJSONObject("settings").getString("play_beep"),jobj.getJSONObject("settings").getString("files_permission"));
                    response_data = new GetSetting_Response(jobj.getString("app"),jobj.getString("credits"),"Get Setting Successfully",settings);
                    return response_data;
                }
                else
                {
                    response_data = new GetSetting_Response(jobj.getString("msg"));
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


