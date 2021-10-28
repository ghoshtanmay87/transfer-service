create table account(
account_no varchar(20) primary key,
account_name varchar(255),
balance decimal(20, 2),
version bigint);

insert into account (account_no, account_name, balance, version) values ('A10000', 'Jones', 1000.00, 1);
insert into account (account_no, account_name, balance, version) values ('B20000', 'Morgan', 1000.00, 1);
insert into account (account_no, account_name, balance, version) values ('C30000', 'Smith', 1000.00, 1);

commit;

create table transfer_data(
transfer_id varchar(50) primary key,
source_ac varchar(50),
destination_ac varchar(50),
amount number,
transfer_status varchar(20),
transfer_timestamp timestamp);