package Servlets;

import Sessions.ListSessions;
import Sessions.Session;
import Users.ListUsers;
import Users.User;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@WebServlet(name = "Servlets.InitServlet")
public class InitServlet extends HttpServlet {

    public static final String CONTEXT_SESSIONS = "CONTEXT_SESSIONS";
    public static final String CONTEXT_USERS = "CONTEXT_USERS";

    @Override
    public void init(ServletConfig config) throws ServletException{

        Boolean isInit = false;
        FirebaseApp iniApp;
        FileInputStream refreshToken = null;
        try {
            refreshToken = new FileInputStream("C:\\Users\\emile\\IdeaProjects\\BoardGames\\src\\main\\resources\\token.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        GoogleCredentials credentials = null;
        try {
            credentials = GoogleCredentials.fromStream(refreshToken);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
        for (FirebaseApp app : firebaseApps) {
            if(app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                isInit = true;
                iniApp = app;
            }
        }
        if (!isInit) {
            iniApp = FirebaseApp.initializeApp(options);
        }

        ListSessions sessions = new ListSessions();
        ListUsers users = new ListUsers();

        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> futureuser = db.collection("users").get();
        ApiFuture<QuerySnapshot> future = db.collection("sessions").get();
        List<QueryDocumentSnapshot> docsUsers = null;
        List<QueryDocumentSnapshot> documents = null;
        try {
            docsUsers = futureuser.get().getDocuments();
            documents = future.get().getDocuments();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        for (QueryDocumentSnapshot docuser : docsUsers) {
            String email = docuser.getData().get("Email").toString();
            String username = docuser.getData().get("UserName").toString();
            String password = docuser.getData().get("Password").toString();
            String mode = docuser.getData().get("Mode").toString();

            users.add(new User(email, username, password, mode));
        }

        for (QueryDocumentSnapshot doc : documents) {
            String date = doc.getData().get("Date").toString();
            Date date1 = null;
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(date1);
            Session session = new Session(doc.getData().get("ID").toString(), date1, doc.getData().get("HeureDebut").toString(), doc.getData().get("HeureFin").toString());
            //System.out.print(session.toString());
            sessions.add(session);
            System.out.print(" Session added");
        }
        config.getServletContext().setAttribute(CONTEXT_USERS, users);
        config.getServletContext().setAttribute(CONTEXT_SESSIONS, sessions);
        System.out.println("Config Loaded");
    }


}
