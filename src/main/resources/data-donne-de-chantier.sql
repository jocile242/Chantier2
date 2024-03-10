INSERT INTO chantier (id, nom, adresse)
VALUES ('1', 'nouveauchantier1', '10 rue du paradis');
    ('2', 'nouveauchantier2', '5 rue du paradis');

INSERT INTO Operation (date, chantier_id)
VALUES ('2024-03-10', 1);

INSERT INTO Operation (date, chantier_id)
VALUES ('2024-03-11', 1);

INSERT INTO Operation (date, chantier_id)
VALUES ('2024-03-12', 2);

INSERT INTO Tache (nom, tempsDeRealisation, chantier_id)
VALUES ('Tâche 1', 60, 1);

INSERT INTO Tache (nom, tempsDeRealisation, chantier_id)
VALUES ('Tâche 2', 90, 1);

INSERT INTO Tache (nom, tempsDeRealisation, chantier_id)
VALUES ('Tâche 3', 120, 2);

INSERT INTO Consommable (nom, tache_id)
VALUES ('Consommable 1', 1);

INSERT INTO Consommable (nom, tache_id)
VALUES ('Consommable 2', 1);

INSERT INTO Consommable (nom, tache_id)
VALUES ('Consommable 3', 2);

INSERT INTO Consommable (nom, tache_id)
VALUES ('Consommable 4', 3);
