/**
 * File: Comment.java
 * User: Ricardo Lopez
 * Date: 17, Feb 2019
 */
package micronaut.cassandra.tc.ms.models.udts;

import java.util.Objects;
import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;

/**
 * This class helps to show information of comments.
 * @version 1.0.0
 * @since 1.0.0
 * @author Rich Lopez
 */
@UDT(name = "comment", keyspace = "stores_ny_keyspace")
public class Comment {

    /** The comment.*/
    @Field(name = "comment_text")
    private String comment;

    /** The number of starts. Limit 5.*/
    @Field(name = "stars")
    private int stars;

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Comment comment1 = (Comment) o;
        return stars == comment1.stars
                && comment.equals(comment1.comment);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(comment, stars);
    }

    /**
     * Gets the comment.
     *
     * @return the value comment.
     */
    public final String getComment() {
        return comment;
    }

    /**
     * Sets the comment.
     *
     * @param commentParam value.
     */
    public final void setComment(final String commentParam) {
        this.comment = commentParam;
    }

    /**
     * Gets the stars.
     *
     * @return the value stars.
     */
    public final int getStars() {
        return stars;
    }

    /**
     * Sets the stars.
     *
     * @param starsParam value.
     */
    public final void setStars(final int starsParam) {
        this.stars = starsParam;
    }

    @Override
    public final String toString() {
        return "Comment{"
                + "comment='" + comment + '\''
                + ", stars=" + stars
                + '}';
    }
}
