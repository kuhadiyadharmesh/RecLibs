package lib.api.poll.com.mylibrary.model.Request;

/**
 * Created by Dharmesh-PC on 4/19/2018.
 */

public class Deviceinfo
{

//   private String  deviceVersion ,browserName , browserVersion , browserUserAgent, snsType , deviceName , devicePlatform , snsDeviceId ,channelId;
   private String  deviceId ,deviceVersion , snsType , deviceName ,  snsDeviceId ,channelId;
   // public Deviceinfo(String deviceVersion , String browserName , String browserVersion,String browserUserAgent,String snsType , String deviceName , String devicePlatform , String snsDeviceId, String channelId)
    public Deviceinfo(String deviceVersion ,String snsType , String deviceName ,  String snsDeviceId, String channelId)
    {
        this.deviceVersion = deviceVersion;
        this.deviceId = deviceId;
        //this.browserName = browserName ;
        //this.browserVersion = browserVersion;
        //this.browserUserAgent = browserUserAgent ;
        this.snsType = snsType;
        this.deviceName = deviceName;
       // this.devicePlatform = devicePlatform;
        this.snsDeviceId = snsDeviceId;
        this.channelId = channelId;
    }
    /*
    "    \"deviceVersion\": \"galaxy\",\n" +
            "    \"browserName\": \"mobile\",\n" +
            "    \"browserVersion\": \"1.0\",\n" +
            "    \"browserUserAgent\": \"mobile\",\n" +
            "    \"snsType\": \"GCM\",\n" +
            "    \"deviceName\": \"Android\",\n" +
            "    \"devicePlatform\": \"Android\",\n" +
            "    \"snsDeviceId\": \""+snsToken+"\",\n" +
            "    \"channelId\": \""+imei+"\"\n" +
            "  }
    */

    public String getDeviceVersion()
    {
        return  this.deviceVersion;
    }
   /* public String getBrowserName()
    {
        return this.browserName;
    }
    public String getBrowserVersion()
    {
        return this.browserVersion;
    }
    public String getBrowserUserAgent()
    {
        return  this.browserUserAgent;
    }*/
    public String getSnsType()
    {
        return this.snsType;
    }
    public String getDeviceId()
    {
        return this.deviceId;
    }
    public String getSnsDeviceId()
    {
        return  this.snsDeviceId;
    }
    public String getChannelId()
    {
        return this.channelId;
    }
    public String getDeviceName() {return  this.deviceName;}

}
