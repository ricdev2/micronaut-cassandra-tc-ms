/**
 * File: OrderFactory.java
 * User: Rich Lopez
 * Date: 26, Jan 2019
 */
package micronaut.cassandra.tc.ms.factories;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import micronaut.cassandra.tc.ms.models.Information;

import javax.inject.Singleton;

/**
 * This [...] has the porpuse of [...] 
 * @version 1.0.0
 * @since 1.0.0
 * @author Rich Lopez 
 */
@Factory
public class OrderFactory {

    @Value("${message.info}")
    private String messageInfo;

    @Bean
    @Singleton
    Information information(){
        return new Information(messageInfo);
    }
}
