package hotelManagement.model.dto.member;

import hotelManagement.model.entity.member.GuestEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder
public class GuestDto {

    private int mgno;   // 비회원 기본키

    public GuestEntity toEntity() { // dto -> Entity
        return GuestEntity.builder()
                .mgno(this.mgno)
                .build();
    }
}
