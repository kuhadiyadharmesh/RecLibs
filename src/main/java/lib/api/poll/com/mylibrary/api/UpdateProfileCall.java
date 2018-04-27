package lib.api.poll.com.mylibrary.api;

import org.apache.james.mime4j.field.datetime.DateTime;
import org.json.JSONException;
import org.json.JSONObject;

import lib.api.poll.com.mylibrary.client.ApiInfo;
import lib.api.poll.com.mylibrary.client.PollApi;
import lib.api.poll.com.mylibrary.model.Common.HeaderCall;
import lib.api.poll.com.mylibrary.model.Request.LoginData;
import lib.api.poll.com.mylibrary.model.Request.UpdateProfileData;
import lib.api.poll.com.mylibrary.model.Response.Common_Response;
import lib.api.poll.com.mylibrary.model.Response.LoginResponse;
import lib.api.poll.com.mylibrary.model.Response.ViewProfileResponse;

/**
 * Created by Dharmesh-PC on 4/26/2018.
 */

public class UpdateProfileCall
{
    /*
   String req = "{\"userName\": \""+user_name+"\",\n" +
           "  \"password\": \""+password+"\", \"newDevice\": {\n" +
           "    \"deviceVersion\": \"galaxy\",\n" +
           "    \"browserName\": \"mobile\",\n" +
           "    \"browserVersion\": \"1.0\",\n" +
           "    \"browserUserAgent\": \"mobile\",\n" +
           "    \"snsType\": \"GCM\",\n" +
           "    \"deviceName\": \"Android\",\n" +
           "    \"devicePlatform\": \"Android\",\n" +
           "    \"snsDeviceId\": \""+snsToken+"\",\n" +
           "    \"channelId\": \""+imei+"\"\n" +
           "  }}";*/
    private UpdateProfileData data ;
    private PollApi pollApi;
    private HeaderCall hdata ;

    public UpdateProfileCall(UpdateProfileData data , HeaderCall hdata)
    {
        pollApi = new PollApi();
        this.data = data ;
        this.hdata = hdata;
    }


    public ViewProfileResponse pdateProfile_Call()
    {
        if(hdata.getUserid().equals(""))
            return new ViewProfileResponse("Developer error header -> UserId id Empty.");
        if(hdata.getToken().equals(""))
            return new ViewProfileResponse("Developer error header -> Token is Empty.");


        if(data.getId().equals(""))
            return new ViewProfileResponse("Please enter id.");
//        if(data.getrelationshipStatus().equals(""))
//            return new ViewProfileResponse("Please enter relationshipStatus.");
        if(data.getmaritalStatus().equals(""))
            return new ViewProfileResponse("Please enter maritalStatus.");
        if(data.getpictureId().equals(""))
            return new ViewProfileResponse("Please enter pictureId.");
//        if((data.getviewCounter()+"").equals(""))
//            return new ViewProfileResponse("Please enter viewCounter.");
//        if((data.getphoneType()+"").equals(""))
//            return new ViewProfileResponse("Please enter phoneType.");
        if(data.getuserId().equals(""))
            return new ViewProfileResponse("Please enter userId.");
        if(data.getCompanyName().equals(""))
            return new ViewProfileResponse("Please enter companyName.");
        if(data.getjobTitle().equals(""))
            return new ViewProfileResponse("Please enter jobTitle.");
        if((data.getcountryCode()+"").equals(""))
            return new ViewProfileResponse("Please enter countryCode.");
        if(data.getphoneNumber().equals(""))
            return new ViewProfileResponse("Please enter phoneNumber.");
        if(data.getgender().equals(""))
            return new ViewProfileResponse("Please enter gender.");
        if(data.getbirthDate().equals(""))
            return new ViewProfileResponse("Please enter birthDate.");
        if(data.geteducationLevel().equals(""))
            return new ViewProfileResponse("Please enter educationLevel.");
        if(data.getaddressLine1().equals(""))
            return new ViewProfileResponse("Please enter addressLine1.");
        if(data.getaddressCity().equals(""))
            return new ViewProfileResponse("Please enter addressCity.");
        if(data.getaddressCountry().equals(""))
            return new ViewProfileResponse("Please enter addressCountry.");
        if(data.getaddressState().equals(""))
            return new ViewProfileResponse("Please enter addressState.");
        if(data.getaddressZip().equals(""))
            return new ViewProfileResponse("Please enter addressZip.");
//        if(data.getownerId().equals(""))
//            return new ViewProfileResponse("Please enter ownerId.");
        if(data.getpictureUrl().equals(""))
            return new ViewProfileResponse("Please enter pictureUrl.");
//        if(data.getprofilePictures().equals(""))
//            return new ViewProfileResponse("Please enter profilePictures.");
//        if((data.getpublicPolls()+"").equals(""))
//            return new ViewProfileResponse("Please enter publicPolls.");
//        if((data.getbusinessPolls()+"").equals(""))
//            return new ViewProfileResponse("Please enter businessPolls.");
//        if((data.getprivatePolls()+"").equals(""))
//            return new ViewProfileResponse("Please enter privatePolls.");
//        if((data.gettotalPolls()+"").equals(""))
//            return new ViewProfileResponse("Please enter totalPolls.");


//        if(data.getlastLogin().equals(""))
//            return new ViewProfileResponse("Please enter lastLogin.");
//        if(data.getmemberSince().equals(""))
//            return new ViewProfileResponse("Please enter memberSince.");
        if(data.getfirstName().equals(""))
            return new ViewProfileResponse("Please enter firstName.");
        if(data.getlastName().equals(""))
            return new ViewProfileResponse("Please enter lastName.");
        if(data.getpayPalEmail().equals(""))
            return new ViewProfileResponse("Please enter payPalEmail.");


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
        //Validation

        String param = "{" +
                "  \"id\": \"" + data.getId() + "\",\n" +
                  /*  "  \"relationshipStatus\": \"sample string 1\",\n" +*/
                "  \"maritalStatus\": \"" + data.getmaritalStatus() + "\",\n" +
                "  \"pictureId\": \"" + data.getpictureId() + "\",\n" +
                "  \"isPublicProfile\": " + data.getisPublicProfile() + ",\n" +
                  /*  "  \"isPhonePublic\": true,\n" +
                    "  \"isEmailPublic\": true,\n" +*/
                  /*  "  \"viewCounter\": 6,\n" +*/
                 /*   "  \"phoneType\": 0,\n" +*/
                "  \"userId\": \"" + data.getuserId() + "\",\n" +
                "  \"companyName\": \"" + data.getCompanyName() + "\",\n" +
                "  \"jobTitle\": \"" + data.getjobTitle() + "\",\n" +
                "  \"countryCode\": " + data.getcountryCode() + ",\n" +
                "  \"phoneNumber\": \"" + data.getphoneNumber() + "\",\n" +
                "  \"gender\": \"" + data.getgender() + "\",\n" +
                "  \"birthDate\": \"" + data.getbirthDate() + "\",\n" +
                "  \"educationLevel\": \"" + data.geteducationLevel() + "\",\n" +
                "  \"addressLine1\": \"" + data.getaddressLine1() + "\",\n" +
                "  \"addressLine2\": \"" + data.getaddressLine2() + "\",\n" +
                "  \"addressCity\": \"" + data.getaddressCity() + "\",\n" +
                "  \"addressCountry\": \"" + data.getaddressCountry() + "\",\n" +
                "  \"addressState\": \"" + data.getaddressState() + "\",\n" +
                "  \"addressZip\": " + data.getaddressZip() + ",\n" +
                /*    "  \"ownerId\": \"ad168c78-b9fd-40bd-a354-29b898a6f917\",\n" +*/
                "  \"pictureUrl\": \"" + data.getpictureUrl() + "\",\n" +
                 /*   "  \"profilePictures\": {\n" +
                    "    \"65dfccea-60a0-43d9-8c3d-e5f5db6e00cc\": \"sample string 2\",\n" +
                    "    \"f01e23f6-9a2b-4ef7-8adf-907e2c6f56a7\": \"sample string 4\"\n" +
                    "  },\n" +
                    "  \"isEmailVerified\": true,\n" +
                    "  \"isPhoneVerified\": true,\n" +
                      "  \"publicPolls\": 1,\n" +
                    "  \"businessPolls\": 1,\n" +
                    "  \"privatePolls\": 1,\n" +
                    "  \"totalPolls\": 1,\n" +
                       "  \"deletedPictures\": [\n" +
                    "    \"ed58dfcf-43fa-4dc5-bdb0-9f13548b5b8a\",\n" +
                    "    \"ceaf85b2-5aeb-4b40-ad87-456af4317ddb\"\n" +
                    "  ],\n" +*/
                  /*  "  \"lastLogin\": \"2018-03-13T20:47:40.8902556-07:00\",\n" +
                    "  \"memberSince\": \"2018-03-13T20:47:40.8902556-07:00\",\n" +*/
                "  \"firstName\": \"" + data.getfirstName() + "\",\n" +
                "  \"lastName\": \"" + data.getlastName() + "\",\n" +
                "  \"payPalEmail\": \"" + data.getpayPalEmail()+ "\"\n" +
                "}";

        JSONObject jobj = null;
        ViewProfileResponse response_data  = null;
        jobj =  pollApi.makeHTTPPOST_SSL(ApiInfo.UpdateProfile_api,param,hdata);//.makeHTTPPOSTLogin_SSL(ApiInfo.login_api, param);

        if(jobj == null)
        {
            response_data = new ViewProfileResponse("Something Wrong- api not responded.");
        }
        else
        {
            try
            {
                if (jobj.getString("status").equals("ok"))
                {
                    response_data = new ViewProfileResponse(jobj);//new LoginResponse(jobj.getString("userName").toString(),jobj.getString("userId"),jobj.getString("emailAddress"),jobj.getString("token"),jobj.getString("secretAccessKey"));
                    return response_data;
                }
                else
                {//statusMessage
                    response_data = new ViewProfileResponse(jobj.getString("statusMessage"));
                    return  response_data;
                }
            }
            catch (JSONException e)
            {
                e.printStackTrace();
                response_data = new ViewProfileResponse("Something Wrong- api not responded.- JSONException");
            }
        }
        return  response_data;
    }
}
