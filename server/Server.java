import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Calculator {

    public Server() {
    }

    public static void main(String[] args) {

        try {

            Server server = new Server();
            Calculator calculator = (Calculator) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9400);
            registry.bind("Calculator", calculator);

            System.out.println("Server on");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public double plus(double val_0, double val_1) throws RemoteException {
        return val_0 + val_1;
    }

    @Override
    public double minus(double val_0, double val_1) throws RemoteException {
        return val_0 - val_1;
    }

    @Override
    public double divide(double val_0, double val_1) throws RemoteException {
        return val_0 / val_1;
    }

    @Override
    public double multiply(double val_0, double val_1) throws RemoteException {
        return val_0 * val_1;
    }

}
