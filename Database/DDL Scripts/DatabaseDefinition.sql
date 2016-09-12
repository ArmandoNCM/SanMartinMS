CREATE TABLE CLIENT (
	NIT	CHAR(15) NOT NULL,
	NAME	CHAR(40) NOT NULL,
	PRIMARY KEY (NIT)
	);

CREATE TABLE ADDRESS (
	ADDRESS	CHAR(64) NOT NULL,
	CLIENT	CHAR(15) NOT NULL,
	PRIMARY KEY (ADDRESS)
	);

CREATE TABLE INVOICE (
	SERIAL_NUMBER	NUMERIC  NOT NULL,
	PLACED_DATE		DATE NOT NULL,
	CLIENT			CHAR(15) NOT NULL,
	PAYMENT_DAYS	NUMERIC  NOT NULL,
	PRIMARY KEY (SERIAL_NUMBER)
	);

CREATE TABLE ITEM (
	ITEM_CODE 	CHAR(10) NOT NULL,
	DESCRIPTION	CHAR(20) NOT NULL,
	BARCODE		VARCHAR(20),
	PRIMARY KEY (ITEM_CODE)
	);

CREATE TABLE ITEM_PRICE (
	ITEM		CHAR(10) NOT NULL,
	SET_DATE	DATE NOT NULL,
	PRICE		NUMERIC  NOT NULL,
	IVA_PERCENT	NUMERIC  NOT NULL,
	ACTIVE		CHAR(1) DEFAULT 'N' CHECK (ACTIVE IN ('Y','N'))  NOT NULL,
	PRIMARY KEY (ITEM, SET_DATE)
	);

CREATE TABLE ORDER_DETAIL (
	INVOICE		NUMERIC  NOT NULL,
	ITEM		CHAR(10) NOT NULL,
	QUANTITY	NUMERIC  NOT NULL,
	PRIMARY KEY (INVOICE, ITEM)
	);
