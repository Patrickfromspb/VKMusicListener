package org.ncedu.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by User on 19.09.2016.
 */
@Entity
@Table(name = "changes")
public class Change {
    @Id
    @GeneratedValue
    @Column(name = "Change_ID")
    private int id;



}
