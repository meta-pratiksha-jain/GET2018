#Assignment-4
USE StoreFront;

/*
1.Consider a form where providing a Zip Code populates associated City and State. 
Create appropriate tables and relationships for the same and write a SQL
         query for that returns a Resultset containing Zip Code, City Names and
         States ordered by State Name and City Name.
*/

CREATE TABLE Zipcode(
zipcode INT NOT NULL,
city VARCHAR(100) NOT NULL,
state VARCHAR(100) NOT NULL,
PRIMARY KEY(zipcode)
);

INSERT INTO Zipcode(zipcode, city, state)
            VALUES(313001, 'udaipur', 'rajasthan'),
                  (302001, 'jaipur', 'rajasthan'),
                  (305001, 'ajmer', 'rajasthan'),
                  (282001, 'agra', 'madhya pradesh'),
                  (411001, 'pune', 'maharashtra'),
                  (321001, 'bharatpur', 'rajasthan'),
                  (400008, 'mumbai', 'maharashtra');

SELECT zipcode,city,state
FROM Zipcode
ORDER BY state,city;
