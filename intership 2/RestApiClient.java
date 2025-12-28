import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
// This library helps to read JSON
import org.json.JSONObject;
public class RestApiClient {
    public static void main(String[] args) {
        try {
            // 1️⃣ API address
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            // 2️⃣ Open connection
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            // 3️⃣ Read data from API
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );
            String line;
            StringBuilder data = new StringBuilder();
            while ((line = br.readLine()) != null) {
                data.append(line);
            }
            br.close();
            // 4️⃣ Convert text into JSON object
            JSONObject json = new JSONObject(data.toString());
            // 5️⃣ Print structured output
            System.out.println("POST DETAILS");
            System.out.println("------------");
            System.out.println("User ID : " + json.getInt("userId"));
            System.out.println("Post ID : " + json.getInt("id"));
            System.out.println("Title   : " + json.getString("title"));
            System.out.println("Body    : " + json.getString("body"));

        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
