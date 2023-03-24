DROP DATABASE IF EXISTS animal; 
CREATE DATABASE animal;
USE animal;

DROP TABLE IF EXISTS dog_staff; 
DROP TABLE IF EXISTS dogs; 
DROP TABLE IF EXISTS clients; 
DROP TABLE IF EXISTS staff; 

CREATE TABLE staff( 
staff_id INT(3) NOT NULL AUTO_INCREMENT, 
staff_first_name VARCHAR(40) NOT NULL, 
staff_last_name VARCHAR(40) NOT NULL, 
PRIMARY KEY (staff_id) 
); 

CREATE TABLE clients( 
client_id INT(6) NOT NULL AUTO_INCREMENT, 
client_first_name VARCHAR(40) NOT NULL, 
client_last_name VARCHAR(40) NOT NULL,  
client_address VARCHAR(100) NOT NULL,
PRIMARY KEY (client_id)
); 

CREATE TABLE dogs( 
dog_id INT(4) NOT NULL AUTO_INCREMENT, 
dog_name VARCHAR(40) NOT NULL,
gender ENUM('Male', 'Female') NOT NULL,
birthday date,
breed VARCHAR(40) NOT NULL, 
size ENUM('Toy', 'Small', 'Medium', 'Large') NOT NULL,
client_id INT(6),
PRIMARY KEY (dog_id),
FOREIGN KEY (client_id) references clients(client_id) ON DELETE CASCADE
); 

CREATE TABLE dog_staff( 
dog_id INT(4) NOT NULL, 
staff_id INT(3) NOT NULL, 
FOREIGN KEY (dog_id) references dogs(dog_id) ON DELETE CASCADE,
FOREIGN KEY (staff_id) references staff(staff_id) ON DELETE CASCADE,
UNIQUE KEY (dog_id, staff_id)
); 

INSERT INTO staff (staff_first_name, staff_last_name) VALUES('Amy', 'Dannis');
INSERT INTO staff (staff_first_name, staff_last_name) VALUES('Debbie', 'Johnson');
INSERT INTO staff (staff_first_name, staff_last_name) VALUES('Kailey', 'Roussy');

INSERT INTO clients (client_first_name, client_last_name, client_address) VALUES('Stephanie', 'Roussy', '678 Puppies Blvd');
INSERT INTO clients (client_first_name, client_last_name, client_address) VALUES('Samantha', 'Davidson', '333 Piggy Lane');
INSERT INTO clients (client_first_name, client_last_name, client_address) VALUES('Dorian', 'Bates', '9 Horses Pasture');
INSERT INTO clients (client_first_name, client_last_name, client_address) VALUES('Jeff', 'Oscar', '64567 Kitties Corner');
INSERT INTO clients (client_first_name, client_last_name, client_address) VALUES('Serge', 'Boston', '25 Donkey Hwy');
INSERT INTO clients (client_first_name, client_last_name, client_address) VALUES('Joseph', 'McGraw', '98674 Bunny Farm');
INSERT INTO clients (client_first_name, client_last_name, client_address) VALUES('Hilary', 'Bush', '1112 Turtle Street');
INSERT INTO clients (client_first_name, client_last_name, client_address) VALUES('Abbey', 'Chadsey', '444 Goats Grove');
INSERT INTO clients (client_first_name, client_last_name, client_address) VALUES('Melissa', 'Fields', '97654 Sheep Shephard Blvd');
INSERT INTO clients (client_first_name, client_last_name, client_address) VALUES('Kenya', 'Marshall', '45678 Jaguar Road');
INSERT INTO clients (client_first_name, client_last_name, client_address) VALUES('Matthew', 'Law', '53627 Tiger Street');

INSERT INTO dogs (dog_name, gender, birthday, breed, `size`, client_id) VALUES('Finn', 'Male', '2020-09-22', 'Labrador Mix', 'Medium', 1);
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`, client_id) VALUES('Pongo', 'Male', '2013-02-05', 'Dalmation Mix', 'Medium', 1);
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`) VALUES('George', 'Male', '2016-04-08', 'Pitbull', 'Medium');
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`) VALUES('Sadie', 'Female', '2021-06-23', 'Bichon', 'Small');
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`, client_id) VALUES('Cloe', 'Female', '2020-07-04', 'Mastiff', 'Large', 2);
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`) VALUES('Angel', 'Female', '2021-01-09', 'Yellow Labrador', 'Medium');
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`) VALUES('Dodger', 'Male', '2017-10-22', 'Bloodhound', 'Large');
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`, client_id) VALUES('Mooch', 'Female', '2018-11-26', 'Chihuahua', 'Toy', 3);
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`) VALUES('Koda', 'Male', '2018-12-05', 'Cavalier King Charles Spaniel', 'Small');
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`, client_id) VALUES('Meeko', 'Female', '2019-02-01', 'Border Collie', 'Medium', 5);
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`) VALUES('Lily', 'Female', '2020-03-01', 'Basset/English Bulldog Mix', 'Medium');
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`, client_id) VALUES('Charming', 'Male', '2016-09-15', 'German Shepherd Mix', 'Large', 4);
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`) VALUES('Max', 'Male', '2013-03-18', 'Rottweiler/Poodle Mix', 'Large');
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`, client_id) VALUES('Fido', 'Male', '2019-04-04', 'Pointer', 'Medium', 6);
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`, client_id) VALUES('Cookie', 'Female', '2016-06-04', 'Husky', 'Medium', 11);
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`) VALUES('Walker', 'Male', '2018-07-07', 'Black Labrador', 'Medium');
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`, client_id) VALUES('Peter', 'Male', '2019-02-09', 'Golden Retriever', 'Medium', 7);
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`, client_id) VALUES('Momma', 'Female', '2020-02-05', 'Pug Mix', 'Small', 8);
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`) VALUES('Nugget', 'Female', '2012-09-09', 'Chihuahua', 'Toy');
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`, client_id) VALUES('Foxy', 'Female', '2017-04-03', 'Beagle', 'Medium', 9);
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`, client_id) VALUES('Zeus', 'Male', '2019-02-01', 'Newfoundland', 'Large', 10);
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`, client_id) VALUES('Brutus', 'Male', '2016-06-08', 'Bulldog', 'Medium', 8);
INSERT INTO dogs (dog_name, gender, birthday, breed, `size`) VALUES('Romeo', 'Male', '2017-07-07', 'Saint Bernard Mix', 'Large');



INSERT INTO dog_staff (dog_id, staff_id) VALUES(4, 1);
INSERT INTO dog_staff (dog_id, staff_id) VALUES(3, 2);
INSERT INTO dog_staff (dog_id, staff_id) VALUES(4, 3);
INSERT INTO dog_staff (dog_id, staff_id) VALUES(13, 2);
INSERT INTO dog_staff (dog_id, staff_id) VALUES(7, 3);
INSERT INTO dog_staff (dog_id, staff_id) VALUES(3, 3);
INSERT INTO dog_staff (dog_id, staff_id) VALUES(6, 1);
INSERT INTO dog_staff (dog_id, staff_id) VALUES(9, 2);
INSERT INTO dog_staff (dog_id, staff_id) VALUES(11, 3);
INSERT INTO dog_staff (dog_id, staff_id) VALUES(16, 3);
INSERT INTO dog_staff (dog_id, staff_id) VALUES(23, 1);
INSERT INTO dog_staff (dog_id, staff_id) VALUES(19, 2);
INSERT INTO dog_staff (dog_id, staff_id) VALUES(7, 2);
INSERT INTO dog_staff (dog_id, staff_id) VALUES(7, 1);
INSERT INTO dog_staff (dog_id, staff_id) VALUES(6, 2);




 