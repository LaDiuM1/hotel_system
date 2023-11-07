package hotelManagement.model.dto.discount;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DiscountDto {
    private String dtype;   // 할인 종류
    private double drate;   // 할인율
}
