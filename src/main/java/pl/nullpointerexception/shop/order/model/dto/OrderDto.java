package pl.nullpointerexception.shop.order.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderDto {
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String street;
    @NotNull
    private String zipcode;
    @NotNull
    private String city;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private Long cartId;
    @NotNull
    private Long shipmentId;
    @NotNull
    private Long paymentId;
}
