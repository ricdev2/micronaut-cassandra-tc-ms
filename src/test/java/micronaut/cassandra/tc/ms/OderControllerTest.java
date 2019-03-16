/**
 * File: OderControllerTest.java
 * User: Rich Lopez
 * Date: 09, Feb 2019
 */
package micronaut.cassandra.tc.ms;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import org.junit.*;
import org.testcontainers.containers.CassandraContainer;

/**
 * Test class.
 * @version 1.0.0
 * @since 1.0.0
 * @author Rich Lopez 
 */
public class OderControllerTest {

    @Rule
    public CassandraContainer cassandraContainer = new CassandraContainer("cassandra:3.11.3");

    private Session session;

    @Before
    public void setUp(){
        session = cassandraContainer.getCluster().newSession();
        session.execute("CREATE KEYSPACE IF NOT EXISTS orders WITH REPLICATION = { 'class': 'SimpleStrategy', 'replication_factor': 1};");
        session.execute("CREATE TABLE orders.products(id UUID PRIMARY KEY, name text, price float);");
        session.execute("insert into orders.products(id, name, price) values(c4b65263-fe58-4846-83e8-f0e1c13d518f, 'soap', 12.3);");
    }

    @Test
    public void test(){
        final ResultSet rs = session.execute("select * from orders.products;");
        rs.forEach(row -> System.out.println("Id: " + row.getString("name")));

    }

    @After
    public void after(){
        session.getCluster().close();
    }
}
