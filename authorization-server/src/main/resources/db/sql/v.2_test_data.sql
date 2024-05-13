INSERT INTO auth_server.user (id, creation_date, last_action_date, username, role)
VALUES ('29351082-f191-4429-8378-a84d3db1707f', '2024-04-01 13:22:57.123040', '2024-04-01 15:35:57.002200', 'user', 'USER'),
       ('52ded2cb-79e7-484d-bdb5-1a173d49d732', '2024-04-01 13:22:57.123040', '2024-04-01 15:35:57.002200', 'admin', 'ADMIN')
on CONFLICT DO NOTHING;
