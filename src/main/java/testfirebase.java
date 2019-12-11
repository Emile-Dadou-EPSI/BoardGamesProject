import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.io.IOException;

public class testfirebase {
    // Use the application default credentials
    public static void main(String[] args) throws IOException {
        FileInputStream refreshToken = new FileInputStream("C:\\Users\\emile\\IdeaProjects\\BoardGames\\src\\main\\java\\boardgames-6813a-firebase-adminsdk-vvivt-657fd5ca31.json");

        FirebaseOptions options = new FirebaseOptions.Builder().setCredential(FirebaseCredentials.fromRefreshToken(refreshToken)).build();

        FirebaseApp.initializeApp(options);

        FirebaseDatabase db;
       //db = new FirebaseDatabase('');
    }
}
