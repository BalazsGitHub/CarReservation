package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String zip;

    @Column
    private boolean licenseApproved;

    @Column
    private double ranking;

    @OneToMany(mappedBy = "member_id")
    private Set<Reservation> reservation;

    public Member(String firstName, String lastName, String street, String city, String zip, boolean licenseApproved, double ranking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.licenseApproved = licenseApproved;
        this.ranking = ranking;
    }
}
