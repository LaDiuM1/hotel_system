import axios from 'axios'
import '../css/room/RoomReservation.css'
import {useEffect, useState} from 'react'
import Record from './RecordComponent'
export default function RoomReservation(){
    /* 등급명, 시작날짜, 키워드*/
    let[ info, setInfo ] = useState( {
        gname: "Nonselect",
        rrstartdate: new Date().toISOString().slice(0, 10),
        rrenddate:'',
        keyword: '',
        nowPage: 1
    })
    // 검색 시 페이지와 레코드 배열이 담겨있음.
    let[ reservationRecord, setReservationRecord ] = useState( [] )
    let[ recordPage , setRecordPage ] = useState(null)
    /* 최초 검색 실행 */
    useEffect(() => {onSearch();}, []);
    /* info 수정 시 실행 */
    useEffect(() => {onSearch()}, [info])
    // 검색 함수
    const onSearch = () => {
        axios
            .get("http://localhost:80/guestRoomReservation", {params:info})
            .then( response => {
                setRecordPage(response.data);
                setReservationRecord( response.data.roomDtoList );
            })
    }
    // 페이징 관련 함수 =========================
    function pageBtn(){
        if( recordPage === null ) return;

        let htmlArr = [];

        for(let i = recordPage.startBtn; i <= recordPage.endBtn; i++ ) {
            htmlArr.push(<button className={i === info.nowPage ? "pageActive" : ""} type={"button"} key={i}
                                 onClick={() => {
                                     setInfo({...info, nowPage: i});
                                 }}>{i}</button>)
        }

        if( htmlArr.length === 0 ) htmlArr.push( <button type={"button"} key={1}>{1}</button> )
        return htmlArr;
    }
    // 검색 결과 총 사이즈 가져오는 함수
    function getTotalSize(){
        if(recordPage === null) return 0;
        return recordPage.totalSize;
    }
    // ========================================

    /* 객실 예약 컴포넌트 */
    return(<>
        <div className={"reservationContainer"}>
            <div className={"reservationWrap"}>
                <div className={"searchWrap"}>
                    <div className={"searchBox"}>
                        <select onChange={(e)=>{ setInfo({...info, gname: e.target.value}); }} className={"ReservationGrade"}>
                            <option value={"Nonselect"}>전체</option>
                            <option value={"Standard"}>Standard</option>
                            <option value={"Deluxe"}>Deluxe</option>
                            <option value={"Premier"}>Premier</option>
                            <option value={"Royal"}>Royal</option>
                            <option value={"Suite"}>Suite</option>
                        </select>
                        <input type={"date"} className={"ReservationDate"} value={info.rrstartdate} onChange={(e)=>{setInfo({...info, rrstartdate: e.target.value} );  }}/>
                        <input type={"date"} className={"ReservationDate"} value={info.rrenddate} onChange={(e)=>{setInfo({...info, rrenddate: e.target.value});}}/>
                        <input type={"text"} className={"ReservationSearch"} value={info.keyword} onChange={(e)=>{ setInfo( {...info, keyword: e.target.value });} } placeholder={"검색"}/>
                        <button type={"button"} className={"searchBtn"} onClick={ onSearch }>검색</button>
                    </div>
                    <div className={"totalRecordWrap"}>
                        총 검색 게시물 수 : <span>{getTotalSize()}</span>
                    </div>
                </div>
                <div className={"tableWrap"}>
                    {/* 테이블 컬럼 명 */}
                    <div className={"tableColumn"}>
                        <span className={"guestRoomNum"}>호실</span>
                        <span className={"guestRoomGrade"}>등급</span>
                        <span className={"guestRoomStart"}>시작 날짜</span>
                        <span className={"guestRoomEnd"}>종료 날짜</span>
                        <span className={"guestRoomName"}>성함</span>
                        <span className={"guestRoomPhone"}>전화번호</span>
                        <span className={"guestRoomCheckIn"}>체크인</span>
                        <span className={"guestRoomCheckOut"}>체크아웃</span>
                    </div>
                    {/* 레코드 구역 */}
                    {
                        reservationRecord.map( (r,i) => { return (<Record key={i} props={r}/>) } )
                    }
                </div>
                {/* 페이지 공간 */}
                <div className={"tablePage"}>
                    <button type={"button"} onClick={ () => {
                        let page = info.nowPage;
                        setInfo({...info, nowPage: page <= 1 ? page : page - 1 });

                    } }> &lt; </button>
                    {/* 페이지 버튼*/}
                    {
                        pageBtn()
                    }

                    <button type={"button"} onClick={ () => {
                        let page = info.nowPage;
                        setInfo({...info, nowPage: page >= recordPage.totalPage ? page : page + 1 });
                    } }> &gt; </button>
                </div>
            </div>
        </div>
    </>)
}



