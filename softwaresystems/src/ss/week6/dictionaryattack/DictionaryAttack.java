package ss.week6.dictionaryattack;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.apache.commons.codec.binary.Hex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


public class DictionaryAttack {
	private Map<String, String> passwordMap = new HashMap<String, String>();
	private Map<String, String> hashDictionary = new HashMap<String, String>();
	private static final String PATH = "/Users/raalse/Programming/";

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled with the content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 * @throws IOException 
	 */
	public void readPasswords(String filename) throws IOException {
		String line;
		String[] elements;
		BufferedReader reader = new BufferedReader(new FileReader(PATH + filename));
		Scanner in = new Scanner(reader);
		while (in.hasNextLine()) {
			line = in.nextLine();
			elements = line.split(": ");
			hashDictionary.put(elements[0], elements[1]);
		}
		in.close();
		reader.close();
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public String getPasswordHash(String password) {
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] digest = m.digest(password.getBytes());
		return Hex.encodeHexString(digest);
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
        if (user == null || password == null) {
        	return false;
        }
        if (!hashDictionary.containsKey(user)) {
        	return false;
        }
        for (String key : hashDictionary.keySet()) {
            if (key.equals(user)) {
            	if (getPasswordHash(password).equals(hashDictionary.get(key))) {
            		return true;
            	} else {
            		return false;
            	}
            }
        }
		return false;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 * @throws IOException 
	 */
    public void addToHashDictionary(String filename) throws IOException {
    	String line;
		BufferedReader reader = new BufferedReader(new FileReader(PATH + filename));
		Scanner in = new Scanner(reader);
		while (in.hasNextLine()) {
			line = in.nextLine();
			passwordMap.put(getPasswordHash(line), line);
		}
		in.close();
		reader.close();
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		for (Entry<String, String> entry : hashDictionary.entrySet()) {
			if (passwordMap.containsKey(entry.getValue())) {
				for (String key : passwordMap.keySet()) {
					if (entry.getValue().equals(key)) {
						System.out.println(entry.getKey() + ": " + passwordMap.get(key));
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		DictionaryAttack da = new DictionaryAttack();
		da.addToHashDictionary("Dictionary.txt");
		da.readPasswords("LeakedPasswords.txt");
		da.doDictionaryAttack();
	}
}
//The average number of attempts to find a four letter lowercase password is: 228488