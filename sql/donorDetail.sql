create table donor_detail(
user_name varchar(100) not null unique,
donor_blood varchar(5) not null,
donor_name varchar(100) not null,
donor_number varchar(12) not null,
donor_age int not null,
donor_place varchar(100) not null,
donor_status varchar(10));
