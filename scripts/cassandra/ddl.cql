/* This script creates the schema stores_ny_keyspace and create the table structure
*  department_store.
*/

CREATE KEYSPACE IF NOT EXISTS stores_ny_keyspace
    WITH REPLICATION = { 'class': 'SimpleStrategy', 'replication_factor': 1};

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
    comments frozen<list<comment>>,
    primary key ( (latitude, longitude), address)
) with clustering order by (address asc );