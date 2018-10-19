package echoserver;
import java.net.*;
import java.io.*;

public class EchoServer {
  
    public static final int portNumber = 6013;

    public static void main (String[] args) {
        
      try {
            
        // Start listening on the specified port.

        ServerSocket sock = new ServerSocket(portNumber);

        // Run forever, which is common for server style services.
        
        while (true) {
                
          // Wait until someone connects.
                
          Socket client = sock.accept();
          System.out.println("Got a request!");

          InputStream input = client.getInputStream();
          OutputStream output = client.getOutputStream();

          int newByte;

          // Read data from the client and then send it back to the client.
          
          while ((newByte = input.read()) != -1) {
                  
            output.write(newByte);
            
          }
                
          // Close the client.
          
          client.shutdownOutput();
          
        }
        
      }
     
      // Error handling.
     
      catch (IOException ioe) {
      
        System.out.println("We caught an unexpected exception");
        System.err.println(ioe);
    
      }
  }
}
