package hotelManagement.model.dto.discount;

import hotelManagement.model.entity.discount.TicketEntity;

import java.time.LocalDate;

public class TicketDto {
    private int tno;                // 기본키
    private LocalDate tstartdate;   // 이용권 시작 날짜
    private LocalDate tenddate;     // 이용권 종료 날짜
    private int mno;                // 멤버번호(필요시 멤버 객체)

    // 엔티티 변환 메서드
    // 현재 mno 미포함 상태 !!!
    public TicketEntity toEntity(){
        return TicketEntity.builder()
                .tno(this.tno)
                .tstartdate(this.tstartdate)
                .tenddate(this.tenddate)
                .build();
    }
}
