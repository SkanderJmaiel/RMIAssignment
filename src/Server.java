import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements MyInterface {

    public Server() throws RemoteException {}

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);
    }

    @Override
    public String reverse(String word) {
        String reversedWord="";
        for(int i=word.length()-1 ; i>=0; i--)
        {
            reversedWord+=word.charAt(i);
        }
        return reversedWord;
    }

    @Override
    public String minChar(String word) {
        char min = word.charAt(0);

        for(int i=1 ; i<word.length();i++)
        {
            if (min>word.charAt(i)) min=word.charAt(i);
        }
        return Character.toString(min);
    }

    @Override
    public String caseChange(String word) {
        String changedWord="";
        for(int i=0;i<word.length();i++)
        {
            if(Character.isLowerCase(word.charAt(i))) changedWord+=Character.toUpperCase(word.charAt(i));
            else if (Character.isUpperCase(word.charAt(i))) changedWord+=Character.toLowerCase((word.charAt(i)));
            else changedWord+=word.charAt(i);
        }
        return changedWord;
    }
}
