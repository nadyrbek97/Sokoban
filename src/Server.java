import java.io.*;
import java.net.*;

public class Server{
    static Socket socket = null;
    static int maxsize = 999999999;
    static int byteread;
    static int current = 0;
    public static void main(String[] args) throws FileNotFoundException, IOException{
        byte[] buffer = new byte[maxsize];
        Socket socket = new Socket("157.245.219.46", 4448);
        InputStream is = socket.getInputStream();
        File test = new File("/home/nadyrbek/development/Sokoban/src/levels/levelFromServer.soc");
        test.createNewFile();
        FileOutputStream fos = new FileOutputStream(test);
        BufferedOutputStream out = new BufferedOutputStream(fos);
        byteread = is.read(buffer, 0, buffer.length);
        current = byteread;

        while ((byteread = is.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, byteread);
        }
        out.flush();

        socket.close();
        fos.close();
        is.close();

    }
}