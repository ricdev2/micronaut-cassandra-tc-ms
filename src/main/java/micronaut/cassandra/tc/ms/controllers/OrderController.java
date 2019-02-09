/**
 * File: OrderController.java
 * User: Rich Lopez
 * Date: 26, Jan 2019
 */
package micronaut.cassandra.tc.ms.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import micronaut.cassandra.tc.ms.service.OrderService;

/**
 * This [...] has the porpuse of [...] 
 * @version 1.0.0
 * @since 1.0.0
 * @author Rich Lopez 
 */
@Controller("/orders")
public class OrderController {


    private OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public String info(){
        return orderService.info();
    }
}
