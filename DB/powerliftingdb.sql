-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema powerliftingdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `powerliftingdb` ;

-- -----------------------------------------------------
-- Schema powerliftingdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `powerliftingdb` DEFAULT CHARACTER SET utf8 ;
USE `powerliftingdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(200) NULL,
  `last_name` VARCHAR(200) NULL,
  `weight` INT NULL,
  `height` VARCHAR(200) NULL,
  `age` INT NULL,
  `gender` VARCHAR(45) NULL,
  `bench_pr` INT NULL,
  `squat_pr` INT NULL,
  `deadlift_pr` INT NULL,
  `username` VARCHAR(200) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `role` VARCHAR(45) NOT NULL DEFAULT 'user',
  `active` TINYINT NOT NULL DEFAULT 1,
  `date_created` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `training_day_lift`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `training_day_lift` ;

CREATE TABLE IF NOT EXISTS `training_day_lift` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '\n\n\n\n\n\n\n*******************',
  `training_lift` VARCHAR(200) NULL,
  `first_set_weight` INT NULL,
  `second_set_weight` INT NULL,
  `third_set_weight` INT NULL,
  `amrap_weight` INT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tranning_day_plan_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_tranning_day_plan_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `training_day_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `training_day_log` ;

CREATE TABLE IF NOT EXISTS `training_day_log` (
  `id` INT NOT NULL,
  `lift_log` VARCHAR(45) NULL,
  `first_set_rep_total` INT NULL,
  `second_set_rep_total` INT NULL,
  `third_set_rep_total` INT NULL,
  `amrap_rep_total` INT NULL,
  `rpe` INT NULL,
  `date_created` DATETIME NULL,
  `training_day_lift_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_training_day_record_training_day_lift1_idx` (`training_day_lift_id` ASC),
  INDEX `fk_training_day_record_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_training_day_record_training_day_lift1`
    FOREIGN KEY (`training_day_lift_id`)
    REFERENCES `training_day_lift` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_training_day_record_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `accessory_work`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `accessory_work` ;

CREATE TABLE IF NOT EXISTS `accessory_work` (
  `id` INT NOT NULL,
  `exercise` VARCHAR(45) NULL,
  `weight` VARCHAR(45) NULL,
  `sets` VARCHAR(45) NULL,
  `training_day_lift_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_accessory_work_training_day_lift1_idx` (`training_day_lift_id` ASC),
  CONSTRAINT `fk_accessory_work_training_day_lift1`
    FOREIGN KEY (`training_day_lift_id`)
    REFERENCES `training_day_lift` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warmup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `warmup` ;

CREATE TABLE IF NOT EXISTS `warmup` (
  `id` INT NOT NULL,
  `warmup_exercise` VARCHAR(45) NULL,
  `warmup_strech` VARCHAR(45) NULL,
  `foam_roll` TINYINT NULL,
  `training_day_lift_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_warmup_training_day_lift1_idx` (`training_day_lift_id` ASC),
  CONSTRAINT `fk_warmup_training_day_lift1`
    FOREIGN KEY (`training_day_lift_id`)
    REFERENCES `training_day_lift` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS powerlifter;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'powerlifter' IDENTIFIED BY 'powerlifter';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'powerlifter';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `powerliftingdb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `weight`, `height`, `age`, `gender`, `bench_pr`, `squat_pr`, `deadlift_pr`, `username`, `password`, `role`, `active`, `date_created`) VALUES (1, 'Nathan', 'Hafley', 230, '6', 29, 'Male', 300, 365, 455, 'Nateomancer', 'Jake1992', 'admin', 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `training_day_lift`
-- -----------------------------------------------------
START TRANSACTION;
USE `powerliftingdb`;
INSERT INTO `training_day_lift` (`id`, `training_lift`, `first_set_weight`, `second_set_weight`, `third_set_weight`, `amrap_weight`, `user_id`) VALUES (1, 'Bench', 235, 250, 270, 185, 1);
INSERT INTO `training_day_lift` (`id`, `training_lift`, `first_set_weight`, `second_set_weight`, `third_set_weight`, `amrap_weight`, `user_id`) VALUES (2, 'Squat', 275, 295, 310, 225, 1);
INSERT INTO `training_day_lift` (`id`, `training_lift`, `first_set_weight`, `second_set_weight`, `third_set_weight`, `amrap_weight`, `user_id`) VALUES (3, 'Deadlift', 315, 340, 385, 275, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `training_day_log`
-- -----------------------------------------------------
START TRANSACTION;
USE `powerliftingdb`;
INSERT INTO `training_day_log` (`id`, `lift_log`, `first_set_rep_total`, `second_set_rep_total`, `third_set_rep_total`, `amrap_rep_total`, `rpe`, `date_created`, `training_day_lift_id`, `user_id`) VALUES (1, 'Bench', 5, 3, 1, 10, 8, NULL, 1, 1);
INSERT INTO `training_day_log` (`id`, `lift_log`, `first_set_rep_total`, `second_set_rep_total`, `third_set_rep_total`, `amrap_rep_total`, `rpe`, `date_created`, `training_day_lift_id`, `user_id`) VALUES (2, 'Squat', 5, 3, 1, 7, 9, NULL, 2, 1);
INSERT INTO `training_day_log` (`id`, `lift_log`, `first_set_rep_total`, `second_set_rep_total`, `third_set_rep_total`, `amrap_rep_total`, `rpe`, `date_created`, `training_day_lift_id`, `user_id`) VALUES (3, 'Deadlift', 5, 3, 1, 8, 8, NULL, 3, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `accessory_work`
-- -----------------------------------------------------
START TRANSACTION;
USE `powerliftingdb`;
INSERT INTO `accessory_work` (`id`, `exercise`, `weight`, `sets`, `training_day_lift_id`) VALUES (1, 'Shoulder Press', '185', '3', 1);
INSERT INTO `accessory_work` (`id`, `exercise`, `weight`, `sets`, `training_day_lift_id`) VALUES (2, 'Tricep Pushdowns', '165', '3', 1);
INSERT INTO `accessory_work` (`id`, `exercise`, `weight`, `sets`, `training_day_lift_id`) VALUES (3, 'Hack Squat', '225', '3', 2);
INSERT INTO `accessory_work` (`id`, `exercise`, `weight`, `sets`, `training_day_lift_id`) VALUES (4, 'Leg Press', '405', '3', 2);
INSERT INTO `accessory_work` (`id`, `exercise`, `weight`, `sets`, `training_day_lift_id`) VALUES (5, 'Romanian Deadlifts', '225', '3', 3);
INSERT INTO `accessory_work` (`id`, `exercise`, `weight`, `sets`, `training_day_lift_id`) VALUES (6, 'Hamstring Curls', '165', '3', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `warmup`
-- -----------------------------------------------------
START TRANSACTION;
USE `powerliftingdb`;
INSERT INTO `warmup` (`id`, `warmup_exercise`, `warmup_strech`, `foam_roll`, `training_day_lift_id`) VALUES (1, 'Push Ups', 'Shoulder Stretch', 1, 1);
INSERT INTO `warmup` (`id`, `warmup_exercise`, `warmup_strech`, `foam_roll`, `training_day_lift_id`) VALUES (2, 'Body Squats', 'Quad Stretch', 1, 2);
INSERT INTO `warmup` (`id`, `warmup_exercise`, `warmup_strech`, `foam_roll`, `training_day_lift_id`) VALUES (3, 'Light Cardio', 'Hamstring Stretch', 1, 3);

COMMIT;

