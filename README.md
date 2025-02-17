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

