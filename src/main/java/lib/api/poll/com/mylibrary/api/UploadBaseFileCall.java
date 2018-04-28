package lib.api.poll.com.mylibrary.api;

import org.json.JSONException;
import org.json.JSONObject;

import lib.api.poll.com.mylibrary.client.ApiInfo;
import lib.api.poll.com.mylibrary.client.PollApi;
import lib.api.poll.com.mylibrary.model.Common.HeaderCall;
import lib.api.poll.com.mylibrary.model.Request.UploadBaseFileData;
//import lib.api.poll.com.mylibrary.model.Response.Common_Response;
import lib.api.poll.com.mylibrary.model.Response.UploadBaseFile_Response;

/**
 * Created by Dharmesh-PC on 4/28/2018.
 */

public class UploadBaseFileCall
{

    private UploadBaseFileData data ;
    private HeaderCall hdata ;
    private PollApi pollApi;

    public UploadBaseFileCall(UploadBaseFileData data , HeaderCall hdata)
    {
        this.data = data ;
        this.hdata = hdata;
        pollApi = new PollApi();
    }


    public UploadBaseFile_Response UploadBaseFile_Call()
    {
        //Validation for header
        if(hdata.getUserid().equals(""))
            return new UploadBaseFile_Response("Developer error header -> UserId id Empty.");
        if(hdata.getToken().equals(""))
            return new UploadBaseFile_Response("Developer error header -> Token is Empty.");

        //Validation
        if(data.getBase64FileString().equals(""))
            return new UploadBaseFile_Response("Developer error Imagebase64 -> Imagebase64 is Empty." );


        String param = "{" +
                "  \"isProfilePic\": "+data.getisProfilePic()+",\n" +
                "  \"base64FileString\": \"" + data.getBase64FileString() + "\"," +
                "  \"accessSeceretKey\": \"" + hdata.getToken() + "\"," +
                "  \"userId\": \"" + hdata.getUserid() + "\"" +
                "}";

        JSONObject jobj = null;
        UploadBaseFile_Response response_data  = null;
        jobj =  pollApi.makeHTTPPOST_SSL(ApiInfo.UploadBase64File_api,param,hdata);//.makeHTTPPOSTLogin_SSL(ApiInfo.login_api, param);

        if(jobj == null)
        {
            response_data = new UploadBaseFile_Response("Something Wrong- api not responded.");
        }
        else
        {
            try
            {
               // if (jobj.getString("status").equals("ok"))
               // {
                    response_data = new UploadBaseFile_Response("Thanks , making call Please wait .");//new LoginResponse(jobj.getString("userName").toString(),jobj.getString("userId"),jobj.getString("emailAddress"),jobj.getString("token"),jobj.getString("secretAccessKey"));
                //    return response_data;
               // }
               // else
               // {//statusMessage
                //    response_data = new UploadBaseFile_Response(jobj.getString("statusMessage"));
               //     return  response_data;
              //  }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                response_data = new UploadBaseFile_Response("Something Wrong- api not responded.");
            }
        }
        return  response_data;
    }





}
