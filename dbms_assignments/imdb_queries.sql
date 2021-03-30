create table movies (
MovieId char(11) not null,
MovieName varchar(30) not null,
actorId char(11) not null,
production varchar(30) not null,
genre varchar(30) not null,
CONSTRAINT MovieIdPK PRIMARY KEY (MovieId),
CONSTRAINT actorIdFK FOREIGN KEY (actorId) references actor (actorId));

create table actor (
actorId char(11) not null,
actorName varchar(30) not null,
Age integer not null,
phNo integer not null,
moviesActed integer not null,
TvsActed integer not null,
CONSTRAINT actorIdPK PRIMARY KEY (actorId));

create table TVseries (
TvseriesId char(11) not null,
TvsName varchar(30) not null,
actorId char(11) not null,
production varchar(30) not null,
genre varchar(30) not null,
CONSTRAINT TvseriesIdPK PRIMARY KEY (TvseriesId),
CONSTRAINT actorIdTVSFK FOREIGN KEY (actorId) references actor (actorId));