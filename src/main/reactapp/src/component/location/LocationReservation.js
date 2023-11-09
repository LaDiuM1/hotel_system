
import '../css/location/LocationReservation.css'
import {useEffect, useState} from "react";
import axios from "axios";

export default function LocationReservation(){

    let[ info, setInfo ] = useState({
        lname: "Nonselect",
        lrstate: 3,
        startDate: new Date().toISOString().slice(0, 10),
        endDate: "",
        keyword: "",
        // 페이지 관련
        limitPage: 10,
        nowPage: 1,
        // 정렬 관련
        cname: "",
        isSorted: false
    });
    // 검색 시 결과 리스트 저장
    let[ reservationRecord, setReservationRecord ] = useState( [] )
    // 검색 시 페이징 처리를 위한 데이터 저장
    let[ recordPage , setRecordPage ] = useState(null)
    /* 최초 검색 실행 */
    useEffect(() => {onSearch();}, [info]);
    const onSearch = () => {
        axios.get("http://localhost:80/locationReservation",{params:info})
            .then(response=>{
                console.log(response)

            })
    }
    console.log(info)

    return(<>
            <div className={"reservationContainer"}>
                <div className={"reservationWrap"}>
                    <div className={"searchWrap"}>
                        <div className={"searchBox"}>
                            <select className={"ReservationGrade"} onChange={(e)=>{setInfo( {...info, lname:e.target.value});} }>
                                <option value={"Nonselect"}>전체</option>
                                <option value={"실내수영장"}>실내수영장</option>
                                <option value={"피트니스"}>피트니스</option>
                                <option value={"실내골프장"}>실내골프장</option>
                                <option value={"wholeDining"}>다이닝</option>
                            </select>
                            <select onChange={(e)=>{setInfo( {...info, lrstate:e.target.value})}}>
                                <option value={3} >전체</option>
                                <option value={0}>예약 중</option>
                                <option value={1}>예약 만료</option>
                                <option value={2}>예약 취소</option>
                            </select>
                            <input type={"date"} className={"ReservationDate"} onChange={ (e)=>{setInfo({...info, startDate:e.target.value})} } value={info.startDate}/>
                            <input type={"date"} className={"ReservationDate"} onChange={ (e)=>{setInfo({...info, endDate:e.target.value})} }/>
                            <input type={"text"} className={"ReservationSearch"} onChange={ (e)=>{setInfo({...info, keyword:e.target.value})} } placeholder={"예약자명 및 전화번호 입력"}/>
                            <button type={"button"} className={"searchBtn"}>검색</button>
                        </div>
                        <div className={"totalRecordWrap"}>
                            총 검색 게시물 수 : <span>{}</span>
                        </div>
                        {/* 출력할 레코드 수 select*/}
                        <select onChange={(e)=>{setInfo({...info,limitPage: e.target.value})}}>
                            <option value={10}>10</option>
                            <option value={15}>15</option>
                            <option value={20}>20</option>
                        </select>
                    </div>
                    <div className={"diningWrap"}>
                        {
                            // 현재 select value가 다이닝에 관련되지 않았다면 빈 값 return
                            // 관련 되었다면 다이닝 예약과 관련된 select box 랜더링
                            (()=> {

                                if (!(info.lname === "wholeDining" || info.lname === "모닝_다이닝" || info.lname === "런치_다이닝" || info.lname === "디너_다이닝")) return(<></>)
                                else return(<>
                                    <select key={0} onChange={(e)=>{setInfo( {...info, lname:e.target.value})}}>
                                        <option value={"wholeDining"}>전체</option>
                                        <option value={"모닝_다이닝"}>모닝다이닝</option>
                                        <option value={"런치_다이닝"}>런치다이닝</option>
                                        <option value={"디너_다이닝"}>디너다이닝</option>
                                    </select>
                                </>)
                            })()
                        }
                    </div>
                    <div className={"tableWrap"}>
                        {/* 테이블 컬럼 명 */}
                        <div className={"tableColumn"}>
                            {
                                (()=>{
                                    let tableColumn = [
                                        {className:"lname" ,ctitle:"시설이름",cname:"lrname"},
                                        {className:"lrstate" ,ctitle:"시설예약상태",cname:"lrstate"},
                                        {className:"lrmname" ,ctitle:"예약자명",cname:"lrmname"},
                                        {className:"lrmphone" ,ctitle:"전화번호",cname:"lrmphone"},
                                        {className:"lrtime" ,ctitle:"시설예약시간",cname:"lrtime"},
                                    ]
                                    let htmlArr = [];

                                    for(let i = 0; i < tableColumn.length; i++){
                                        htmlArr.push( <span key={i} className={tableColumn[i].className}>{tableColumn[i].ctitle}<span className={"sortPointer"} onClick={()=>{
                                            setInfo({...info, cname:tableColumn[i].cname, isSorted: !info.isSorted } )}}
                                        >↑↓</span></span> )
                                    }
                                    return htmlArr;
                                })()
                            }
                        </div>
                        {/* 레코드 구역 */}
                        <div className={"tableRecord"}>
                            <span className={"lname"}>실내수영장</span>
                            <span className={"lrstate"}>예약 중</span>
                            <span className={"lrmname"}>홍길동</span>
                            <span className={"lrmphone"}>01011112222</span>
                            <span className={"lrtime"}>2023-11-23 11:00:00</span>
                        </div>
                    </div>

                    {/* 페이지 공간 */}
                    <div className={"tablePage"}>
                        <button type={"button"}>&lt;</button>
                        <button type={"button"}>&gt;</button>
                    </div>
                </div>
            </div>
        </>)
}