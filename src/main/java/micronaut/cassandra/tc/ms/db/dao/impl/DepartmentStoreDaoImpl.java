/**
 * File: DepartmentStoreDaoImpl.java
 * User: Ricardo Lopez
 * Date: 17, Feb 2019
 */
package micronaut.cassandra.tc.ms.db.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.mapping.Mapper;
import micronaut.cassandra.tc.ms.db.dao.AbstractCassandraDao;
import micronaut.cassandra.tc.ms.db.dao.DepartmentStoreCassandraDao;
import micronaut.cassandra.tc.ms.models.DepartmentStore;


/**
 * Class to access records in department store table.
 * @version 1.0.0
 * @since 1.0.0
 * @author Ricardo Lopez
 */
@Singleton
public class DepartmentStoreDaoImpl extends
            AbstractCassandraDao<DepartmentStore, DepartmentStore.Location>
                                    implements DepartmentStoreCassandraDao {

    /** Query statement that returns all registers in table. */
    private static final String STM_FIND_ALL =
                            "select * from stores_ny_keyspace.department_store";

    /** Prepare statement for all results. */
    private PreparedStatement prepStmFindAll =
                                    getSession().prepare(STM_FIND_ALL);


    /** Mapper for DepartmentStore object.*/
    private Mapper<DepartmentStore> mapper;

    /**
     * Create a new Instance of {@link DepartmentStoreDaoImpl}.
     * @param cluster   The cluster reference.
     */
    @Inject
    public DepartmentStoreDaoImpl(final Cluster cluster) {
        super(cluster);
        this.mapper = getMappingManager().mapper(DepartmentStore.class);
    }

    @Override
    public final List<DepartmentStore> findAll() {
        final ResultSet rs = getSession().execute(prepStmFindAll.bind());
        return mapper.map(rs).all();
    }

}
