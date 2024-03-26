INSERT INTO chantier(nom, adresse, utilisateur_id)
VALUES ("Construction d'un bâtiment sans ou cent étages ", "9 rue labro Longwy", 1), ("Aménagement de ligne rouge est bleu transparente", "2 place de la stupidité", 2);

INSERT INTO consommable (nom)
VALUES ("Brique"), ("Ciment gris"), ("Tige d'acier"), ("Bloc creux"), ("Pierre concassée"), ("Sable fin"), ("Panneaux solaires"), ("Fenêtres PVC"), ("Portes coupe-feu");

INSERT INTO operation(nom, date, tache_id, chantier_id, utilisateur_id)
VALUES ("Excavation des grottes ",  DATE '2400-08-35', 1, 1,1), ("Couler la fondation", DATE '3000-26-12', 2, 2,2);

INSERT INTO role(designation)
VALUES ("Chef"), ("Petit"), ("Esclave");

INSERT INTO tache(nom, temps)
VALUES ("Excaver une tranchée", "24"), ("Préparer des crêpes", "1");

INSERT INTO role(designation)
VALUES ("Chef"), ("Petit"), ("Esclave");

INSERT INTO utilisateur (pseudo, motdepasse, role_id)
VALUES ("titi", "666",1), ("tata", "2424",2),("toto", "9856",3);

INSERT INTO operation(nom, date, tache_id, chantier_id, utilisateur_id)
VALUES ("Excavation des grottes ",  DATE '2400-08-35', 1, 1,1), ("Couler la fondation", DATE '2024-03-25', 2, 2,2);

INSERT INTO consommable_tache (consommable_id, tache_id)
VALUES (1,3), (2,3);



-- INSERT INTO spring_chantier (nom, adresse, operation_id)
-- VALUES ('nouveauchantier1', '10 rue du paradis'),
--     ('nouveauchantier2', '5 rue du paradis');
--
-- INSERT INTO operation (date, nom, chantier_id)
-- VALUES ('2024-03-10', 'peindre',1);
--
-- INSERT INTO operation (date, nom,chantier_id)
-- VALUES ('2024-03-11', 'enduire',1);
--
-- INSERT INTO operation (date, nom, chantier_id)
-- VALUES ('2024-03-12', 'gratter', 1);
--
-- INSERT INTO tache (nom, temps)
-- VALUES ('Tache 1', 60);
--
-- INSERT INTO tache (nom, temps)
-- VALUES ('Tache 2', 90);
--
-- INSERT INTO tache (nom, temps)
-- VALUES ('Tache 3', 120);
--
-- INSERT INTO consommable (nom)
-- VALUES ('Consommable 1');
--
-- INSERT INTO consommable (nom)
-- VALUES ('Consommable 2');
--
-- INSERT INTO consommable (nom)
-- VALUES ('Consommable 3');
--
-- INSERT INTO consommable (nom)
-- VALUES ('Consommable 4');
