package lib.api.poll.com.mylibrary.model.Common;

/**
 * Created by Dharmesh-PC on 4/27/2018.
 */

public class City
{
    private  int id ;
    private  String Cityname ;

    public City(int id , String Cityname)
    {
        this.id = id ;
        this.Cityname = Cityname;
    }

    public int getId(){return  this.id;}
    public String getCityname(){return this.Cityname;}

}
