package customTransport;
import java.rmi.server.RMISocketFactory;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

public class CustomTransport extends RMISocketFactory {
    @Override
    public Socket createSocket(String host, int port) throws IOException {
        System.out.println("Creating custom client socket...");
        return new Socket(host, port);
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        System.out.println("Creating custom server socket...");
        return new ServerSocket(port);
    }
}