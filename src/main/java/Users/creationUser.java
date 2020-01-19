package Users;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
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

import static Servlets.InitServlet.CONTEXT_USERS;

@WebServlet(name = "Users.creationUser")
public class creationUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User newUser = new User(request.getParameter("email"), request.getParameter("id"), request.getParameter("password"), request.getParameter("mode"));
        System.out.println(request.getParameter("login"));

        FileInputStream refreshToken = new FileInputStream("C:\\Users\\emile\\IdeaProjects\\BoardGames\\src\\main\\resources\\token.json");

        GoogleCredentials credentials = GoogleCredentials.fromStream(refreshToken);
        FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
        //FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();

        // Add document data with id "test"
        Map<String, Object> data = new HashMap<>();
        data.put("Email", newUser.email);
        data.put("UserName", newUser.username);
        data.put("Password", newUser.password);
        data.put("Mode", newUser.type);

        ApiFuture<WriteResult> res = db.collection("users").document(newUser.username).set(data);
        ApiFuture<QuerySnapshot> restodisplay = db.collection("users").get();
        System.out.println(restodisplay);

        if (newUser.type.equals("user")) {
            String requestUrl = request.getRequestURI();
            sendMail email = new sendMail(newUser.email, newUser.username, newUser.password);
            email.sendtheemail();
            ListUsers USERS = (ListUsers) request.getServletContext().getAttribute(CONTEXT_USERS);
            USERS.add(newUser);
            request.getRequestDispatcher("/LoggedPageAdmin.jsp").forward(request, response);
        }
        else {
            ListUsers USERS = (ListUsers) request.getServletContext().getAttribute(CONTEXT_USERS);
            USERS.add(newUser);
            request.getRequestDispatcher("/LoggedPageAdmin.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
