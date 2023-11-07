package hotelManagement.service.guestroom;

import hotelManagement.model.dto.room.RoomDto;
import hotelManagement.model.dto.room.RoomReservationDto;
import hotelManagement.model.entity.room.RoomEntity;
import hotelManagement.model.entity.member.MemberInfoEntity;
import hotelManagement.model.entity.room.RoomReservationEntity;
import hotelManagement.model.repository.room.RoomEntityRepository;
import hotelManagement.model.repository.room.RoomGradeEntityRepository;
import hotelManagement.model.repository.room.RoomReservationEntityRepository;
import hotelManagement.model.repository.member.MemberInfoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomEntityRepository roomEntityRepository;
    @Autowired
    private RoomReservationEntityRepository roomReservationEntityRepository;
    @Autowired
    private RoomGradeEntityRepository roomGradeEntityRepository;
    @Autowired
    MemberInfoEntityRepository memberInfoEntityRepository;

    @Transactional // 객실 정보 반환 함수
    public List<RoomDto> getGuestRoomList(){
        LocalDateTime nowDate = LocalDateTime.now();
        List<RoomEntity> RoomEntityList = roomEntityRepository.findAll();

        List<RoomDto> roomDtoList = new ArrayList<>();
        RoomEntityList.forEach( p -> {
            RoomDto roomDto = p.toDto();
            // 네이티브 쿼리 결과를 인터페이스로 저장
            RoomReservationEntityRepository.RoomReservationDto roomReservationDto =  roomReservationEntityRepository.stateCheck(p.getRno(), nowDate);

            int roomState = p.getRstate();
            // 1 : 입실중 , 2 : 공실, 3 : 사용불가
            if (roomReservationDto != null && roomState == 1) {
                roomDto.setRstate(1);

                // 예약 정보가 있을 시 객실 예약테이블 회원번호 참조키로 회원 정보 호출
                Optional<MemberInfoEntity> memberInfoEntity = memberInfoEntityRepository.findById(roomReservationDto.getMno_fk());
                MemberInfoEntity entity = new MemberInfoEntity();

                if (memberInfoEntity.isPresent()) { entity = memberInfoEntity.get(); }

                // RoomDto 객체 생성하여 예약정보, 회원정보 빌더 메서드로 대입
                roomDto.getRoomReservationDtoList().add(
                        RoomReservationDto.builder()
                                .rrno(roomReservationDto.getRrno())
                                .rrstartdate(roomReservationDto.getRrstartdate())
                                .rrenddate(roomReservationDto.getRrenddate())
                                .rrcheckin(roomReservationDto.getRrcheckin())
                                .mname(entity.getMname())
                                .mphone(entity.getMphone())
                                .build()
                );
            }
            else if (roomState == 0) { // 객실 상태가 0 일때 사용불가 설정
                roomDto.setRstate(3);
            }
            else {
                roomDto.setRstate(2); // 그 외에는 공실로 설정
            }

            roomDtoList.add(roomDto);
        });

        return roomDtoList;
    }

    @Transactional // 객실 상태 변경 함수
    public boolean updateRoomState(RoomDto roomDto){
        System.out.println("roomDto = " + roomDto);
        Optional<RoomEntity> roomEntity = roomEntityRepository.findById(roomDto.getRno());
        
        if (roomEntity.isPresent()) {   // 객실 상태 전송 정보가 true면 tinyint 타입의 객실 상태에 1 ( 사용 가능 대입 )
            roomEntity.get().setRstate(roomDto.getRstate());
            return true;
        }
        return false;

    }

    @Transactional // 퇴실 처리 함수
    public boolean checkout(int rrno){
        Optional<RoomReservationEntity> OpRoomResvEntity = roomReservationEntityRepository.findById(rrno);

        if(OpRoomResvEntity.isPresent()){
            OpRoomResvEntity.get().setRrcheckout(LocalDateTime.now());
            return true;
        }
        return false;
    }
}
