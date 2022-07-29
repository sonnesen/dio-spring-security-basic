insert into tb_users (id, account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username)
select 1, true, true, true, true, '$2a$10$B2O1/737EFQYKlGsC6aIFuVNZcFTFgEcFUrcj7OORjbZANIuFAWTS', 'user'
where not exists (select username from tb_users where id = 1);

insert into tb_users (id, account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username)
select 2, true, true, true, true, '$2a$10$g70YKsiXbCEAQZQdzg9jz.shMs4PgU5J/Y0R75WVsjv1FdXJe2wSS', 'manager'
where not exists (select username from tb_users where id = 2);

insert into tb_authorities (id, authority, user_id)
select 1, 'USER', 1
where not exists (select authority from tb_authorities where id = 1);

insert into tb_authorities (id, authority, user_id)
select 2, 'MANAGER', 2
where not exists (select authority from tb_authorities where id = 2);
