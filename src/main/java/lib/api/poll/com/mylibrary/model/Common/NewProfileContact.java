package lib.api.poll.com.mylibrary.model.Common;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dharmesh-PC on 4/26/2018.
 */

public class NewProfileContact
{

    private JSONObject jsonObject ;
    private Map<String , String> profileimg;

    public NewProfileContact(JSONObject jsonObject)
    {
        this.jsonObject = jsonObject;
    }

    public String getId(){return  getStringValue("id");}
    public String getCompanyName(){return getStringValue("companyName");}
    public String getjobTitle(){return getStringValue("jobTitle");}
    public String geteducationLevel() {return  getStringValue("educationLevel");}
    public String getrelationshipStatus(){return getStringValue("relationshipStatus");}
    public String getmaritalStatus(){return getStringValue("maritalStatus");}
    public String getpictureId(){return  getStringValue("pictureId");}
    public String getuserId(){return getStringValue("userId");}
    public String getphoneNumber() {return getStringValue("phoneNumber");}
    public String getgender(){return getStringValue("gender");}
    public String getbirthDate(){return getStringValue("birthDate");}

    public String getaddressLine1(){return getStringValue("addressLine1");}
    public String getaddressLine2(){return getStringValue("addressLine2");}
    public String getaddressCity(){return getStringValue("addressCity");}
    public String getaddressCountry(){return getStringValue("addressCountry");}
    public String getaddressState(){return getStringValue("addressState");}
    public String getaddressZip(){return getStringValue("addressZip");}
    public String getownerId(){return getStringValue("ownerId");}
    public String getpictureUrl(){return getStringValue("pictureUrl");}

    public String getlastLogin(){return getStringValue("lastLogin");}
    public String getmemberSince(){return getStringValue("memberSince");}
    public String getfirstName(){return getStringValue("firstName");}
    public String getlastName(){return getStringValue("lastName");}
    public String getpayPalEmail(){return getStringValue("payPalEmail");}
    public String getphoneVerifiedDateTime(){return getStringValue("phoneVerifiedDateTime");}
    public String getphoneVerificationMethod(){return getStringValue("phoneVerificationMethod");}
    public String getemailVerifiedDateTime(){return getStringValue("emailVerifiedDateTime");}

    public boolean getisPublicProfile(){return  getBooleanValue("isPublicProfile");}
    public boolean getisPhonePublic(){return getBooleanValue("isPhonePublic");}
    public boolean getisEmailPublic(){return getBooleanValue("isEmailPublic");}
    public boolean getisEmailVerified(){return getBooleanValue("isEmailVerified");}
    public boolean getisPhoneVerified(){return getBooleanValue("isPhoneVerified");}

    public int getviewCounter(){return getIntValue("viewCounter");}
    public int getphoneType(){return getIntValue("phoneType");}
    public int getcountryCode(){return getIntValue("countryCode");}
    public int getpublicPolls(){return getIntValue("publicPolls");}
    public int getbusinessPolls(){return getIntValue("businessPolls");}
    public int getprivatePolls(){return getIntValue("privatePolls");}
    public int gettotalPolls(){return getIntValue("totalPolls");}

    public Map getprofilePictures()
    {
        Map m = new HashMap();
        try {
            JSONObject jj = jsonObject.getJSONObject("profilePictures");

            String[] dd = (jj.toString()).split(",");

            int co = dd.length;
           for (int i = 0 ; i<=co ;i++)
            {
                String[] dd1 = dd[i].split(":");
                m.put(dd1[0].toString(),dd1[1].toString());
            }

        }
        catch (JSONException e)
        {

        }
       return m;
    }

    public JSONArray getdeletedPictures()
    {
        try
        {
            return jsonObject.getJSONArray("deletedPictures");
        }
        catch (JSONException e)
        {
            return null;
        }

    }



//    public int get(){return getIntValue("");}

    /*
    "newProfileContact": {
//    "id": "a65f61ef-65e4-48e8-b374-ff4b5a90e087",
//    "companyName": "sample string 1",
//    "jobTitle": "sample string 2",
//    "educationLevel": "sample string 3",
//    "relationshipStatus": "sample string 5",
//    "maritalStatus": "sample string 6",
//    "pictureId": "d406506f-e5b4-4a0b-b22b-f5389671d924",
    "isPublicProfile": true,
    "isPhonePublic": true,
    "isEmailPublic": true,
    "viewCounter": 10,
    "phoneType": 0,
//    "userId": "f79604ce-93b9-4713-b3c0-8a48d036c31b",
    "countryCode": 1,
//    "phoneNumber": "sample string 2",
//    "gender": "sample string 3",
//    "birthDate": "sample string 4",
//    "addressLine1": "sample string 5",
//    "addressLine2": "sample string 6",
//    "addressCity": "sample string 7",
//    "addressCountry": "sample string 8",
//    "addressState": "sample string 9",
//    "addressZip": "sample string 10",
//    "ownerId": "d1a49be7-231d-4ab3-8f9b-fe5f77466483",
//    "pictureUrl": "sample string 12",
    "profilePictures": {
      "fc2c2afc-825a-4c36-91fe-4feb616b597a": "sample string 2",
      "113abcfc-1faa-4a79-8b11-4e4b4ba362b6": "sample string 4"
    },
    "isEmailVerified": true,
    "isPhoneVerified": true,
    "publicPolls": 1,
    "businessPolls": 1,
    "privatePolls": 1,
    "totalPolls": 1,
    "deletedPictures": [
      "ec6c66ae-8949-41c6-ad05-dabd7f62a227",
      "1bafd2f5-5d66-452b-98b4-1e03c0ee4705"
    ],
//    "lastLogin": "2018-04-25T02:43:44.7029486-07:00",
//    "memberSince": "2018-04-25T02:43:44.7029486-07:00",
//    "firstName": "sample string 19",
//    "lastName": "sample string 20",
//    "payPalEmail": "sample string 21",
//    "phoneVerifiedDateTime": "2018-04-25T02:43:44.7029486-07:00",
//    "phoneVerificationMethod": "sample string 24",
//    "emailVerifiedDateTime": "2018-04-25T02:43:44.7029486-07:00"
  },
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
