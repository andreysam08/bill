INSERT INTO bill.user
VALUES ('29351082-f191-4429-8378-a84d3db1707f', '2024-04-01 13:22:57.123040', '2024-04-01 15:35:57.002200', 'testEmail',
        'testSurname', 'testName', 'testPatronymic');
INSERT INTO bill.bank
VALUES ('68596de7-8a67-4cc7-a279-8f7fdaf0c381', '2024-04-01 13:22:57.123040', '2024-04-01 13:22:57.123040', 'testName', 'testOgrn', 'testInn');
INSERT INTO bill.account
VALUES ('eb607c8c-26c9-4b77-adf9-7293c9970f84', '2024-04-01 13:22:57.123040', '2024-04-01 15:35:57.002200', '456.33',
        '29351082-f191-4429-8378-a84d3db1707f', '68596de7-8a67-4cc7-a279-8f7fdaf0c381');
insert into bill.transaction
values ('8b808c6a-2257-44fb-9ce8-9630b15addc3', '2024-04-01 13:22:57.123040', '2024-04-01 13:22:57.123040', 'eb607c8c-26c9-4b77-adf9-7293c9970f84',
        'CREDIT', '100.43')