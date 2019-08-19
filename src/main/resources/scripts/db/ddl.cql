/** This script is used to create the keyspace and tables to database.*/

CREATE KEYSPACE IF NOT EXISTS stores_ny_keyspace WITH REPLICATION = { 'class': 'SimpleStrategy', 'replication_factor': 1};

create type stores_ny_keyspace.comment(
  comment_text  text,
  stars int
  );

create table stores_ny_keyspace.department_store(
                                                  latitude double,
                                                  longitude double,
                                                  address text,
                                                  name text,
                                                  telephone text,
                                                  previews list<text>,
                                                  rank float,
                                                  comments list<frozen<comment>>,
                                                  primary key ( (latitude, longitude), address)
) with clustering order by (address asc );