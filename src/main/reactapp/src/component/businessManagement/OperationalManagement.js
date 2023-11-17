import styles from '../css/businessManagement/operationalManagement.css'
import React, {useEffect, useState} from "react";
import {Table} from "react-bootstrap";
import axios from "axios";


export default function OperationalManagement(){

    // 데이터 호출 후 출력을 위한 상태 관리 함수
    const [isVisible, setIsVisible] = useState(false);

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
                        <button type={"button"} className={"componentTitleBtn"}>
                            객실 변경
                        </button>
                        <button type={"button"} className={"componentTitleBtn"}>
                            시설 변경
                        </button>
                        <button type={"button"} className={"componentTitleBtn"}>
                            인사 변경
                        </button>
                    </div>  {/* 변경 기능 종류 선택 종료*/}

                    <RoomUpdate />



                </div>{/* 컨텐츠 표시 구역 종료*/}

            </div> {/* 페이지 전체 구역 종료 */}
        </>)
}

function RoomUpdate(){
    // 객실 등급별 평일/주말 요금,최대 인원, 회원권 할인율 변경
    const [roomOpData, setRoomOpData] = useState(
        [
            {
            'rgname' : '',
            'rwprice' : 0,
            'rhprice' : 0,
            'rgmaxcapa' : 0,
            'drate' : 0.0,
        }
        ]
    );

    // 컴포넌트 생성 시 객실 등급 데이터 호출
    useEffect(() => {
        axios
            .get('http://localhost:80/operationalManagement/getRoomOpData')
            .then( r => {
                let data = r.data;

                // 객실 요금이 낮은 순으로 정렬
                data.sort(function (a, b) {
                    if (a.rwprice > b.rwprice) {
                        return 1;
                    }
                    if (a.rwprice < b.rwprice) {
                        return -1;
                    }
                    return 0;
                })

                setRoomOpData(r.data);
                console.log(r.data)
            })
    }, []);



    const roomOpDataChange = (e, i) => {
        let className = e.target.className;
        let value = e.target.value;
        console.log(roomOpData)
        // 그 외에는 일치하는 속성에 입력된 값 저장
        let updateRoomOpData= {...roomOpData[i], [className]: value};
        let data = [...roomOpData];

        data[i] = updateRoomOpData;
        console.log(data)

        setRoomOpData(data);

    }




    return(<>
        <div className={"opPrintArea"}>
            <Table className={"opTable"}> {/* 기능 출력 구역 */}
                <thead>
                    <tr>
                        <th>등급</th><th>평일 요금</th><th>주말 요금</th><th>최대 인원</th><th>회원권 할인율</th>
                    </tr>
                </thead>
                <tbody>
                {
                    roomOpData.map( (p, i) => {
                    return(<React.Fragment key={p.rgname}>
                        <tr>
                            <td>{p.rgname}</td>
                            <td><input className={"rhprice"} onChange={(e) => roomOpDataChange(e, i)} type={"text"} value={p.rhprice.toLocaleString()}/></td>
                            <td><input className={"rwprice"} onChange={(e) => roomOpDataChange(e, i)} type={"text"} value={p.rwprice.toLocaleString()}/></td>
                            <td><input className={"rgmaxcapa"} onChange={(e) => roomOpDataChange(e, i)} type={"text"} value={p.rgmaxcapa+'명'}/></td>
                            <td><input className={"drate"} onChange={(e) => roomOpDataChange(e, i)} type={"text"} value={(p.drate*100)+'%'}/></td>
                        </tr>
                    </React.Fragment>)
                    })
                }
                </tbody>
            </Table>
            <div>
                <button type={"button"}>변경 확인</button>
                <button type={"button"}>취소</button>
            </div>

        </div> {/*기능 출력 구역 종료*/}


        </>)
}