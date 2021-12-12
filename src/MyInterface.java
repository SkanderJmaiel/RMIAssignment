import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {
    String reverse(String word)throws RemoteException;
    String minChar(String word)throws RemoteException;
    String caseChange(String word)throws RemoteException;

}
