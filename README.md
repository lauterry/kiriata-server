#sigi
_Maquette orientée service / sécurisation, ACL, rôles er SSO_

##Introduction
Le répertoire _sigi_ contient trois projets :
* _sigi-server_ : Provider OAUTH2.0. Joue le rôle de Resource Server et d'Authorization Server. Fournit des resources protégées accessibles par REST.
* _sigi-client_ : Application pour le Citoyen. Permet à ce dernier de déclarer un chien à la commune, de suivre leur statut et de déclarer un chien vendu par un autre citoyen.
. L'application joue le rôle de Client OAuth2.0.
* _sigi-client-fonct_ : Application pour le fonctionnaire. Permet à ce dernier de valider ou refuser les déclarations soumis par les citoyens.
L'application joue également le rôle de Client OAuth2.0

## Prérequis
Une serveur de base de donnée mysql avec une database et un user correspondant à ce qui est renseigné dans les [propertiers
du fichier sigi-server/pom.xml](https://github.com/Sfeir/sigi/blob/master/sigi-server/pom.xml#L19).

##Initialiser la base du projet sigi-server
* Satisfaire le prérequis
* ouvrir un terminal
* placez-vous à la racine de sigi-server
* exécuter les commandes maven
 * <code>mvn compile</code>
 * <code>mvn flyway:clean</code> si besoin pour supprimer les tables
 * <code>mvn flyway:init</code>
 * <code>mvn flyway:migrate</code>

##Démarrer _sigi-server_
Pour démarrer le serveur :
* ouvrir un terminal
* placez-vous à la racine du projet _sigi-server_
* exécuter la commande maven <code>mvn bees:run</code>

le lien [http://localhost:8080/sigi/admin] (http://localhost:8080/sigi/admin) permet de consulter les tokens Oauth actifs et de les révoker

##Démarrer _sigi-client_
Pour démarrer le server proxy et la partie client :
* ouvrir un terminal
* placer-vous à la racine du projet _sigi-client_
* exécuter la commande maven <code>mvn bees:run -Dbees.port=8000</code>
* ouvrir votre navigateur et ouvrir le lien [http://localhost:8000/] (http://localhost:8000/)
* La page de login doit s'afficher.
* Login : Citoyen1
* Mdp : 12345

##Démarrer _sigi-client-fonct_
Pour démarrer le server proxy et la partie client :
* ouvrir un terminal
* placer-vous à la racine du projet _sigi-client-fonct_
* exécuter la commande maven <code>mvn bees:run -Dbees.port=8001</code>
* ouvrir votre navigateur et ouvrir le lien [http://localhost:8001/] (http://localhost:8000/)
* La page de login doit s'afficher.
* Login : Fonctionnaire1
* Mdp : 12345

##Authentification et Authorisation
L'authentification et l'autorisation s'appuie sur l'extension OAUTH de Restlet 2.1 M7.
C'est la [draft v10 de OAUTH 2.0](http://tools.ietf.org/html/draft-ietf-oauth-v2-10) qui est implémentée (en sachant que la dernière version actuelle est la v.31)

Chaque application possède un scope propre.
* _sigi-client_ possède un scope "Citoyen"
* _sigi-client-fonct_ possède un scope "Fonctionnaire"

Un scope au sens OAUTH 2.0 définit une liste de ressources protégées et de méthodes pour y accéder.
  
##API REST
Les services REST sont mises à disposition par le serveur http://localhost:8080/ en local

Le scope *Citoyen* définit les accès aux ressources suivantes :
* <code>GET    /dogs</code>            Récupère la liste des chiens du citoyen
* <code>POST   /dogs</code>            Déclare un chien
* <code>PUT    /dogs/{dogId}</code>    Acquiert un chien
* <code>DELETE /dogs/{dogId}</code>    Supprime un chien déclaré

Le profile *Fonctionnaire* a accès aux ressources suivantes:
* <code>GET    /commune/dogs</code>               Récupère la liste des chiens de la commune auquel appartient le fonctionnaire
* <code>POST   /commune/dogs/{dogId}</code>       Valide ou refuse la déclaration d'un chien
