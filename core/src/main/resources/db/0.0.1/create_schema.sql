set search_path to medical_schema;

CREATE TABLE IF NOT EXISTS medical_card
(
    id            bigserial not null primary key,
    client_status char(20)  not null,
    med_status    char(20)  not null,
    registry_dt   date      not null,
    comment       text
);

CREATE TABLE IF NOT EXISTS contact
(
    id           bigserial    not null primary key,
    phone_number varchar(32)  not null,
    email        varchar(128) not null,
    profile_link text
);

CREATE TABLE IF NOT EXISTS person_data
(
    id              bigserial     not null primary key,
    last_name       varchar(255)  not null,
    first_name      varchar(255)  not null,
    birth_dt        date          not null,
    age             smallint,
    sex             char(1)       not null,
    contact_id      bigint        not null references contact (id),
    medical_card_id bigint unique not null references medical_card (id),
    parent_id       bigint check ( parent_id <> id ) references person_data (id)
);

CREATE TABLE IF NOT EXISTS illness
(
    id              bigserial not null primary key,
    medical_card_id bigint    not null references medical_card (id),
    type_id         bigint,
    heaviness       char(1),
    appearance_dttm timestamp not null,
    recovery_dt     date
);

CREATE TABLE IF NOT EXISTS address
(
    id         bigserial    not null primary key,
    contact_id bigint       not null references contact (id),
    country_id bigint       not null,
    city       varchar(255) not null,
    index      int,
    street     varchar(255) not null,
    building   varchar(255) not null,
    flat       varchar(32)
);
