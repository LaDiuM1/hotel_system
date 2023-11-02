package hotelManagement.model.entity.member;

import hotelManagement.model.dto.member.MemberDto;
import lombok.*;
import javax.persistence.*;


@Entity
@Table( name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder
// 회원 테이블
public class MemberEntity {

    @Id
    @Column(length = 20, nullable = false)
    private String mid;
    @Column(length = 100, nullable = false)
    private String mpwd;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "mno_fk")
    private MemberInfoEntity memberInfoEntity;

/*    @OneToMany( mappedBy = "memberEntity")
    @Builder.Default
    private List<RoomReservationEntity> roomReservationEntityList = new ArrayList<>();*/
    // Dto변환
    public MemberDto toMemberDto(){
        return MemberDto.builder()
                .mid(this.mid)
                .mpwd(this.mpwd).build();
    }
}
