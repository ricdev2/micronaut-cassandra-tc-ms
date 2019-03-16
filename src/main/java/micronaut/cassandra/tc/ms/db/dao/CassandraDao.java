/**
 * File: CassandraDao.java
 * User: Ricardo Lopez
 * Date: 17, Feb 2019
 */
package micronaut.cassandra.tc.ms.db.dao;

import java.util.List;

/**
 * Interface class that expose base methods to cassandra Data Base.
 *
 * @param <T> The type of information.
 * @param <U> The type of partition key.
 * @author Ricardo Lopez
 * @version 1.0.0
 * @since 1.0.0
 */
public interface CassandraDao<T, U> {

    /**
     * Find all records in the table.
     *
     * @return A list with the records founded.
     */
    List<T> findAll();

    /**
     * Find a record by Id.
     * @param identifier The partition key.
     * @return A record founded.
     */
    T findById(U identifier);
}
