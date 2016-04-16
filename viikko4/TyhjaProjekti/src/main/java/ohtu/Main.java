
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import ohtu.Submission;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "014245042";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2016.herokuapp.com/students/"+studentNr+"/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream =  method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        int yht  = 0;
        int h = 0;
        for (Submission sub : subs) {
            sub.setB();
            sub.setDone();
            yht += sub.getDone();
            h += sub.getHours();
        }
        //

        System.out.println("Opiskelijanumero: " + subs[0].getStudent_number());
        for (Submission submission : subs) {
            System.out.println(submission);
        }
        System.out.println("Yhteensä: " + yht + " tehtävää " + h + " tuntia" );
    }
}