CREATE TABLE CLIENT (
	NIT	CHAR(15) NOT NULL,
	NAME	VARCHAR(80) NOT NULL,
	PRIMARY KEY (NIT)
	);

CREATE TABLE DISPATCH (
	OWNER CHAR(15) NOT NULL,
	DISPATCH_DISPLAY_NAME CHAR(50) NOT NULL,
	ADDRESS	CHAR(60) NOT NULL,
	PRIMARY KEY (OWNER, DISPATCH_DISPLAY_NAME)
	);

CREATE TABLE INVOICE (
	SERIAL_NUMBER	CHAR(15)  NOT NULL,
	PLACED_DATE		DATE NOT NULL,
	CLIENT			CHAR(15) NOT NULL,
	PAYMENT_DAYS	NUMERIC  NOT NULL,
	DISCOUNT_PERCENTAGE NUMERIC NOT NULL,
	PRIMARY KEY (SERIAL_NUMBER)
	);

CREATE TABLE ITEM (
	ITEM_CODE 	CHAR(10) NOT NULL,
	DESCRIPTION	VARCHAR(40) NOT NULL,
	BARCODE		VARCHAR(256),
	PRIMARY KEY (ITEM_CODE)
	);

CREATE TABLE ITEM_PRICE (
	ITEM		CHAR(10) NOT NULL,
	SET_DATE	DATE NOT NULL,
	UNIT_PRICE		NUMERIC  NOT NULL,
	IVA_PERCENT	NUMERIC  NOT NULL,
	ACTIVE		CHAR(1) NOT NULL,
	PRIMARY KEY (ITEM, SET_DATE)
	);

CREATE TABLE ORDER_DETAIL (
	INVOICE		CHAR(15)  NOT NULL,
	DETAIL_ITEM		CHAR(10) NOT NULL,
	QUANTITY	NUMERIC  NOT NULL,
	UNIT_PRICE NUMERIC NOT NULL,
	IVA_PERCENT NUMERIC NOT NULL,
	PRIMARY KEY (INVOICE, DETAIL_ITEM)
	);

CREATE TABLE ENVIRONMENT_SETTINGS (
	PROPERTY_NAME		CHAR(20) NOT NULL,
	PROPERTY_SET_DATE	DATE NOT NULL,
	VALUE				VARCHAR(128) NOT NULL,
	ACTIVE				CHAR(1) NOT NULL,
	PRIMARY KEY (PROPERTY_NAME, PROPERTY_SET_DATE)
	);
