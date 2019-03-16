/**
 * File: MicronautCassandraApplication.java
 * User: Ricardo Lopez
 * Date: 23, Feb 2019
 */
package micronaut.cassandra.tc.ms;

import io.micronaut.runtime.Micronaut;

/**
 * This class is the entry point to application.
 *
 * @author Ricardo Lopez
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("uncommentedmain")
public final class MicronautCassandraApplication {

    /**
     * A private constructor.
     */
    private MicronautCassandraApplication() {
        //Do nothing.
    }

    /**
     * Start the application.
     *
     * @param args  The command line arguments.
     */
    public static void main(final String[] args) {
        Micronaut.run(MicronautCassandraApplication.class);
    }
}
