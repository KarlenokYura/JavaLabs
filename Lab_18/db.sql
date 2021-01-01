CREATE TABLE reference (
    id INT NOT NULL IDENTITY PRIMARY KEY,
    url NVARCHAR(50) NOT NULL,
    description NVARCHAR(50) NOT NULL,
	minus INT,
	plus INT
);

CREATE TABLE comment (
    id INT NOT NULL IDENTITY PRIMARY KEY,
    refId INT NOT NULL FOREIGN KEY REFERENCES reference(id),
    sessionId NVARCHAR(50) NOT NULL,
	stamp DATE,
	comment NVARCHAR(50) NOT NULL
);

select * from reference where description like 'A' or description like 'B';