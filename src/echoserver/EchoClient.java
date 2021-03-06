package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {
    
  public static final int portNumber = 6013;

    public static void main(String[] args) throws IOException {
        
      String server;
        // Use "127.0.0.1", i.e., localhost, if no server is specified.
      if (args.length == 0) {
            
          server = "127.0.0.1";
        
      }
      
      else {
            
          server = args[0];
        
      }

        try {
            // Connect to the server
            Socket socket = new Socket(server, portNumber);

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
          
            int kByte;
            int oByte;
          
            // Read the incoming data from the server.
          
            while ((kByte = System.in.read()) != -1) {
            
              // Print the data that have been read from the server
              
              output.write(kByte);
              output.flush();
              
              oByte = input.read();
              
              System.out.write(oByte);
              
            }
          
            // Make sure any remaining bytes are written out.
          
            System.out.flush();
          
            // Close the socket after reading from it.
          
            socket.close();
          
        }
      
        // Error handling.
        
        catch (ConnectException ce) {
            
          System.out.println("We were unable to connect to " + server);
          System.out.println("You should make sure the server is running.");
        
        }
        
        catch (IOException ioe) {
            
          System.out.println("We caught an unexpected exception");
          System.err.println(ioe);
        
        }
    }
}
