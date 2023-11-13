import Record from "../room/RecordComponent";
import style from '../css/EmployeeManagement/employeeManagement.css'
import axios from "axios";

export default function EmployeeManagement(){

    const onSearch = ()=>{
        axios
            .post("http://localhost:80/locationReservation")
            .then( response => {console.log(response)})
    }


    return(<>
        <div className={"reservationContainer"}>
            <div className={"reservationWrap"}>
                <div className={"searchWrap"}>
                    <div className={"search_Box"}>
                        <select className={""}>
                            <option>부서</option>
                            <option>서비스</option>
                            <option>시설관리</option>
                            <option>호텔조리</option>
                            <option>마케팅</option>
                            <option>총무</option>
                            <option>인사</option>
                            <option>운영</option>
                        </select>
                        <select>
                            <option>직책</option>
                            <option>사원</option>
                            <option>주임</option>
                            <option>대리</option>
                            <option>과장</option>
                            <option>차장</option>
                            <option>부장</option>
                            <option>이사</option>
                            <option>사장</option>
                        </select>
                        <input type={"text"} placeholder={"검색"}/>
                        <select>
                            <option>전체</option>
                            <option>사원번호</option>
                            <option>사원명</option>
                            <option>전화번호</option>
                        </select>
                    </div>
                    <div className={"totalRecordWrap"}>
                        총 검색 게시물 수 : <span>{}</span>
                    </div>
                    {/* 출력할 레코드 수 select*/}
                    <select>
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
                                    {className:"eno" ,ctitle:"사원번호",cname:"eno"},
                                    {className:"mname" ,ctitle:"사원명",cname:"mname"},
                                    {className:"msex" ,ctitle:"성별",cname:"msex"},
                                    {className:"mbirth" ,ctitle:"생년월일",cname:"mbirth"},
                                    {className:"rphone" ,ctitle:"전화번호",cname:"rphone"},
                                    {className:"eaddress" ,ctitle:"주소",cname:"eaddress"},
                                    {className:"pname" ,ctitle:"직책",cname:"pname"},
                                    {className:"dcode" ,ctitle:"부서",cname:"dcode"},
                                    {className:"mregiste" ,ctitle:"등록날짜",cname:"mregiste"}
                                ]
                                let htmlArr = [];
                                //
                                for(let i = 0; i < tableColumn.length; i++){
                                    htmlArr.push( <span key={i} className={tableColumn[i].className}>{tableColumn[i].ctitle}<span className={"sortPointer"}
                                    >↑↓</span></span> )
                                }
                                return htmlArr;
                            })()
                        }
                    </div>
                    {/* 레코드 구역 */}

                </div>
                {/* 페이지 공간 */}
                <div className={"tablePage"}>
                    <button type={"button"}> &lt; </button>
                    {/* 페이지 버튼*/}

                    <button type={"button"}> &gt; </button>
                </div>
            </div>
        </div>
    </>)
}