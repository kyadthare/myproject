	DROP TABLE PROVIDER;
	
	DROP TABLE QUALITYSTARRATING;
	
	DROP TABLE ADDRESS;
	
	DROP TABLE PROVIDERTYPE;
	
	CREATE TABLE QUALITYSTARRATING
	(
	RATINGID        INT NOT NULL,
	DESCRIPTION TEXT,
    PRIMARY KEY (RATINGID)
	);
	
	CREATE TABLE ADDRESS
	(
	ADDRESSID        INT NOT NULL,
	CITY TEXT,
	COUNTYNUMBER INT NOT NULL,
	COUNTY TEXT,
	ZIPCODE INT,
	PRIMARY KEY (ADDRESSID)
	);
	
	CREATE TABLE PROVIDERTYPE
	(
	TypeId        INT NOT NULL,
	Description TEXT,
	PRIMARY KEY (TypeId)
	);
	
	CREATE TABLE PROVIDER
	(
	PROVIDERID        INT NOT NULL,
	Name    TEXT,
	LICENSETYPE      TEXT,
	TypeId     INT NOT NULL,
	ADDRESSID     INT NOT NULL,
	RATINGID       INT NOT NULL,
	Capacity INT NOT NULL,
	PHONENUMBER 	TEXT,
	PRIMARY KEY (PROVIDERID),
	FOREIGN KEY (TYPEID) REFERENCES PROVIDERTYPE (TypeId),
	FOREIGN KEY (ADDRESSID) REFERENCES ADDRESS (ADDRESSID),
	FOREIGN KEY (RATINGID) REFERENCES QUALITYSTARRATING (RATINGID)
	);
	
	COMMIT;