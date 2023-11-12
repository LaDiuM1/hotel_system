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
                        <input type={"text"} placeholder={"사원번호"}/>
                        <input type={"text"} placeholder={"사원명"}/>
                        <input type={"text"} placeholder={"성별"}/>
                        <input type={"text"} placeholder={"생년월일"}/>
                        <input type={"text"} placeholder={"전화번호"}/>
                        <input type={"text"} placeholder={"주소"}/>
                        <input type={"text"} placeholder={"권한"}/>
                        <select>
                            <option></option>
                            <option></option>
                            <option></option>
                            <option></option>
                        </select>
                        <select>
                            <option></option>
                            <option></option>
                            <option></option>
                            <option></option>
                        </select>
                        <select>
                            <option></option>
                            <option></option>
                            <option></option>
                            <option></option>
                        </select>
                        <input type={"text"} placeholder={"직책"}/>
                        <input type={"text"} placeholder={"부서"}/>

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