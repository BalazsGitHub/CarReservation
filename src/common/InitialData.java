package common;

import Entity.Car;
import Entity.Member;
import Repository.CarRepository;
import Repository.MemberRepository;
import Repository.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialData implements CommandLineRunner {

    CarRepository carRepository;

    MemberRepository memberRepository;

    ReservationRepository reservationRepository;

    public InitialData(CarRepository carRepository, MemberRepository memberRepository, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Car car1 = new Car("Tesla", "S", 500, true);
        Car car2 = new Car("BMW", "i8", 1000, false);

        carRepository.save(car1);
        carRepository.save(car2);

        Member member1 = new Member("Golden", "Member", "Woltersgade", "Copenhagen", "2300", true,1 );
        Member member2 = new Member("Agent", "Secret", "Elm", "Goddamn", "zap", true, 5);

        memberRepository.save(member1);
        memberRepository.save(member2);
    }
}