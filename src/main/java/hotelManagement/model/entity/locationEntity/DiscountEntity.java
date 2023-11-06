package hotelManagement.model.entity.locationEntity;

import hotelManagement.model.entity.BaseTime;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table( name = "discount")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class DiscountEntity extends BaseTime {
    @Id
    @Column(length = 20 , nullable = false)
    private String dtype;   // 할인 종류
    private double drate;   // 할인율

}
