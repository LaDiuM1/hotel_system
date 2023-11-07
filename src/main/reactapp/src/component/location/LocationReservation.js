
import '../css/location/LocationReservation.css'
import Record from "../room/RecordComponent";

export default function LocationReservation(){
    return(<>
            <div className={"reservationContainer"}>
                <div className={"reservationWrap"}>
                    <div className={"searchWrap"}>
                        <div className={"searchBox"}>
                            <select className={"ReservationGrade"}>
                                <option value={"Nonselect"}>전체</option>
                                <option value={"Standard"}>Standard</option>
                                <option value={"Deluxe"}>Deluxe</option>
                                <option value={"Premier"}>Premier</option>
                                <option value={"Royal"}>Royal</option>
                                <option value={"Suite"}>Suite</option>
                            </select>
                            <input type={"date"} className={"ReservationDate"} />
                            <input type={"date"} className={"ReservationDate"} />
                            <input type={"text"} className={"ReservationSearch"}/>
                            <button type={"button"} className={"searchBtn"}>검색</button>
                        </div>
                        <div className={"totalRecordWrap"}>
                            총 검색 게시물 수 : <span>{}</span>
                        </div>
                    </div>
                    <div className={"tableWrap"}>
                        {/* 테이블 컬럼 명 */}
                        <div className={"tableColumn"}>
                            <span className={"guestRoomStart"}>시설이름</span>
                            <span className={"guestRoomNum"}>시설예약상태</span>
                            <span className={"guestRoomEnd"}>예약자명</span>
                            <span className={"guestRoomName"}>전화번호</span>
                            <span className={"guestRoomGrade"}>시설예약시간</span>
                        </div>
                    </div>
                        {/* 레코드 구역 */}


                    {/* 페이지 공간 */}
                    <div className={"tablePage"}>
                        <button type={"button"}>&lt;</button>
                        <button type={"button"}>&gt;</button>
                    </div>
                </div>
            </div>
        </>)
}