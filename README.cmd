This is a simple demo of Springboot application

Preparation:
1. logon psql console:
psql -U postgres
2. Create database:
create database student;
create user tester with encrypted password 'password';
grant all privileges on database "student" to postgres;
grant all privileges on database "student" to tester;

\c student

select * from student;


with these setup, the application should be to run with the standard CRUD operations.
