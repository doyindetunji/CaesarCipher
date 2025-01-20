import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PasswordHasher {
    public static void main(String[] args) {
        //create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the password you will like to hash:");
        String password = scanner.nextLine();

        //Hash the password
        String hashedPassword = hashPassword(password);

        //Display the Hash
        if (hashedPassword != null) {
            System.out.println("SHA-256-Hash:" +hashedPassword);
        } else {
            System.out.println("Error hashing your password.");
        }

        scanner.close();
    }

    //Sha-256 hash Method
    public static String hashPassword(String password) {
        try {
            //MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            //make hash a byte array
            byte[] hashBytes = digest.digest(password.getBytes());

            //convert byte array to hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() ==1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-256 Algorithm not found!");
            return null;
        }
        
    }
}
