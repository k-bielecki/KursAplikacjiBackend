--liquibase formatted sql
--changeset kbielecki:9

alter table review add moderated boolean default false;