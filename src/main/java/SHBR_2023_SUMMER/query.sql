WITH time_diff AS(
    SELECT t1.host AS sender,
           t1.datetime AS sent_time,
           t2.parent_request_id AS parent_request_id,
           t2.host AS reciever,
           t2.datetime AS recieve_time,
           t2.datetime - t1.datetime AS diff
    FROM requests
        t1 JOIN requests t2 ON
            (t1.type = 'RequestSent' AND t2.type = 'RequestReceived'
            AND t1.data = t2.host AND t2.parent_request_id = t1.request_id)
            OR (t1.type = 'ResponseSent' AND t2.type = 'ResponseReceived'
            AND t1.host = ANY(string_to_array(t2.data, ' ')) AND t1.parent_request_id = t2.request_id)
)
SELECT EXTRACT(MILLISECONDS FROM sum(recieve_time-sent_time) /
      (select count(distinct request_id)
       from (select request_id from requests where parent_request_id is null) x
      )) avgtime
FROM time_diff