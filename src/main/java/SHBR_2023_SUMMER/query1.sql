SELECT EXTRACT(MILLISECONDS FROM AVG(diff)) AS avg_network_time_ms
FROM (
         SELECT SUM(r2.datetime - r1.datetime) AS diff,
                CASE
                    WHEN r1.parent_request_id IS NULL THEN r1.request_id
                    WHEN r2.parent_request_id IS NULL THEN r2.request_id
                    WHEN r1.type = 'RequestSent' THEN r1.parent_request_id
                    WHEN r1.type = 'ResponseSent' THEN r2.parent_request_id
                    ELSE NULL
                    END AS rid
         FROM requests AS r1, requests AS r2
         WHERE (
                     r1.request_id = r2.parent_request_id
                 AND r1.type = 'RequestSent'
                 AND r2.type = 'RequestReceived'
                 AND r1.data = r2.host
             ) OR (
                     r1.parent_request_id = r2.request_id
                 AND r1.type = 'ResponseSent'
                 AND r2.type = 'ResponseReceived'
                 AND r2.data LIKE r1.host || '%'
             )
         GROUP BY rid
     ) AS temp