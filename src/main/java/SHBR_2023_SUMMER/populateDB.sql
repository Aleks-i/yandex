DELETE
FROM requests;

INSERT INTO requests (datetime, request_id, parent_request_id, host, type, data)
VALUES ('2011-05-17 13:18:48.000', 0, NULL, 'balancer.test.yandex.ru', 'RequestReceived', ''),
       ('2011-05-17 13:18:48.100', 0, NULL, 'balancer.test.yandex.ru', 'RequestSent', 'backend1.ru'),
       ('2011-05-17 13:18:48.101', 0, NULL, 'balancer.test.yandex.ru', 'RequestSent', 'backend2.ru'),
       ('2011-05-17 13:18:48.150', 1, 0, 'backend1.ru', 'RequestReceived', ''),
       ('2011-05-17 13:18:48.200', 2, 0, 'backend2.ru', 'RequestReceived', ''),
       ('2011-05-17 13:18:48.155', 1, 0, 'backend1.ru', 'RequestSent', 'backend3.ru'),
       ('2011-05-17 13:18:48.210', 2, 0, 'backend2.ru', 'ResponseSent', ''),
       ('2011-05-17 13:18:48.200', 3, 1, 'backend3.ru', 'RequestReceived', ''),
       ('2011-05-17 13:18:48.220', 3, 1, 'backend3.ru', 'ResponseSent', ''),
       ('2011-05-17 13:18:48.260', 1, 0, 'backend1.ru', 'ResponseReceived', 'backend3.ru    OK'),
       ('2011-05-17 13:18:48.300', 1, 0, 'backend1.ru', 'ResponseSent', ''),
       ('2011-05-17 13:18:48.310', 0, NULL, 'balancer.test.yandex.ru', 'ResponseReceived', 'backend1.ru    OK'),
       ('2011-05-17 13:18:48.250', 0, NULL, 'balancer.test.yandex.ru', 'ResponseReceived', 'backend2.ru    OK'),
       ('2011-05-17 13:18:48.400', 0, NULL, 'balancer.test.yandex.ru', 'ResponseSent', ''),
       ('2011-05-17 13:18:48.500', 4, NULL, 'balancer.test.yandex.ru', 'RequestReceived', ''),
       ('2011-05-17 13:18:48.505', 4, NULL, 'balancer.test.yandex.ru', 'RequestSent', 'backend1.ru'),
       ('2011-05-17 13:18:48.510', 5, 4, 'backend1.ru', 'RequestReceived', ''),
       ('2011-05-17 13:18:48.700', 5, 4, 'backend1.ru', 'ResponseSent', ''),
       ('2011-05-17 13:18:48.710', 4, NULL, 'balancer.test.yandex.ru', 'ResponseReceived', 'backend1.ru    ERROR'),
       ('2011-05-17 13:18:48.715', 4, NULL, 'balancer.test.yandex.ru', 'ResponseSent', '');
