package lib.api.poll.com.mylibrary.api;

import org.json.JSONException;
import org.json.JSONObject;

import lib.api.poll.com.mylibrary.client.ApiInfo;
import lib.api.poll.com.mylibrary.client.PollApi;
import lib.api.poll.com.mylibrary.model.Request.LoginData;
import lib.api.poll.com.mylibrary.model.Request.LoginSocialData;
import lib.api.poll.com.mylibrary.model.Response.LoginResponse;

/**
 * Created by Dharmesh-PC on 4/23/2018.
 */

public class LoginSocialCall
{
    /*

    PostAuth_api

    String param = "{" +
                    "  \"deviceId\": \"" + sp_db.getString(Constant.lib_uuid) + "\",\n" +
                    "  \"appId\": \"" + sa_App_id + "\",\n" +
                    "  \"provider\": " + sa_social_provider + ",\n" +
                    "  \"id\": \"" + sa_Id + "\",\n" +
                    "  \"userName\": \"" + sa_user_name + "\",\n" +
                    "  \"email\": \"" + sa_email_id + "\",\n" +
                    "  \"phoneNumber\": \"" + sa_phone_num + "\",\n" +
                    "  \"verifiedEmail\": false,\n" +
                    "  \"name\": \"" + sa_name + "\",\n" +
                    "  \"givenName\": \"" + sa_name + "\",\n" +
                    "  \"familyName\": \"" + sa_name + "\",\n" +
                    "  \"accessToken\": \"" + sa_accessToken + "\",\n" +
                    "  \"gender\": \"" + sa_gender + "\",\n" +
                    "  \"newDevice\": {\n" +
                    "    \"deviceName\": \"" + Device_name + "\",\n" +
                    "    \"devicePlatform\": \"Android\",\n" +
                    "    \"deviceVersion\": \"" + Device_version + "\",\n" +
                    "    \"browserName\": \"\",\n" +
                    "    \"browserVersion\": \"\",\n" +
                    "    \"browserUserAgent\": \"mobile\",\n" +
                    "    \"status\": \"sample string 9\",\n" +
                    "    \"snsType\": \"GCM\",\n" +
                    "    \"snsDeviceId\": \"" + regid + "\",\n" +
                    "    \"channelId\": \"" + sp_db.getString(Constant.lib_uuid) + "\"\n" +
                    "  }\n" +
                    "}";

                    SocialExtraDailog(response.getBoolean("usernameRequired"), response.getBoolean("emailRequired"), response.getBoolean("phoneNumberRequired"));
    */

    private LoginSocialData data ;
    private PollApi pollApi;

    public LoginSocialCall(LoginSocialData data)
    {
        pollApi = new PollApi();
        this.data = data ;
    }


    public LoginResponse LoginUser_Call()
    {
        //Validation
        if(data.getUserName().equals(""))
            return new LoginResponse("Please enter username.");
        if(data.getAppid().equals(""))
            return new LoginResponse("Developer error Social -> Appid forgot to set.");
        if(data.getProvider().equals(""))
            return new LoginResponse("Developer error Social Provider-> Proivider forgot to set.");
        if(data.getId().equals(""))
            return new LoginResponse("Developer error Social ID-> Id forgot to set.");
        if(data.getAccessToken().equals(""))
            return new LoginResponse("Developer error Social AccessToken-> AccessToken forgot to set.");
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

        String param = "{" +
                "  \"deviceId\": \"" + data.getDeviceId() + "\",\n" +
                "  \"appId\": \"" + data.getAppid() + "\",\n" +
                "  \"provider\": " + data.getProvider() + ",\n" +
                "  \"id\": \"" + data.getId() + "\",\n" +
                "  \"userName\": \"" + data.getUserName() + "\",\n" +
                "  \"email\": \"" + data.getEmail() + "\",\n" +
                "  \"phoneNumber\": \"" + data.getPhoneNumber() + "\",\n" +
                "  \"verifiedEmail\": false,\n" +
                "  \"name\": \"" + data.getName() + "\",\n" +
                "  \"givenName\": \"" + data.getGivenName() + "\",\n" +
                "  \"familyName\": \"" + data.getFamilyName() + "\",\n" +
                "  \"accessToken\": \"" + data.getAccessToken() + "\",\n" +
                "  \"gender\": \"" + data.getGender() + "\",\n" +
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
        jobj =  pollApi.makeHTTPPOSTLogin_SSL(ApiInfo.PostAuth_api, param);

        if(jobj == null)
        {
            response_data = new LoginResponse("Something Wrong- api not responded.");
        }
        else
        {
            try
            {
                if (jobj.has("userId"))
                {
                    response_data = new LoginResponse(jobj.getString("userName").toString(),jobj.getString("userId"),jobj.getString("emailAddress"),jobj.getString("token"),jobj.getString("secretAccessKey"));
                    return response_data;
                }
                else
                {
                    //SocialExtraDailog(response.getBoolean("usernameRequired"), response.getBoolean("emailRequired"), response.getBoolean("phoneNumberRequired"));
                    response_data = new LoginResponse(jobj.getString("AdditionalInformation"),jobj.getBoolean("usernameRequired"), jobj.getBoolean("emailRequired"), jobj.getBoolean("phoneNumberRequired"));
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
