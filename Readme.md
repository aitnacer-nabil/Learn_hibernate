@Entity(name)
used for creating JPQL
@Table(name)
used for creating Native Query
# Hibernate 
Hibernate est un framework de persistance open-source pour Java qui simplifie l'interaction avec les bases de données relationnelles. Il offre une couche d'abstraction entre l'application Java et la base de données, facilitant le stockage et la récupération des objets Java dans la base de données.

# Transaction :
Une transaction représente une séquence d'opérations exécutées comme une seule unité atomique. En Hibernate, les transactions sont utilisées pour garantir la cohérence des données en assurant que toutes les opérations sont exécutées avec succès ou aucune ne l'est.

# SessionFactory : 
La SessionFactory est un objet dans Hibernate qui permet de créer des objets Session. Elle est généralement configurée une seule fois au démarrage de l'application et est responsable de la création de sessions Hibernate.

# EntityManager : 
En relation avec JPA (Java Persistence API), l'EntityManager est une interface utilisée pour effectuer des opérations de persistance, telles que le stockage, la mise à jour et la suppression d'entités dans la base de données.

# @Entity : 
Cette annotation est utilisée pour indiquer à Hibernate que la classe Java est une entité persistante, ce qui signifie qu'elle est associée à une table dans la base de données.

# @Table :
L'annotation @Table est utilisée pour spécifier le nom de la table associée à une entité. Elle peut également être utilisée pour spécifier d'autres propriétés de la table, telles que le schéma auquel elle appartient.
# @Id
@Id en Java indique que la propriété à laquelle elle est appliquée représente l'identifiant unique d'une entité
# Generation Strategies 
## AUTO 
La stratégie AUTO permet au système de base de données de choisir automatiquement la méthode de génération appropriée en fonction des capacités de la base de données
## IDENTITY
La stratégie IDENTITY utilise les colonnes d'identité de la base de données pour générer automatiquement les valeurs des clés primaires lors de l'insertion d'un nouvel enregistrement
## SEQUENCE
 La stratégie SEQUENCE utilise une séquence (une structure interne de la base de données) pour générer des valeurs de clés primaires. Elle est souvent utilisée dans les bases de données telles qu'Oracle.
## TABLE
La stratégie TABLE utilise une table spéciale dans la base de données pour stocker et générer les valeurs des clés primaires. 
# @Column
@Column en Java est utilisée dans le contexte de la persistance des données pour mapper une propriété d'une classe à une colonne spécifique dans une table de base de données. Elle permet de définir des propriétés spécifiques de la colonne, telles que son nom, sa longueur, sa nullability, etc.
# @Temporal
-- Pour old Java Api and for new api use localDate
en Java est utilisée dans le contexte de la persistance des données pour spécifier le type de données temporelles d'une propriété date ou heure dans une classe
pour indiquer si la propriété doit être traitée comme une date (TemporalType.DATE), une heure (TemporalType.TIME), ou une combinaison de date et heure (TemporalType.TIMESTAMP)
# @Transient
****Ignorer une propriété spécifique lors de la persistance dans la base de données.****
