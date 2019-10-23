import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.*;

public class UDPClient implements Runnable {

  @Override
  public void run(){

    try {
      MulticastSocket socket=new MulticastSocket(8000);
      InetAddress group = InetAddress.getByName("240.0.0.192");

      Session peer = new Session(socket, group);
      AudioSession audio = new AudioSession(peer);
      socket.joinGroup(group);

      audio.captureAudio();
      audio.play();

      socket.leaveGroup(group);
      socket.close();

    }catch(IOException ex){
      ex.printStackTrace();
    }
  }
}
