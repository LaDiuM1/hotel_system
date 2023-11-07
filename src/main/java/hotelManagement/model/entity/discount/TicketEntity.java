package hotelManagement.model.entity.discount;

import hotelManagement.model.entity.BaseTime;
import hotelManagement.model.entity.member.MemberEntity;
import hotelManagement.model.entity.member.MemberInfoEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table( name = "ticket")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class TicketEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int tno;                // 기본키
    private LocalDate tstartdate;   // 이용권 시작 날짜
    private LocalDate tenddate;     // 이용권 종료 날짜

    @ManyToOne
    @JoinColumn(name = "mno")
    private MemberInfoEntity memberInfoEntity;  // 회원번호

}
