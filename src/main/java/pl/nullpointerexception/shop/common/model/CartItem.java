package pl.nullpointerexception.shop.common.model;

import jakarta.persistence.*;
import lombok.*;
import pl.nullpointerexception.shop.common.model.Product;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @OneToOne
    private Product product;
    private Long cartId;
}
