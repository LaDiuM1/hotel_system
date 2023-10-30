package hotelManagement.model.repository;

import hotelManagement.model.entity.MemberInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberInfoEntityRepository extends JpaRepository<MemberInfoEntity, Integer> {


}
