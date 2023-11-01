package hotelManagement.model.entity.guestroom;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table( name = "roomresv")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class RoomReservationEntity { // 객실 예약 명단 엔티티

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int rrno;                   // 객실 예약 기본키 [ pk ]
    @Column(nullable = false)
    private LocalDateTime rrtime;       // 객실 예약 시간 필드 / EntityListener 클래스를 통해 default 값으로 현재 시간 설정
    @Column(nullable = false)
    private LocalDate rrstartdate;      // 예약 시작 날짜
    @Column(nullable = false)
    private LocalDate rrenddate;        // 예약 종료 날짜
    @Column
    private LocalDateTime rrcheckin;    // 체크인 시간
    @Column
    private LocalDateTime rrcheckout;   // 체크 아웃 시간
    @Column
    private int mno;                     // 회원 번호 fk
    @Column
    private int rno;                     // 객실 번호 fk


}
