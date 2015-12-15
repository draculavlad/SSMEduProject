/* db create sql */

CREATE TABLE `edu`.`students` (
  `studentId` INT NOT NULL AUTO_INCREMENT,
  `studentName` NVARCHAR(50) NOT NULL,
  `gender` NVARCHAR(50) NOT NULL,
  PRIMARY KEY (`studentId`),
  UNIQUE INDEX `studentId_UNIQUE` (`studentId` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8
COMMENT = 'table ‘students’ for test usage';

/* db create sql */

CREATE TABLE `edu`.`subjects` (
  `subjectId` INT NOT NULL AUTO_INCREMENT,
  `subjectName` NVARCHAR(50) NOT NULL,
  `created` DATETIME NOT NULL,
  PRIMARY KEY (`subjectId`),
  UNIQUE INDEX `subjectId_UNIQUE` (`subjectId` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8
COMMENT = 'table subjects for edu usage';

/* db create sql */

CREATE TABLE `edu`.`signins` (
  `signinId` INT NOT NULL AUTO_INCREMENT,
  `studentId` INT NOT NULL,
  `subjectId` INT NOT NULL,
  PRIMARY KEY (`signinId`),
  UNIQUE INDEX `signinId_UNIQUE` (`signinId` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8
COMMENT = 'table ‘signing’ for edu usage';

/* db create sql */

CREATE TABLE `edu`.`teachers` (
  `teacherId` INT NOT NULL AUTO_INCREMENT,
  `teacherName` NVARCHAR(50) NOT NULL,
  `subjectId` INT NOT NULL,
  PRIMARY KEY (`teacherId`),
  UNIQUE INDEX `teacherId_UNIQUE` (`teacherId` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8
COMMENT = 'table ‘teachers’ for test usage';



