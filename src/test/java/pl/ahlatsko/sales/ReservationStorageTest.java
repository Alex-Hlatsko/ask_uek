package pl.ahlatsko.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.ahlatsko.sales.reservation.Reservation;
import pl.ahlatsko.sales.reservation.ReservationRepository;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootTest
public class ReservationStorageTest {

    @Autowired
    ReservationRepository reservationRepository;

    @Test
    void insert() {
        Reservation reservation = new Reservation(
                UUID.randomUUID().toString(),
                BigDecimal.TEN,
                "payment");
        reservationRepository.save(reservation);
    }

    @Test
    void select() {
        String id = UUID.randomUUID().toString();
        Reservation reservation = new Reservation(
                id,
                BigDecimal.TEN,
                "payment");
        reservationRepository.save(reservation);

        Reservation loaded =  reservationRepository.findById(id)
                .get();
    }
}