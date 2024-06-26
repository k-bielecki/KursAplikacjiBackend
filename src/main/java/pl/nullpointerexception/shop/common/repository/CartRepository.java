package pl.nullpointerexception.shop.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.nullpointerexception.shop.common.model.Cart;

import java.time.LocalDateTime;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByCreatedLessThan(LocalDateTime minusDays);
    @Query("delete from Cart c where c.id=:id")
    @Modifying
    void deleteCartById(Long id);

    @Query("delete from CartItem ci where ci.cartId in (:ids)")
    @Modifying
    void deleteAllByIdIn(List<Long> ids);
}
