CREATE TABLE Category(
CategoryID int,
Name varchar(30)
);
SELECT * FROM Category ORDER BY CategoryID;
INSERT INTO Category(CategoryID, Name) VALUES (1, 'school')
INSERT INTO Category(CategoryID, Name) VALUES (2, 'hobby')
INSERT INTO Category(CategoryID, Name) VALUES (3, 'home');

CREATE TABLE Priority(
PriorityID int,
Name varchar(30)
);
SELECT * FROM Priority ORDER BY PriorityID;
INSERT INTO Priority(PriorityID, Name) VALUES (1, 'low')
INSERT INTO Priority(PriorityID, Name) VALUES (2, 'medium')
INSERT INTO Priority(PriorityID, Name) VALUES (3, 'high')

CREATE TABLE Difficulty(
DifficultyID int,
Name varchar(30)
);
SELECT * FROM Difficulty ORDER BY DifficultyID;
INSERT INTO Difficulty(DifficultyID, Name) VALUES (1, 'easy')
INSERT INTO Difficulty(DifficultyID, Name) VALUES (2, 'medium')
INSERT INTO Difficulty(DifficultyID, Name) VALUES (3, 'hard')