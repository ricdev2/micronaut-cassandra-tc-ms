/**
 * File: DepartmentStoreController.java
 * User: Ricardo Lopez
 * Date: 17, Feb 2019
 */
package micronaut.cassandra.tc.ms.controllers;

import java.util.List;

import javax.inject.Inject;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import micronaut.cassandra.tc.ms.db.dao.CassandraDao;
import micronaut.cassandra.tc.ms.models.DepartmentStore;


/**
 * This class handle all request for Department Store resource.
 *
 * @author Ricardo Lopez
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller("/department-store")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentStoreController {

    /** A reference to Cassandra Dao.*/
    private CassandraDao<DepartmentStore,
                    DepartmentStore.Location> cassandraDao;



    /**
     * Create a new instance with parameters.
     * @param cassandraDaoParam The cassandra Dao object.
     */
    @Inject
    public DepartmentStoreController(
            final CassandraDao<DepartmentStore,
                    DepartmentStore.Location> cassandraDaoParam
    ) {
        this.cassandraDao = cassandraDaoParam;
    }

    /**
     * Gets all Department Store from database.
     *
     * @return  A list of {@code DepartmentStore}.
     */
    @Get
    public List<DepartmentStore> getAll() {
        return cassandraDao.findAll();
    }
}
