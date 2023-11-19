import axios from 'axios'
import '../css/room/roomReservation.css'
import {useEffect, useState} from 'react'
import Record from './RecordComponent'
export default function RoomReservation(){
    /* 등급명, 시작날짜, 키워드*/
    let[ info, setInfo ] = useState( {
        gname: "Nonselect",
        rrstartdate: "",
        rrenddate:'',
        keyword: '',
        // 페이징과 정렬 객체
        pageAndSort: {
            //페이징 관련
            nowPage: 1,
            limitPage: 10,
            /* 정렬 관련 */
            cname:"",
            isSorted: false
        }
    })
    // 검색 시 결과 리스트 저장
    let[ reservationRecord, setReservationRecord ] = useState( [] )
    // 검색 시 페이징 처리를 위한 데이터 저장
    let[ recordPage , setRecordPage ] = useState(null)
    // 정렬을 위한 객체 저장
    //let[ isSorted, setIsSorted ] = useState({  });

    /* info 수정 시 실행 */
    useEffect(() => {onSearch();console.log(info); }, [info])
    // 검색 함수
    const onSearch = () => {
        axios
            .post("/guestRoomReservation", info)
            .then( response => {
                // 페이징 처리를 위한 데이터
                setRecordPage(response.data);
                // 검색 결과 리스트 배열
                setReservationRecord( response.data.roomDtoList );

                console.log(reservationRecord)
            })
    }
    // 페이징 관련 함수 =========================
    function pageBtn(){
        if( recordPage === null ) return;

        let htmlArr = [];

        for(let i = recordPage.startBtn; i <= recordPage.endBtn; i++ ) {
            htmlArr.push(<button className={i === info.pageAndSort.nowPage ? "pageActive" : ""} type={"button"} key={i}
                                 onClick={() => {
                                     setInfo({
                                         ...info,
                                         pageAndSort: { ...info.pageAndSort, nowPage: i}
                                     });
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
                    {/* 출력할 레코드 수 select*/}
                    <select onChange={(e)=>{setInfo({
                        ...info,
                        pageAndSort:{
                            ...info.pageAndSort
                            ,limitPage: e.target.value }
                    })}}>
                        <option value={10}>10</option>
                        <option value={15}>15</option>
                        <option value={20}>20</option>
                    </select>
                </div>
                <div className={"tableWrap"}>
                    {/* 테이블 컬럼 명 */}
                    <div className={"tableColumn"}>
                        {
                            (()=>{
                                let tableColumn = [
                                    {className:"guestRoomNum" ,ctitle:"호실",cname:"rrno"},
                                    {className:"guestRoomGrade" ,ctitle:"등급",cname:"rgrade"},
                                    {className:"guestRoomStart" ,ctitle:"시작 날짜",cname:"sdate"},
                                    {className:"guestRoomEnd" ,ctitle:"종료 날짜",cname:"edate"},
                                    {className:"guestRoomName" ,ctitle:"성함",cname:"rname"},
                                    {className:"guestRoomPhone" ,ctitle:"전화번호",cname:"rphone"},
                                    {className:"guestRoomCheckIn" ,ctitle:"체크인",cname:"rcin"},
                                    {className:"guestRoomCheckOut" ,ctitle:"체크아웃",cname:"rcout"}
                                ]
                                let htmlArr = [];
                                //
                                for(let i = 0; i < tableColumn.length; i++){
                                    htmlArr.push( <span key={i} className={tableColumn[i].className}>{tableColumn[i].ctitle}<span className={"sortPointer"}
                                        onClick={()=>{
                                            setInfo({
                                                ...info,
                                                pageAndSort:{
                                                    ...info.pageAndSort,
                                                    cname:tableColumn[i].cname,
                                                    isSorted: !info.pageAndSort.isSorted
                                                }
                                            })}}
                                        >↑↓</span></span> )
                                }
                                return htmlArr;
                            })()
                        }
                    </div>
                    {/* 레코드 구역 */}
                    {
                        reservationRecord.map( (r,i) => { return (<Record key={i} props={r}/>) } )
                    }
                </div>
                {/* 페이지 공간 */}
                <div className={"tablePage"}>
                    <button type={"button"} onClick={ () => {
                        let page = info.pageAndSort.nowPage;
                        setInfo({
                            ...info,
                            pageAndSort: {
                                ...info.pageAndSort,
                                nowPage: page <= 1 ? page : page - 1
                            }
                        });
                    } }> &lt; </button>
                    {/* 페이지 버튼*/}
                    {
                        pageBtn()
                    }

                    <button type={"button"} onClick={ () => {
                        let page = info.pageAndSort.nowPage;
                        setInfo({
                            ...info,
                            pageAndSort: {
                                ...info.pageAndSort,
                                nowPage: page >= recordPage.totalPage ? page : page + 1
                            }
                        });
                    } }> &gt; </button>
                </div>
            </div>
        </div>
    </>)
}



