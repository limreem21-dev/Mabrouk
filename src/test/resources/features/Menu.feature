Feature: Navigation dans le menu Mabrouk

  Scenario: Accéder à la page Chemises et Blouses
    Given l'utilisateur accède à la page d'accueil
    When il survole le menu "Femme"
    And il clique sur le sous-menu "Chemises & Blouses"
    Then la page "Chemises & Blouses" doit s'afficher

