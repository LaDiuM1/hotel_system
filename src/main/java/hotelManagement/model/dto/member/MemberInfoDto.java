package hotelManagement.model.dto.member;

import hotelManagement.model.entity.member.MemberInfoEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder
public class MemberInfoDto {

    private int mno;                // 테이블 회원 번호
    private int mtype;              // 회원 비회원 구분 필드
    private String mname;              // 회원 이름 공통 필드
    private String msex;               // 회원 성별 공통 필드
    private String mphone;             // 회원 전화번호 공통 필드
    private String mbirth;             // 회원 생년월일 공통 필드
    private int mgno;               // 회원, 비회원 참조 필드

    public MemberInfoEntity toEntity() { // dto -> Entity
        return MemberInfoEntity.builder()
                .mno(this.mno)
                .mtype(this.mtype)
                .mname(this.mname)
                .msex(this.msex)
                .mphone(this.mphone)
                .mbirth(this.mbirth)
                .build();
    }

}
