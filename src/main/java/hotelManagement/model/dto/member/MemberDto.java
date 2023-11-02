package hotelManagement.model.dto.member;

import hotelManagement.model.entity.member.MemberEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder
public class MemberDto {

    private String mid;     // 회원 아이디
    private String mpwd;    // 회원 비밀번호


    public MemberEntity toEntity() { // dto -> Entity
        return MemberEntity.builder()
                .mid(this.mid)
                .mpwd(this.mpwd)
                .build();
    }

}
