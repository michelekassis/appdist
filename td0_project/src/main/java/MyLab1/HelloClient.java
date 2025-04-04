package MyLab1;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient {
    public static void main(String[] args) {
        // 1. Create channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
            .usePlaintext() // For testing only!
            .build();
        
        // 2. Create stub
        HelloServiceGrpc.HelloServiceBlockingStub stub = 
            HelloServiceGrpc.newBlockingStub(channel);
        
        // 3. Create request
        HelloRequest request = HelloRequest.newBuilder()
            .setGreeting("gRPC Student")
            .build();
        
        // 4. Make RPC call
        HelloResponse response = stub.sayHello(request);
        
        // 5. Process response
        System.out.println("Server replied: " + response.getReply());
        
        // 6. Shutdown channel
        channel.shutdown();
    }
}