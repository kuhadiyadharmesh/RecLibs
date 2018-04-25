package lib.api.poll.com.mylibrary.model.Request;

/**
 * Created by Dharmesh-PC on 4/25/2018.
 */

public class VerifyEmailData
{
    private String id ;

    public VerifyEmailData(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }
}
