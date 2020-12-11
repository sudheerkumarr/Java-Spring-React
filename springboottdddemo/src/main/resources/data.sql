DROP TABLE IF EXISTS projects;

CREATE TABLE projects (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  proj_identifier VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL
 
);

INSERT INTO projects (id, name, proj_identifier, description) VALUES ('101','First Project','fp01','First Project Description');
INSERT INTO projects (id, name, proj_identifier, description) VALUES ('102','Second Project','sp02','Second Project Description');
INSERT INTO projects (id, name, proj_identifier, description) VALUES ('103','Third Project','tp03','Third Project Description');

