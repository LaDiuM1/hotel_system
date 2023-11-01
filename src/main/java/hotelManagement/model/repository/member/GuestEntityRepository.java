package hotelManagement.model.repository.member;

import hotelManagement.model.entity.member.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestEntityRepository extends JpaRepository<GuestEntity, Integer> {


}
