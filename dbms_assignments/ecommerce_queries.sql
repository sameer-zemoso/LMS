create table customer (
CustId char(11) not null,
CName varchar(30) not null,
phNo INTEGER not null,
email varchar(30),
Address varchar(30),
CONSTRAINT CustIdPK PRIMARY KEY (CustId));

create table item (
itemId char(11) not null,
itemName varchar(20) not null,
itemCategory varchar(20) not null,
price float not null,
CONSTRAINT itemIdPK PRIMARY KEY (itemId));

alter table item
add column supplier varchar(20) not null;
alter table item
add constraint supplierIdFK FOREIGN KEY (supplier) references supplier (supplierId);
alter table item
add column brand varchar(20) not null;
select * from item;

create table Orders (
orderId char(11) not null,
quantity integer,
totalprice float not null,
CustId char(11) not null,
itemId char(11) not null,
CONSTRAINT itemIdFK FOREIGN KEY (itemId) references item (itemId),
CONSTRAINT CustIdFK FOREIGN KEY (CustId) references customer (CustId),
constraint orderIdPK PRIMARY KEY (orderId));

create table supplier (
supplierId char(11) not null,
CompanyName integer,
phNo INTEGER not null,
email varchar(30),
Address varchar(30),
CONSTRAINT supplierIdFK PRIMARY KEY (supplierId));
