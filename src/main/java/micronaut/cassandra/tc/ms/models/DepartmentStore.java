/**
 * File: DepartmentStore.java
 * User: Ricardo Lopez
 * Date: 17, Feb 2019
 */
package micronaut.cassandra.tc.ms.models;

import java.util.List;
import java.util.Objects;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import micronaut.cassandra.tc.ms.constants.Tables;
import micronaut.cassandra.tc.ms.models.udts.Comment;

/**
 * Model class helps to show information of department stores.
 *
 * @author Ricardo Lopez.
 * @version 1.0.0
 * @since 1.0.0
 */
@Table(name = Tables.DEPARTMENT_STORE_TABLE, keyspace = "stores_ny_keyspace")
public class DepartmentStore {

    /** The latitude.*/
    @PartitionKey
    @Column(name = "latitude")
    private Double latitude;

    /** The longitude.*/
    @PartitionKey(1)
    @Column(name = "longitude")
    private Double longitude;

    /** The full address direcction.*/
    @Column(name = "address")
    private String address;

    /** The name of department store.*/
    @ClusteringColumn
    private String name;

    /** A telephone number.*/
    @Column(name = "telephone")
    private String telephone;

    /** URLs of images.*/
    @Column(name = "previews")
    private List<String> previews;

    /** Average of starts rank base on comments.*/
    @Column(name = "rank")
    private float rank;

    /** A list of recent comments.*/
    @Frozen
    @Column(name = "comments")
    private List<Comment> comments;

    /**
     * This class handle information about store location.
     */
    public static class Location {

        /** The latitude.*/
        private Double latitude;

        /** The longitude.*/
        private Double longitude;

        /**
         * Gets the latitude.
         *
         * @return the value latitude.
         */
        public final Double getLatitude() {
            return latitude;
        }

        /**
         * Sets the latitude.
         *
         * @param latitudeParam value.
         */
        public final void setLatitude(final Double latitudeParam) {
            this.latitude = latitudeParam;
        }

        /**
         * Gets the longitude.
         *
         * @return the value longitude.
         */
        public final Double getLongitude() {
            return longitude;
        }

        /**
         * Sets the longitude.
         *
         * @param longitudeParam value.
         */
        public final void setLongitude(final Double longitudeParam) {
            this.longitude = longitudeParam;
        }

    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final DepartmentStore that = (DepartmentStore) o;
        return Float.compare(that.rank, rank) == 0
                && latitude.equals(that.latitude)
                && longitude.equals(that.longitude)
                && address.equals(that.address)
                && name.equals(that.name)
                && telephone.equals(that.telephone)
                && previews.equals(that.previews)
                && comments.equals(that.comments);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(latitude, longitude, address,
                name, telephone, previews, rank, comments);
    }

    /**
     * Gets the latitude.
     *
     * @return the value latitude.
     */
    public final Double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude.
     *
     * @param latitudeParam value.
     */
    public final void setLatitude(final Double latitudeParam) {
        this.latitude = latitudeParam;
    }

    /**
     * Gets the longitude.
     *
     * @return the value longitude.
     */
    public final Double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude.
     *
     * @param longitudeParam value.
     */
    public final void setLongitude(final Double longitudeParam) {
        this.longitude = longitudeParam;
    }

    /**
     * Gets the address.
     *
     * @return the value address.
     */
    public final String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param addressParam value.
     */
    public final void setAddress(final String addressParam) {
        this.address = addressParam;
    }

    /**
     * Gets the name.
     *
     * @return the value name.
     */
    public final String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param nameParam value.
     */
    public final void setName(final String nameParam) {
        this.name = nameParam;
    }

    /**
     * Gets the telephone.
     *
     * @return the value telephone.
     */
    public final String getTelephone() {
        return telephone;
    }

    /**
     * Sets the telephone.
     *
     * @param telephoneParam value.
     */
    public final void setTelephone(final String telephoneParam) {
        this.telephone = telephoneParam;
    }

    /**
     * Gets the previews.
     *
     * @return the value previews.
     */
    public final List<String> getPreviews() {
        return previews;
    }

    /**
     * Sets the previews.
     *
     * @param previewsParam value.
     */
    public final void setPreviews(final List<String> previewsParam) {
        this.previews = previewsParam;
    }

    /**
     * Gets the rank.
     *
     * @return the value rank.
     */
    public final float getRank() {
        return rank;
    }

    /**
     * Sets the rank.
     *
     * @param rankParam value.
     */
    public final void setRank(final float rankParam) {
        this.rank = rankParam;
    }

    /**
     * Gets the comments.
     *
     * @return the value comments.
     */
    public final List<Comment> getComments() {
        return comments;
    }

    /**
     * Sets the comments.
     *
     * @param commentsParam value.
     */
    public final void setComments(final List<Comment> commentsParam) {
        this.comments = commentsParam;
    }

    @Override
    public final String toString() {
        return "DepartmentStore{"
                + "latitude=" + latitude
                + ", longitude=" + longitude
                + ", address='" + address + '\''
                + ", name='" + name + '\''
                + ", telephone='" + telephone + '\''
                + ", previews=" + previews
                + ", rank=" + rank
                + ", comments=" + comments
                + '}';
    }
}
