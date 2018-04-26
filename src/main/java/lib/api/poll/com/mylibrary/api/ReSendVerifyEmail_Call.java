package lib.api.poll.com.mylibrary.api;

import org.json.JSONException;
import org.json.JSONObject;

import lib.api.poll.com.mylibrary.client.ApiInfo;
import lib.api.poll.com.mylibrary.client.PollApi;
import lib.api.poll.com.mylibrary.model.Common.HeaderCall;

import lib.api.poll.com.mylibrary.model.Request.ReSendVerifyEmailData;

import lib.api.poll.com.mylibrary.model.Response.ReSendVerifyEmailResponse;

/**
 * Created by Dharmesh-PC on 4/25/2018.
 */

public class ReSendVerifyEmail_Call
{


    private ReSendVerifyEmailData data ; //ReSendVerifyEmailData
    private HeaderCall hdata ;
    private PollApi pollApi;

    public ReSendVerifyEmail_Call(ReSendVerifyEmailData data, HeaderCall hdata)
    {
        pollApi = new PollApi();
        this.data = data ;
        this.hdata = hdata;
    }


    public ReSendVerifyEmailResponse MakeCall_Call()
    {
        //Validation for header
        if(hdata.getUserid().equals(""))
            return new ReSendVerifyEmailResponse("Developer error header -> UserId id Empty.",0);
        if(hdata.getToken().equals(""))
            return new ReSendVerifyEmailResponse("Developer error header -> Token is Empty.",0);
        //Validation
        if(data.getEmailAddress().equals(""))
            return new ReSendVerifyEmailResponse("Please enter EmailAddress." , 0);


        String param = "{\n" +
                "  \"emailAddress\": \"" + data.getEmailAddress() + "}";

        JSONObject jobj = null;
        ReSendVerifyEmailResponse response_data  = null;
        jobj =  pollApi.makeHTTPPOST_SSL(ApiInfo.ReSendVerifyEmail_api,param,hdata);//.makeHTTPPOSTLogin_SSL(ApiInfo.login_api, param);

        if(jobj == null)
        {
            response_data = new ReSendVerifyEmailResponse("Something Wrong- api not responded.",0);
        }
        else
        {
            try
            {
                if (jobj.getString("status").equals("ok"))
                {
                    response_data = new ReSendVerifyEmailResponse("Thanks , making call Please wait .",1);//new LoginResponse(jobj.getString("userName").toString(),jobj.getString("userId"),jobj.getString("emailAddress"),jobj.getString("token"),jobj.getString("secretAccessKey"));
                    return response_data;
                }
                else
                {//statusMessage
                    response_data = new ReSendVerifyEmailResponse(jobj.getString("statusMessage"),0);
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
