package lib.api.poll.com.model.File;


import java.util.ArrayList;

import lib.api.poll.com.model.Common.FileData;

/**
 * Created by Dharmesh-PC on 1/11/2018.
 */

public class GetFiles_Response
{
    private boolean status =false ;
    private String msg = "server not response";
    private String credit = "0";
    private ArrayList<FileData> filedata ;


    public GetFiles_Response(String msg)
    {
        this.msg = msg ;
        filedata = new ArrayList<>();
    }
    public GetFiles_Response(String msg , ArrayList<FileData> filedata ,String credit)
    {
        this.msg = msg ;
        this.status = true ;
        this.filedata = filedata;
        this.credit = credit;
    }

    public ArrayList<FileData> getFiledata()
    {
        return this.filedata;
    }
    public String getCredit()
    {
        return this.credit;
    }
    public String getMsg()
    {

        return  this.msg;
    }
    public boolean getStatus()
    {
        return this.status;
    }
}
