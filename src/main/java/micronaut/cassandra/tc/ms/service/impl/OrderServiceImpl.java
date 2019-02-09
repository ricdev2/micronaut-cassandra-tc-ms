/**
 * File: OrderServiceImpl.java
 * User: Rich Lopez
 * Date: 26, Jan 2019
 */
package micronaut.cassandra.tc.ms.service.impl;

import micronaut.cassandra.tc.ms.factories.OrderFactory;
import micronaut.cassandra.tc.ms.models.Information;
import micronaut.cassandra.tc.ms.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

/**
 * This [...] has the porpuse of [...] 
 * @version 1.0.0
 * @since 1.0.0
 * @author Rich Lopez 
 */
@Singleton
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    private boolean initial;

    Information information;

    public OrderServiceImpl(Information information) {
        this.information = information;
    }

    @Override
    public String info() {
        return "{\"message\":\""+ information.getMessage()+"\"}";
    }

    @PostConstruct
    void initialize(){
        initial = true;
        LOGGER.info(">>"+initial);
    }
}
