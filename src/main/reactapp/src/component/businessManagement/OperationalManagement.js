import styles from '../css/businessManagement/operationalManagement.css'
import React, {useEffect, useState} from "react";
import {Table} from "react-bootstrap";
import axios from "axios";
import RoomUpdate from "./RoomUpdate";
import LocationUpdate from "./LocationUpdate";
import PositionUpdate from "./PositionUpdate";



export default function OperationalManagement(){

    // 데이터 호출 후 출력을 위한 상태 관리 함수
    const [dataLoadState, setDataLoadState] = useState(true)
    // 컴포넌트 선택 여부 관리 함수
    const [selectedState, setSelectedState] = useState('')

    // 시설 선택
    const selectLocation = () => { setSelectedState('Location') }
    // 객실 변경 선택
    const selectRoom = () => { setSelectedState('Room') }
    // 인사 변경 선택
    const selectPosition = () => { setSelectedState('Position') }



    return(<>
            <div className={`${dataLoadState ? 'webContaiser' : 'hidden'}`}> {/* 페이지 전체 구역 */}
                <div className={"operationalContent"}>  {/* 컨텐츠 표시 구역 */}
                    {/* 운영 관리 변경 기능
                    0. 회원권 할인율 [ 각 변경 종류 마다 표기 ]
                    1. 객실 등급별 평일/주말 요금,최대 인원
                    2. 시설 종류별 성인/아동 요금, 운영 시간, 최대 수용 인원
                    3. 직책별 월급, 보너스 비율, 직책별 기본 연차 수
                    */}

                    <div className={"opTitleArea"}>   {/* 변경 기능 종류 선택, 재 클릭 방지 삼항연산자 추가 */}
                        <button onClick={selectedState === 'Room' ? null : selectRoom} type={"button"} className={`componentTitleBtn ${selectedState === 'Room' ? "selectedColor" : ""}`}>
                            객실 변경
                        </button>
                        <button onClick={selectedState === 'Location' ? null : selectLocation} type={"button"} className={`componentTitleBtn ${selectedState === 'Location' ? "selectedColor" : ""}`}>
                            시설 변경
                        </button>
                        <button onClick={selectedState === 'Position' ? null : selectPosition} type={"button"} className={`componentTitleBtn ${selectedState === 'Position' ? "selectedColor" : ""}`}>
                            인사 변경
                        </button>
                    </div>  {/* 변경 기능 종류 선택 종료*/}

                    {
                        selectedState === 'Room' ?
                            <RoomUpdate dataLoadState={dataLoadState} setDataLoadState={setDataLoadState} /> :
                        selectedState === 'Location' ?
                            <LocationUpdate dataLoadState={dataLoadState} setDataLoadState={setDataLoadState} /> :
                        selectedState === 'Position' &&
                            <PositionUpdate dataLoadState={dataLoadState} setDataLoadState={setDataLoadState} />
                    }

                </div>{/* 컨텐츠 표시 구역 종료*/}

            </div> {/* 페이지 전체 구역 종료 */}
        </>)
}

