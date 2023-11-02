package hotelManagement.service.guestroom;

import hotelManagement.model.dto.guestroom.RoomReservationDto;
import hotelManagement.model.dto.member.RoomSearchDto;
import hotelManagement.model.entity.guestroom.RoomReservationEntity;
import hotelManagement.model.repository.guestroom.RoomReservationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomReservationService {

    @Autowired
    RoomReservationEntityRepository roomReservationEntityRepository;
    // get 객실 예약 리스트
    public List<RoomReservationDto> getRoomReservation(RoomSearchDto roomSearchDto){
        // keyword의 전화번호, 이름, 호실 판단 로직
        String keyword = roomSearchDto.getKeyword();
        // type엔 keyword가 이름, 호실, 전화번호 셋 중 하나가 들어있음
        String type = aboutType(keyword);
        System.out.println(roomSearchDto.getRrstartdate().isEmpty()
                && roomSearchDto.getGname().isEmpty()
                && roomSearchDto.getKeyword().isEmpty());
        // 모든 검색조건이 없을 때
        if( roomSearchDto.getRrstartdate().isEmpty()
                && roomSearchDto.getGname().equals("Nonselect")
                    && roomSearchDto.getKeyword().isEmpty()){
            List<RoomReservationEntity> entities= roomReservationEntityRepository.findAll();
            List<RoomReservationDto> dtoList = new ArrayList<>();
            for( RoomReservationEntity entitie : entities ){
                dtoList.add(entitie.toDto());
            }
            System.out.println("dtoList = " + dtoList);
            return dtoList;
        }
        System.out.println("RoomReservationService.getRoomReservation");
        return null;
    }
    public String aboutType(String keyword){
        char[] charKeyword = keyword.toCharArray();
        // 이름 판단
        for (char i : charKeyword) {
            if ( '힣' > i && i > '가') {
                return "mname";
            }
        }
        // 전화번호, 호실 판단
        if( charKeyword.length > 4 ) return "rno";
        else return "rphone";
    }

}
