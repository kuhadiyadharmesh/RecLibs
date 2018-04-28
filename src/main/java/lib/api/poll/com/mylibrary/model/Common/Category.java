package lib.api.poll.com.mylibrary.model.Common;

/**
 * Created by Dharmesh-PC on 4/27/2018.
 */

public class Category
{
    private  int id ;
    private  String CategoryName ;

    public Category(int id , String CategoryName)
    {
        this.id = id ;
        this.CategoryName = CategoryName;
    }

    public int getId(){return  this.id;}
    public String getCategoryName(){return this.CategoryName;}

}
