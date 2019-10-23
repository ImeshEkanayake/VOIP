import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class UDPServer implements Runnable{
public void run() {
  try{
    DatagramSocket socket = new DatagramSocket();
    int port = 8000;
    InetAddress ip = InetAddress.getByName("240.0.0.192");
    
    Session user = new Session(socket, ip, port);// initiate a session
    AudioSession audio = new AudioSession(user);//	create an audio session
    //capture and play audios
    audio.captureAudio();
    audio.capture();
    socket.close();//at the end of audio capturing 
  }
  catch(IOException ex){
    ex.printStackTrace();
  }

}
}
