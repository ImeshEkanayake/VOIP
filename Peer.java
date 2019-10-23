import java.util.*;
import java.io.IOException;

public abstract class PeerUnit implements Runnable{

  public static void main(String[] args){
    //Create the server Thread 
    Thread serverT = new Thread(new UDPServer());
    serverT.start();// start the server thread
    //Create the client Thread
    Thread clientT=new Thread(new UDPClient());
    clientT.start();// start the client thead
  }
}
