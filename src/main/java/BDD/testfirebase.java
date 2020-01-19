package BDD;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;


public class testfirebase {
    // Use the application default credentials
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        FileInputStream refreshToken = new FileInputStream("C:\\Users\\emile\\IdeaProjects\\BoardGames\\src\\main\\java\\boardgames-6813a-firebase-adminsdk-vvivt-657fd5ca31.json");

        GoogleCredentials credentials = GoogleCredentials.fromStream(refreshToken);
        FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
        FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();

        // Add document data with id "test"
        Map<String, Object> data = new HashMap<>();
        data.put("Name", "Emile");
        data.put("LastName", "Dadou");
        data.put("Username", "EmileDadou");
        data.put("Password", "test");
        //db.collection("FirstTest").document("Test1").set(data);
        ApiFuture<WriteResult> res = db.collection("test").document("EmileDadou").set(data);
        System.out.print("Update time : " + res.get().getUpdateTime());


        // Read data test
        DocumentReference docref = db.collection("users").document("user1");
        ApiFuture<DocumentSnapshot> future = docref.get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            System.out.println("Document Data: " + document.getData().get("LastName"));
        }
        else {
            System.out.println("No document");
        }
    }

}
