import React from 'react';
import styles from '../css/room/roomManagement.css'
import {useEffect, useState} from "react";
import axios from "axios";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import RoomStateComponent from "./RoomStateComponent";
import refrashBtn from "../img/refresh_btn.png";


export default function RoomManagement(){
    const [roomStateData, setRoomStateData] = useState([]); // 객실 데이터 상태 관리 함수
    const [isVisible, setIsVisible] = useState(false);  // 데이터 호출 후 동시 출력을 위한 상태 관리 함수
    const [nowTime, setNowTime] = useState('')
    const [timer, setTimer] = useState(10);
    
    const fetchData = () =>{
        axios
            .get('http://localhost:80/guestRoom')
            .then(r => {

                let floor = 15; // 각층 마다 호실 수 설정

                /* 객체 배열의 요소(호실)을 층으로 구분하기 위해 각층의 호실 개수만큼 인덱스를 슬라이스 후 배열에 push*/
                const slicedData = [];
                for (let i = 0; i < r.data.length; i += floor) {
                    const slice = r.data.slice(i, i + floor);
                    slicedData.push(slice);
                }

                console.dir(slicedData)
                setRoomStateData(slicedData);
                setTimer(10);

                // 데이터 호출 이후 div 속성을 none에서 block으로 변경하여 일시에 출력
                setIsVisible(true);
                // YYYY-MM-DD hh:mm:ss 형태의 현재 시간 생성
                const now = new Date();
                let year = now.getFullYear();
                const month = ('0' + (now.getMonth() + 1)).slice(-2);
                const day = ('0' + now.getDate()).slice(-2);
                const hours = ('0' + now.getHours()).slice(-2);
                const minutes = ('0' + now.getMinutes()).slice(-2);
                const seconds = ('0' + now.getSeconds()).slice(-2);

                setNowTime(`${year}-${month}-${day} ${hours}:${minutes}:${seconds}`);

            })

    }
    
    // 최초 실행 시 호출되는 useEffect
    useEffect( () => {

        // 최초 랜더링 시 데이터 호출
        fetchData();
        // 이후 10초 간격으로 반복 랜더링
        const interval = setInterval(() => {
            setTimer((prevTimer) => {
                if (prevTimer === 1) {
                    fetchData();
                    return 10;
                } else {
                    return prevTimer - 1;
                }
            });
        }, 1000);

        // 컴포넌트 해제 시 때 타이머 해제
        return () => clearInterval(interval);

    }, [])

    useEffect(  () => {
          

    }, [])


    return(<>
            <div className={`${isVisible ? 'webContainer' : 'hidden'}`}> {/* 웹페이지 전체 영역 */}

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
                            {/* 테이블 1열 공통 사이즈 조절 */}
                            <col style={{ width: '80px' }} />
                        </colgroup>

                        <thead>
                        <tr>
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
                        </thead>
                        <tbody>
                        {

                            roomStateData.map( (floor, i) => { // 층으로 구분된 객체 배열 순회
                                return(<React.Fragment key={"floor : "+i+4}>
                                    <tr>
                                    {

                                        floor.map((p, i) => { // 각 층마다 개별 객실 출력
                                            return (<React.Fragment key={p.rno}>

                                                {/* 각 층마다 최초 인덱스에 층수 출력*/}
                                                {i === 0 &&
                                                    <td className={"floor"}>{Math.floor(p.rno / 100)}F</td>}
                                                {/* 개별 객실을 출력하는 컴포넌트에 개별 객실 상태값 전달 후 출력*/}
                                                {<RoomStateComponent state={p.rstate} rno={p.rno}
                                                                     rgname={p.rgname}
                                                                     reservInfo={p.roomReservationDtoList[0]}/>}
                                                 {/*객실 등급 구분을 위해 테이블 데이터 사이에 간격을 넣어줌*/}
                                                {(i === 4 || i === 8 || i === 11 || i === 13) &&
                                                    <td className={"roomComponentSpacing"}></td>}
                                           </React.Fragment>)
                                        })

                                    }
                                    </tr>
                                </React.Fragment>)
                            })
                        }
                        </tbody>
                    </table>
                    <div className={"refrashArea"} style={{marginTop:'20px'}}>
                        {/* 숫자 10의 자리 1의 자리 가운데 정렬을 위한 삼항 연산자 */}
                        <div onClick={fetchData} className={"refrashBtn"}>
                            <div className={`${timer === 10 ? "timer1" : "timer"}`}>{timer}</div>
                            <img src={refrashBtn} alt={"null"} width={"50px"} height={"50px"}/>
                        </div>
                    </div>
                </div>
            </div>


    </>)

}







