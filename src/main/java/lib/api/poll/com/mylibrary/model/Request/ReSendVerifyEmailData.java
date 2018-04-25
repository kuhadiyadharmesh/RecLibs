package lib.api.poll.com.mylibrary.model.Request;

/**
 * Created by Dharmesh-PC on 4/25/2018.
 */

public class ReSendVerifyEmailData
{
    private String emailAddress ;

    public ReSendVerifyEmailData(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress()
    {
        return this.emailAddress;
    }
}
