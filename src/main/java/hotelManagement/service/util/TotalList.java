package hotelManagement.service.util;

import java.util.List;
import java.util.Map;

public interface TotalList< T , G > {


    /*
    * 리스트 가져오는 추상 메서드
    * */
    public abstract Map<String,Object> getList( T searchDto );

    /*
    * 페이징 처리 담당하는 추상 메서드
    * */
    public abstract Map<String,Object> onPagging( G recordList, int page, int limitPage, int totalSize );

    /*
    * 정렬 처리 담당하는 추상 메서드
    * */
    public abstract G onSort( G recordList, String columnName, String ascOrDesc );

}
