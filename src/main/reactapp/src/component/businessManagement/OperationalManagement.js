import styles from '../css/businessManagement/operationalManagement.css'
import {useState} from "react";

export default function OperationalManagement(){

    // 데이터 호출 후 출력을 위한 상태 관리 함수
    const [isVisible, setIsVisible] = useState(false);
            /* 운영 관리 변경 기능
                0. 회원권 할인율 [ 각 변경 종류 마다 표기 ]
                1. 객실 등급별 평일/주말 요금,최대 인원
                2. 시설 종류별 성인/아동 요금, 운영 시간, 최대 수용 인원
                3. 직책별 월급, 보너스 비율
                */
    return(<>
            <div className={"webContainer"}> {/* 페이지 전체 구역 */}
                <div className={"operationalContent"}>  {/* 컨텐츠 표시 구역 */}
                    {/* 운영 관리 변경 기능
                    0. 회원권 할인율 [ 각 변경 종류 마다 표기 ]
                    1. 객실 등급별 평일/주말 요금,최대 인원
                    2. 시설 종류별 성인/아동 요금, 운영 시간, 최대 수용 인원
                    3. 직책별 월급, 보너스 비율
                    */}

                    <div className={"opTitleArea"}>   {/* 변경 기능 종류 선택 */}
                        <div className={"componentTitle"}>
                            객실 변경
                        </div>
                        <div className={"componentTitle"}>
                            시설 변경
                        </div>
                        <div className={"componentTitle"}>
                            인사 변경
                        </div>
                    </div>  {/* 변경 기능 종류 선택 종료*/}

                    <div className={"opPrintArea"}>{/* 기능 출력 구역*/}


                    </div>{/* 기능 출력 구역 종료*/}



                </div>{/* 컨텐츠 표시 구역 종료*/}

            </div> {/* 페이지 전체 구역 종료 */}
        </>)
}