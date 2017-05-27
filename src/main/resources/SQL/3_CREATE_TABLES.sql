USE TP_PermisPiste;

/*
DROP TABLE IF EXISTS users_actions;
DROP TABLE IF EXISTS trainings_actions;

DROP TABLE IF EXISTS missions_goals;
DROP TABLE IF EXISTS goals_actions;
DROP TABLE IF EXISTS papers_missions;
DROP TABLE IF EXISTS trainings_papers;
DROP TABLE IF EXISTS trainings_rules;
DROP TABLE IF EXISTS trainings_users;

DROP TABLE IF EXISTS rules;
DROP TABLE IF EXISTS missions;
DROP TABLE IF EXISTS papers;
DROP TABLE IF EXISTS goals;
DROP TABLE IF EXISTS actions;
DROP TABLE IF EXISTS trainings;
DROP TABLE IF EXISTS logs;
DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS users;
*/


CREATE TABLE users (
  id               INT PRIMARY KEY NOT NULL,
  lastname         VARCHAR(70)     NOT NULL,
  firstname        VARCHAR(70)     NOT NULL,
  email            VARCHAR(70)     NOT NULL UNIQUE,
  password         VARCHAR(70)     NOT NULL,
  is_enabled       BOOLEAN         NOT NULL,
  is_administrator BOOLEAN         NOT NULL
);

CREATE TABLE logs (
  id         INT PRIMARY KEY NOT NULL,
  user       INT             NOT NULL,
  date       DATETIME        NOT NULL,
  ip_address VARCHAR(20)     NOT NULL,
  CONSTRAINT FK_log_user FOREIGN KEY (user) REFERENCES users (id)
);

CREATE TABLE messages (
  id      INT PRIMARY KEY NOT NULL,
  subject VARCHAR(70)     NOT NULL,
  body    VARCHAR(70)     NOT NULL,
  date    DATETIME        NOT NULL,
  is_read BOOLEAN         NOT NULL,
  user    INT             NOT NULL,
  CONSTRAINT FK_message_user FOREIGN KEY (user) REFERENCES users (id)
);

CREATE TABLE actions (
  id    INT PRIMARY KEY NOT NULL,
  label VARCHAR(70)     NOT NULL UNIQUE
);

CREATE TABLE goals (
  id    INT PRIMARY KEY NOT NULL,
  label VARCHAR(70)     NOT NULL UNIQUE
);

CREATE TABLE missions (
  id    INT PRIMARY KEY NOT NULL,
  label VARCHAR(70)     NOT NULL UNIQUE
);

CREATE TABLE papers (
  id    INT PRIMARY KEY NOT NULL,
  label VARCHAR(70)     NOT NULL UNIQUE
);

CREATE TABLE trainings (
  id          INT PRIMARY KEY NOT NULL,
  label       VARCHAR(70)     NOT NULL UNIQUE,
  description VARCHAR(70)     NOT NULL,
  image_path  VARCHAR(70)
);

CREATE TABLE rules (
  id            INT PRIMARY KEY NOT NULL,
  label         VARCHAR(70)     NOT NULL UNIQUE,
  minimal_score INT             NOT NULL
);

CREATE TABLE trainings_users (
  training INT NOT NULL,
  user     INT NOT NULL,
  PRIMARY KEY (training, user),
  CONSTRAINT FK_training_user FOREIGN KEY (training) REFERENCES trainings (id),
  CONSTRAINT FK_user_training FOREIGN KEY (user) REFERENCES users (id)
);

CREATE TABLE trainings_papers (
  training INT NOT NULL,
  paper    INT NOT NULL,
  PRIMARY KEY (training, paper),
  CONSTRAINT FK_paper_training FOREIGN KEY (training) REFERENCES trainings (id),
  CONSTRAINT FK_training_paper FOREIGN KEY (paper) REFERENCES papers (id)
);

CREATE TABLE papers_missions (
  paper   INT NOT NULL,
  mission INT NOT NULL,
  PRIMARY KEY (paper, mission),
  CONSTRAINT FK_mission_paper FOREIGN KEY (paper) REFERENCES papers (id),
  CONSTRAINT FK_paper_mission FOREIGN KEY (mission) REFERENCES missions (id)
);

CREATE TABLE missions_goals (
  mission INT NOT NULL,
  goal    INT NOT NULL,
  PRIMARY KEY (mission, goal),
  CONSTRAINT FK_goal_mission FOREIGN KEY (mission) REFERENCES missions (id),
  CONSTRAINT FK_mission_goal FOREIGN KEY (goal) REFERENCES goals (id)
);

CREATE TABLE goals_actions (
  goal   INT NOT NULL,
  action INT NOT NULL,
  PRIMARY KEY (goal, action),
  CONSTRAINT FK_action_goal FOREIGN KEY (goal) REFERENCES goals (id),
  CONSTRAINT FK_goal_action FOREIGN KEY (action) REFERENCES actions (id)
);

CREATE TABLE users_actions (
  user         INT NOT NULL,
  training     INT NOT NULL,
  paper        INT NOT NULL,
  mission      INT NOT NULL,
  goal         INT NOT NULL,
  action       INT NOT NULL,
  offset       INT NOT NULL,
  elasped_time INT NOT NULL,
  PRIMARY KEY (user, training, paper, mission, goal, action),
  CONSTRAINT FK_user_action FOREIGN KEY (user) REFERENCES users (id),
  CONSTRAINT FK_action_training FOREIGN KEY (training) REFERENCES trainings (id),
  CONSTRAINT FK_action_paper FOREIGN KEY (paper) REFERENCES papers (id),
  CONSTRAINT FK_action_mission FOREIGN KEY (mission) REFERENCES missions (id),
  CONSTRAINT FK_action_goal2 FOREIGN KEY (goal) REFERENCES goals (id),
  CONSTRAINT FK_action_user FOREIGN KEY (action) REFERENCES actions (id)
);

CREATE TABLE trainings_actions (
  training INT NOT NULL,
  paper    INT NOT NULL,
  mission  INT NOT NULL,
  goal     INT NOT NULL,
  action   INT NOT NULL,
  offset   INT NOT NULL,
  PRIMARY KEY (training, paper, mission, goal, action),
  CONSTRAINT FK_training_action FOREIGN KEY (training) REFERENCES trainings (id),
  CONSTRAINT FK_paper_action FOREIGN KEY (paper) REFERENCES papers (id),
  CONSTRAINT FK_mission_action FOREIGN KEY (mission) REFERENCES missions (id),
  CONSTRAINT FK_goal_action2 FOREIGN KEY (goal) REFERENCES goals (id),
  CONSTRAINT FK_training_actions FOREIGN KEY (action) REFERENCES actions (id)
);

CREATE TABLE trainings_rules (
  training INT NOT NULL,
  rule     INT NOT NULL,
  PRIMARY KEY (training, rule),
  CONSTRAINT FK_rule_training FOREIGN KEY (training) REFERENCES trainings (id),
  CONSTRAINT FK_training_rule FOREIGN KEY (rule) REFERENCES rules (id)
);