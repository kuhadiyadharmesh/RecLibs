package lib.api.poll.com.mylibrary.model.Common;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Dharmesh-PC on 4/26/2018.
 */

public class NewDevice
{
    /*
    "newDevice": {
    "deviceName": "sample string 2",
    "devicePlatform": "sample string 3",
    "deviceVersion": "sample string 4",
    "browserName": "sample string 5",
    "browserVersion": "sample string 6",
    "browserUserAgent": "sample string 7",
    "status": "sample string 9",
    "snsType": "sample string 10",
    "snsDeviceId": "sample string 1",
    "channelId": "sample string 2"
  },
     */
    private JSONObject jsonObject;

    public NewDevice(JSONObject jsonObject)
    {
        this.jsonObject = jsonObject;
    }

    public String getdeviceName() {return getStringValue("deviceName");}
    public String getdevicePlatform(){return getStringValue("devicePlatform");}
    public String getdeviceVersion(){return getStringValue("deviceVersion");}
    public String getbrowserName(){return getStringValue("browserName");}
    public String getbrowserVersion(){return getStringValue("browserVersion");}
    public String getbrowserUserAgent(){return getStringValue("browserUserAgent");}
    public String getstatus(){return getStringValue("status");}
    public String getsnsType(){return getStringValue("snsType");}
    public String getsnsDeviceId(){return  getStringValue("snsDeviceId");}
    public String getchannelId(){return getStringValue("channelId");}




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



}
