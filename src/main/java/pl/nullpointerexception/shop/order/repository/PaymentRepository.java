package pl.nullpointerexception.shop.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.nullpointerexception.shop.order.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
