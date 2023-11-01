package hotelManagement.model.entity.member;

import hotelManagement.model.entity.BaseTime;
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
    private int mname;              // 회원 이름 공통 필드
    @Column(nullable = false, length = 5)
    private int msex;               // 회원 성별 공통 필드
    @Column(nullable = false, length = 20)
    private int mphone;             // 회원 전화번호 공통 필드
    @Column(nullable = false, length = 10)
    private int mbirth;             // 회원 생년월일 공통 필드
    @Column(nullable = false)
    private int mgno;               // 회원, 비회원 참조 필드

    @OneToOne
    MemberEntity memberEntity;
    @OneToOne
    GuestEntity guestEntity;
/*    @OneToMany( mappedBy = "memberInfoEntity" )
    List<MemberEntity> MemberEntityList = new ArrayList<>();
    @Builder.Default
    @OneToMany( mappedBy = "memberInfoEntity" )
    List<GuestEntity> GuestEntityList = new ArrayList<>();*/

    /* BaseTime 상속 필드
    @CreatedDate
    protected LocalDateTime cdate;    // 레코드 생성 날짜
    @LastModifiedDate
    protected LocalDateTime udate;    // 레코드 수정 날짜
    */


}
