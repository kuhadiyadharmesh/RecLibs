package lib.api.poll.com.mylibrary.model.Request;

import lib.api.poll.com.mylibrary.model.Common.Deviceinfo;

/**
 * Created by Dharmesh-PC on 4/23/2018.
 */

public class LoginSocialData
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
                    "}";
    */

//    private  String userName , password ,deviceId  ;
    private String deviceId , appid , provider , id , userName , email,phoneNumber , name , givenName , familyName , accessToken , gender ;

    private Deviceinfo deviceinfo;

    public LoginSocialData(String deviceId , String appid , String provider , String id , String userName , String email , String phoneNumber , String name , String givenName , String familyName , String accessToken, String gender
            , Deviceinfo deviceinfo)
    {
        this.appid = appid;
        this.provider = provider ;
        this.id = id ;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name ;
        this.givenName = givenName;
        this.familyName = familyName;
        this.accessToken = accessToken;
        this.gender = gender;
        this.userName = userName;
//      this.password = password;
        this.deviceinfo = deviceinfo;
        this.deviceId = deviceId;
    }

    public String getAppid() {return  appid;}
    public String getProvider() {return  provider;}
    public String getId() {return  id;}
    public String getEmail() {return  email;}
    public String getPhoneNumber() {return  phoneNumber;}
    public String getName() {return  name;}
    public String getGivenName(){return  givenName;}
    public String getAccessToken() {return accessToken;}
    public String getGender(){return  gender;}
    public String getFamilyName() {return  familyName;}
    public String getUserName()
    {
        return  userName;
    }
    public String getDeviceId()
    {
        return  deviceId;
    }
    /*public String getPassword()
    {
        return  password;
    }*/


    public Deviceinfo getDeviceinfo()
    {
        return  deviceinfo;
    }
}
