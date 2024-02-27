package pl.nullpointerexception.shop.category.model;

import org.springframework.data.domain.Page;
import pl.nullpointerexception.shop.product.controller.dto.ProductListDto;
import pl.nullpointerexception.shop.product.model.Product;

public record CategoryProductDto(Category category, Page<ProductListDto> products) {
}
