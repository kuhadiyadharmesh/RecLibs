package lib.api.poll.com.mylibrary.api;

import org.json.JSONException;
import org.json.JSONObject;

import lib.api.poll.com.mylibrary.client.ApiInfo;
import lib.api.poll.com.mylibrary.client.PollApi;
import lib.api.poll.com.mylibrary.model.Common.HeaderCall;

import lib.api.poll.com.mylibrary.model.Response.ViewProfileResponse;

/**
 * Created by Dharmesh-PC on 4/25/2018.
 */

public class ViewProfileCall
{
    //private MakeCallData data ;
    private HeaderCall hdata ;
    private PollApi pollApi;

    public ViewProfileCall(HeaderCall hdata)
    {
        pollApi = new PollApi();
        //this.data = data ;
        this.hdata = hdata;
    }


    public ViewProfileResponse ViewProfile_Call()
    {
        //Validation for header
        if(hdata.getUserid().equals(""))
            return new ViewProfileResponse("Developer error header -> UserId id Empty.");
        if(hdata.getToken().equals(""))
            return new ViewProfileResponse("Developer error header -> Token is Empty.");
        //Validation
        //if(data.getUsername().equals(""))
          //  return new Common_Response("Please enter username." , 0);


        String param = "";

        JSONObject jobj = null;
        ViewProfileResponse response_data  = null;
        jobj =  pollApi.makeHTTPPOST_SSL(ApiInfo.ViewProfile_api,param,hdata);//.makeHTTPPOSTLogin_SSL(ApiInfo.login_api, param);

        if(jobj == null)
        {
            response_data = new ViewProfileResponse("Something Wrong- api not responded.");
        }
        else
        {
            try
            {
                if (jobj.getString("status").equals("ok"))
                {
                    response_data = new ViewProfileResponse(jobj);//new LoginResponse(jobj.getString("userName").toString(),jobj.getString("userId"),jobj.getString("emailAddress"),jobj.getString("token"),jobj.getString("secretAccessKey"));
                    return response_data;
                }
                else
                {//statusMessage
                    response_data = new ViewProfileResponse(jobj.getString("statusMessage"));
                    return  response_data;
                }
            }
            catch (JSONException e)
            {
                e.printStackTrace();
                response_data = new ViewProfileResponse("Something Wrong- api not responded.- JSONException");
            }
        }
        return  response_data;
    }
}
