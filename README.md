Il s'agit d'une application Java EE réalisée en TP. L'interface IDAOConstantes a été imposée. 

Le programme permet de simuler une partie de 421 contre l'ordinateur, on nous a demandé de simplifier les règles et de ne tenir compte
que du score max après trois tentatives et de le comparer à celui de l'ordinateur qui lui n'a qu'une seule tentative.

les joueurs ont été créés en amont dans une BD MySQL, le nom de la BD est nt2-tp3. Les joueurs qui ont plus de 16 sont autorisés à joueur.
ils jouent contre l'ordinateur, à la fin de la partie on redémarre une nouvelle partie: le résultat de la partie précédente s'affiche , 
le résultat est sauvé dans une table résultat. Si le joueur ferme la fenetre la partie en cours est conservée dans un cookie et il peut 
reprendre sa session là où il s'était arrêté. 

les tables joueur et resultats on été créées en amont dans la bd nt2-tp3, si le joueur n'a pas encore de resultat, une ligne est créée 
dans la table resultats.

Il manque à gérer les exceptions, envoi vers une page d'erreur. Et il manque la fermeture de la connection à la base,
soit pour chaque requête on ferme directement à la fin de la requête. Soit on laisse une connection ouverte et on ferme qd on quitte
(à prévoir dans déconnexion, dans le traitement des exceptions et dans le time out de la session). 
