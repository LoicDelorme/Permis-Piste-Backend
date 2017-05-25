USE TP_PermisPiste;

--DROP TABLE users;
CREATE TABLE users (
	id INT PRIMARY KEY NOT NULL,
    lastname VARCHAR(70) NOT NULL,
    firstname VARCHAR(70) NOT NULL,
    email VARCHAR(70) NOT NULL UNIQUE,
    password VARCHAR(70) NOT NULL,
    is_enabled BOOLEAN NOT NULL,
    is_administrator BOOLEAN NOT NULL
);

--DROP TABLE users_logs;
CREATE TABLE users_logs (
	id INT PRIMARY KEY NOT NULL,
    user INT NOT NULL,
    date DATETIME NOT NULL,
    ip_address VARCHAR(20) NOT NULL,
    FOREIGN KEY (user) REFERENCES users(id)
);

--DROP TABLE messages;
CREATE TABLE messages (
	id INT PRIMARY KEY NOT NULL,
    subject VARCHAR(70) NOT NULL,
    body VARCHAR(70) NOT NULL,
    date DATETIME NOT NULL,
    is_read BOOLEAN NOT NULL,
    user INT NOT NULL,
    FOREIGN KEY (user) REFERENCES users(id)
);

--DROP TABLE actions;
CREATE TABLE actions (
	id INT PRIMARY KEY NOT NULL,
    label VARCHAR(70) NOT NULL UNIQUE
);

--DROP TABLE goals;
CREATE TABLE goals (
	id INT PRIMARY KEY NOT NULL,
    label VARCHAR(70) NOT NULL UNIQUE
);

--DROP TABLE missions;
CREATE TABLE missions (
	id INT PRIMARY KEY NOT NULL,
    label VARCHAR(70) NOT NULL UNIQUE
);

--DROP TABLE papers;
CREATE TABLE papers (
	id INT PRIMARY KEY NOT NULL,
    label VARCHAR(70) NOT NULL UNIQUE
);

--DROP TABLE trainings;
CREATE TABLE trainings (
	id INT PRIMARY KEY NOT NULL,
    label VARCHAR(70) NOT NULL UNIQUE,
    description VARCHAR(70) NOT NULL,
    image_path VARCHAR(70)
);

--DROP TABLE rules;
CREATE TABLE rules (
	id INT PRIMARY KEY NOT NULL,
    label VARCHAR(70) NOT NULL UNIQUE,
    minimal_score INT NOT NULL
);

--DROP TABLE trainings_users;
CREATE TABLE trainings_users (
	training INT NOT NULL,
    user INT NOT NULL,
    PRIMARY KEY (training, user),
    FOREIGN KEY (training) REFERENCES trainings(id),
    FOREIGN KEY (user) REFERENCES users(id)
);

--DROP TABLE trainings_papers;
CREATE TABLE trainings_papers (
	training INT NOT NULL,
    paper INT NOT NULL,
    PRIMARY KEY (training, paper),
    FOREIGN KEY (training) REFERENCES trainings(id),
    FOREIGN KEY (paper) REFERENCES papers(id)
);

--DROP TABLE papers_missions;
CREATE TABLE papers_missions (
	paper INT NOT NULL,
    mission INT NOT NULL,
    PRIMARY KEY (paper, mission),
    FOREIGN KEY (paper) REFERENCES papers(id),
    FOREIGN KEY (mission) REFERENCES missions(id)
);

--DROP TABLE missions_goals;
CREATE TABLE missions_goals (
	mission INT NOT NULL,
    goal INT NOT NULL,
    PRIMARY KEY (mission, goal),
    FOREIGN KEY (mission) REFERENCES missions(id),
    FOREIGN KEY (goal) REFERENCES goals(id)
);

--DROP TABLE goals_actions;
CREATE TABLE goals_actions (
	goal INT NOT NULL,
    action INT NOT NULL,
    PRIMARY KEY (goal, action),
    FOREIGN KEY (goal) REFERENCES goals(id),
    FOREIGN KEY (action) REFERENCES actions(id)
);

--DROP TABLE users_actions;
CREATE TABLE users_actions (
	user INT NOT NULL,
    training INT NOT NULL,
    paper INT NOT NULL,
    mission INT NOT NULL,
    goal INT NOT NULL,
    action INT NOT NULL,
    offset INT NOT NULL,
    elasped_time INT NOT NULL,
    PRIMARY KEY (user, training, paper, mission, goal, action),
    FOREIGN KEY (user) REFERENCES users(id),
    FOREIGN KEY (training) REFERENCES trainings(id),
    FOREIGN KEY (paper) REFERENCES papers(id),
    FOREIGN KEY (mission) REFERENCES missions(id),
    FOREIGN KEY (goal) REFERENCES goals(id),
    FOREIGN KEY (action) REFERENCES actions(id)
);

--DROP TABLE trainings_actions;
CREATE TABLE trainings_actions (
    training INT NOT NULL,
    paper INT NOT NULL,
    mission INT NOT NULL,
    goal INT NOT NULL,
    action INT NOT NULL,
    offset INT NOT NULL,
    PRIMARY KEY (training, paper, mission, goal, action),
    FOREIGN KEY (training) REFERENCES trainings(id),
    FOREIGN KEY (paper) REFERENCES papers(id),
    FOREIGN KEY (mission) REFERENCES missions(id),
    FOREIGN KEY (goal) REFERENCES goals(id),
    FOREIGN KEY (action) REFERENCES actions(id)
);

--DROP TABLE trainings_rules;
CREATE TABLE trainings_rules (
    training INT NOT NULL,
    rule INT NOT NULL,
    PRIMARY KEY (training, rule),
    FOREIGN KEY (training) REFERENCES trainings(id),
    FOREIGN KEY (rule) REFERENCES rules(id)
);