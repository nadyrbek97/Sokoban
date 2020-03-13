import java.io.*;
import java.net.*;

/**
 * Client Server
 * connects to the Source Server
 * gets the last version of server levels
 * static function executes in Model() constructor
 */
public class Server {

    public synchronized static void getLevelsFromServer() {
        try {
            // path where files will be saved
            String levelDir = "src/levels";
            // socket with server ip and port
            Socket socket = new Socket("157.245.219.46", 4445);

            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            DataInputStream dis = new DataInputStream(bis);
            // get amount of files
            int filesCount = dis.readInt();
            File[] files = new File[filesCount];

            for(int i = 0; i < filesCount; i++) {
                // get single file length
                long fileLength = dis.readLong();
                // get file name
                String fileName = dis.readUTF();
                // create file
                files[i] = new File(levelDir + "/" + fileName);
                // open output streams
                FileOutputStream fos = new FileOutputStream(files[i]);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                // write file context
                for(int j = 0; j < fileLength; j++) bos.write(bis.read());
                // close stream
                bos.close();
            }

            dis.close();

        } catch (ConnectException e) {
            System.out.println(e);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}