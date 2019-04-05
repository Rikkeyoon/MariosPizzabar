DROP TABLE  if exists Bestillingslinjer;
DROP TABLE if exists Bestillinger;
DROP TABLE if exists Pizzaer;


CREATE TABLE  Bestillinger(	
	Bestilnr INTEGER NOT NULL AUTO_INCREMENT,
	Afhenttid TIME,
	PRIMARY KEY (Bestilnr)
); 

CREATE TABLE Pizzaer(
	Pizzanr INTEGER NOT NULL AUTO_INCREMENT,
	Pizzanavn VARCHAR(50),
    Toppings VARCHAR(255),
    Pris FLOAT NOT NULL,
	PRIMARY KEY (Pizzanr)
);

CREATE TABLE Bestillingslinjer(
	Antal INTEGER NOT NULL,
    Pizzanr INTEGER NOT NULL,
    Bestilnr INTEGER NOT NULL,
    PRIMARY KEY (Bestilnr, Pizzanr),
	FOREIGN KEY (Bestilnr) REFERENCES Bestillinger(Bestilnr),
	FOREIGN KEY (Pizzanr) REFERENCES Pizzaer(Pizzanr)
);

INSERT INTO bestillinger (afhenttid) VALUES ('18:30:00');
INSERT INTO bestillinger (afhenttid) VALUES ('19:00:00');


INSERT INTO pizzaer (pizzanavn, toppings, pris) VALUES ('Vesuvio', 'tomatsauce, ost, skinke og oregano', 57.0);
INSERT INTO pizzaer (pizzanavn, toppings, pris) VALUES ('Amerikaner', 'tomatsauce, ost, oksefars og oregano', 53.0);
INSERT INTO pizzaer (pizzanavn, toppings, pris) VALUES ('Cacciatore', 'tomatsauce, ost, pepperoni og oregano', 57.0);
INSERT INTO pizzaer (pizzanavn, toppings, pris) VALUES ('Carbona', 'tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano', 63.0);
INSERT INTO pizzaer (pizzanavn, toppings, pris) VALUES ('Dennis', 'tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano', 65.0);
INSERT INTO pizzaer (pizzanavn, toppings, pris) VALUES ('Bertil', 'tomatsauce, ost, bacon og oregano', 57.0);
INSERT INTO pizzaer (pizzanavn, toppings, pris) VALUES ('Silvia' , 'tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano', 61.0);
INSERT INTO pizzaer (pizzanavn, toppings, pris) VALUES ('Victoria', 'tomatsauce, ost, skinke, ananas, champignon, løg og oregano', 61.0);
INSERT INTO pizzaer (pizzanavn, toppings, pris) VALUES ('Toronfo', 'tomatsauce, ost, skinke, bacon, kebab, chili og oregano', 61.0);
INSERT INTO pizzaer (pizzanavn, toppings, pris) VALUES ('Capricciosa', 'tomatsauce, ost, skinke, champignon og oregano', 61.0);
INSERT INTO pizzaer (pizzanavn, toppings, pris) VALUES ('Hawaii', 'tomatsauce, ost, skinke, ananas og oregano', 61.0);
INSERT INTO pizzaer (pizzanavn, toppings, pris) VALUES ('Le Blissola', 'tomatsauce, ost, skinke, rejer og oregano', 61.0);
INSERT INTO pizzaer (pizzanavn, toppings, pris) VALUES ('Venezia', 'tomatsauce, ost, skinke, bacon og oregano', 61.0);
INSERT INTO pizzaer (pizzanavn, toppings, pris) VALUES ('Mafia', 'tomatsauce, ost, pepperoni, bacon, løg og oregano', 61.0); 

INSERT INTO bestillingslinjer (antal, pizzanr, bestilnr) VALUES (4, 5, 1);
INSERT INTO bestillingslinjer (antal, pizzanr, bestilnr) VALUES (2, 6, 2);

commit;

