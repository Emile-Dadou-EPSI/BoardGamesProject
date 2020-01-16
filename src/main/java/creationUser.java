import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "creationUser")
public class creationUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User newUser = new User(request.getParameter("login"), request.getParameter("password"), request.getParameter("mode"));


        FileInputStream refreshToken = new FileInputStream("C:\\Users\\emile\\IdeaProjects\\BoardGames\\src\\main\\java\\boardgames-6813a-firebase-adminsdk-vvivt-657fd5ca31.json");

        GoogleCredentials credentials = GoogleCredentials.fromStream(refreshToken);
        FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
        //FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();

        // Add document data with id "test"
        Map<String, Object> data = new HashMap<>();
        data.put("UserName", newUser.username);
        data.put("Password", newUser.password);
        data.put("Mode", newUser.type);

        ApiFuture<WriteResult> res = db.collection("users").document(newUser.username).set(data);

        request.getRequestDispatcher("/LoggedPage.html").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
