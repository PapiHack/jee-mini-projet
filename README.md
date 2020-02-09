# Mini projet - App de gestion de clientelle  

Mini projet consistant à créer une application basique de gestion des clients (CRUD sur les clients). 
Ce projet devait être réalisé avec `Java EE` ainsi que les technologies `JSTL, JSP`, plus une interaction avec une base de donnée `MySQL` via `JDBC`.

## Architecture du projet  

Pour une meilleur organisation, j'ai découpé l'appplication en packages ou couches effectuant des tâches bien scpécifiques :  

- `meissa.beans`  
Contient les beans ou entités également appelé classe métier de l'application.  

- `meissa.managers`  
Correspond à la couche `DAO` de l'application et contient les classes permettant de persister les entités (beans) correspondant en base de donnée.  

- `meissa.metier`  
Correspond à la couche métier et contient dans notre cas une classe permettant de vérifier la validité des données des entitiés.  

- `meissa.servlets`  
Contient les servlets de l'application et font office de controller. Ce package correspond à la couche `Controller`.  

## Notes  

A la racine du projet se trouve un script sql nommé `create_client.script.sql` permettant de créer une base de donnée `gestion_client` ainsi qu'une table `client` permettant de stocker les informations des différents client.

### Entrée de l'application  

Aprés avoir lancé le script permettant de mettre en place la base de donnée et démarré l'application, vous vous rendrez au niveau de l'url suivante afin d'accéder à cette dernière :  
`http://localhost:8080/gestionClient/home`
