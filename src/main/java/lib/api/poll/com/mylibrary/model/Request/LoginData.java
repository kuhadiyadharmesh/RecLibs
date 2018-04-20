package lib.api.poll.com.mylibrary.model.Request;

/**
 * Created by Dharmesh-PC on 4/17/2018.
 */

public class LoginData
{
    /*
    String req = "{\"userName\": \""+user_name+"\",\n" +
            "  \"password\": \""+password+"\",
            \"newDevice\": {\n" +
            "    \"deviceVersion\": \"galaxy\",\n" +
            "    \"browserName\": \"mobile\",\n" +
            "    \"browserVersion\": \"1.0\",\n" +
            "    \"browserUserAgent\": \"mobile\",\n" +
            "    \"snsType\": \"GCM\",\n" +
            "    \"deviceName\": \"Android\",\n" +
            "    \"devicePlatform\": \"Android\",\n" +
            "    \"snsDeviceId\": \""+snsToken+"\",\n" +
            "    \"channelId\": \""+imei+"\"\n" +
            "  }}";*/
  private  String userName , password ,deviceId  ;
  private  Deviceinfo deviceinfo;

    public LoginData(String userName , String password , String deviceId  ,Deviceinfo deviceinfo)
    {
        this.userName = userName;
        this.password = password;
        this.deviceinfo = deviceinfo;
        this.deviceId = deviceId;
    }

    public String getUserName()
    {
        return  userName;
    }
    public String getDeviceId()
    {
        return  deviceId;
    }
    public String getPassword()
    {
        return  password;
    }


    public Deviceinfo getDeviceinfo()
    {
        return  deviceinfo;
    }






}
