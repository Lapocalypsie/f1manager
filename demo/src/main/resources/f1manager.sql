-- Create table for Ailerons
CREATE TABLE IF NOT EXISTS aileron (
    id SERIAL PRIMARY KEY,
    coef_aileron DOUBLE PRECISION,
    poid_aileron DOUBLE PRECISION,
    prix_aileron DOUBLE PRECISION,
    image_aileron VARCHAR(255)
);

-- Create table for Moteurs
CREATE TABLE IF NOT EXISTS moteur (
    id SERIAL PRIMARY KEY,
    nom_moteur VARCHAR(255),
    consommation_essence DOUBLE PRECISION,
    puissance DOUBLE PRECISION,
    coef_moteur DOUBLE PRECISION,
    prix_moteur DOUBLE PRECISION,
    image_moteur VARCHAR(255)
);

-- Create table for Wheels
CREATE TABLE IF NOT EXISTS wheel (
    id SERIAL PRIMARY KEY,
    nom_pneu VARCHAR(255),
    poids_pneus DOUBLE PRECISION,
    prix_pneus DOUBLE PRECISION,
    type_pneus VARCHAR(255),
    coef_pneus DOUBLE PRECISION,
    image_pneus VARCHAR(255)
);

-- Create table for F1
CREATE TABLE IF NOT EXISTS f1 (
    id SERIAL PRIMARY KEY,
    poid_f1 DOUBLE PRECISION,
    vitessemax DOUBLE PRECISION,
    zeroto100 DOUBLE PRECISION,
    maniability DOUBLE PRECISION,
    coef DOUBLE PRECISION,
    wheel_id INT REFERENCES wheel(id),
    moteur_id INT REFERENCES moteur(id),
    aileron_id INT REFERENCES aileron(id),
    image_f1 VARCHAR(255)
);

-- Create table for Joueur
CREATE TABLE IF NOT EXISTS joueur (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    argent DOUBLE PRECISION,
    xp_actuelle DOUBLE PRECISION,
    niv_actuel INT
);

-- Create table for Mecanicien
CREATE TABLE IF NOT EXISTS mecanicien (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    niveau_actuel INT,
    vitesse DOUBLE PRECISION,
    performance DOUBLE PRECISION
);

-- Create table for Pilote
CREATE TABLE IF NOT EXISTS pilote (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    niveau_actuel INT,
    number INT,
    price DOUBLE PRECISION,
    force DOUBLE PRECISION,
    endurance DOUBLE PRECISION,
    image_pilote VARCHAR(255)
);


-- MAX VERSTAPPEN
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Verstappen', 'Max', 1, 33, 20000000, 95, 90, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/verstappen');

-- SERGIO PÉREZ
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Pérez', 'Sergio', 1, 11, 10000000, 85, 85, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/perez');

-- CHARLES LECLERC
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Leclerc', 'Charles', 1, 16, 15000000, 90, 85, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/leclerc');

-- CARLOS SAINZ JR.
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Sainz Jr.', 'Carlos', 1, 55, 8000000, 85, 80, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/sainz');

-- LEWIS HAMILTON
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Hamilton', 'Lewis', 1, 44, 25000000, 100, 95, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/hamilton');

-- GEORGE RUSSELL
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Russell', 'George', 1, 63, 6000000, 85, 85, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/russell');

-- ESTEBAN OCON
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Ocon', 'Esteban', 1, 31, 5000000, 85, 80, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/ocon');

-- PIERRE GASLY
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Gasly', 'Pierre', 1, 10, 7000000, 85, 80, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/gasly');

-- LANDO NORRIS
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Norris', 'Lando', 1, 4, 12000000, 90, 85, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/norris');

-- OSCAR PIASTRI
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Piastri', 'Oscar', 1, 81, 3000000, 85, 85, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/piastri');

-- VALTTERI BOTTAS
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Bottas', 'Valtteri', 1, 77, 15000000, 90, 85, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/bottas');

-- ZHOU GUANYU
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Zhou', 'Guanyu', 1, 24, 4000000, 85, 80, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/zhou');

-- LANCE STROLL
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Stroll', 'Lance', 1, 18, 9000000, 85, 80, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_auto,w_1320,t_16by9North/content/dam/fom-website/drivers/2024Drivers/stroll');

-- FERNANDO ALONSO
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Alonso', 'Fernando', 1, 14, 20000000, 95, 90, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/alonso');

-- KEVIN MAGNUSSEN
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Magnussen', 'Kevin', 1, 20, 3000000, 85, 80, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/magnussen');

-- NICO HULKENBERG
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Hulkenberg', 'Nico', 1, 27, 5000000, 85, 85, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/hulkenberg');

-- YUKI TSUNODA
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Tsunoda', 'Yuki', 1, 22, 2000000, 80, 80, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/tsunoda');

-- DANIEL RICCIARDO
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Ricciardo', 'Daniel', 1, 3, 10000000, 90, 85, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/ricciardo');

-- ALEXANDER ALBON
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Albon', 'Alexander', 1, 23, 4000000, 85, 80, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/albon');

-- LOGAN SARGEANT
INSERT INTO pilote (nom, prenom, niveau_actuel, number, price, force, endurance, image_pilote)
VALUES ('Sargeant', 'Logan', 1, 2, 1000000, 80, 80, 'https://media.formula1.com/image/upload/f_auto,c_limit,q_75,w_1320/content/dam/fom-website/drivers/2024Drivers/sargeant');


-- Wheels
-- Soft Compound
INSERT INTO wheel (nom_pneu, poids_pneus, prix_pneus, type_pneus, coef_pneus, image_pneus)
VALUES ('Pirelli P Zero Soft', 7.0, 1000.0, 'Soft', 1.05, 'https://v12rs.com/cdn/shop/files/1PRLI-P-00225_1copy_1024x1024_2x_9e928059-c6c4-43e4-b201-615b7d66d20b_650x.jpg?v=1683141370');

-- Medium Compound
VALUES ('Pirelli P Zero Medium', 7.5, 1100.0, 'Medium', 1.0, 'https://afbmotorsport.com/95978-large_default/pneu-pirelli-pole-position-echelle-1-2-jaune-intermediaire.jpg');

-- Hard Compound
VALUES ('Pirelli P Zero Hard', 8.0, 1200.0, 'Hard', 0.95, 'https://tibormodel.s8.cdn-upgates.com/_cache/2/5/2505491e597a94e35468d36057deb066-pirelli-p-zero-hard-white-mini-tyre-1-7.jpg');

-- Wet Compound
VALUES ('Pirelli Cinturato Wet', 7.2, 1300.0, 'Wet', 1.1, 'https://www.f1authentics.com/cdn/shop/files/Pirelli-Wet-Tyre-2_1.jpg?v=1695646689&width=3905');

INSERT INTO aileron (coef_aileron, poid_aileron, prix_aileron, image_aileron)
VALUES (1.02, 5.0, 5000.0, 'https://f1i.autojournal.fr/wp-content/uploads/sites/17/2021/08/f1-7-aileron-arriere.jpg'),
       (1.05, 4.8, 5500.0, 'https://cdn-9.motorsport.com/images/amp/YXR9gW50/s1000/formula-1-monaco-gp-2021-red-b-2.jpg'),
       (1.08, 4.5, 6000.0, 'https://picolio.auto123.com/art-images/127004/mrw-inline4.jpg');

INSERT INTO moteur (nom_moteur, consommation_essence, puissance, coef_moteur, prix_moteur, image_moteur)
VALUES ('Mercedes-AMG F1 M12 E Performance', 2.0, 950, 1.05, 10000000, 'https://www.autohebdo.fr/app/uploads/2022/08/b_D8D7537-Large1-753x494.jpg'),
       ('Ferrari 065/6', 2.2, 940, 1.0, 9500000, 'https://medias.leblogauto.com/20/2022/08/photo_article/92592/174515/1200-L-la-fia-adopte-enfin-le-rglement-moteur-f1-2026.jpg'),
       ('Renault E-Tech 22', 1.8, 960, 0.95, 9000000, 'https://cdn-7.motorsport.com/images/amp/k2QXyPv0/s6/f1-renault-f1-reveals-2015-eng.jpg');


-- Oracle Red Bull Racing
INSERT INTO f1 (poid_f1, vitessemax, zeroto100, maniability, coef, wheel_id, moteur_id, aileron_id, image_f1)
VALUES (752, 350, 2.5, 90, 1.0, 1, 1, 1, 'oracle_red_bull_racing.jpg');

-- Scuderia Ferrari
VALUES (746, 340, 2.7, 85, 1.0, 2, 2, 2, 'scuderia_ferrari.jpg');

-- Mercedes-AMG Petronas F1
VALUES (743, 345, 2.6, 95, 1.0, 3, 3, 3, 'mercedes_amg_petronas_f1.jpg');

-- BWT Alpine F1
VALUES (741, 338, 2.8, 88, 1.0, 1, 4, 4, 'bwt_alpine_f1.jpg');

-- McLaren F1
VALUES (747, 342, 2.7, 87, 1.0, 2, 5, 5, 'mclaren_f1.jpg');

-- Stake F1 Team
VALUES (750, 348, 2.6, 86, 1.0, 3, 6, 6, 'stake_f1_team.jpg');

-- Aston Martin Aramco Cognizant F1
VALUES (744, 340, 2.7, 88, 1.0, 1, 7, 7, 'aston_martin_aramco_cognizant_f1.jpg');

-- MoneyGram Haas F1
VALUES (753, 346, 2.5, 84, 1.0, 2, 8, 8, 'moneygram_haas_f1.jpg');

-- Visa Cash App RB
VALUES (745, 341, 2.8, 89, 1.0, 3, 9, 9, 'visa_cash_app_rb.jpg');

-- Williams Racing
VALUES (740, 339, 2.9, 83, 1.0, 3, 10, 10, 'williams_racing.jpg');

ALTER TABLE wheel
ADD COLUMN niv_actuel INTEGER DEFAULT 0;

UPDATE wheel
SET niv_actuel = 0;