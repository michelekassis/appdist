package MyLab1;
import java.io.FileOutputStream;

public class SerializeRequest {
    public static void main(String[] args) throws Exception {
        HelloRequest request = HelloRequest.newBuilder()
            .setGreeting("youhou")
            .build();
        request.writeTo(new FileOutputStream("td1.ser"));
    }
}