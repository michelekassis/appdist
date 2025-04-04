package MyLab1;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class HelloServer {
    public static void main(String[] args) throws Exception {
        // 1. Create server instance
        Server server = ServerBuilder.forPort(50051)
            .addService(new HelloServiceImpl())
            .build();
        
        // 2. Start the server
        server.start();
        System.out.println("Server running on port 50051");
        
        // 3. Keep it running
        server.awaitTermination();
    }
}