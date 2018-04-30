package lib.api.poll.com.mylibrary.api;

import org.json.JSONArray;
import org.json.JSONObject;

import lib.api.poll.com.mylibrary.client.ApiInfo;
import lib.api.poll.com.mylibrary.client.PollApi;
import lib.api.poll.com.mylibrary.model.Common.Countries;
import lib.api.poll.com.mylibrary.model.Common.HeaderCall;
import lib.api.poll.com.mylibrary.model.Request.GetEmployeeFilterCountData;
import lib.api.poll.com.mylibrary.model.Response.Common_Response;
import lib.api.poll.com.mylibrary.model.Response.GetStateByCountry_Response;

/**
 * Created by Dharmesh-PC on 4/30/2018.
 */

public class GetEmployeeFilterCountCall
{
    private GetEmployeeFilterCountData cdata ;
    private HeaderCall hdata ;
    private PollApi pollApi;

    public GetEmployeeFilterCountCall(GetEmployeeFilterCountData cdata,HeaderCall hdata)
    {
        pollApi = new PollApi();
        //this.data = data ;
        this.cdata = cdata;
        this.hdata = hdata;
    }


    public Common_Response GetEmployeeFilterCount_Call()
    {
        //Validation for header
        if(hdata.getUserid().equals(""))
            return new Common_Response("Developer error header -> UserId id Empty.",0);
        if(hdata.getToken().equals(""))
            return new Common_Response("Developer error header -> Token is Empty.",0);
        //Validation
        //if(data.getUsername().equals(""))
        //  return new Common_Response("Please enter username." , 0);


        String param = "{" +
                "  \"filterNameValue\": " + cdata.getFilterPairs() + "," +
                "  \"orgId\": \"" + cdata.getOrgId() + "\"" +
                "}";

        JSONObject jobj = null;
        Common_Response response_data  = null;
        jobj =  pollApi.makeHTTPPOST_SSL(ApiInfo.GetEmployeeFilterCount_api,param,hdata);//.makeHTTPPOSTLogin_SSL(ApiInfo.login_api, param);

        if(jobj == null)
        {
            response_data = new Common_Response("Something Wrong- api not responded.",0);
        }
        else
        {
            try
            {
                //if (jobj.getString("status").equals("ok"))
                //{
                response_data = new Common_Response(jobj.getString("statusMessage"),1);//new LoginResponse(jobj.getString("userName").toString(),jobj.getString("userId"),jobj.getString("emailAddress"),jobj.getString("token"),jobj.getString("secretAccessKey"));
                return response_data;
                // }
                //else
                // {//statusMessage
                //     response_data = new GetCountries_Response(jobj.getString("statusMessage"));
                //     return  response_data;
                // }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                response_data = new Common_Response("Something Wrong- api not responded.- JSONException",0);
            }
        }
        return  response_data;
    }
}
