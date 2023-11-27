import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {

    double plus(double val_0, double val_1) throws RemoteException;

    double minus(double val_0, double val_1) throws RemoteException;

    double divide(double val_0, double val_1) throws RemoteException;

    double multiply(double val_0, double val_1) throws RemoteException;
}