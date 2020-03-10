import java.net.*;
import java.io.*;

public class SourceServer {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(9090);
        } catch (IOException e) {
            System.out.println(e);
        }
        // list of File objects
        File[] files = new File("/home/nadyrbek/development/examples/socketJava/server/levels").listFiles();

        while (true) {
            try {
                // wait for connection
                Socket socket = serverSocket.accept();
                // create output stream
                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
                DataOutputStream dos = new DataOutputStream(bos);
                // send amount of files
                dos.writeInt(files.length);
                for (File file : files) {
                    // send single file length
                    long length = file.length();
                    dos.writeLong(length);
                    // send file name
                    String name = file.getName();
                    dos.writeUTF(name);
                    // open input streams
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    // send file context
                    int theByte = 0;
                    while ((theByte = bis.read()) != -1) bos.write(theByte);
                    bis.close();
                }
                // close connection
                dos.close();
                socket.close();

            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }
}
