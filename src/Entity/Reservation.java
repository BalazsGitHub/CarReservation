package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String reservationDate;

    @Column
    private String rentalDate;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car_id;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member_id;

    public Reservation(String reservationDate, String rentalDate, Car car_id, Member member_id) {
        this.reservationDate = reservationDate;
        this.rentalDate = rentalDate;
        this.car_id = car_id;
        this.member_id = member_id;
    }
}