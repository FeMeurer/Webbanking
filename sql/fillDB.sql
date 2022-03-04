insert into customer (name, surname, username) value ('Felix','Meurer','fmeurer');
insert into customer (name, surname, username) value ('Tina','Mina','tmina');

insert into bic (bic, institute) values ('GENODEF1P11', 'PSD Bank');
insert into bic (bic, institute) values ('GENODEF1P22', 'Volksbank');
insert into bic (bic, institute) values ('COBADEF1P11', 'Commerzbank');
insert into bic (bic, institute) values ('NOLADE22P22', 'Sparkasse');

insert into iban (iban, bic_id) values ('DE11222233334444555566',1);
insert into iban (iban, bic_id) values ('DE22333344445555666677',2);
insert into iban (iban, bic_id) values ('DE33444455556666777788',3);
insert into iban (iban, bic_id) values ('DE44555566667777888899',4);

insert into transaction (receiver, customer_ID, iban_ID, amount, purpose, creationdate) values ('Edeka',1,4,-20.66,'Einkauf bei Edeka', '20220204080000');
insert into transaction (receiver, customer_ID, iban_ID, amount, purpose, creationdate) values ('Küchenbauer',1,3,-3000.45,'Einbauküche Rechnung', '20220101150000');
insert into transaction (receiver, customer_ID, iban_ID, amount, purpose, creationdate) values ('Familie',2,2,5000.00,'Geburtstagsgeschenk', '20211212100000');
insert into transaction (receiver, customer_ID, iban_ID, amount, purpose, creationdate) values ('Versicherung',1,1,-34.66,'Haftpflichtversicherung', '20220203080000');
insert into transaction (receiver, customer_ID, iban_ID, amount, purpose, creationdate) values ('Versicherung',1,1,-8.22,'Handyversicherung', '20220203080000');
insert into transaction (receiver, customer_ID, iban_ID, amount, purpose, creationdate) values ('Versicherung',1,1,-150.54,'Autoversicherung', '20220203080000');