DROP TABLE if exists bestillingslinjer;
DROP TABLE if exists gemte_bestillingslinjer;
DROP TABLE if exists pizzaer;
DROP TABLE if exists bestillinger;
DROP TABLE if exists gemte_bestillinger;

CREATE TABLE bestillinger (
  bestilnr INT NOT NULL AUTO_INCREMENT,
  afhenttid TIME NOT NULL,
  PRIMARY KEY (bestilnr)
  );

CREATE TABLE pizzaer (	
	pizzanr INT NOT NULL AUTO_INCREMENT, 
	pizzanavn VARCHAR(50), 
	toppings VARCHAR(255), 
	pris FLOAT NOT NULL, 
	PRIMARY KEY (pizzanr)
);

CREATE TABLE bestillingslinjer (
  antal INT NOT NULL,
  pizzanr INT NOT NULL,
  bestilnr INT NOT NULL,
  PRIMARY KEY (bestilnr, pizzanr),
  FOREIGN KEY (bestilnr) REFERENCES bestillinger(bestilnr),
  FOREIGN KEY (pizzanr) REFERENCES pizzaer(pizzanr)
  );
  
CREATE TABLE gemte_bestillinger (
  bestilnr INT NOT NULL AUTO_INCREMENT,
  afhenttid TIME NOT NULL,
  PRIMARY KEY (bestilnr)
);

CREATE TABLE gemte_bestillingslinjer (
  antal INT NOT NULL,
  pizzanr INT NOT NULL,
  bestilnr INT NOT NULL,
  PRIMARY KEY (bestilnr, pizzanr),
  FOREIGN KEY (bestilnr) REFERENCES gemte_bestillinger(bestilnr),
  FOREIGN KEY (pizzanr) REFERENCES pizzaer(pizzanr)
);

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

INSERT INTO bestillinger (afhenttid) VALUES ('18:30:00');
INSERT INTO bestillinger (afhenttid) VALUES ('18:45:00');

INSERT INTO bestillingslinjer VALUES (1, 5, 1);
INSERT INTO bestillingslinjer VALUES (2, 12, 2);


commit;

