package hotelManagement.model.dto.guestroom;

import hotelManagement.model.dto.member.MemberDto;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
// 객실 예약 명단 DTO
public class RoomReservationDto {

    private int rrno;                   // 객실 예약 기본키 [ pk ]
    private LocalDateTime rrtime;       // 객실 예약 시간 필드 / EntityListener 클래스를 통해 default 값으로 현재 시간 설정
    private LocalDate rrstartdate;      // 예약 시작 날짜
    private LocalDate rrenddate;        // 예약 종료 날짜
    private LocalDateTime rrcheckin;    // 체크인 시간
    private LocalDateTime rrcheckout;   // 체크아웃 시간
   // private int mno;                     // 회원 번호 fk
    private String mname;                  // 회원 이름
    private String mphone;                 // 회원 전화번호
    private int rno;                     // 객실 번호 fk


}


