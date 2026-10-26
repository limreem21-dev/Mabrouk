Feature: Consultation d'un produit Mabrouk

  Scenario: Accéder à la fiche produit
    Given l'utilisateur est sur la page "Chemises & Blouses"
    When l'utilisateur clique sur le produit "CHEMISE À COL CLASSIQUE ET COUPE AMPLE"
    Then la page du produit est affichée