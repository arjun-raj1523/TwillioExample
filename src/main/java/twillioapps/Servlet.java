package twillioapps;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import com.twilio.sdk.resource.factory.CallFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.verbs.*;
import com.twilio.sdk.TwilioRestException;



/**
 * Created by arjun1523 on 2/2/16.
 */

public class Servlet extends javax.servlet.http.HttpServlet  {
    public static final String ACCOUNT_SID = "AC459982629b33625fd159bbe287c7c88b";
    public static final String AUTH_TOKEN = "44078bcbf9807fd1f1dd916959a26b69";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {



    }


    //Message Function
    public void messageme(){

        try{
            TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

            Account account = client.getAccount();

            MessageFactory messageFactory = account.getMessageFactory();
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("To", "+13128748830")); // Replace with a valid phone number for your account.
            params.add(new BasicNameValuePair("From", "+15598235766")); // Replace with a valid phone number for your account.
            params.add(new BasicNameValuePair("Body", "Can we get him?"));
            //params.add(new BasicNameValuePair("MediaUrl", "http://4.bp.blogspot.com/-3qr8VGDrWJ4/VCLeoaSksjI/AAAAAAAAADA/bI1KrRShT9g/s1600/how%2Bto%2Bpotty%2Btrain%2Ba%2Bhusky%2Bpuppy.png"));
            Message sms = messageFactory.create(params);





        }catch(Exception e){

        }
    }
    //Call Function
    public void callme(){
        try{

            TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
            Account mainAccount = client.getAccount();
            CallFactory callFactory = mainAccount.getCallFactory();
            Map<String, String> callParams = new HashMap<String, String>();
            callParams.put("To", "+13128774221"); // Replace with your phone number
            callParams.put("From", "+15598235766"); // Replace with a Twilio number
            callParams.put("Url", "http://demo.twilio.com/welcome/voice/");
            // Make the call
            Call call = callFactory.create(callParams);
            // Print the call SID (a 32 digit hex like CA123..)
            System.out.println(call.getSid());

        }catch(Exception e){

        }

    }
}
