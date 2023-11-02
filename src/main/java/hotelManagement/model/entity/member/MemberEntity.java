package hotelManagement.model.entity.member;

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
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int mgno;
    @Column( name = "mno")
    private int mno;
    @Column(length = 20, nullable = false)
    private String mid;
    @Column(length = 100, nullable = false)
    private String mpwd;
    @ToString.Exclude
    @OneToOne(mappedBy = "memberEntity")
    private MemberInfoEntity memberInfoEntity;

}
