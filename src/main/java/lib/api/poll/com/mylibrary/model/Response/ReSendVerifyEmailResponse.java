package lib.api.poll.com.mylibrary.model.Response;

/**
 * Created by Dharmesh-PC on 4/25/2018.
 */

public class ReSendVerifyEmailResponse
{
    /*

    {
      "status": "sample string 1",
      "statusMessage": "sample string 2"
    }
     */

    private String message="";
    private int status = 0;

    public ReSendVerifyEmailResponse(String message, int status )
    {
        this.message = message;
        this.status = status;
    }
//    public ReSendVerifyEmailResponse
}
