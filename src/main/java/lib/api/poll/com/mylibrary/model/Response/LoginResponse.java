package lib.api.poll.com.mylibrary.model.Response;

/**
 * Created by Dharmesh-PC on 4/18/2018.
 */

public class LoginResponse
{
    /*
     try {
                sp_db.putString(Constant.lib_username, response.getString("userName"));
                sp_db.putString(Constant.lib_userId, response.getString("userId"));
                sp_db.putString(Constant.lib_email, response.getString("emailAddress"));
                sp_db.putString(Constant.lib_token, response.getString("token"));
                sp_db.putString(Constant.lib_secretAccessKey, response.getString("secretAccessKey"));

                GotoHome();

            } catch (Exception e) {
                try {
                    Toast.makeText(this, "" + response.getString("AdditionalInformation"), Toast.LENGTH_SHORT).show();
                    if (what == Constant.PostAuth_type)
                    {
                        SocialExtraDailog(response.getBoolean("usernameRequired"), response.getBoolean("emailRequired"), response.getBoolean("phoneNumberRequired"));
                    }


                } catch (Exception e1) {
                    // Toast.makeText(this, "something wents wrong..\n please try again", Toast.LENGTH_SHORT).show();
                }
            }
            */

    private int status = 0 ;
    public String message = "";

    private String username , userid , emailaddress , token , secretAccesskey ;

    public LoginResponse(String message)
    {
        this.message = message;

    }

    public LoginResponse(String username , String userid , String emailaddress , String token , String secretAccesskey)
    {
        this.username = username;
        this.userid = userid;
        this.emailaddress = emailaddress ;
        this.token = token ;
        this.secretAccesskey = secretAccesskey;
        this.status = 1;
    }

   // public
    public String getUsername()
    {
        return  this.username;
    }
    public String getUserid()
    {
        return this.userid;
    }
    public String getEmailaddress()
    {
        return this.emailaddress;
    }
    public String getToken()
    {
        return this.token;
    }
    public String getMessage()
    {
        return this.message;
    }
    public int  getStatus()
    {
        return this.status;
    }


}
