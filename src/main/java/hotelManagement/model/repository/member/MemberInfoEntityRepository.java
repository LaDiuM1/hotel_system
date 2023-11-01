package hotelManagement.model.repository.member;

import hotelManagement.model.entity.member.MemberInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberInfoEntityRepository extends JpaRepository<MemberInfoEntity, Integer> {


}
