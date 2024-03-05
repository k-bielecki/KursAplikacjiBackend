package pl.nullpointerexception.shop.cart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.nullpointerexception.shop.common.model.Cart;
import pl.nullpointerexception.shop.common.model.CartItem;
import pl.nullpointerexception.shop.cart.model.dto.CartProductDto;
import pl.nullpointerexception.shop.common.repository.CartRepository;
import pl.nullpointerexception.shop.common.model.Product;
import pl.nullpointerexception.shop.common.repository.ProductRepository;

import java.util.List;

import static java.time.LocalDateTime.*;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Cart addProductToCart(Long id, CartProductDto cartProductDto) {
        Cart cart = getInitializedCart(id);
        cart.addProduct(CartItem.builder()
                        .quantity(cartProductDto.quantity())
                        .product(getProduct(cartProductDto.productId()))
                        .cartId(cart.getId())
                .build());

        return cart;
    }

    @Transactional
    public Cart updateCart(Long id, List<CartProductDto> cartProductDtos) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        cart.getItems().forEach(cartItem -> {
            cartProductDtos.stream()
                    .filter(cartProductDto -> cartItem.getProduct().getId().equals(cartProductDto.productId()))
                    .findFirst()
                    .ifPresent(cartProductDto1 -> cartItem.setQuantity(cartProductDto1.quantity()));
        });
        return cart;
    }
    private Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    private Cart getInitializedCart(Long id) {
        if(id == null || id <= 0) {
            return cartRepository.save(Cart.builder().created(now()).build());
        }
        return cartRepository.findById(id).orElseThrow();
    }
}
