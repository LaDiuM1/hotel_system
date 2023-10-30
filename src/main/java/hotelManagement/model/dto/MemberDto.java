package hotelManagement.model.dto;

import hotelManagement.model.entity.MemberEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder
public class MemberDto {

    private int mgno;       // 회원 기본키
    private String mid;     // 회원 아이디
    private String mpwd;    // 회원 비밀번호


    public MemberEntity toEntity() { // dto -> Entity
        return MemberEntity.builder()
                .mgno(this.mgno)
                .mid(this.mid)
                .mpwd(this.mpwd)
                .build();
    }

}
