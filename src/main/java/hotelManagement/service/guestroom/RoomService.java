package hotelManagement.service.guestroom;

import hotelManagement.model.dto.guestroom.RoomDto;
import hotelManagement.model.dto.guestroom.RoomReservationDto;
import hotelManagement.model.entity.guestroom.RoomEntity;
import hotelManagement.model.entity.member.MemberEntity;
import hotelManagement.model.repository.guestroom.RoomEntityRepository;
import hotelManagement.model.repository.guestroom.RoomGradeEntityRepository;
import hotelManagement.model.repository.guestroom.RoomReservationEntityRepository;
import hotelManagement.model.repository.member.MemberEntityRepository;
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
    MemberEntityRepository memberEntityRepository;

    @Transactional // 객실 정보 반환 함수
    public List<RoomDto> getGuestRoomList(){
        LocalDateTime nowDate = LocalDateTime.now();
        List<RoomEntity> RoomEntityList = roomEntityRepository.findAll();
        
        List<RoomDto> roomDtoList = new ArrayList<>();
        RoomEntityList.forEach( p -> {
            RoomDto roomDto = p.toDto();
            // 네이티브 쿼리 결과를 인터페이스로 저장
            RoomReservationEntityRepository.RoomReservationDto roomReservationDto =  roomReservationEntityRepository.stateCheck(p.getRno(), nowDate);

            Optional<MemberEntity> memberEntity = memberEntityRepository.findById(roomReservationDto.getMno_fk());

            if(memberEntity.isPresent()){

            }

            int roomState = p.getRstate();
            // 1 : 입실중 , 2 : 공실, 3 : 사용불가
            if(roomReservationDto != null && roomState == 1){
                roomDto.setRstate(1);

                // dto 객체 builder 후 인터페이스로 필드 값 호출 후 저장
                roomDto.getRoomReservationDtoList().add(
                        RoomReservationDto.builder()
                                .rrno(roomReservationDto.getRrno())
                                .rrstartdate(roomReservationDto.getRrstartdate())
                                .rrenddate(roomReservationDto.getRrenddate())
                                .rrcheckin(roomReservationDto.getRrcheckin())
                                .build()
                );
            }
            else if ( roomState == 0){
                roomDto.setRstate(3);
            }
            else {
                roomDto.setRstate(2);
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

}
