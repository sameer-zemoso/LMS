create table hotel (
hotelId char(11) not null,
hotelName varchar(30) not null,
price float,
roomsAvail integer,
CustCount integer,
CONSTRAINT hotelIdPK PRIMARY KEY (hotelId));


create table customer (
CustId char(11) not null,
CName varchar(30) not null,
phNo INTEGER not null,
AadhaarNo varchar(30) not null,
check_in datetime,
check_out datetime,
hotelId char(11),
CONSTRAINT hotelIdFK FOREIGN KEY (hotelId) REFERENCES hotel (hotelId), 
CONSTRAINT CustIdPK PRIMARY KEY (CustId));