/**
 * File: Information.java
 * User: Rich Lopez
 * Date: 26, Jan 2019
 */
package micronaut.cassandra.tc.ms.models;

/**
 * This [...] has the porpuse of [...] 
 * @version 1.0.0
 * @since 1.0.0
 * @author Rich Lopez 
 */
public class Information {

    private String message;

    public Information(String message) {
        this.message = message;
    }

    /**
     * Gets the message.
     *
     * @return the value message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message value.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
