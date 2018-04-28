package lib.api.poll.com.mylibrary.model.Response;

/**
 * Created by Dharmesh-PC on 4/25/2018.
 */

public class Common_Response
{
    /*

    {
      "status": "sample string 1",
      "statusMessage": "sample string 2"
    }
     */

    private String message="";
    private int status = 0;

    public Common_Response(String message, int status )
    {
        this.message = message;
        this.status = status;
    }
//    public Common_Response

    public int getStatus(){return this.status;}
    public String getMessage(){return this.message;}
}
