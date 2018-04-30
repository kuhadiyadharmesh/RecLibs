package lib.api.poll.com.mylibrary.model.Common;

/**
 * Created by Dharmesh-PC on 4/30/2018.
 */

public class FilterPairs
{
    private String filterName = null,filterValue = null;

    public FilterPairs(String filterName , String filterValue)
    {
            this.filterName = filterName ;
            this.filterValue = filterValue;
    }
    public String getFilterName()
    {
        return this.filterName;
    }
    public String getFilterValue()
    {
        return this.filterValue;
    }
}
