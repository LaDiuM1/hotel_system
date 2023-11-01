package hotelManagement.model.entity;

import hotelManagement.model.entity.guestroom.RoomReservationEntity;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Component
public class EntityListener { // 엔티티 이벤트 적용 함수
    @PrePersist // 객실 예약 시간 default 현재 시간 적용 함수
    public void setCreatedAt(RoomReservationEntity entity) {
        if (entity.getRrtime() == null) {
            entity.setRrtime(LocalDateTime.now());
        }
    }
}
