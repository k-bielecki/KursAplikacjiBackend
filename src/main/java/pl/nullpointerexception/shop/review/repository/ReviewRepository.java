package pl.nullpointerexception.shop.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.nullpointerexception.shop.review.model.Review;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}