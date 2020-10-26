create table train (
TrainNo char(11) not null,
TName varchar(30) not null,
startStation varchar(30) not null,
endStation varchar(30) not null,
DateAvail varchar(10) not null,
seatsAvail INTEGER,
CONSTRAINT TrainNoPK PRIMARY KEY (TrainNo));

insert into train
(TrainNo, TName, startStation, endStation, DateAvail, seatsAvail)
 VALUES ('12734', 'Narayanadri Express', 'Secbd', 'Tirupati','22-10-2020',100);
insert into train
(TrainNo, TName, startStation, endStation, DateAvail, seatsAvail)
 VALUES ('12806', 'Janmabhoomi Express', 'Secbd', 'Vizag','23-10-2020',100); 
 
desc train;

create table customer (
CustId char(11) not null,
CName varchar(30) not null,
Age INTEGER not null,
Gender varchar(10) not null,
phNo INTEGER not null,
Quota varchar(30) not null,
TrainNo char(11),
CONSTRAINT TrainNoFK FOREIGN KEY (TrainNo) REFERENCES train (TrainNo), 
CONSTRAINT CustIdPK PRIMARY KEY (CustId));

ALTER table customer 
MODIFY phNo varchar(10) not null;

insert into customer
(CustId,CName,Age,Gender,phNo,Quota)
VALUES ('101','Sameer',22,'M','9876543210','null');

insert into customer
(CustId,CName,Age,Gender,phNo,Quota)
VALUES ('102','Rao',60,'M','9876543211','Sr.Citizen');
select * from customer;

insert into customer
(CustId,CName,Age,Gender,phNo,Quota)
VALUES ('103','Sanjay',42,'M','9876543212','Divyaang');

insert into customer
(CustId,CName,Age,Gender,phNo,Quota)
VALUES ('104','Raju',23,'M','9876543213','null');

update customer set phNo = '9876543213' where CustId='104';

alter table customer
add constraint phNoUnique UNIQUE(phNo);

desc customer; 

create table station (
StationId char(11) not null,
StationName varchar(30) not null,
ArrivalTime varchar(30) not null,
DepartTime varchar(30) not null,
TrainNo char(11) not null,
CONSTRAINT TrainNoStationFK FOREIGN KEY (TrainNo) REFERENCES train (TrainNo),
CONSTRAINT StationIdPK PRIMARY KEY (StationId));

select * from train;

INSERT INTO station 
(StationId, StationName, ArrivalTime, DepartTime, TrainNo)
VALUES ('NLDA','Nalgonda','19:38','19:39','12734');

INSERT INTO station 
(StationId, StationName, ArrivalTime, DepartTime, TrainNo)
VALUES ('GNT','Guntur','22:55','23:10','12734'),
('RU','Renigunta','05:30','05:32','12734');

INSERT INTO station 
(StationId, StationName, ArrivalTime, DepartTime, TrainNo)
VALUES ('SC','Secunderabad','18:05','18:05','12734'),
('TPTY','Tirupati','06:05','ends','12734');

update station set ArrivalTime = 'starts' where StationId='SC';

select * from station;

create table ticket (
TicketNo char(11) not null,
TrainNo char(11) not null,
CustId char(11) not null,
BookingType varchar(30) not null,
BhogiNo varchar(11) not null,
SeatNo varchar(5) not null,
FromStation varchar(30) not null,
ToStation varchar(30) not null,
class varchar(10) not null,
RStatus varchar(12) not null,
cost float not null,
BookMeal varchar(5),
CONSTRAINT TicketNoPK PRIMARY KEY (TicketNo),
CONSTRAINT TrainNoTicketFK FOREIGN KEY (TrainNo) REFERENCES train (TrainNo),
CONSTRAINT CustIdFK FOREIGN KEY (CustId) REFERENCES customer (CustId) );

delimiter |
create trigger dupliCust
after insert on ticket for each row
begin
	DECLARE cidTicket varchar(10);
    DECLARE tNoTicket varchar(11);
	DECLARE tNoCust varchar(11);
    DECLARE tSeats INTEGER;
	select new.CustId into cidTicket from ticket limit 1;
    select new.TrainNo into tNoTicket from ticket limit 1;
    select trainNo into tNoCust from customer where CustId=new.CustId limit 1;
    select seatsAvail into tSeats from train where trainNo = new.TrainNo;
	IF tNoCust IS null THEN
		UPDATE customer SET TrainNo=new.TrainNo where CustId=new.CustId;
	ELSE 
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'customer already has train ticket';
	END IF;
    IF tSeats <> 0 AND new.RStatus = 'unreserved' THEN
		UPDATE train SET seatsAvail = seatsAvail - 0 where TrainNo = new.TrainNo;
    ELSEIF tSeats <> 0 AND new.RStatus = 'reserved' THEN
		UPDATE train SET seatsAvail = seatsAvail - 1 where TrainNo = new.TrainNo;
	ELSEIF TSeats = 0 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'seats full';
	END IF;
end 
|
delimiter ;

insert into ticket
(TicketNo,TrainNo,CustId,BookingType,BhogiNo,SeatNo,FromStation,ToStation,class,RStatus,cost,BookMeal)
VALUES ('4567f','12734','101','tathkal','S8','201-U','Secunderabad','Tirupati','AC','reserved','700.5','YES');

insert into ticket
(TicketNo,TrainNo,CustId,BookingType,BhogiNo,SeatNo,FromStation,ToStation,class,RStatus,cost,BookMeal)
VALUES ('4568f','12806','102','tathkal','S3','205-L','Secunderabad','Vizag','Non-AC','reserved','890.6','YES');

insert into ticket
(TicketNo,TrainNo,CustId,BookingType,BhogiNo,SeatNo,FromStation,ToStation,class,RStatus,cost,BookMeal)
VALUES ('4569f','12734','103','general','S3','205-L','Secunderabad','Tirupati','passenger','unreserved','250.0','YES');



select * from ticket;

select * from customer;
update customer set trainNo = null where CustId = '101';

drop trigger dupliCust;

delete from ticket where TicketNo='4567f';
select * from train;

update train set seatsAvail=100 where trainNo='12734'; 

select 