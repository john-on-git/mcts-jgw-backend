DROP TABLE IF EXISTS task, task_status CASCADE;


/* create task status types */
CREATE TABLE task_status (
  id SERIAL PRIMARY KEY NOT NULL,
  title VARCHAR(10) NOT NULL
);

INSERT INTO task_status (id, title) VALUES (1, 'Completed');
INSERT INTO task_status (id, title) VALUES (2, 'Incomplete');



/* create task table */
CREATE TABLE task (
  id SERIAL PRIMARY KEY NOT NULL,
  title VARCHAR NOT NULL,
  description VARCHAR,
  due_at TIMESTAMP NOT NULL,
  status INT NOT NULL REFERENCES task_status(id)
);
