import React from "react";

export default function LocationComponent(props){
    let nowHour = new Date().getHours();    // 현재의 시간(hour)을 변수에 저장
    let data = props.data;  // 매개변수의 데이터를 저장
    let diningCheck = typeof(data.lname) === "object";  // 통합되어 저장된 다이닝 객체를 식별하여 논리값으로 반환
    let timeCheck = false;  // 각 시설의 운영 시간 종료 여부를 체크하기 위한 논리 변수

    if(diningCheck){    // 객체가 다이닝일 시
        data = data.lname;  // data 변수에 다이닝 객체 저장
        for (let diningData of data) {  // 분리된 다이닝 객체에서 운영시간에 해당하는 인덱스를 data에 저장
            let startTime = parseInt(diningData.lstarttime.slice(0, 2));
            let endTime = parseInt(diningData.lendtime.slice(0, 2));

            if (nowHour >= startTime && nowHour <= endTime) {
                timeCheck = true; data = diningData;
            }
        }
    }
    else{   // 객체가 다이닝이 아닐 시 첫 속성 값으로 운영 시간 체크하여 저장
        timeCheck = nowHour >= parseInt(data.lstarttime.slice(0,2)) && nowHour <= parseInt(data.lendtime.slice(0,2))
    }
    // 혼잡도 예약율 50% 미만 원활, 80% 미만 보통, 80% 이상 혼잡
    let congestion = 0; // 혼잡도를 저장하기 위한 변수 선언
    // 만약 운영시간 이내라면 혼잡도에 예약인원/최대 수용 인원 값을 소숫점 둘째자리까지 내림하여 반환
    if(timeCheck) { congestion = Math.floor(data.lresvList.length / data.lmaxcapa * 100) / 100; }

    return(<>

        <div className={"locationComponent"}>
            <div className={"locationHeader"}>
                { diningCheck === false ? data.lname : "다이닝" }  {/* 시설 제목 속성값 표기, 다이닝이라면 다이닝 표기*/}
            </div>

            { !timeCheck ? // 운영 시간 여부 확인하여 운영 시간이 아니라면 운영시간 종료 구조 출력
            <div className={"locationInfoArea hideInfoArea"}>
                <h3 style={{marginBottom:'20px'}}>운영 시간 종료</h3>
                <h6>운영 시간</h6>
                {
                     diningCheck ? data.map( p => { /* 다이닝 객체라면 운영 시간을 모닝,런치,디너로 나누어 출력 */
                        return(<React.Fragment key={p.lname}>
                           <h6>{p.lname.slice(0,2)} : {p.lstarttime.slice(0,5)} ~ {p.lendtime.slice(0,5)}</h6>
                        </React.Fragment>)
                     }) : <h6>{data.lstarttime.slice(0,5)} ~ {data.lendtime.slice(0,5)}</h6> /* 아니라면 운영 시간 출력*/

                }
            </div>
                :
            <div className={"locationInfoArea"}>
                <div className={"locationInfoComponent"}>
                    <div className={"infoText"}>
                        혼잡도 <div className={"stateBox"+ /* 혼잡도별로 다른 CSS 선택자를 호출하여 색상 변화 */
                        `${congestion < 0.5 ? " stateColor1" : congestion < 0.8 ? " stateColor2" : " stateColor3"}`}></div>
                    </div>
                    <div className={"infoText"}>
                        <span>예약 인원 : </span>
                        <span className={"stateText"}>
                                        { data.lresvList.length } / { data.lmaxcapa }
                                        </span>
                    </div>
                    <div className={"infoText"}>
                        운영상태 <br/>
                        <span className={"stateText"}>
                                        {timeCheck ? "예약제 운영중" : "운영 종료" }
                            {diningCheck === true ? ` [${data.lname.slice(0,2)}]` : "" } {/* 다이닝 객체면 앞 두글자만 출력*/}
                                        </span>
                    </div>
                </div>

                <div className={"locationInfoComponent"}>
                    <div className={"infoText"}>
                        이용료 [ 성인 / 아동 ] <br/> <span className={"stateText"}>
                                        { data.lprice.toLocaleString() }원 / { data.lchildprice.toLocaleString() }원
                                    </span>
                    </div>
                    <div className={"infoText"}>
                        운영 시간<br/> <span className={"stateText"}>{data.lstarttime.slice(0,5)} ~ {data.lendtime.slice(0,5)}</span>
                    </div>
                </div>
            </div>
            }
        </div>

        </>)

}