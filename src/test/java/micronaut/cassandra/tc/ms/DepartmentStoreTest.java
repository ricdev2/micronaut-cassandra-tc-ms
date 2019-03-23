/**
 * File: DepartmentStoreTest.java
 * User: Ricardo Lopez
 * Date: 09, Feb 2019
 */
package micronaut.cassandra.tc.ms;

import com.datastax.driver.core.Session;
import micronaut.cassandra.tc.ms.controllers.DepartmentStoreController;
import micronaut.cassandra.tc.ms.db.dao.impl.DepartmentStoreDaoImpl;
import org.junit.*;
import org.testcontainers.containers.CassandraContainer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Test class.
 *
 * @author Ricardo Lopez
 * @version 1.0.0
 * @since 1.0.0
 */
public class DepartmentStoreTest {

    /**
     * Cassandra version.
     */
    public static final String CASSANDRA_IMG_VERSION = "cassandra:3.11.3";

    /**
     * Cassandra test container.
     */
    @Rule
    public CassandraContainer cassandraContainer =
            new CassandraContainer(CASSANDRA_IMG_VERSION);

    /**
     * Cassandra session.
     */
    private Session session;

    @Before
    public void setUp() {
        session = cassandraContainer.getCluster().newSession();
        loadScript();
    }


    @Test
    public void test_get_all() {
        final DepartmentStoreDaoImpl dao = new DepartmentStoreDaoImpl(cassandraContainer.getCluster());
        final DepartmentStoreController controller = new DepartmentStoreController(dao);
        Assert.assertNotNull(controller.getAll());
        Assert.assertEquals(1, controller.getAll().size());
    }

    @After
    public void after() {
        session.getCluster().close();
    }

    /**
     * This method load script from classpath, this script create the keyspace, tables and data to cassandra.
     */
    private void loadScript() {
        try {
            final Path scriptPath = Paths.get(getClass().getClassLoader().getResource("scripts/init_script.cql").toURI());
            final Stream<String> lines = Files.lines(scriptPath);
            lines.forEach(scriptLine -> session.execute(scriptLine));
        } catch (final URISyntaxException e) {
            System.out.println("Can not get .cql file from classpath.");
            throw new RuntimeException("Can not init the test because can read the cassandra .cql files");
        } catch (final IOException e) {
            System.out.println("Can not read .cql file.");
            throw new RuntimeException("Can not read the .cql files");
        }
    }
}
