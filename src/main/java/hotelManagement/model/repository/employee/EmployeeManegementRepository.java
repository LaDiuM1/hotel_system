package hotelManagement.model.repository.employee;

import hotelManagement.model.entity.employee.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeManegementRepository extends JpaRepository<EmployeeEntity, String> {

    // employee, depart, memberinfo 테이블 join
    @Query(value = " select e.eno,e.eaddress,m.mname,m.msex,m.mbirth,m.mphone,e.pname_fk,d.dname " +
            "from employee e,department d ,memberinfo m " +
            // 교집합
            "where e.mno_fk = m.mno and e.dcode_fk = d.dcode " +
            // 부서
            "AND IF( :depart = '' , true, d.dname = :depart) " +
            // 직책
            "AND IF( :position = '', true, e.pname_fk = :position) " +
            // 키워드 타입에 따른 키워드 검색
            "AND IF( :keyword = '', true" +
            ", IF( :searchType = 'eno', e.eno like %:keyword% " +
            ", IF( :searchType = 'mname', m.mname like %:keyword%, m.mphone like %:keyword% )))" , nativeQuery = true)
    // 검색, 페이지 조건에 따른 네이티브 쿼리
    List<Map<String,Object>> findByCondition(String depart, String position, String keyword, String searchType );
}
