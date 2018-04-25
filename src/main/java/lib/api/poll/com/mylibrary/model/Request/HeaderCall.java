package lib.api.poll.com.mylibrary.model.Request;

/**
 * Created by Dharmesh-PC on 4/25/2018.
 */

public class HeaderCall
{
    private String userid , token ;

    public HeaderCall(String userid , String token)
    {
        this.userid = userid;
        this.token = token;
    }

    public String getUserid()
    {
        return  this.userid;
    }
    public  String getToken()
    {
        return  this.token;
    }
}
