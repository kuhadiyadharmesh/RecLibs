package lib.api.poll.com.mylibrary.model.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import lib.api.poll.com.mylibrary.model.Common.FilterPairs;

/**
 * Created by Dharmesh-PC on 4/30/2018.
 */

public class GetEmployeeFilterCountData
{
    private String orgId ;
    private List<FilterPairs> fdata;

   // private JSONArray jsonArray;


    public GetEmployeeFilterCountData(String orgId ,List<FilterPairs> fdata)
    {
        this.orgId = orgId;
        this.fdata =fdata;
    }

    public String getOrgId() {return  this.orgId;}
    public JSONArray getFilterPairs()
    {
        JSONArray ja = new JSONArray();
        for (int i = 0; i < fdata.size(); i++) {
            JSONObject jo = new JSONObject();
            try {
                jo.put("filterName", fdata.get(i).getFilterName());
                jo.put("filterValue", fdata.get(i).getFilterValue().toString());

                ja.put(jo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ja;
    }


    /*
    {
            Prg_dialog(true);

            filterlist = new ArrayList<>();
            if (fpair_1.getFilterName() != null)
                filterlist.add(fpair_1);
            if (fpair_2.getFilterName() != null)
                filterlist.add(fpair_2);
            if (fpair_3.getFilterName() != null)
                filterlist.add(fpair_3);

            JSONArray ja = new JSONArray();
            for (int i = 0; i < filterlist.size(); i++) {
                JSONObject jo = new JSONObject();
                try {
                    jo.put("filterName", filterlist.get(i).getFilterName().toString());
                    jo.put("filterValue", filterlist.get(i).getFilterValue().toString());

                    ja.put(jo);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            String param = "{" +
                    "  \"filterNameValue\": " + ja + "," +
                    "  \"orgId\": \"" + sp_db.getString(Constant.lib_uuid) + "\"" +
                    "}";
            Log.e("ser", "vice Request: " + param);
            new Parse(uiHandler, this).handleRequest(Constant.GetFilterDataCount_type, param, "POST");
        }
     */
}
