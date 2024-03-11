INSERT INTO spring_chantier (nom, adresse)
VALUES ('nouveauchantier1', '10 rue du paradis'),
    ('nouveauchantier2', '5 rue du paradis');

INSERT INTO operations (date, nom, chantier_id)
VALUES ('2024-03-10', 'peindre',1);

INSERT INTO operations (date, nom,chantier_id)
VALUES ('2024-03-11', 'enduire',1);

INSERT INTO operations (date, nom, chantier_id)
VALUES ('2024-03-12', 'gratter', 1);

INSERT INTO tache (nom, temps)
VALUES ('Tâche 1', 60);

INSERT INTO tache (nom, temps)
VALUES ('Tâche 2', 90);

INSERT INTO tache (nom, temps)
VALUES ('Tâche 3', 120);

INSERT INTO consommable (nom)
VALUES ('Consommable 1');

INSERT INTO consommable (nom)
VALUES ('Consommable 2');

INSERT INTO consommable (nom)
VALUES ('Consommable 3');

INSERT INTO consommable (nom)
VALUES ('Consommable 4');
