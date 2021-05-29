create table user_credential(
username varchar(100) not null,
userpassword varchar(100) not null unique key,
userbloodgroup varchar(5) not null,
usermobilenumber varchar(100) not null unique key,
userage int not null,
userplace varchar(100) not null);