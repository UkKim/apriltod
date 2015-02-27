# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table participant (
  id                        bigint not null,
  user_id                   bigint,
  task_id                   bigint,
  constraint pk_participant primary key (id))
;

create table project (
  id                        bigint not null,
  constraint pk_project primary key (id))
;

create table task (
  id                        bigint not null,
  project_id                bigint,
  constraint pk_task primary key (id))
;

create table user (
  id                        bigint not null,
  email                     varchar(255),
  name                      varchar(255),
  password                  varchar(255),
  address                   varchar(255),
  constraint pk_user primary key (id))
;

create sequence participant_seq;

create sequence project_seq;

create sequence task_seq;

create sequence user_seq;

alter table participant add constraint fk_participant_user_1 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_participant_user_1 on participant (user_id);
alter table participant add constraint fk_participant_task_2 foreign key (task_id) references task (id) on delete restrict on update restrict;
create index ix_participant_task_2 on participant (task_id);
alter table task add constraint fk_task_project_3 foreign key (project_id) references project (id) on delete restrict on update restrict;
create index ix_task_project_3 on task (project_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists participant;

drop table if exists project;

drop table if exists task;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists participant_seq;

drop sequence if exists project_seq;

drop sequence if exists task_seq;

drop sequence if exists user_seq;

