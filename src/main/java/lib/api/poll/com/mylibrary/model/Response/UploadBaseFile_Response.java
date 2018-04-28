package lib.api.poll.com.mylibrary.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Dharmesh-PC on 4/28/2018.
 */

public class UploadBaseFile_Response
{
    /*
    {
  "id": "b25c3fdd-2397-45ca-962f-7d695b8f163d",
  "fileID": 3,
  "contentType": "sample string 4",
  "url": "sample string 5",
  "fileName": "sample string 6",
  "fileDeleted": true,
  "lastUpdate": "2018-04-27T22:19:08.4360631-07:00"
}
     */

    private JSONObject jsonObject;

    private int status = 0;

    private String message ="" ;

    public UploadBaseFile_Response(JSONObject jsonObject)
    {
        this.jsonObject = jsonObject;
        this.status = 1;
    }
    public UploadBaseFile_Response(String message)
    {
        this.message = message;
    }

    public String getId(){return getStringValue("id");}
    public String getFileId() {return  getStringValue("fileID");}
    public String getContestType(){return getStringValue("contentType");}
    public String geturl(){return getStringValue("url");}
    public String getfileName(){return getStringValue("fileName");}
   // public String get

    private String getStringValue(String key)
    {
        try
        {
            return  this.jsonObject.getString(key);
        }
        catch (JSONException e)
        {
            return null;
        }

    }
/*
    private boolean getBooleanValue(String key)
    {
        try
        {
            return  this.jsonObject.getBoolean(key);
        }
        catch (JSONException e)
        {
            return false;
        }
    }

    private int getIntValue(String key)
    {
        try
        {
            return  this.jsonObject.getInt(key);
        }
        catch (JSONException e)
        {
            return -1;
        }
    }
*/
}
