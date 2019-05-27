CREATE TABLE IF NOT EXISTS pizza(
   id SMALLINT PRIMARY KEY AUTO_INCREMENT,
   nom VARCHAR(50),
   prix DECIMAL(15,2)
) ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS ingredient(
   id SMALLINT PRIMARY KEY AUTO_INCREMENT,
   nom VARCHAR(50)
) ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS taille(
   id SMALLINT PRIMARY KEY AUTO_INCREMENT,
   nom VARCHAR(50),
   pourcentage FLOAT(10)
) ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS livreur(
   id SMALLINT PRIMARY KEY AUTO_INCREMENT,
   nom VARCHAR(50),
   prénom VARCHAR(50)
) ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS type_vehicule(
	id SMALLINT PRIMARY KEY AUTO_INCREMENT,
	nom_type VARCHAR(50)
) ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS vehicule(
   id SMALLINT PRIMARY KEY AUTO_INCREMENT,
   plaque VARCHAR(50),
   id_type SMALLINT,
   FOREIGN KEY (id_type) REFERENCES  type_vehicule(id)
) ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS client(
   id SMALLINT PRIMARY KEY AUTO_INCREMENT,
   nom VARCHAR(50),
   prenom VARCHAR(50),
   solde VARCHAR(50) default 0
) ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS commande(
   id SMALLINT PRIMARY KEY AUTO_INCREMENT,
   prix DECIMAL(15,2),
   temps_livraison DECIMAL(15,2),
   id_livreur SMALLINT NOT NULL,
   id_vehicule SMALLINT NOT NULL,
   id_client SMALLINT NOT NULL,
   FOREIGN KEY (id_livreur) REFERENCES  livreur(id),
   FOREIGN KEY (id_vehicule) REFERENCES  vehicule(id),
   FOREIGN KEY (id_client) REFERENCES  client(id)
) ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS preparer(
   id_pizza SMALLINT,
   id_ingredient SMALLINT,
   PRIMARY KEY(id_pizza, id_ingredient),
   FOREIGN KEY (id_pizza) REFERENCES  pizza(id),
   FOREIGN KEY (id_ingredient) REFERENCES  ingredient(id)
) ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS tailler(
   id_pizza SMALLINT,
   id_taille SMALLINT,
   prix DECIMAL(15,2),
   PRIMARY KEY(id_pizza, id_taille),
   FOREIGN KEY (id_pizza) REFERENCES  pizza(id),
   FOREIGN KEY (id_taille) REFERENCES  taille(id)
) ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS preparercommander(
   id_pizza SMALLINT,
   id_commande SMALLINT,
   PRIMARY KEY(id_pizza, id_commande),
   FOREIGN KEY (id_pizza) REFERENCES  pizza(id),
   FOREIGN KEY (id_commande) REFERENCES  commande(id)
) ENGINE InnoDB;

DELIMITER $$
CREATE TRIGGER IF NOT EXISTS after_pizza_insert 
    AFTER INSERT ON pizza
    FOR EACH ROW 
BEGIN
    INSERT INTO tailler(id_pizza, id_taille, prix) VALUES(new.id,1,10);
END$$
DELIMITER ;