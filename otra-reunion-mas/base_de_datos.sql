CREATE DATABASE `otrareunionmas` 
/*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */
/*!80016 DEFAULT ENCRYPTION='N' */;

-- otrareunionmas.reunion definition

CREATE TABLE reunion (
  id int NOT NULL AUTO_INCREMENT,
  fecha datetime DEFAULT NULL,
  asunto varchar(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;