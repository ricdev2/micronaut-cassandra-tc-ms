/**
 * File: AbstractCassandraDao.java
 * User: Ricardo Lopez
 * Date: 17, Feb 2019
 */
package micronaut.cassandra.tc.ms.db.dao;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.DefaultNamingStrategy;
import com.datastax.driver.mapping.DefaultPropertyMapper;
import com.datastax.driver.mapping.MappingConfiguration;
import com.datastax.driver.mapping.MappingManager;

/**
 * Base class for all implementation to access Cassandra Database.
 * @param <T> The type of data.
 * @param <U> The partition key.
 * @author Ricardo Lopez
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractCassandraDao<T, U> implements CassandraDao<T, U> {

    /**
     * Cluster access to Cassandra.
     */
    private Cluster cluster;

    /**
     * Constructor that receive the cluster reference.
     *
     * @param clusterParam The cluster Cassandra reference.
     */
    public AbstractCassandraDao(final Cluster clusterParam) {
        this.cluster = clusterParam;
    }

    /**
     * Creates a new session to Cassandra.
     *
     * @return A object Session instance.
     */
    protected final Session getSession() {
        return cluster.newSession();
    }

    /**
     * This method create a new MappingManager object.
     *
     * @return  A MappingManager object.
     */
    protected final MappingManager getMappingManager() {
        final DefaultPropertyMapper propertyManager =
                new DefaultPropertyMapper()
                    .setNamingStrategy(new DefaultNamingStrategy());
        final MappingConfiguration configuration =
                MappingConfiguration.builder()
                .withPropertyMapper(propertyManager)
                .build();
        return new MappingManager(getSession(), configuration);
    }
}
