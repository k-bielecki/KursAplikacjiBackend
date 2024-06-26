package pl.nullpointerexception.shop.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nullpointerexception.shop.common.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//    @Query("select c from Category c " +
//            "left join fetch c.product " +
//            "where c.slug=:slug")
    Category findBySlug(String slug);
}
