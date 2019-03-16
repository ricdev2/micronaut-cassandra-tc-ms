
CREATE KEYSPACE IF NOT EXISTS orders WITH REPLICATION = { 'class': 'SimpleStrategy', 'replication_factor': 1};
CREATE TABLE orders.products(id UUID PRIMARY KEY, name text, price float);
CREATE ROLE IF NOT EXISTS ADMIN_ORDERS WITH SUPERUSER = true AND LOGIN = true and PASSWORD = '1nt3rw4r3#';
GRANT ALL ON orders.products TO  ADMIN_ORDERS;