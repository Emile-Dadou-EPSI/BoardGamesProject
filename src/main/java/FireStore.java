import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class FireStore {

    public FireStore() {
        super();
    }

    public User getUserName(String user) throws IOException, ExecutionException, InterruptedException { // from a user document BattLionel (ex)  and get the field username
        Boolean isInit = false;
        User usertofind = new User();
        FirebaseApp iniApp;
        FileInputStream refreshToken = new FileInputStream("C:\\Users\\emile\\IdeaProjects\\BoardGames\\src\\main\\java\\boardgames-6813a-firebase-adminsdk-vvivt-657fd5ca31.json");

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
            usertofind.username = document.getData().get("UserName").toString();
            usertofind.password = document.getData().get("Password").toString();
        }
        return usertofind;
    }

}
