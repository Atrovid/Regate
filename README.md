[<img src="https://www.ensicaen.fr/wp-content/uploads/2017/02/LogoEnsicaen.gif" width="256" >](https://www.ensicaen.fr)

Projet de régate : Elgama
================

## Description du projet

Ce projet contient un exemple d'une application graphique écrite en Java avec
la bibliothèque graphique JavaFX. Elle est basée sur le patron d'architecture
Modèle-Vue-Présentation.

Le projet est géré par le moteur de production 'gradle'.

## Organisation du projet
 
Le projet a la structure suivante :

    .
    │
    ├── build.gradle, settings.gradle, gradle.properties
    │
    ├── .gitlab-ci.yml
    │
    └── src
        ├── main
        │   ├── java
        │   │      ├── fr.ensicaen.Elgama/*.java
        │   │      ├── fr.ensicaen.Elgama.model/*.java
        │   │      ├── fr.ensicaen.Elgama.presenter/*.java
        │   │      └── fr.ensicaen.Elgama.view/*.java
        │   │
        │   └── resources
        │          ├── fr.ensicaen.Elgama/view/*.fxml
        │          ├── fr.ensicaen.Elgama/view/*.css
        │          └── fr.ensicaen.Elgama/MessageBundle.properties.properties
        ├── test
            ├── java
            │      └── fr.ensicaen.Elgama/*.java
            └── resources

# À vous de jouer !