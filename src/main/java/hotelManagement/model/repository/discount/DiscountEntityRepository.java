package hotelManagement.model.repository.discount;

import hotelManagement.model.entity.discount.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountEntityRepository extends JpaRepository<DiscountEntity, String> {

}
