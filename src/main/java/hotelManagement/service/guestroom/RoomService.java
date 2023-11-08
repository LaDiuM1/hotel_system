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
        // 현재 시간 기준 예약 날짜 확인을 위한 현재 시간 구하기
        LocalDateTime nowDate = LocalDateTime.now();
        // 모든 객실 엔티티 호출 후 저장
        List<RoomEntity> RoomEntityList = roomEntityRepository.findAll();
        // 결과 반환을 위한 Dto 리스트 선언
        List<RoomDto> roomDtoList = new ArrayList<>();
        // 객실 수만큼 반복문 실행
        RoomEntityList.forEach( p -> {
            // 개별 객실 엔티티를 dto로 변환
            RoomDto roomDto = p.toDto();
            // 현재 시간 기준의 객실 예약 정보가 있는지 확인, 네이티브 쿼리를 인터페이스로 인터페이스 필드와 매칭
            RoomReservationEntityRepository.RoomReservationDto roomReservationDto =  roomReservationEntityRepository.stateCheck(p.getRno(), nowDate);
            // 객실 상태 저장
            int roomState = p.getRstate();
            // 쿼리 검색 결과가 없거나 객실 상태가 사용 가능이면 아래 기준 입실중 반환
            // 1 : 입실중 , 2 : 공실, 3 : 사용 불가
            if (roomReservationDto != null && roomState == 1) {
                roomDto.setRstate(1);

                // 쿼리 결과 인터페이스의 회원 번호 참조키로 회원 정보를 반환, 옵셔널 형태로 저장
                Optional<MemberInfoEntity> memberInfoEntity = memberInfoEntityRepository.findById(roomReservationDto.getMno_fk());
                // 반환 결과에 회원 정보를 포함하기 위한 회원 정보 엔티티 생성
                MemberInfoEntity entity = new MemberInfoEntity();
                // isPresent로 결과가 null인지 확인하여 null이 아니면 엔티티에 회원 정보 저장
                if (memberInfoEntity.isPresent()) { entity = memberInfoEntity.get(); }

                // 빌더 패턴으로 예약 정보의 인터페이스 필드와 회원 엔티티의 각 필드값을 저장하여
                // 생성 후 roomDto 객체의 객실 예약 정보 리스트 필드에 추가
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
            // 객실 상태가 0 일때 사용불가 설정
            else if (roomState == 0) {
                roomDto.setRstate(3);
            }
            // 그 외에는 공실로 설정
            else {
                roomDto.setRstate(2);
            }
            // 반환용 리스트에 객실 Dto 객체 순차적으로 추가
            roomDtoList.add(roomDto);
        });
        // 반복문 종료 후 List 반환
        return roomDtoList;
    }

    @Transactional // 객실 상태 변경 함수
    public boolean updateRoomState(RoomDto roomDto){
        Optional<RoomEntity> roomEntity = roomEntityRepository.findById(roomDto.getRno());
        
        if (roomEntity.isPresent()) {   // 객실 상태 전송 정보가 true면 tinyint 타입의 객실 상태에 1 ( 사용 가능 대입 )
            roomEntity.get().setRstate(roomDto.getRstate());
            return true;
        }
        return false;

    }

    @Transactional // 퇴실 처리 함수
    public boolean checkout(int rrno){
        // 매개변수의 PK값으로 객실 예약 정보 엔티티 옵셔널로 호출
        Optional<RoomReservationEntity> OpRoomResvEntity = roomReservationEntityRepository.findById(rrno);

        // 결과가 있다면 실행
        if(OpRoomResvEntity.isPresent()){
            // 객실 예약정보 체크 아웃 필드에 현재 시간 삽입하여 퇴실 처리
            OpRoomResvEntity.get().setRrcheckout(LocalDateTime.now());
            return true;
        }
        return false;
    }
}
