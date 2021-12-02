insert into course(id, name, created_date, last_updated_date) values (10001, 'JPA in 50 steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) values (10002, 'Hibernate in 50 steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) values (10003, 'Springboot in 50 steps', sysdate(), sysdate());

insert into passport(id, number) values(30001, '1233');
insert into passport(id, number) values(30002, '23332');
insert into passport(id, number) values(30003, '33534');

insert into student(id, name, passport_id) values(20001, 'Niel', 30001);
insert into student(id, name, passport_id) values(20002, 'Jack', 30002);
insert into student(id, name, passport_id) values(20003, 'Me', 30003);

insert into review(rating, description) values('5', 'Great Course');
insert into review(rating, description) values('3', 'Okay');
insert into review(rating, description) values('1', 'Horrible');