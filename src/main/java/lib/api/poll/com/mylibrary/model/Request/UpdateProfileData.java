package lib.api.poll.com.mylibrary.model.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Dharmesh-PC on 4/26/2018.
 */

public class UpdateProfileData
{

//    private int viewCounter,phoneType,countryCode,addressZip,publicPolls,businessPolls,privatePolls,totalPolls;
//    private String id , relationshipStatus , maritalStatus,pictureId,userId,companyName,jobTitle,phoneNumber,gender,birthDate,educationLevel,addressLine1,addressLine2,addressCity,addressCountry,addressState;
//    private String ownerId,pictureUrl,lastLogin,memberSince,firstName,lastName,payPalEmail;
//
//    private boolean isPublicProfile,isPhonePublic,isEmailPublic,isEmailVerified,isPhoneVerified;

    //Map<String, Object> data = null;

    private JSONObject jsonObject;


    /*
    "deletedPictures": [
    "047b5571-b314-47b6-9441-a5905c271a15",
    "bed187f2-8ab6-429c-b288-23726b981cdb"
  ]

  "profilePictures": {
    "9398160e-e96a-4224-8f60-10e452ee2b86": "sample string 2",
    "7f0f97da-253d-4bd4-9985-0f6ee9cdb2ed": "sample string 4"
  },
     */
    public UpdateProfileData(Map<String, Object> data)
    {
        //this.data = data ;
        jsonObject = new JSONObject(data);
    }

    public String getId(){return  getStringValue("id");}
//    public String getrelationshipStatus(){return getStringValue("relationshipStatus");}
    public String getmaritalStatus(){return getStringValue("maritalStatus");}
    public String getpictureId(){return  getStringValue("pictureId");}

    public String getuserId(){return getStringValue("userId");}
    public String getCompanyName(){return getStringValue("companyName");}
    public String getjobTitle(){return getStringValue("jobTitle");}
    public String getphoneNumber() {return getStringValue("phoneNumber");}
    public String getgender(){return getStringValue("gender");}
    public String getbirthDate(){return getStringValue("birthDate");}
    public String geteducationLevel() {return  getStringValue("educationLevel");}
    public String getaddressLine1(){return getStringValue("addressLine1");}
    public String getaddressLine2(){return getStringValue("addressLine2");}
    public String getaddressCity(){return getStringValue("addressCity");}
    public String getaddressCountry(){return getStringValue("addressCountry");}
    public String getaddressState(){return getStringValue("addressState");}
    public String getaddressZip(){return getStringValue("addressZip");}
//    public String getownerId(){return getStringValue("ownerId");}
    public String getpictureUrl(){return getStringValue("pictureUrl");}

//    public String getlastLogin(){return getStringValue("lastLogin");}
//    public String getmemberSince(){return getStringValue("memberSince");}
    public String getfirstName(){return getStringValue("firstName");}
    public String getlastName(){return getStringValue("lastName");}
    public String getpayPalEmail(){return getStringValue("payPalEmail");}

//    public String getphoneVerifiedDateTime(){return getStringValue("phoneVerifiedDateTime");}
//    public String getphoneVerificationMethod(){return getStringValue("phoneVerificationMethod");}
//    public String getemailVerifiedDateTime(){return getStringValue("emailVerifiedDateTime");}

    public boolean getisPublicProfile(){return  getBooleanValue("isPublicProfile");}
//    public boolean getisPhonePublic(){return getBooleanValue("isPhonePublic");}
//    public boolean getisEmailPublic(){return getBooleanValue("isEmailPublic");}
//    public boolean getisEmailVerified(){return getBooleanValue("isEmailVerified");}
//    public boolean getisPhoneVerified(){return getBooleanValue("isPhoneVerified");}

//    public int getviewCounter(){return getIntValue("viewCounter");}
//    public int getphoneType(){return getIntValue("phoneType");}
    public int getcountryCode(){return getIntValue("countryCode");}
//    public int getpublicPolls(){return getIntValue("publicPolls");}
//    public int getbusinessPolls(){return getIntValue("businessPolls");}
//    public int getprivatePolls(){return getIntValue("privatePolls");}
//    public int gettotalPolls(){return getIntValue("totalPolls");}

    public JSONArray getdeletedPictures(){return getArrayValue("deletedPictures");}
    public String getprofilePictures(){return getStringValue("profilePictures");}


    /*

    {
  "id": "a27a8898-6fd8-4e13-84f7-4bd9a325b222",
  "relationshipStatus": "sample string 1",
  "maritalStatus": "sample string 2",
  "pictureId": "991bd06c-dbd2-4a96-b804-9ca09fe778fa",
  "isPublicProfile": true,
  "isPhonePublic": true,
  "isEmailPublic": true,
  "viewCounter": 6,
  "phoneType": 0,
  "userId": "43b654e9-513d-4e4a-a84f-782067211800",
  "companyName": "sample string 2",
  "jobTitle": "sample string 3",
  "countryCode": 4,
  "phoneNumber": "sample string 5",
  "gender": "sample string 6",
  "birthDate": "2018-04-25T23:53:50.831595-07:00",
  "educationLevel": "sample string 8",
  "addressLine1": "sample string 9",
  "addressLine2": "sample string 10",
  "addressCity": "sample string 11",
  "addressCountry": "sample string 12",
  "addressState": "sample string 13",
  "addressZip": 14,
  "ownerId": "64692aa3-6d8c-4608-abac-deefff544a2b",
  "pictureUrl": "sample string 16",
  "profilePictures": {
    "9398160e-e96a-4224-8f60-10e452ee2b86": "sample string 2",
    "7f0f97da-253d-4bd4-9985-0f6ee9cdb2ed": "sample string 4"
  },
  "isEmailVerified": true,
  "isPhoneVerified": true,
  "publicPolls": 1,
  "businessPolls": 1,
  "privatePolls": 1,
  "totalPolls": 1,
  "deletedPictures": [
    "047b5571-b314-47b6-9441-a5905c271a15",
    "bed187f2-8ab6-429c-b288-23726b981cdb"
  ],
  "lastLogin": "2018-04-25T23:53:50.831595-07:00",
  "memberSince": "2018-04-25T23:53:50.831595-07:00",
  "firstName": "sample string 23",
  "lastName": "sample string 24",
  "payPalEmail": "sample string 25"
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

    private JSONArray getArrayValue(String key)
    {
        try
        {
            return  this.jsonObject.getJSONArray(key);
        }
        catch (JSONException e)
        {
            return null;
        }
    }
}
