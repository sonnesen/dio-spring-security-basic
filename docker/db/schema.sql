create table if not exists tb_users
(
    id                      bigint auto_increment
    primary key,
    account_non_expired     bit          not null,
    account_non_locked      bit          not null,
    credentials_non_expired bit          not null,
    enabled                 bit          not null,
    password                varchar(100) not null,
    username                varchar(255) not null,
    constraint UK_8n82lwp7lflhwda2v2v3wckc9
    unique (username)
);

create table if not exists tb_authorities
(
    id        bigint auto_increment
    primary key,
    authority varchar(100) not null,
    user_id   bigint       null,
    constraint FK1rgkeiqgi2xydb5bv3ldy78u2
    foreign key (user_id) references tb_users (id)
);