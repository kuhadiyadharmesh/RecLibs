package lib.api.poll.com.mylibrary.model.Common;

/**
 * Created by Dharmesh-PC on 4/27/2018.
 */

public class States
{
    private  int id ;
    private  String Statename ;

    public States(int id , String Statename)
    {
        this.id = id ;
        this.Statename = Statename;
    }

    public int getId(){return  this.id;}
    public String getStatename(){return this.Statename;}

}
