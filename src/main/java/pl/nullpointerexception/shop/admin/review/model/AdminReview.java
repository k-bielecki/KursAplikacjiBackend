package pl.nullpointerexception.shop.admin.review.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "review")
public class AdminReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String authorName;
    private String content;
    private boolean moderated;
}
