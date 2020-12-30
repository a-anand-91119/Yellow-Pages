CREATE TABLE `yellow_pages`.`users` ( `U_USERID` INT NOT NULL AUTO_INCREMENT , `U_NAME` VARCHAR(50) NOT NULL , `U_PHONENUMBER` VARCHAR(50) NOT NULL , `U_EMAILADDRESS` VARCHAR(50) NOT NULL , `U_ADDRESS` VARCHAR(500) NOT NULL , `U_LOGINNAME` VARCHAR(50) NOT NULL , `U_PASSWORD` VARCHAR(50) NOT NULL , `U_ROLE` INT(1) NOT NULL , `U_LOGINSTATUS` INT(1) NOT NULL , PRIMARY KEY (`U_USERID`)) ENGINE = InnoDB;

CREATE TABLE `yellow_pages`.`contacts` ( `C_CONTACTID` INT NOT NULL AUTO_INCREMENT , `C_USERID` INT NOT NULL , `C_NAME` VARCHAR(50) NOT NULL , `C_PHONENUMBER` VARCHAR(50) NOT NULL , `C_EMAILADDRESS` VARCHAR(50) NOT NULL , `C_ADDRESS` VARCHAR(500) NOT NULL , `C_REMARK` VARCHAR(500) NOT NULL , PRIMARY KEY (`C_CONTACTID`)) ENGINE = InnoDB;

ALTER TABLE `contact` ADD CONSTRAINT `UserId Constraint` FOREIGN KEY (`C_USERID`) REFERENCES `users`(`U_USERID`) ON DELETE CASCADE ON UPDATE RESTRICT;