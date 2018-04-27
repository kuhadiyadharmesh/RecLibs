package lib.api.poll.com.mylibrary.api;

import org.json.JSONArray;

import lib.api.poll.com.mylibrary.client.ApiInfo;
import lib.api.poll.com.mylibrary.client.PollApi;
//import lib.api.poll.com.mylibrary.model.Common.Countries;
import lib.api.poll.com.mylibrary.model.Common.HeaderCall;
import lib.api.poll.com.mylibrary.model.Common.States;
import lib.api.poll.com.mylibrary.model.Response.GetCityByState_Response;
//import lib.api.poll.com.mylibrary.model.Response.GetStateByCountry_Response;

/**
 * Created by Dharmesh-PC on 4/27/2018.
 */

public class GetCityByStatesCall
{
     /*
            {
          "id": 1,
          "name": "sample string 2"
        }
     */

    private States cdata ;
    private HeaderCall hdata ;
    private PollApi pollApi;

    public GetCityByStatesCall(States cdata, HeaderCall hdata)
    {
        pollApi = new PollApi();
        //this.data = data ;
        this.cdata = cdata;
        this.hdata = hdata;
    }


    public GetCityByState_Response GetCityByStates_Call()
    {
        //Validation for header
        if(hdata.getUserid().equals(""))
            return new GetCityByState_Response("Developer error header -> UserId id Empty.");
        if(hdata.getToken().equals(""))
            return new GetCityByState_Response("Developer error header -> Token is Empty.");
        //Validation
        //if(data.getUsername().equals(""))
        //  return new Common_Response("Please enter username." , 0);


        String param = "{\"id\":\""+cdata.getId()+"\",\"name\":\""+cdata.getStatename()+"\"}";

        JSONArray jobj = null;
        GetCityByState_Response response_data  = null;
        jobj =  pollApi.makeHTTPPOSTArray_SSL(ApiInfo.CitiesByState_api,param,hdata);//.makeHTTPPOSTLogin_SSL(ApiInfo.login_api, param);

        if(jobj == null)
        {
            response_data = new GetCityByState_Response("Something Wrong- api not responded.");
        }
        else
        {
            try
            {
                //if (jobj.getString("status").equals("ok"))
                //{
                response_data = new GetCityByState_Response(jobj);//new LoginResponse(jobj.getString("userName").toString(),jobj.getString("userId"),jobj.getString("emailAddress"),jobj.getString("token"),jobj.getString("secretAccessKey"));
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
                response_data = new GetCityByState_Response("Something Wrong- api not responded.- JSONException");
            }
        }
        return  response_data;
    }

}
