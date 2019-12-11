import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredential;

import java.io.FileInputStream;
import java.io.IOException;

public class testfirebase {
    // Use the application default credentials
    private static void main(String[] args) throws IOException {
        FileInputStream refreshToken = new FileInputStream("path");

        FirebaseOptions options = new FirebaseOptions.Builder().setCredential((FirebaseCredential) GoogleCredential.fromStream(refreshToken)).setDatabaseUrl("https://<BDD_NAME>.firebaseio.com/").build();

        FirebaseApp.initializeApp(options);
    }
}
