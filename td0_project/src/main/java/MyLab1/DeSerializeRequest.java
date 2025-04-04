package MyLab1;

import MyLab1.HelloRequest;
import java.io.FileInputStream;

public class DeSerializeRequest {
    public static void main(String[] args) throws Exception {
        FileInputStream f=new FileInputStream("td1.ser");
        HelloRequest h = HelloRequest.parseFrom(f);
        System.out.println(h.getGreeting());

    }
}