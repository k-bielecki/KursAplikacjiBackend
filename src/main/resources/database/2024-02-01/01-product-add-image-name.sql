--liquibase formatted sql
--changeset kbielecki:2

alter table product add image varchar(128) after currency;