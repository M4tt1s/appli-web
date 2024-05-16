# appli-web

## Definition du site

Site de CTF pour la cybersécurité. Permet d'apprendre des notions de cybersécurité de manière ludique. L'utilisateur peut créer un compte et souscrire à un plan prémium (quelques activités en plus, pas de limite d'activités par jour).

Les utilisateurs gagnent des points en complétant des activités (objectifs, indices, résumer sous forme de mini cours) et peuvent consulter le classement global. Il y a 3 types d'utilisateur : admin (créer des activités), utlisateur standard (limité au activités standard et une au plus par jour) et utilisateur premium (accès aux acitivités premium et plus de limite journalière).

Les administrateurs créer des activités (premium au choix) et précise le niveau de difficulté, ces activités seront proposées automatiquement en fonction de leur difficulté et du premium. Les utilisateurs standard voit les activités premium comme les utilisateurs premium mais lorqu'il se rende sur la page de l'activité ils sont bloqués par un message leur proposant de passer premium.

## Theme et Specifications du site

### Theme

Site de Challenge avec connection et score.

### Fonctionnalites

Créer un compte ou se connecter, un compte = un pseudo, un e-mail, un mot-de-passe. La connection se fait avec le pseudo uniquement (pas l'adresse mail).

Créer une activité pour un administrateur (un seul compte "en dur" qui lorsqu'on s'y connecte permet de supprimer/ajouter des activités) et ajouter des tags.

Limiter les utilisateurs standard.

Sourscrire à un plan prémium en entrant un code prémium.

Accéder aux activités, trier les activités selon leurs tags.

Persistence des données (comptes, activités, etc...).

Tableau des scores (classements des utilisateurs).

Activités = ensemble de blocs de textes (questions, instructions, etc...) et d'inputs (déposer un fichier, taper un résultat/un mdp) éventuellement bloquants (enchainement dans l'ordre).

IRC entre tous les utilisateurs (leur permet de demander de l'aide ou discuter du site). en 

### Enchainement des pages

![Enchainement des pages](/enchainementpages.png)

### Schema de donnees

Entités : utilisateur, challenge, resultat, classement (place dans le tableau des scores), message (pour le IRC), documentation (comme un petit cours sur une notion/technologie), code premium

![Schéma de données](/schema_donnees.png)

## Configuration de l'environnement

Eclipse, JEE, MariaDB, Makefile pour utiliser juste code
Angular

## Séance 2

### Front-end partiel

![Front-end Partiel](/front_end_partiel.png)

### Définition des Entities (code métier)

- Challenge.java : relation OneToOne avec entity Premium, attributs (titre, text, points).
- Classement.java : relation OneToOne avec entity Utilisateur, attribut (position).
- Documentation.java : aucune relation, attributs (titre, text).
- Message.java : relation OneToOne avec entity Utilisateur, attributs (textes, date).
- Premium.java : relation OneToOne avec entity Utilisateur, attribut (code).
- Resultat.java : relation OneToOne avec entity Utilisateur, relation OneToOne avec entity Challenge, attribut (aReussi).
- Utilisateur.java : relation OneToOne avec entity Premium, attributs (pseudo, mail, passwordHash).

## Séance 3

### Relations

- Utilisateur/Premium OneToOne, porteur = Utilisateur
- Utilisateur/Resultat OneToMany, porteur = Resultat
