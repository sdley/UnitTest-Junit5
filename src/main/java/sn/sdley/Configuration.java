package sn.sdley;

public class Configuration {
    // Instance unique de la classe
    private static Configuration instance;

    // Constructeur privé pour empêcher l'instanciation extérieure
    private Configuration() {
        System.out.println("Instance de Configuration créée !");
    }

    // Méthode d'accès à l'unique instance
    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration(); // Crée l'instance si elle n'existe pas
        }
        return instance;
    }
}
