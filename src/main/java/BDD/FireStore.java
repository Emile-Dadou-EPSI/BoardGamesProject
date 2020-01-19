package BDD;

import Sessions.Session;
import Users.User;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class FireStore {

    public FireStore() {
        super();
    }

    public static User getUserName(String user) throws IOException, ExecutionException, InterruptedException { // from a user document BattLionel (ex)  and get the field username
        Boolean isInit = false;
        User usertofind = new User();
        FirebaseApp iniApp;
        FileInputStream refreshToken = new FileInputStream("C:\\Users\\emile\\IdeaProjects\\BoardGames\\src\\main\\resources\\token.json");

        GoogleCredentials credentials = GoogleCredentials.fromStream(refreshToken);
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

        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docref = db.collection("users").document(user);
        ApiFuture<DocumentSnapshot> future = docref.get();
        DocumentSnapshot document = future.get();


        if (document.exists()) {
            usertofind.email = document.getData().get("Email").toString();
            usertofind.username = document.getData().get("UserName").toString();
            usertofind.password = document.getData().get("Password").toString();
            usertofind.type = document.getData().get("Mode").toString();
        }
        return usertofind;
    }

    public List<Session> getSessions() throws IOException, ExecutionException, InterruptedException, ParseException {
        Boolean isInit = false;
        FirebaseApp iniApp;
        FileInputStream refreshToken = new FileInputStream("C:\\Users\\emile\\IdeaProjects\\BoardGames\\src\\main\\resources\\token.json");

        GoogleCredentials credentials = GoogleCredentials.fromStream(refreshToken);
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

        List<Session> sessions = new ArrayList<>();

        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection("sessions").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot doc : documents) {
            String date = doc.getData().get("Date").toString();
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            System.out.println(date1);
            sessions.add(new Session(doc.getData().get("ID").toString(), date1, doc.getData().get("HeureDebut").toString(), doc.getData().get("HeureFin").toString()));
        }


        return null;
    }

}
