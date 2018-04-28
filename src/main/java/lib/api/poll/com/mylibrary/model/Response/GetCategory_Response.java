package lib.api.poll.com.mylibrary.model.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import lib.api.poll.com.mylibrary.model.Common.Category;
import lib.api.poll.com.mylibrary.model.Common.States;

/**
 * Created by Dharmesh-PC on 4/27/2018.
 */

public class GetCategory_Response
{
    private int status = 0;
    private String message = "";
    private List<Category> data = null;
    public GetCategory_Response(String message)
    {
        this.message = message;
    }
    public GetCategory_Response(JSONArray jsonArray)
    {
        //this.message = message;

        this.data = data ;

        try
        {
           // JSONArray jar = jsonArray.getJSONArray("items");
            //data = new ArrayList<>();
            Category d ;
            for (int i=0 ; i<= jsonArray.length() ; i++)
            {
                JSONObject jo = jsonArray.getJSONObject(i);
                d = new Category(jo.getInt("catId"),jo.getString("catName"));
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

    public List<Category> getCountries()
    {
        return this.data;
    }

}
