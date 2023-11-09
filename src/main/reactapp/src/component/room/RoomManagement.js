import styles from '../css/room/roomManagement.css'
import {useEffect, useState} from "react";
import axios from "axios";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import RoomStateComponent from "./RoomStateComponent";


export default function RoomManagement(){

    let [roomStateData, setRoomStateData] = useState([]);

    useEffect(  () => {
          axios
            .get('http://localhost:80/guestRoom')
            .then(r => {
                console.dir(r.data)
                setRoomStateData(r.data);

            })

    }, [])

    // YYYY-MM-DD hh:mm:ss 형태의 현재 시간 생성
    const now = new Date();
    let year = now.getFullYear();
    const month = ('0' + (now.getMonth() + 1)).slice(-2);
    const day = ('0' + now.getDate()).slice(-2);
    const hours = ('0' + now.getHours()).slice(-2);
    const minutes = ('0' + now.getMinutes()).slice(-2);
    const seconds = ('0' + now.getSeconds()).slice(-2);

    const nowTime = `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;

    return(<>
            <div className={"webConteiner"}> {/* 웹페이지 전체 영역 */}

                <div className={"contentArea"}> {/* 콘텐츠 표기 영역 */}

                    <div className={"contentHeader"}> {/* 콘텐츠 상단 표기 영역 */}
                        <div className={"nowTimePrint"}> {/* 기준 시간 출력 */}
                            기준 시간 : { nowTime }
                        </div>
                        <div className={"guide"}> {/* 색 가이드 출력 */}
                            <div className={"color1"}></div>입실
                            <div className={"color2"}></div>공실
                            <div className={"color3"}></div>사용불가
                        </div>
                    </div>

                    <table className={"roomStateTable"}>{/* 객실 상태 표현 테이블 */}

                        <colgroup>
                            <col style={{ width: '80px' }} />
                        </colgroup>
                        {/* 테이블 1열 공통 사이즈 조절 */}

                        {
                            roomStateData.map( (p, i) => {
                                return(<>
                                    { i === 0 ?  <thead>
                                        <tr>
                                            {/* 테이블 헤더와 테이블 데이터 렌더링 시간 일치화를 위해 Map 내부에서 표현 */}
                                            <th> </th>
                                            <th colSpan={5}>
                                                <div className="contentName">
                                                    Standard
                                                </div>
                                            </th>
                                            <th></th>
                                            <th colSpan={4}>
                                                <div className="contentName">
                                                    Deluxe
                                                </div>
                                            </th>
                                            <th></th>
                                            <th colSpan={3}>
                                                <div className="contentName">
                                                    Suite
                                                </div>
                                            </th>
                                            <th></th>
                                            <th colSpan={2}>
                                                <div className="contentName4">
                                                    Premier
                                                </div>
                                            </th>
                                            <th></th>
                                            <th>
                                                <div className="contentName5">
                                                    Royal
                                                </div>
                                            </th>
                                        </tr>
                                        </thead> : null }

                                    {/* 층마다 15개의 객실로 이루어져 있어 15의 배수마다 층 출력 */}
                                    { i %15 === 0 ? <td key={p.id} className={"floor"}>{Math.floor(p.rno / 100)}F</td> : null }
                                    {/* 개별 객실을 출력하는 컴포넌트에 개별 객실 상태값 전달 후 출력 */}
                                    { <RoomStateComponent  key={p.id} state = {p.rstate} rno = {p.rno} rgname = {p.rgname} reservInfo = {p.roomReservationDtoList[0]} />  }
                                    {/* 객실 등급 구분을 위해 테이블 데이터 사이에 간격을 넣어줌 */}
                                    { i % 15 === 4 || i % 15 === 8 || i % 15 === 11 || i % 15 === 13 ?
                                    <td key={p.id} className={"roomComponentSpacing"}></td> : null }
                                    {/* 15의 배수마다 줄바꿈 [ 층 구분 ] */}
                                    { (i+1) % 15 === 0 ? <tr/> : null }

                                </>)
                            })
                        }
                        <tbody />

                    </table>
                </div>
            </div>


    </>)

}







