INSERT INTO bill.user
VALUES ('29351082-f191-4429-8378-a84d3db1707f', '2024-04-01 13:22:57.123040', '2024-04-01 15:35:57.002200', 'testEmail',
        'testSurname', 'testName', 'testPatronymic') ON CONFLICT DO NOTHING ;
INSERT INTO bill.bank
VALUES ('68596de7-8a67-4cc7-a279-8f7fdaf0c381', '2024-04-01 13:22:57.123040', '2024-04-01 13:22:57.123040', 'testName', 'testOgrn', 'testInn') ON CONFLICT DO NOTHING;
INSERT INTO bill.account
VALUES ('eb607c8c-26c9-4b77-adf9-7293c9970f84', '2024-04-01 13:22:57.123040', '2024-04-01 15:35:57.002200', '456.33',
        '29351082-f191-4429-8378-a84d3db1707f', '68596de7-8a67-4cc7-a279-8f7fdaf0c381') ON CONFLICT DO NOTHING;