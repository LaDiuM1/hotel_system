
import '../css/guestroom/RoomReservation.css'
import {useState} from 'react'



export default function RoomReservation(){

    /*let info = {
        rgname:document.querySelector('.ReservationGrade').value
    }*/

    function changeGrade(){
        console.log(document.querySelector('.ReservationGrade').value)
    }

    /* 객실 예약 컴포넌트 */
    return(<>
        <div className={"reservationContainer"}>
            <div className={"reservationWrap"}>
                <div className={"searchBox"}>
                    <select value={"Nonselect"} onChange={changeGrade} className={"ReservationGrade"}>
                        <option value={"Nonselect"}>전체</option>
                        <option value={"Standard"}>Standard</option>
                        <option value={"Deluxe"}>Deluxe</option>
                        <option value={"Premier"}>Premier</option>
                        <option value={"Royal"}>Royal</option>
                        <option value={"Suite"}>Suite</option>
                    </select>
                    <input type={"date"} className={"ReservationDate"}/>
                    <input type={"text"} className={"ReservationSearch"} placeholder={"검색"}/>
                    <button type={"button"} className={"searchBtn"}>검색</button>
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
                    </div>
                    {/* 레코드 구역 */}
                    <div className={"tableRecord"}>
                        <span className={"guestRoomNum"}>101</span>
                        <span className={"guestRoomGrade"}>스탠다드</span>
                        <span className={"guestRoomStart"}>2023-10-12</span>
                        <span className={"guestRoomEnd"}>2023-10-14</span>
                        <span className={"guestRoomName"}>홍길동</span>
                        <span className={"guestRoomPhone"}>01022113333</span>
                    </div>
                    <div className={"tableRecord"}>
                        <span className={"guestRoomNum"}>101</span>
                        <span className={"guestRoomGrade"}>스탠다드</span>
                        <span className={"guestRoomStart"}>2023-10-12</span>
                        <span className={"guestRoomEnd"}>2023-10-14</span>
                        <span className={"guestRoomName"}>홍길동</span>
                        <span className={"guestRoomPhone"}>01022113333</span>
                    </div>
                    <div className={"tableRecord"}>
                        <span className={"guestRoomNum"}>101</span>
                        <span className={"guestRoomGrade"}>스탠다드</span>
                        <span className={"guestRoomStart"}>2023-10-12</span>
                        <span className={"guestRoomEnd"}>2023-10-14</span>
                        <span className={"guestRoomName"}>홍길동</span>
                        <span className={"guestRoomPhone"}>01022113333</span>
                    </div>
                    <div className={"tableRecord"}>
                        <span className={"guestRoomNum"}>101</span>
                        <span className={"guestRoomGrade"}>스탠다드</span>
                        <span className={"guestRoomStart"}>2023-10-12</span>
                        <span className={"guestRoomEnd"}>2023-10-14</span>
                        <span className={"guestRoomName"}>홍길동</span>
                        <span className={"guestRoomPhone"}>01022113333</span>
                    </div><div className={"tableRecord"}>
                    <span className={"guestRoomNum"}>101</span>
                    <span className={"guestRoomGrade"}>스탠다드</span>
                    <span className={"guestRoomStart"}>2023-10-12</span>
                    <span className={"guestRoomEnd"}>2023-10-14</span>
                    <span className={"guestRoomName"}>홍길동</span>
                    <span className={"guestRoomPhone"}>01022113333</span>
                </div><div className={"tableRecord"}>
                    <span className={"guestRoomNum"}>101</span>
                    <span className={"guestRoomGrade"}>스탠다드</span>
                    <span className={"guestRoomStart"}>2023-10-12</span>
                    <span className={"guestRoomEnd"}>2023-10-14</span>
                    <span className={"guestRoomName"}>홍길동</span>
                    <span className={"guestRoomPhone"}>01022113333</span>
                </div><div className={"tableRecord"}>
                    <span className={"guestRoomNum"}>101</span>
                    <span className={"guestRoomGrade"}>스탠다드</span>
                    <span className={"guestRoomStart"}>2023-10-12</span>
                    <span className={"guestRoomEnd"}>2023-10-14</span>
                    <span className={"guestRoomName"}>홍길동</span>
                    <span className={"guestRoomPhone"}>01022113333</span>
                </div>
                    <div className={"tableRecord"}>
                        <span className={"guestRoomNum"}>101</span>
                        <span className={"guestRoomGrade"}>스탠다드</span>
                        <span className={"guestRoomStart"}>2023-10-12</span>
                        <span className={"guestRoomEnd"}>2023-10-14</span>
                        <span className={"guestRoomName"}>홍길동</span>
                        <span className={"guestRoomPhone"}>01022113333</span>
                    </div>
                    <div className={"tableRecord"}>
                        <span className={"guestRoomNum"}>101</span>
                        <span className={"guestRoomGrade"}>스탠다드</span>
                        <span className={"guestRoomStart"}>2023-10-12</span>
                        <span className={"guestRoomEnd"}>2023-10-14</span>
                        <span className={"guestRoomName"}>홍길동</span>
                        <span className={"guestRoomPhone"}>01022113333</span>
                    </div>
                    <div className={"tableRecord"}>
                        <span className={"guestRoomNum"}>101</span>
                        <span className={"guestRoomGrade"}>스탠다드</span>
                        <span className={"guestRoomStart"}>2023-10-12</span>
                        <span className={"guestRoomEnd"}>2023-10-14</span>
                        <span className={"guestRoomName"}>홍길동</span>
                        <span className={"guestRoomPhone"}>01022113333</span>
                    </div>
                </div>
                {/* 페이지 공간 */}
                <div className={"tablePage"}>
                    <button type={"button"}> &lt; </button>
                    <button type={"button"}> 1 </button>
                    <button type={"button"}> 2 </button>
                    <button type={"button"}> &gt; </button>
                </div>
            </div>
        </div>
    </>)
}


