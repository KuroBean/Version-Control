// Import the File class
import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Blob {
	public Blob(String fileName) throws IOException {
		File myFile = new File(fileName);
		System.out.println(myFile.exists());
		BufferedReader reader = new BufferedReader(new FileReader(myFile));
		System.out.println(myFile.getName());
		
		String sha1Name=encryptThisString(myFile.getName());
		
		//creates new file in objects folder
		File newFile = new File("/Users/kensukeshimojo/eclipse-workspace/Prerequisites/tests/objects/"+sha1Name+".txt");
		newFile.getParentFile().mkdirs(); 
		newFile.createNewFile();
		/**
		if (!newFile.exists()){
			newFile.mkdirs();
		}*/
		//PrintWriter writer=new PrintWriter(newFile);
		
		
	}
	
	public static String encryptThisString(String input)//from geeksforgeeks
    {
    try {
        // getInstance() method is called with algorithm SHA-1
        MessageDigest md = MessageDigest.getInstance("SHA-1");

        // digest() method is called
        // to calculate message digest of the input string
        // returned as array of byte
        byte[] messageDigest = md.digest(input.getBytes());

        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, messageDigest);

        // Convert message digest into hex value
        String hashtext = no.toString(16);

        // Add preceding 0s to make it 32 bit
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }

        // return the HashText
        return hashtext;
    }

    // For specifying wrong message digest algorithms
    catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
}
}