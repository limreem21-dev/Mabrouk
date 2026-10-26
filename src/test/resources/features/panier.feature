Feature: Ajout au panier sur Mabrouk

    Scenario: Ajouter le produit au panier
  Given l'utilisateur est sur la page "Chemises & Blouses"
  When l'utilisateur clique sur le produit "CHEMISE À COL CLASSIQUE ET COUPE AMPLE"
  And l'utilisateur choisit une couleur
  And l'utilisateur choisit une taille
  And il ajoute le produit au panier
  And l'utilisateur accède au panier
  Then le produit est ajouté au panier