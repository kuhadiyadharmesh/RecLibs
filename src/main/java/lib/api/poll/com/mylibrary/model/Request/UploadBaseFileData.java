package lib.api.poll.com.mylibrary.model.Request;

/**
 * Created by Dharmesh-PC on 4/28/2018.
 */

public class UploadBaseFileData
{
    private boolean isProfilePic ;
    private String  base64FileString;

    public UploadBaseFileData(boolean isProfilePic , String base64FileString)
    {
        this.isProfilePic = isProfilePic ;
        this.base64FileString = base64FileString;
    }

    public boolean getisProfilePic ()
    {
        return  this.isProfilePic;
    }
    public String getBase64FileString()
    {
        return this.base64FileString;
    }
            //,accessSeceretKey,userId
}
