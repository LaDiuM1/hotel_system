import Record from "../room/RecordComponent";
import style from '../css/EmployeeManagement/employeeManagement.css'

export default function EmployeeManagement(){
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
                        <input type={"text"} className={"ReservationSearch"} placeholder={"검색"}/>
                        <button type={"button"} className={"searchBtn"} >검색</button>
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
                                    {className:"erank" ,ctitle:"접근권한",cname:"erank"},
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