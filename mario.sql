DROP TABLE if exists bestillingslinjer;
DROP TABLE if exists pizzaer;
DROP TABLE if exists bestillinger;

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

insert into pizzaer (pizzanr, pizzanavn, toppings, pris) values (1, 'Vesuvio', 'tomatsauce, ost, skinke og oregano', 57.0);
insert into pizzaer (pizzanr, pizzanavn, toppings, pris) values (2, 'Amerikaner', 'tomatsauce, ost, oksefars og oregano', 53.0);
insert into pizzaer (pizzanr, pizzanavn, toppings, pris) values (3, 'Cacciatore', 'tomatsauce, ost, pepperoni og oregano', 57.0);
insert into pizzaer (pizzanr, pizzanavn, toppings, pris) values (4, 'Carbona', 'tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano', 63.0);
insert into pizzaer (pizzanr, pizzanavn, toppings, pris) values (5, 'Dennis', 'tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano', 65.0);
insert into pizzaer (pizzanr, pizzanavn, toppings, pris) values (6, 'Bertil', 'tomatsauce, ost, bacon og oregano', 57.0);
insert into pizzaer (pizzanr, pizzanavn, toppings, pris) values (7, 'Silvia' , 'tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano', 61.0);
insert into pizzaer (pizzanr, pizzanavn, toppings, pris) values (8, 'Victoria', 'tomatsauce, ost, skinke, ananas, champignon, løg og oregano', 61.0);
insert into pizzaer (pizzanr, pizzanavn, toppings, pris) values (9, 'Toronfo', 'tomatsauce, ost, skinke, bacon, kebab, chili og oregano', 61.0);
insert into pizzaer (pizzanr, pizzanavn, toppings, pris) values (10, 'Capricciosa', 'tomatsauce, ost, skinke, champignon og oregano', 61.0);
insert into pizzaer (pizzanr, pizzanavn, toppings, pris) values (11, 'Hawaii', 'tomatsauce, ost, skinke, ananas og oregano', 61.0);
insert into pizzaer (pizzanr, pizzanavn, toppings, pris) values (12, 'Le Blissola', 'tomatsauce, ost, skinke, rejer og oregano', 61.0);
insert into pizzaer (pizzanr, pizzanavn, toppings, pris) values (13, 'Venezia', 'tomatsauce, ost, skinke, bacon og oregano', 61.0);
insert into pizzaer (pizzanr, pizzanavn, toppings, pris) values (14, 'Mafia', 'tomatsauce, ost, pepperoni, bacon, løg og oregano', 61.0);


commit;

