package hotelManagement.model.entity.member;

import hotelManagement.model.entity.BaseTime;
import hotelManagement.model.entity.employee.EmployeeEntity;
import hotelManagement.model.entity.room.RoomReservationEntity;
import hotelManagement.model.entity.locationEntity.LocationReservationEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "memberinfo")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder
// 회원 공통 정보 테이블
public class MemberInfoEntity extends BaseTime {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int mno;                // 테이블 회원 번호
    @Column(columnDefinition = "tinyint", nullable = false)
    private int mtype;              // 회원 비회원 구분 필드
    @Column(nullable = false, length = 20)
    private String mname;              // 회원 이름 공통 필드
    @Column(nullable = false, length = 5)
    private String msex;               // 회원 성별 공통 필드
    @Column(nullable = false, length = 20)
    private String mphone;             // 회원 전화번호 공통 필드
    @Column(nullable = false, length = 10)
    private String mbirth;             // 회원 생년월일 공통 필드

    @OneToOne( mappedBy = "memberInfoEntity")
    private MemberEntity memberEntity;  // 회원 엔티티

    @ToString.Exclude
    @OneToMany( mappedBy = "memberInfoEntity" )
    @Builder.Default
    private List<RoomReservationEntity> roomReservationEntityList = new ArrayList<>(); // 양방향 객실 예약 리스트

    @ToString.Exclude
    @Builder.Default
    @OneToMany( mappedBy = "memberInfoEntity")
    private List<LocationReservationEntity> lresvList = new ArrayList<>(); // 양방향 시설 예약 리스트

    @ToString.Exclude
    @Builder.Default
    @OneToMany( mappedBy = "memberInfoEntity")
    private List<LocationReservationEntity> ticketList = new ArrayList<>(); // 양방향 티켓 리스트

    @ToString.Exclude
    @OneToOne( mappedBy = "memberInfoEntity")
    private EmployeeEntity employeeEntity;  // 직원 정보 엔티티 양방향 관계 설정

}
