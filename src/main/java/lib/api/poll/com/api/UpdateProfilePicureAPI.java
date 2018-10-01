package lib.api.poll.com.api;



import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import lib.api.poll.com.ApiClient;
import lib.api.poll.com.RecordingApi;
import lib.api.poll.com.model.Setting.UpdateProfilePicture;
import lib.api.poll.com.model.Setting.UpdateProfilePicure_Response;

/**
 * Created by Dharmesh-PC on 1/12/2018.
 */

public class UpdateProfilePicureAPI
{
    private UpdateProfilePicture data ;
    private RecordingApi recordingApi;

    public UpdateProfilePicureAPI(UpdateProfilePicture data)
    {
        this.data = data ;
        recordingApi = new RecordingApi();
    }

    public UpdateProfilePicure_Response UpdateProfilePicureCall()
    {
        //Validation
        if(data.getApi_key().equals(""))
            return new UpdateProfilePicure_Response("Please set ApiKey");
        if(data.getFile().equals(""))
            return new UpdateProfilePicure_Response("Please select file");

        // Set parameter
        ArrayList<NameValuePair> param = new  ArrayList<NameValuePair>();
        param.add(new BasicNameValuePair("file",data.getFile()));
        param.add(new BasicNameValuePair("api_key",data.getApi_key()));
        //param.add(new BasicNameValuePair("data",data.getData()));

        JSONObject jobj = null ;
        jobj = recordingApi.makeHttpRequestFor_SSL(ApiClient.Profile_Img_Path,"POST",param);
        UpdateProfilePicure_Response response_data  = null;

        if(jobj == null)
        {
            response_data = new UpdateProfilePicure_Response("Something Wrong");
        }
        else
        {
            try
            {
                if (jobj.getString("status").equals("ok"))
                {
                    response_data = new UpdateProfilePicure_Response(jobj.getString("msg"),jobj.getString("file"));
                    return response_data;
                }
                else
                {
                    response_data = new UpdateProfilePicure_Response(jobj.getString("msg"));
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
