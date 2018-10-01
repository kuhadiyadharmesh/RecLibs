package lib.api.poll.com.model.Setting;


import java.util.ArrayList;

import lib.api.poll.com.model.Common.Message;

/**
 * Created by Dharmesh-PC on 1/13/2018.
 */

public class GetMessage_Response
{
    //{"status":"ok","msgs":[{"id":"1","title":"First Title","body":"New Call Package available Now","time":"2015-07-29 07:38:52"}]}

    private boolean status = false ;
    private String msg = "Server not responding ";
    private ArrayList<Message> messagelist ;

    public GetMessage_Response(String msg)
    {
        this.msg = msg ;
    }

    public GetMessage_Response(String msg , ArrayList<Message> messagelist)
    {
        this.msg = msg ;
        this.messagelist = messagelist;
        this.status = true ;
    }

    public String getMsg()
    {
        return this.msg;
    }
    public boolean getStatus()
    {
        return this.status;
    }
    public ArrayList<Message> getMessagelist()
    {
        return this.messagelist;
    }


}
