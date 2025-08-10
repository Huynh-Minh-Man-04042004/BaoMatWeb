import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String password = "doesnotreallymatter";
        String username = "Jerry";
        String passwordSaltStrong = "DeliberatelyInsecure1235";

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String salted = password + passwordSaltStrong + username;
            byte[] hash = md.digest(salted.getBytes(StandardCharsets.UTF_8));
            System.out.println(Base64.getEncoder().encodeToString(hash));
        } catch (Error e) {

        }

    }
}