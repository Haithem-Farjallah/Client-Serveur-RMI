// Importer les classes nécessaires pour RMI
import java.rmi.Remote; 
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

 // Définir une interface distante
interface StringOperations extends Remote {
    String convertToUpper(String str) throws RemoteException; // Méthode distante
}

// Implémentation de l'interface distante
class StringOperationsImpl extends UnicastRemoteObject implements StringOperations { 
    protected StringOperationsImpl() throws RemoteException { 
        super(); 
    }

    @Override
    public String convertToUpper(String str) throws RemoteException { 
        return str.toUpperCase(); 
    }
}

public class serveurRMI { 
    public static void main(String[] args) { 
        try {
           
            StringOperationsImpl stringOperations = new StringOperationsImpl();

           
            java.rmi.registry.LocateRegistry.createRegistry(1099); 
            java.rmi.Naming.rebind("StringOperations", stringOperations); 

            System.out.println("Serveur RMI prêt."); 
        } catch (Exception e) { 
            System.err.println("Erreur survenue lors du démarrage du serveur : " + e);
        }
    }
}