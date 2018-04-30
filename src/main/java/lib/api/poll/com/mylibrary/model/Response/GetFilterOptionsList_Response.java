package lib.api.poll.com.mylibrary.model.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//import lib.api.poll.com.mylibrary.api.GetFilterOptionsListCall;
//import lib.api.poll.com.mylibrary.model.Common.Countries;
import lib.api.poll.com.mylibrary.model.Common.FilterOptions;

/**
 * Created by Dharmesh-PC on 4/30/2018.
 */

public class GetFilterOptionsList_Response
{
    private List<FilterOptions> fdata ;
    private int status = 0;
    private String message ="";


    public GetFilterOptionsList_Response(String message)
    {
        this.message = message;
    }

    public GetFilterOptionsList_Response(JSONArray jsonObject)
    {
        try
        {
            //JSONArray jar = jsonObject.getJSONArray("item");
            fdata = new ArrayList<>();
            FilterOptions d ;
            for (int i=0 ; i<= jsonObject.length() ; i++)
            {
                JSONObject jo = jsonObject.getJSONObject(i);
                d = new FilterOptions(jo.getInt("id"),jo.getString("filterName"),jo.getBoolean("showGraph"),jo.getBoolean("showFilter"));
                fdata.add(d);
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

    public List<FilterOptions> getFdata()
    {
        return this.fdata;
    }
}
