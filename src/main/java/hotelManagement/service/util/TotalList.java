package hotelManagement.service.util;

import java.util.Map;

public interface TotalList< T , G > {

    // 리스트 가져오는 추상 메서드
    public abstract Map<String,Object> getList( T searchDto );

    // 페이징 처리 담당하는 추상 메서드
    public abstract Map<String,Object> onPagging( int page, int limitPage, int totalSize, G recordList );

}
