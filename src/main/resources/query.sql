create table user
(
    user_id    int primary key auto_increment,
    surname    varchar(255),
    name       varchar(255),
    fatherName varchar(255),
    birthday   varchar(255),
    position   varchar(255),
    finCode    varchar(255)
);

DELIMITER //

CREATE PROCEDURE GetAllUsers()
BEGIN
    SELECT * FROM user;
END //

DELIMITER ;