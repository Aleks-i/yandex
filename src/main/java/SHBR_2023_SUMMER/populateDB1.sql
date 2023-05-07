DELETE FROM requests;

INSERT INTO requests (datetime, request_id, parent_request_id, host, type, data)
VALUES
('2011-05-17 13:18:48.000', 0, NULL, 'balancer.test.yandex.ru', 'RequestReceived', '');