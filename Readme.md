@Entity(name)
used for creating JPQL
@Table(name)
used for creating Native Query

# Hibernate

Hibernate est un framework de persistance open-source pour Java qui simplifie l'interaction avec les bases de données
relationnelles. Il offre une couche d'abstraction entre l'application Java et la base de données, facilitant le stockage
et la récupération des objets Java dans la base de données.

# Transaction :

Une transaction représente une séquence d'opérations exécutées comme une seule unité atomique. En Hibernate, les
transactions sont utilisées pour garantir la cohérence des données en assurant que toutes les opérations sont exécutées
avec succès ou aucune ne l'est.

# SessionFactory :

La SessionFactory est un objet dans Hibernate qui permet de créer des objets Session. Elle est généralement configurée
une seule fois au démarrage de l'application et est responsable de la création de sessions Hibernate.

# EntityManager :

En relation avec JPA (Java Persistence API), l'EntityManager est une interface utilisée pour effectuer des opérations de
persistance, telles que le stockage, la mise à jour et la suppression d'entités dans la base de données.

# @Entity :

Cette annotation est utilisée pour indiquer à Hibernate que la classe Java est une entité persistante, ce qui signifie
qu'elle est associée à une table dans la base de données.

# @Table :

L'annotation @Table est utilisée pour spécifier le nom de la table associée à une entité. Elle peut également être
utilisée pour spécifier d'autres propriétés de la table, telles que le schéma auquel elle appartient.

# @Id

@Id en Java indique que la propriété à laquelle elle est appliquée représente l'identifiant unique d'une entité

# Generation Strategies

## AUTO

La stratégie AUTO permet au système de base de données de choisir automatiquement la méthode de génération appropriée en
fonction des capacités de la base de données

## IDENTITY

La stratégie IDENTITY utilise les colonnes d'identité de la base de données pour générer automatiquement les valeurs des
clés primaires lors de l'insertion d'un nouvel enregistrement

## SEQUENCE

La stratégie SEQUENCE utilise une séquence (une structure interne de la base de données) pour générer des valeurs de
clés primaires. Elle est souvent utilisée dans les bases de données telles qu'Oracle.

## TABLE

La stratégie TABLE utilise une table spéciale dans la base de données pour stocker et générer les valeurs des clés
primaires.

# @Column

@Column en Java est utilisée dans le contexte de la persistance des données pour mapper une propriété d'une classe à une
colonne spécifique dans une table de base de données. Elle permet de définir des propriétés spécifiques de la colonne,
telles que son nom, sa longueur, sa nullability, etc.

# @Temporal

-- Pour old Java Api and for new api use localDate
en Java est utilisée dans le contexte de la persistance des données pour spécifier le type de données temporelles d'une
propriété date ou heure dans une classe
pour indiquer si la propriété doit être traitée comme une date (TemporalType.DATE), une heure (TemporalType.TIME), ou
une combinaison de date et heure (TemporalType.TIMESTAMP)

# @Transient

****Ignorer une propriété spécifique lors de la persistance dans la base de données.****

## Entity Lifecycle

* ### Transient :

  is outside of persistence context
  em.persist()
    * Correspond à un état où l'entité est en dehors du contexte de persistance.
    * Se produit lorsqu'une entité est nouvellement créée et n'est pas encore associée à une session de persistance.
    * L'ajout à la base de données nécessite l'utilisation de la méthode


* ###  Managed/persisted

is inside persistence Context when commit it save id database
em.detach()
em.close()
* Correspond à un état où l'entité est à l'intérieur du contexte de persistance.
* Se produit après l'utilisation de em.persist(), lorsque l'entité est enregistrée dans la base de données lors de la
transaction.
* Pour détacher une entité du contexte de persistance, on peut utiliser em.detach() ou em.close().

* ### Detached

  remove from persistence context have recode in database and primary key
  em.merge() return detached object to persistence context
    * Correspond à un état où l'entité n'est plus dans le contexte de persistance.
    * Peut se produire lorsque la session de persistance est fermée ou lorsque l'entité est explicitement détachée avec
      em.detach().
    * Pour réattacher une entité détachée au contexte de persistance, on peut utiliser em.merge(). Cela ramène l'objet
      détaché dans le contexte de persistance tout en maintenant son identifiant et ses enregistrements en base de
      données.


* ### Remove

    * Correspond à un état où l'entité est marquée pour suppression.
  * Se produit lorsque em.remove() est utilisé pour programmer la suppression d'une entité lors de la prochaine transaction

## em.persist()
on indique au gestionnaire d'entités (EntityManager) de prendre en charge l'entité spécifiée et de la considérer comme devant être persistée. Cependant, il est important de noter que cette méthode ne déclenche pas immédiatement l'insertion dans la base de données ; elle prépare plutôt l'entité à être persistée lorsqu'une transaction est confirmée.
`Utilisateur utilisateur = new Utilisateur();
// Initialiser les propriétés de l'utilisateur...

EntityManager em = // obtenir le gestionnaire d'entités
em.getTransaction().begin();

// Utilisation de persist pour rendre l'entité gérée
em.persist(utilisateur);

em.getTransaction().commit();`
Dans cet exemple, utilisateur est rendu géré/persisté dans le contexte de persistance après l'appel à em.persist(). L'enregistrement effectif dans la base de données se produit lors de l'appel à em.getTransaction().commit().

## find(class Entity,primary id)
in first time to retrieve object  is gonna   make hit immediately to database and put retrieve record to 
persistent context
Elle est utilisée pour récupérer une entité à partir de la base de données en fonction de sa classe et de sa clé primaire (identifiant). La méthode find renvoie l'entité correspondante si elle existe, sinon elle renvoie null.


## getReference()
only when u want information about an object or entity it'll make a  hit to database
La méthode getReference est également une méthode de l'interface EntityManager et est utilisée pour obtenir une référence (proxy) à une entité à partir de la base de données. Contrairement à find, getReference ne déclenche pas immédiatement une requête à la base de données. Elle renvoie plutôt une référence "proxy" à l'entité, et la requête effective à la base de données n'est déclenchée que lorsque des méthodes spécifiques sont appelées sur cette référence. Si l'entité n'existe pas en base de données, une exception peut être levée lors de l'accès aux propriétés de l'entité.

### Differences :
* La principale différence réside dans le moment où la requête est effectuée : find effectue une requête immédiatement, tandis que getReference retarde la requête jusqu'à ce qu'une méthode sur la référence soit appelée.
* find renvoie l'entité elle-même ou null si elle n'est pas trouvée, tandis que getReference renvoie une référence "proxy" à l'entité.
* find peut retourner null pour une entité inexistante, tandis que getReference peut provoquer une exception lorsqu'une méthode est appelée sur une référence proxy pour une entité inexistante.


# merge
![merge_problem.png](images%2Fmerge_problem.png)

Le problème avec la fusion est que lorsqu'une entité est détachée et qu'il y a une autre entité dans le contexte de persistance avec la même clé primaire, un conflit se produira si nous effectuons une fusion.
La fusion prend une copie de l'état modifié de l'entité et modifie l'entité à l'intérieur du contexte de persistance. Toutes les modifications qui se produisent en dehors du contexte de persistance, telles que la détacher, ne seront pas enregistrées dans la base de données ou le contexte de persistance.
merge can do insert and update
# remove
Quand Hibernate voit une entité avec une clé primaire nulle, il sait qu'elle n'existe pas dans la base de données. Ainsi, il n'effectuera pas de suppression


