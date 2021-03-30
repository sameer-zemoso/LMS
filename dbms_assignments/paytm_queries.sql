create table customer (
CustId char(11) not null,
CName varchar(30) not null,
phNo INTEGER not null,
email varchar(30) not null,
Address varchar(30) not null,
Aadhaar varchar(16) not null,
PanNo varchar(10) not null,
CONSTRAINT CustIdPK PRIMARY KEY (CustId));



create table branch (
branchId char(11) not null,
branchName varchar(20) not null,
IFSCcode varchar(11) not null,
Region varchar(30) not null,
constraint IFSCcodePK PRIMARY KEY (IFSCcode));

insert into branch 
(branchId,branchName,IFSCcode,Region)
VALUES ('b101','jntu','1000','hyderabad'),
('b102','ameerpet','2000','hyd');

create table accounts (
AccNo varchar(16) not null,
AccType varchar(20) not null,
Balance float not null,
CustId char(11) not null,
IFSCcode varchar(11) not null,
constraint AccNo PRIMARY KEY (AccNo),
constraint IFSCcodeFK FOREIGN KEY (IFSCcode) references branch (IFSCcode),
constraint CustIdFK FOREIGN KEY (CustId) references customer (CustId));


delimiter |
create trigger Multi_AccInBranch 
after insert on accounts 
for each row
begin 
	DECLARE ifsc varchar(11);
    select IFSCcode into ifsc from accounts where CustId = new.CustId LIMIT 1;
    IF ifsc = new.IFSCcode THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'you already have account in this branch';
	END IF;
end 
|
delimiter ;


select * from accounts;
select * from customer;
select * from branch;
