create sequence hibernate_sequence start with 1 increment by 1

create table invitation (
  invitation_id bigint not null,
  date varchar(255),
  degrees_remaining integer,
  description varchar(255),
  location varchar(255),
  title varchar(255),
  user_receiver_id bigint,
  user_sender_id bigint,
  was_delivered boolean,
  will_attend boolean,
  primary key (invitation_id))

create table person (
  person_id bigint not null,
  display_name varchar(255),
  google_user_id varchar(255),
  latitude double not null,
  longitude double not null,
  user_description varchar(255),
  user_image_location varchar(255),
  vertex_id bigint not null,
  square_id bigint,
  primary key (person_id))

create table person_invitations (
  person_id bigint not null,
  invitation_id bigint not null)

create table square (
  square_id bigint not null,
  latitude_lower_bound double not null,
  latitude_upper_bound double not null,
  longitude_lower_bound double not null,
  longitude_upper_bound double not null,
  primary key (square_id))

create table vertex (
  vertex_id bigint not null,
  latitude double not null,
  longitude double not null,
  primary key (vertex_id))

create table vertex_squares (
  vertex_id bigint not null,
  square_id bigint not null)

alter table person add constraint FKdtljiakvsdxept1xtverbv24j foreign key (vertex_id) references vertex

alter table person add constraint FKhrq8edyrclss720pgqvtnwwcf foreign key (square_id) references square

alter table person_invitations add constraint FKmx30wcfaiqddr6bhrlt4repvu foreign key (invitation_id) references invitation

alter table person_invitations add constraint FKr0llnte6lok5lv7hp09gaxv3p foreign key (person_id) references person

alter table vertex_squares add constraint FKsmblrugt7h93g7r7uxek30eee foreign key (square_id) references square

alter table vertex_squares add constraint FK9wt7vktxh3fqoqmwotb9nussu foreign key (vertex_id) references vertex
