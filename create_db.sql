DROP TABLE IF EXISTS task, task_status CASCADE;


/* create task status types */
CREATE TABLE task_status (
  id SERIAL PRIMARY KEY NOT NULL,
  title CHAR(4) NOT NULL
);

INSERT INTO task_status (id, title) VALUES (1, 'TODO');
INSERT INTO task_status (id, title) VALUES (2, 'DONE');



/* create task table */
CREATE TABLE task (
  id SERIAL PRIMARY KEY NOT NULL,
  title VARCHAR NOT NULL,
  description VARCHAR,
  due_at TIMESTAMP NOT NULL,
  status INT NOT NULL REFERENCES task_status(id)
);
