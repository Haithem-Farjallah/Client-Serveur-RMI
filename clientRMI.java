import java.rmi.Naming; 
import java.util.Scanner; 

public class clientRMI { 
    public static void main(String[] args) { 
        try {
            StringOperations stringOperations = (StringOperations) Naming.lookup("rmi://localhost/StringOperations"); 
           
            Scanner scanner = new Scanner(System.in); 
            System.out.print("Entrez une chaîne : "); 
            String inputString = scanner.nextLine(); 
            String result = stringOperations.convertToUpper(inputString); 
            System.out.println("Résultat de la conversion : " + result); 
            scanner.close();
        } catch (Exception e) { 
            System.err.println("Erreur survenue lors de l'appel au serveur : " + e); 
        }
    }
}