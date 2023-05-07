DROP TABLE IF EXISTS requests;

CREATE TABLE requests (
                          datetime TIMESTAMP,
                          request_id int,
                          parent_request_id int,
                          host TEXT,
                          type TEXT,
                          data TEXT
);
