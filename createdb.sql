use yoyakusystem;

create table user (
userId serial ,
userName varchar(64) NOT NULL default '',
email varchar(64) NOT NULL default '',
password varchar(4) NOT NULL default '',
PRIMARY KEY (userId)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create table reservation (
reId serial ,
roomId int not null,
week int,
date date,
startTime time,
endTime time,
userId int not null,
usageId int not null,
PRIMARY KEY(reId)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create table room (
roomId int,
roomName varchar(32) NOT NULL default '',
PRIMARY KEY (roomId)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create table week(
week int,
PRIMARY KEY (week)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

create table mokuteki (
usageId serial,
mokuteki varchar(64) NOT NULL default '',
PRIMARY KEY (usageId)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

use yoyakusystem;

insert into room (roomId,roomName) VALUE (1,'��c��');

insert into room (roomId,roomName) VALUE (2,'���ڎ�');

insert into room (roomId,roomName) VALUE (3,'���t���b�V���X�y�[�X');

insert into week (week) VALUE(1);

insert into week (week) VALUE(2);

insert into week (week) VALUE(3);

insert into week (week) VALUE(4);

insert into week (week) VALUE(5);


insert into user (userName,email,password) VALUE ('���X','komori@level-five.jp','0000');

insert into user (userName,email,password) VALUE ('�吼','onishi@level-five.jp','9999');

insert into mokuteki (mokuteki) VALUE ('��c');

insert into mokuteki (mokuteki) VALUE ('���q����');

insert into mokuteki (mokuteki) VALUE ('���C');

insert into mokuteki (mokuteki) VALUE ('�׋���');

insert into mokuteki (mokuteki) VALUE ('�A�Љ�');

insert into mokuteki (mokuteki) VALUE ('���̑�');


insert into reservation (roomID,date,week,startTime,endTime,userId,usageId) VALUE (1,'2015-06-25',null,'11:00','12:00',1,1);
insert into reservation (roomID,date,week,startTime,endTime,userId,usageId) VALUE (1,'2015-06-25',null,'11:00','12:00',1,1);

