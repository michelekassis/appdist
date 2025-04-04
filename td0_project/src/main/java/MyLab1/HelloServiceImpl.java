package MyLab1;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void sayHello(HelloRequest request, 
                        StreamObserver<HelloResponse> responseObserver) {
        // 1. Process the request
        String greeting = request.getGreeting();
        
        // 2. Create response
        HelloResponse response = HelloResponse.newBuilder()
            .setReply("Hello, " + greeting + "!")
            .build();
        
        // 3. Send response
        responseObserver.onNext(response);
        
        // 4. Complete the call
        responseObserver.onCompleted();
    }
}