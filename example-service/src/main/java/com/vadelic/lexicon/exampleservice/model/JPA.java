package com.vadelic.lexicon.exampleservice.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by GreenNun on 29/10/2018.
 */
@MappedSuperclass
public abstract class JPA {

    private Long id;
    private Date created = new Date();
    private Date version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Version
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "version")
    public Date getVersion() {
        return version;
    }

    public void setVersion(Date version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        Long id = getId();
        return (id == null ? super.hashCode() : id.intValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        if (hashCode() != obj.hashCode()) {
            return false;
        }
        Long id = getId();
        Long oid = ((JPA) obj).getId();
        return id != null && id.equals(oid);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", created=" + created +
                ", version=" + version;
    }
}
