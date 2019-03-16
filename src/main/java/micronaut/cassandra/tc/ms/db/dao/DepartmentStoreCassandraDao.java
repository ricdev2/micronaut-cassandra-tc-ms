/**
 * File: DepartmentStoreCassandraDao.java
 * User: Ricardo Lopez
 * Date: 17, Feb 2019
 */
package micronaut.cassandra.tc.ms.db.dao;

import micronaut.cassandra.tc.ms.models.DepartmentStore;

/**
 * Interface to expose operate methods on department store in
 * department store table.
 *
 * @version 1.0.0
 * @since 1.0.0
 * @author Ricardo Lopez
 */
public interface DepartmentStoreCassandraDao
        extends CassandraDao<DepartmentStore, DepartmentStore.Location> {

}
