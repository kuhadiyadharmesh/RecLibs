package lib.api.poll.com.mylibrary.model.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import lib.api.poll.com.mylibrary.model.Common.States;

/**
 * Created by Dharmesh-PC on 4/27/2018.
 */

public class GetCityByState_Response
{
    private int status = 0;
    private String message = "";
    private List<States> data = null;
    public GetCityByState_Response(String message)
    {
        this.message = message;
    }
    public GetCityByState_Response(JSONArray jsonArray)
    {
        //this.message = message;

        this.data = data ;

        try
        {
           // JSONArray jar = jsonArray.getJSONArray("items");
            //data = new ArrayList<>();
            States d ;
            for (int i=0 ; i<= jsonArray.length() ; i++)
            {
                JSONObject jo = jsonArray.getJSONObject(i);
                d = new States(jo.getInt("id"),jo.getString("stateName"));
                data.add(d);
            }
            this.status = 1;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            this.status = 0;
            this.message = "no data found .";
        }


    }

    public String getMessage(){return this.message;}
    public int getStatus(){return  this.status;}

    public List<States> getCountries()
    {
        return this.data;
    }

}
