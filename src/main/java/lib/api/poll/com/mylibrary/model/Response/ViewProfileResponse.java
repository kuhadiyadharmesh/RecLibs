package lib.api.poll.com.mylibrary.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import lib.api.poll.com.mylibrary.model.Common.NewDevice;
import lib.api.poll.com.mylibrary.model.Common.NewProfileContact;

/**
 *
 *  Created by Dharmesh-PC on 4/25/2018.
 *
 *
 *
 *
 */

public class ViewProfileResponse
{
    private int status = 0 ;//, userType ,departmentId , accessLevel;
    private String message = "";
    //private String id , username , profileId , token , source , displayName , org , emailAddress , userId , userRole ,lastLogin , createDate;
    //private boolean isEmailVerified,isPhoneVerified , isCallVerified , buyCompanyPolls , buyTurkPolls , isRequiedApproval , emailInvites,isActive , isCanRunFreePoll , isBuyCredits , isPartner ;

    private NewDevice ndevicedata ;
    private NewProfileContact newProfileContact;

    private JSONObject jsonObject;

    public ViewProfileResponse(String message)
    {
        this.message = message;
    }


    public ViewProfileResponse(JSONObject jsonObject)
    {
        this.jsonObject = jsonObject;

        try
        {
            ndevicedata = new NewDevice(jsonObject.getJSONObject("newDevice"));//newDevice
            newProfileContact = new NewProfileContact(jsonObject.getJSONObject("newProfileContact"));//newProfileContact
            status = 1;
        }
        catch (JSONException e)
        {
            status = 0;
            message = "Some problem in NewDevice data or newProfileContact data .";
        }

    }//deletedPictures

    public NewDevice getNdevicedata(){return  this.ndevicedata;}
    public NewProfileContact getNewProfileContact(){return this.newProfileContact;}

    public int getStatus(){return this.status;}
    public int getUserType(){return this.getIntValue("userType");}
    public int getDepartmentId(){return this.getIntValue("departmentId");}
    public int getAccessLevel() {return this.getIntValue("accessLevel");}

    public String getMessage(){return this.message;}
    public String getSource(){return getStringValue("source");}
    public String getId(){return getStringValue("id");}
    public String getUsername(){return getStringValue("userName");}
    public String getToken(){return  getStringValue("token");}
    public String getDisplayName(){return  getStringValue("displayName");}
    public String getProfileId(){ return getStringValue("ProfileId");}
    public String getOrg(){return getStringValue("org");}
    public String getEmailAddress() {return getStringValue("emailAddress");}
    public String getUserId(){return getStringValue("userId");}
    public String getUserRole(){return getStringValue("userRole");}
    public String getLastLogin() {return getStringValue("lastLogin");}
    public String getCreateDate() {return getStringValue("createDate");}

    public boolean getisEmailVerified(){return getBooleanValue("isEmailVerified");}
    public boolean getisPhoneVerified(){return getBooleanValue("isPhoneVerified");}
    public boolean getisCallverified(){return getBooleanValue("isCallVerified");}
    public boolean getbuyCompanyPolls(){return getBooleanValue("buyCompanyPolls");}
    public boolean getbuyTurkPolls(){return getBooleanValue("buyTurkPolls");}
    public boolean getemailInvites(){return getBooleanValue("emailInvites");}
    public boolean getisActive(){return getBooleanValue("isActive");}
    public boolean getisCanRunFreePoll(){return getBooleanValue("isCanRunFreePoll");}
    public boolean getisBuyCredits(){return getBooleanValue("isBuyCredits");}
    public boolean getisPartner(){return  getBooleanValue("isPartner");}




    /*
    {
//  "id": "56e5dc03-426d-4d57-af03-f37ade84579d",
//  "userName": "sample string 2",
//  "profileId": "90e2dff1-e9a4-405a-9634-cd9d0568334a",
//  "status": "sample string 5",
  "isEmailVerified": true,
//  "token": "256bb034-e79a-42e7-8999-53c576c2e240",
  "isPhoneVerified": true,
  "isCallVerified": true,
//  "source": "sample string 11",
//  "displayName": "sample string 12",
//  "userType": 0,
  "buyCompanyPolls": true,
  "buyTurkPolls": true,
  "isRequiedApproval": true,
//  "org": "sample string 16",
  "emailInvites": true,
  ,
//  "emailAddress": "sample string 1",
//  "userId": "9012957d-7f36-4571-8707-4006c654809b",
  "isActive": true,
//  "userRole": "sample string 5",
  "isCanRunFreePoll": true,
  "isBuyCredits": true,
  "isPartner": true,
//  "departmentId": 9,
//  "lastLogin": "2018-04-25T02:43:44.7029486-07:00",
//  "createDate": "2018-04-25T02:43:44.7029486-07:00",
//  "accessLevel": 13
}
     */

    private String getStringValue(String key)
    {
        try
        {
            return  this.jsonObject.getString(key);
        }
        catch (JSONException e)
        {
            return null;
        }

    }

    private boolean getBooleanValue(String key)
    {
        try
        {
            return  this.jsonObject.getBoolean(key);
        }
        catch (JSONException e)
        {
            return false;
        }
    }

    private int getIntValue(String key)
    {
        try
        {
            return  this.jsonObject.getInt(key);
        }
        catch (JSONException e)
        {
            return -1;
        }
    }

}
