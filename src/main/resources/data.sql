INSERT IGNORE INTO roles(id,name) 
VALUES 	('1','ADMIN'),
		('2','STAFF'),
		('3','CUSTOMER');

INSERT IGNORE INTO users (id, email, first_name, password, role_id)
VALUES ('1','admin@sheridan.com', 'Admin', '$2a$10$a3A0JC757FLZqHYVvEJq7uNaYz3AW8320IHORzmljQN43Hkmi4T7C','1');

INSERT IGNORE INTO room_type (id, price, type)
VALUES 	('1','50.00','Semi Deluxe'),
		('2','100.00','Deluxe'),
		('3','150.00','Luxury');

