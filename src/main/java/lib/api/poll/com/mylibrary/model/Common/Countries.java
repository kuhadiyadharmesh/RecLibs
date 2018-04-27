package lib.api.poll.com.mylibrary.model.Common;

/**
 * Created by Dharmesh-PC on 4/27/2018.
 */

public class Countries
{
    private int id ;
    private String countryName,phoneCode;

    public Countries(int id , String countryName , String phoneCode)
    {
        this.id = id ;
        this.countryName = countryName;
        this.phoneCode = phoneCode;
    }

    public Countries(int id , String countryName)
    {
        this.id = id ;
        this.countryName = countryName;
    }

    public int getId(){return this.id;}
    public String getCountryName(){return  this.countryName;}
    public String getPhoneCode(){return  this.phoneCode;}
}
