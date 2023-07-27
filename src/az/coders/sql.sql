create table Student (
                         id int primary key,
                         name varchar(255) not null,
                         surname varchar(255) not null,
                         address varchar(255) not null,
                         mail varchar(255) not null,
                         created timestamp not null
);

create table teacher (
                         id int primary key,
                         name varchar(255) not null,
                         surname varchar(255) not null,
                         address varchar(255) not null,
                         mail varchar(255) not null,
                         created timestamp not null
);

create table group_of (
                          id int primary key,
                          name varchar(20) not null,
                          lesson varchar(255) not null
);

ALTER TABLE student
    ADD COLUMN group_id int;


ALTER TABLE student
    ADD CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES group_of (id);

ALTER TABLE group_of
    ADD COLUMN teacher_id int;

ALTER TABLE group_of
    ADD CONSTRAINT fk_teacher_id FOREIGN KEY (teacher_id) REFERENCES teacher (id);

CREATE SEQUENCE auto_inc
    MINVALUE 1
    MAXVALUE 9999999
    START WITH 1
    INCREMENT BY 1;



CREATE SEQUENCE auto_inc_teacher
    MINVALUE 100
    MAXVALUE 9999999
    START WITH 100
    INCREMENT BY 1;

CREATE SEQUENCE auto_inc_group
    MINVALUE 1000
    MAXVALUE 9999999
    START WITH 1000
    INCREMENT BY 1;

ALTER TABLE student
    ALTER COLUMN id SET DEFAULT nextval('auto_inc');

ALTER TABLE teacher
    ALTER COLUMN id SET DEFAULT nextval('auto_inc_teacher');

ALTER TABLE group_of
    ALTER COLUMN id SET DEFAULT nextval('auto_inc_group');
