import java.lang.ref.Cleaner;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteObjectImpl extends UnicastRemoteObject implements RemoteObjectInterface {
    private static final Cleaner cleaner = Cleaner.create();

    private final Cleaner.Cleanable cleanable;
    private boolean isResourceOpen;

    public RemoteObjectImpl() throws RemoteException {
        super();
        this.isResourceOpen = true;
        System.out.println("RemoteObjectImpl created. Resource opened.");

        cleanable = cleaner.register(this, () -> cleanup());
    }

    private void cleanup() {
        if (isResourceOpen) {
            System.out.println("Cleaning up resources for RemoteObjectImpl...");
            isResourceOpen = false;
        }
    }

    public String sayHello() throws RemoteException {
        return "Hello from RemoteObjectImpl!";
    }
}