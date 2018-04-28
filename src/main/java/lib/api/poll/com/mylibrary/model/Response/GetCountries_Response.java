package lib.api.poll.com.mylibrary.model.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import lib.api.poll.com.mylibrary.model.Common.Countries;

/**
 * Created by Dharmesh-PC on 4/27/2018.
 */

public class GetCountries_Response
{
    private int status = 0;
    private String message = "";
    private List<Countries> data = null;
    public GetCountries_Response(String message)
    {
        this.message = message;
    }
    public GetCountries_Response(JSONObject jsonObject)
    {
        //this.message = message;

        this.data = data ;

        try
        {
            JSONArray jar = jsonObject.getJSONArray("item");
            data = new ArrayList<>();
            Countries d ;
            for (int i=0 ; i<= jar.length() ; i++)
            {
                JSONObject jo = jar.getJSONObject(i);
                d = new Countries(jo.getInt("id"),jo.getString("countryName"),jo.getString("phoneCode"));
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

    public List<Countries> getCountries()
    {
        return this.data;
    }

}
