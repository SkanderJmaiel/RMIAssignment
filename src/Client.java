import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;


public class Client {

    public static void main(String[] args) {
        try {
           MyInterface service = (MyInterface) Naming.lookup("rmi://127.0.0.1:1250/server");
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(System.in));
            String word = input.readLine();
            System.out.println("Reversed word : "+service.reverse(word));
            System.out.println("Lowest ASCII char : "+service.minChar(word));
            System.out.println("Word after change : "+service.caseChange(word));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
