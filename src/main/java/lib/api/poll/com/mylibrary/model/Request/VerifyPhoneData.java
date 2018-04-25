package lib.api.poll.com.mylibrary.model.Request;

/**
 * Created by Dharmesh-PC on 4/25/2018.
 */

public class VerifyPhoneData
{
    /*
    {
      "verificationMethod": "sample string 1",
      "verificationCode": "sample string 1",
      "userName": "sample string 2"
    }
     */
    private String vMethod , vCode , userName;

    public VerifyPhoneData(String userName , String vMethod , String vCode)
    {
        this.vMethod = vMethod;
        this.vCode = vCode;
        this.userName = userName;
    }

    public String getvMethod()
    {
        return this.vMethod;
    }
    public String getvCode()
    {
        return this.vCode;
    }
    public String getUserName()
    {
        return  this.userName;
    }
}
