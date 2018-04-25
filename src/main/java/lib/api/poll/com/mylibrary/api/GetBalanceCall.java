package lib.api.poll.com.mylibrary.api;

import org.json.JSONException;
import org.json.JSONObject;

import lib.api.poll.com.mylibrary.client.ApiInfo;
import lib.api.poll.com.mylibrary.client.PollApi;
import lib.api.poll.com.mylibrary.model.Request.HeaderCall;
import lib.api.poll.com.mylibrary.model.Response.GetBalanceResponse;

/**
 * Created by Dharmesh-PC on 4/25/2018.
 */

public class GetBalanceCall
{
    private HeaderCall hdata ;
    private PollApi pollApi;

    public GetBalanceCall( HeaderCall hdata)
    {
        pollApi = new PollApi();
        //this.data = data ;
        this.hdata = hdata;
    }


    public GetBalanceResponse GetBalanceCall()
    {
        //Validation for header
        if(hdata.getUserid().equals(""))
            return new GetBalanceResponse("Developer error header -> UserId id Empty.");
        if(hdata.getToken().equals(""))
            return new GetBalanceResponse("Developer error header -> Token is Empty.");
        //Validation
//        if(data.getUsername().equals(""))
//            return new Common_Response("Please enter username." , 0);


        String param = "";

        JSONObject jobj = null;
        GetBalanceResponse response_data  = null;
        jobj =  pollApi.makeHTTPPOST_SSL(ApiInfo.LogOut_api,param,hdata);//.makeHTTPPOSTLogin_SSL(ApiInfo.login_api, param);

        if(jobj == null)
        {
            response_data = new GetBalanceResponse("Something Wrong- api not responded.");
        }
        else
        {
            try
            {
                if (jobj.has("userId"))
                {
                    response_data = new GetBalanceResponse(jobj.getString("balanceAmount"),jobj.getString("creditBalance"),jobj.getString("pollsBalance"));//new LoginResponse(jobj.getString("userName").toString(),jobj.getString("userId"),jobj.getString("emailAddress"),jobj.getString("token"),jobj.getString("secretAccessKey"));
                    return response_data;
                }
                else
                {//statusMessage
                    response_data = new GetBalanceResponse(jobj.getString("statusMessage"));
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
