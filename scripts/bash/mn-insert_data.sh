#!/usr/bin/env bash

sleep 30s
#Step 4: Create keyspace and table in Cassandra database.
#        The .cql file already exists in the container.
echo "Create the keyspace (stores_ny_keyspace) in cassandra db  ..........."
docker exec -it cassandra_db cqlsh -f ddl.cql
echo "Keyspace (stores_ny_keyspace) created success  ......................"

#Step 5: Insert data.
#        The .cql file already exists in the container.
echo "Insert data in table (department_store)  ............................"
docker exec -it cassandra_db cqlsh -f dump.cql
echo "Data was success inserted in table (department_store) ..............."