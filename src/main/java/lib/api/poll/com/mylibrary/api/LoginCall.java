package lib.api.poll.com.mylibrary.api;

//import com.poll.api.lib.client.PollApi;
//import com.poll.api.lib.model.Request.LoginData;
//import com.poll.api.lib.model.Response.LoginResponse;

import org.json.JSONException;
import org.json.JSONObject;

import lib.api.poll.com.mylibrary.client.ApiInfo;
import lib.api.poll.com.mylibrary.client.PollApi;
import lib.api.poll.com.mylibrary.model.Request.LoginData;
import lib.api.poll.com.mylibrary.model.Response.LoginResponse;


//import lib.poll.com.model.Request.Login;
//import lib.poll.com.service.Parse;

/**
 * Created by Dharmesh-PC on 4/18/2018.
 */

public class LoginCall //implements Response.Listener, Response.ErrorListener {
{

    /*
    String req = "{\"userName\": \""+user_name+"\",\n" +
            "  \"password\": \""+password+"\", \"newDevice\": {\n" +
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
    private LoginData data ;
    private PollApi pollApi;

    public LoginCall(LoginData data)
    {
        pollApi = new PollApi();
        this.data = data ;
    }
   // private Parse api ;

    //    public LoginCall(Login data , Parse api)
    //    {
    //        this.data = data ;
    //        this.api = api;
    //    }

    public LoginResponse LoginUser_Call()
    {
        //Validation
        if(data.getUserName().equals(""))
            return new LoginResponse("Please enter username.");
        if(data.getPassword().equals(""))
            return new LoginResponse("Please enter password.");
        if(data.getDeviceinfo().getDeviceName().equals(""))
            return new LoginResponse("Developer error Deviceinfo -> DeviceName forgot to add .");
        if(data.getDeviceinfo().getSnsDeviceId().equals(""))
            return new LoginResponse("Developer error Deviceinfo -> snsDeviceId forgot to add .");
        if(data.getDeviceinfo().getChannelId().equals(""))
            return new LoginResponse("Developer error Deviceinfo -> ChannelId forgot to add .");
        if(data.getDeviceinfo().getDeviceVersion().equals(""))
            return new LoginResponse("Developer error Deviceinfo -> DeviceVersion forgot to add .");
        if(data.getDeviceinfo().getSnsType().equals(""))
            return new LoginResponse("Developer error Deviceinfo -> SnsType forgot to add .");
        if(data.getDeviceId().equals(""))
            return new LoginResponse("Developer error  -> DeviceId forgot to add .");

        String param = "{\n" +
                "  \"deviceId\": \"" + data.getDeviceId() + "\",\n" +
                "  \"isPartner\": false,\n" +
                "  \"userName\": \"" + data.getUserName() + "\",\n" +
                "  \"password\": \"" + data.getPassword() + "\",\n" +
                "  \"newDevice\": {\n" +
                "    \"deviceVersion\": \"" + data.getDeviceinfo().getDeviceVersion() + "\",\n" +
                "    \"browserName\": \"\",\n" +
                "    \"browserVersion\": \"\",\n" +
                "    \"browserUserAgent\": \"mobile\",\n" +
                "    \"snsType\": \"GCM\",\n" +
                "    \"deviceName\": \"" + data.getDeviceinfo().getDeviceName() + "\",\n" +
                "    \"devicePlatform\": \"Android\",\n" +
                "    \"snsDeviceId\": \"" + data.getDeviceinfo().getSnsDeviceId() + "\",\n" +
                "    \"channelId\": \"" + data.getDeviceinfo().getChannelId() + "\"\n" +
                "  }\n" +
                "}";

        JSONObject jobj = null;
        LoginResponse response_data  = null;
        jobj =  pollApi.makeHTTPPOSTLogin_SSL(ApiInfo.login_api, param);

        if(jobj == null)
        {
            response_data = new LoginResponse("Something Wrong- api not responded.");
        }
        else
        {
            try
            {
                if (jobj.has("userId"))//(jobj.getString("status").equals("ok"))
                { //(String username , String userid , String emailaddress , String token , String secretAccesskey)
                    response_data = new LoginResponse(jobj.getString("userName").toString(),jobj.getString("userId"),jobj.getString("emailAddress"),jobj.getString("token"),jobj.getString("secretAccessKey"));//(true,jobj.getString("msg"));
                    return response_data;
                }
                else
                {
                    response_data = new LoginResponse(jobj.getString("AdditionalInformation"));
                    return  response_data;
                }
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
        return  response_data;
    }

}
