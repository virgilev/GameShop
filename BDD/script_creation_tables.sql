# Creation des tables, insertions





-- Console

CREATE TABLE CONSOLE (
	pk_name VARCHAR(255) PRIMARY KEY
);

INSERT INTO CONSOLE(pk_name) VALUES("PS3");
INSERT INTO CONSOLE(pk_name) VALUES("PS4");
INSERT INTO CONSOLE(pk_name) VALUES("PC");
INSERT INTO CONSOLE(pk_name) VALUES("XBOX 360");



-- Game

CREATE TABLE GAME (
	pk_title VARCHAR(255),
	fk_console VARCHAR(255),
	price DOUBLE NOT NULL,
	description TEXT NOT NULL,
	PRIMARY KEY (pk_title, fk_console),
	FOREIGN KEY (fk_console) REFERENCES CONSOLE(pk_name)
);

INSERT INTO GAME(pk_title, fk_console, price, description) VALUES("FIFA 16", "PS3", "29.99", "FIFA 16 innove sur tout le terrain pour proposer une experience de jeu equilibree, realiste et passionnante qui vous permet de jouer comme vous voulez et au plus haut niveau. Decouvrez de nouvelles facons de jouer ! Parmi les nombreuses innovations de FIFA 16, retrouvez la confiance en defense, le controle du milieu et tous les outils pour creer des moments magiques comme jamais auparavant. Les debutants ou les joueurs chevronnes qui cherchent a ameliorer leur technique pourront ameliorer leur technique avec le nouvel entraineur FIFA. Des innovations tous azimuts. De nouvelles facons de jouer. Ameliorez votre niveau.");
INSERT INTO GAME(pk_title, fk_console, price, description) VALUES("FIFA 17", "PS4", "59.99", "FIFA 17 devoile une nouvelle experience narrative inedite beneficiant d'un scenario realiste, de cinematiques, ainsi qu'une innovation complete en matiere de gameplay Plonges dans le tout nouveau mode de jeu L'Aventure, les joueurs vivront, sur et en dehors du terrain, l'histoire d'Alex Hunter, recrue du football cherchant a faire sa place en Premier League. 
Ils decouvriront une nouvelle facette du monde du football en rencontrant des personnages travailles en profondeur, et en experimentant les hauts et les bas d'arcs narratifs uniques constitues par leurs decisions en dehors du terrain, leur performance en match et les interactions avec les autres personnages en jouant pour l'un des 20 clubs de Premier League au cours de la saison 2016-2017.");
INSERT INTO GAME(pk_title, fk_console, price, description) VALUES("NBA 2K17", "XBOX 360", "39.99", "Avez-vous ce qu'il faut pour devenir une superstar de la NBA ? 
Entrez sur le terrain, la ou se construisent les carrieres, ou les reves deviennent realite et ou les meilleurs athletes du monde s'affrontent pour decrocher le titre de superstar. Etes-vous pret a laisser le banc derriere vous ? 
Jouez avec les plus grands noms de la ligue NBA, de l'equipe d'Australie de basket-ball et des equipes de l'EuroLeague. Gerez vos joueurs depuis la ligne de touche, organisez vos talents et renforcez votre banc de remplacants. Choisissez vos strategies et modifiez vos configurations jusqu'a la derniere minute pour obtenir les meilleures recompenses du basket professionnel. 
Avec divers modes mutlijoueur en ligne et un mode Carriere hors ligne complet, il existe de nombreux chemins pour acceder au sommet. Il vous suffit d'integrer la draft...");

-- Type

CREATE TABLE TYPE (
	pk_type VARCHAR(255) PRIMARY KEY
);

INSERT INTO TYPE(pk_type) VALUES ("Sport");



-- Client

CREATE TABLE CLIENT (
	pk_email VARCHAR(255) PRIMARY KEY,
	lastName VARCHAR(255) NOT NULL,
	firstName VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	birthDate DATE NOT NULL
);

insert INTO CLIENT(pk_email, lastName, firstName, password, birthDate) VALUES("virgilew@gmail.com", "Vancon", "Virgile", "pwd", "1996-04-01");
insert INTO CLIENT(pk_email, lastName, firstName, password, birthDate) VALUES("pbathell@etu.utc.fr", "Bathellier", "Pierre", "pwd", "1995-10-12");
insert INTO CLIENT(pk_email, lastName, firstName, password, birthDate) VALUES("ebarthol@etu.utc.fr", "Okkis", "Elliot", "pwd", "1995-03-18");



-- Game_Type association

CREATE TABLE GAME_TYPE (
	fk_game VARCHAR(255),
	fk_type VARCHAR(255),
	FOREIGN KEY (fk_type) REFERENCES TYPE(pk_type),
	FOREIGN KEY (fk_game) REFERENCES GAME(pk_title),
	PRIMARY KEY (fk_game, fk_type)
);

INSERT INTO GAME_TYPE(fk_game, fk_type) VALUES("FIFA 17", "Sport");
INSERT INTO GAME_TYPE(fk_game, fk_type) VALUES("NBA 2K17", "Sport");