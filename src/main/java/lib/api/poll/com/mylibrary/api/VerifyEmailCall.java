package lib.api.poll.com.mylibrary.api;

import org.json.JSONException;
import org.json.JSONObject;

import lib.api.poll.com.mylibrary.client.ApiInfo;
import lib.api.poll.com.mylibrary.client.PollApi;
import lib.api.poll.com.mylibrary.model.Request.HeaderCall;
import lib.api.poll.com.mylibrary.model.Request.VerifyEmailData;
import lib.api.poll.com.mylibrary.model.Response.Common_Response;

/**
 * Created by Dharmesh-PC on 4/25/2018.
 */

public class VerifyEmailCall
{
    private VerifyEmailData data ;
    private HeaderCall hdata ;
    private PollApi pollApi;

    public VerifyEmailCall(VerifyEmailData data, HeaderCall hdata)
    {
        pollApi = new PollApi();
        this.data = data ;
        this.hdata = hdata;
    }


    public Common_Response MakeCall_Call()
    {
        //Validation for header
        if(hdata.getUserid().equals(""))
            return new Common_Response("Developer error header -> UserId id Empty.",0);
        if(hdata.getToken().equals(""))
            return new Common_Response("Developer error header -> Token is Empty.",0);
        //Validation
        if(data.getId().equals(""))
            return new Common_Response("Developer error ID -> ID is Empty." , 0);


        String param = "{\n" +
                "  \"id\": \"" + data.getId() + "}";

        JSONObject jobj = null;
        Common_Response response_data  = null;
        jobj =  pollApi.makeHTTPPOST_SSL(ApiInfo.VerifyEmail_api,param,hdata);//.makeHTTPPOSTLogin_SSL(ApiInfo.login_api, param);

        if(jobj == null)
        {
            response_data = new Common_Response("Something Wrong- api not responded.",0);
        }
        else
        {
            try
            {
                if (jobj.getString("status").equals("ok"))
                {
                    response_data = new Common_Response("Thanks , making call Please wait .",1);//new LoginResponse(jobj.getString("userName").toString(),jobj.getString("userId"),jobj.getString("emailAddress"),jobj.getString("token"),jobj.getString("secretAccessKey"));
                    return response_data;
                }
                else
                {//statusMessage
                    response_data = new Common_Response(jobj.getString("statusMessage"),0);
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
