package lib.api.poll.com.mylibrary.model.Request;

/**
 * Created by Dharmesh-PC on 4/30/2018.
 */

public class GetFilterOptionsListData
{
    /*
    {
  "filterType": 0,
  "optionId": 1
}
     */

    private int fileterType ,optionsId;


    public GetFilterOptionsListData(int fileterType , int optionsId)
    {
        this.fileterType = fileterType ;
        this.optionsId =optionsId;
    }

    public int getFileterType(){return this.fileterType;}
    public int getOptionsId(){return this.optionsId;}
}
