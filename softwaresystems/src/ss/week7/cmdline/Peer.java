package ss.week7.cmdline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Peer for a simple client-server application
 * @author  Theo Ruys
 * @version 2005.02.21
 */

public class Peer implements Runnable {
    public static final String EXIT = "exit";

    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected BufferedWriter out;
    Scanner s1 = new Scanner(System.in);
    Scanner s2;


    /*@
       requires (nameArg != null) && (sockArg != null);
     */
    /**
     * Constructor. creates a peer object based in the given parameters.
     * @param   nameArg name of the Peer-process
     * @param   sockArg Socket of the Peer-process
     */
    public Peer(String nameArg, Socket sockArg) throws IOException
    {
    	this.name = nameArg;
    	this.sock = sockArg;
    	InputStream input = sock.getInputStream();
    	this.in = new BufferedReader(new InputStreamReader(input));
    	this.out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
    	s2 = new Scanner(input);
    }

    /**
     * Reads strings of the stream of the socket-connection and
     * writes the characters to the default output.
     */
    public void run() {
    	if (in != null) {
    		//in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			//s2 = new Scanner(sock.getInputStream());
			while(s2.hasNextLine()) {
				System.out.println(s2.nextLine());
			}
    	}
    }

    /**
     * Reads a string from the console and sends this string over
     * the socket-connection to the Peer process.
     * On Peer.EXIT the method ends
     * @throws IOException 
     */
    public void handleTerminalInput() throws IOException {
    	try {
    		String msg = readString("> ");
    		while (msg != null && !msg.equals(Peer.EXIT)) {
    			out.write(getName() + ": " + msg);
    			out.newLine();
    			out.flush();
    			msg = readString("> ");
    		}
    		shutDown();
    	} catch (IOException e) {
    		shutDown();
    	}
    }

    /**
     * Closes the connection, the sockets will be terminated
     * @throws IOException 
     */
    public void shutDown() {
    	try {
    		this.sock.close();
    	} catch (NullPointerException e) {
    		System.out.print("Closed");
    		System.exit(0);
    		

    	} catch (IOException e) {
    		System.out.println("The streams and socket couldn't be closed!");
    		e.printStackTrace();
    	}
    	
    	
    }

    /**  returns name of the peer object*/
    public String getName() {
        return name;
    }

    /** read a line from the default input */
    static public String readString(String tekst) {
        System.out.print(tekst);
        String antw = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            antw = in.readLine();
        } catch (IOException e) {
        }

        return (antw == null) ? "" : antw;
    }
}
