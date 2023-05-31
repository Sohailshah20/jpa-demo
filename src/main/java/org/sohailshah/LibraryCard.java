package org.sohailshah;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "library_card")
public class LibraryCard {
    @Id
    @GeneratedValue
    private int id;
    @Temporal(TemporalType.DATE)
    private Date issuedDate;
    private boolean isActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
