package lib.api.poll.com.mylibrary.model.Common;

/**
 * Created by Dharmesh-PC on 4/30/2018.
 */

public class FilterOptions
{
    /*
        {
        "id": 1,
        "filterName": "sample string 2",
        "showGraph": true,
        "showFilter": true
      },
     */
    private int id ;
    private String filterName ;
    private boolean showGraph , showfilter;

    public FilterOptions(int id , String filterName , boolean showGraph, boolean showfilter)
    {
        this.id = id ;
        this.filterName = filterName;
        this.showGraph = showGraph;
        this.showfilter = showfilter;
    }




}
