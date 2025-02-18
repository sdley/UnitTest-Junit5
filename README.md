# TD1 : Tests Unitaires avec JUnit 5

## Objectifs pédagogiques :

- Apprendre à écrire et exécuter des tests unitaires avec JUnit 5.
- Comprendre les concepts de base des tests unitaires, y compris les annotations et les assertions.
- Améliorer la qualité du code en introduisant des tests automatisés.

## Notes

### Notion de classe utilitaire (Utility Class)
Une classe utilitaire est une classe qui contient uniquement des méthodes statiques et ne stocke aucun état. 
Son but est d'offrir des fonctionnalités réutilisables sans nécessiter l'instanciation de la classe.
Ce qui justifie que ListeUtil n'a pas d'attributs !

Dans notre cas, ListeUtil fournit une méthode statique pour ajouter un élément à une liste :

```java
public static void ajouterElement(List<String> list, String element) {
    if (list == null) {
        throw new IllegalArgumentException("La liste ne peut pas être null.");
    }
    list.add(element);
}
```
#### 📌 Pourquoi cette méthode est static ?

Elle ne dépend pas d'un état interne de ListeUtil.
Elle ne stocke rien : elle agit simplement sur une liste passée en paramètre.
Cela permet d'appeler la méthode directement avec ListeUtil.ajouterElement(...) sans créer d'objet.

#### Quand utiliser une classe avec des attributs ?
Si nous devions stocker une liste interne, nous aurions besoin d'un attribut et d'une instance de classe :

```java
public class ListeUtil {
    private List<String> elements = new ArrayList<>();

    public void ajouterElement(String element) {
        elements.add(element);
    }

    public List<String> getElements() {
        return elements;
    }
}
```

##### 📌 Différence :

- Ici, ListeUtil stocke un état avec l'attribut elements.
- On doit créer un objet pour utiliser cette classe :
```java
ListeUtil liste = new ListeUtil();
liste.ajouterElement("Test");
```

🔴 Dans notre cas, ce n'est pas nécessaire car nous voulons juste ajouter un élément à une liste existante, pas stocker une liste.

#### Résumé : Quand utiliser des attributs ?

| Cas | Attributs nécessaires ? | Exemples |
| --- | :-------------------: | --- |
| Classe utilitaire (méthodes statiques) | X Non | Math, Collections, Files |
| Classe avec un état interne | ✓ Oui | ArrayList, HashMap, Personne |

Dans notre cas, ListeUtil est une classe utilitaire, donc elle n'a pas besoin d'attributs ! 🚀✅

### Notion de HashMap
Un HashMap est une implémentation de la structure de données table de hachage en Java, 
qui permet de stocker des paires clé-valeur. Il fait partie du package java.util et est souvent utilisé pour associer une clé unique à une valeur.

#### 1. Déclaration d'un HashMap
Pour utiliser un HashMap, on doit d'abord l'importer :
```java
import java.util.HashMap;
import java.util.Map; // Interface Map
```
Puis, on peut déclarer un HashMap :
```java
// Création d'un HashMap qui associe un ID (String) à un Utilisateur
Map<String, Utilisateur> utilisateurs = new HashMap<>();
```

#### 2. Opérations de base sur un HashMap
Voici le tableau converti en format Markdown :

| Opération | Méthode | Description |
| --- | --- | --- |
| Ajouter un élément | `put(K key, V value)` | Associe une clé à une valeur. |
| Obtenir une valeur | `get(K key)` | Retourne la valeur associée à la clé. |
| Vérifier l'existence d'une clé | `containsKey(K key)` | Retourne `true` si la clé existe. |
| Vérifier l'existence d'une valeur | `containsValue(V value)` | Retourne `true` si la valeur existe. |
| Supprimer une entrée | `remove(K key)` | Supprime la clé et sa valeur associée. |
| Obtenir la taille | `size()` | Retourne le nombre d'éléments. |
| Vérifier si vide | `isEmpty()` | Retourne `true` si la map est vide. |

#### 3. Exemple d'utilisation
Voici un exemple où on stocke et manipule des utilisateurs dans un HashMap :
```java
import java.util.HashMap;
import java.util.Map;

public class GestionUtilisateurs {
    public static void main(String[] args) {
        // Création d'un HashMap pour stocker des utilisateurs
        Map<String, String> utilisateurs = new HashMap<>();

        // Ajout d'utilisateurs (clé = ID, valeur = nom)
        utilisateurs.put("U123", "Mamadou Diop");
        utilisateurs.put("U456", "Aissatou Fall");
        utilisateurs.put("U789", "Cheikh Ndiaye");

        // Récupérer un utilisateur
        System.out.println("Nom de l'utilisateur U123 : " + utilisateurs.get("U123"));

        // Vérifier si un utilisateur existe
        if (utilisateurs.containsKey("U456")) {
            System.out.println("L'utilisateur avec l'ID U456 existe !");
        }

        // Supprimer un utilisateur
        utilisateurs.remove("U789");

        // Afficher tous les utilisateurs restants
        System.out.println("Utilisateurs restants : " + utilisateurs);
    }
}
```
##### 📌 Résultat attendu :
```
Nom de l'utilisateur U123 : Mamadou Diop
L'utilisateur avec l'ID U456 existe !
Utilisateurs restants : {U123=Mamadou Diop, U456=Aissatou Fall}
```
#### 4. Quand utiliser un HashMap ?
✅ Quand on veut stocker et retrouver des données rapidement à l'aide d'une clé unique.<br>
✅ Quand l'ordre d'insertion n'est pas important.<br>
✅ Quand on a besoin d'associer des informations sous forme de clé-valeur.<br>

🚀 Exemple d'application :

- Associer un identifiant (ID) à un utilisateur.
- Associer un numéro de produit à son prix.
- Stocker des paramètres de configuration d'un système.

#### 5. Différences entre HashMap et TreeMap / LinkedHashMap

Voici le tableau converti en format Markdown :

| Type de Map | Ordre de stockage | Performance (recherche) | Cas d'utilisation |
| --- | --- | --- | --- |
| HashMap | Pas d'ordre garanti | Très rapide (O(1)) | Stocker rapidement des éléments avec des clés uniques. |
| TreeMap | Trie les clés | Moins rapide (O(log n)) | Stocker des éléments triés par clé. |
| LinkedHashMap | Conserve l'ordre d'insertion | Rapide (O(1)) | Besoin de conserver l'ordre d'ajout. |

🔴 HashMap est le plus rapide pour les recherches, mais n'offre pas de garantie sur l'ordre des éléments.<br>

Un HashMap est une structure de données très efficace pour associer des clés et des valeurs, et permet d'accéder rapidement aux données. 🚀

### Notion de Singleton 
Un Singleton est un design pattern qui garantit qu'une seule instance d'une classe est créée et fournit un point d'accès global à cette instance.


