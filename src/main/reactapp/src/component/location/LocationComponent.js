
export default function LocationComponent(props){
    let now = new Date();

    let i = props.i;
    let data = props.data[i];
    let diningCheck = data.lname.indexOf('다이닝') !== -1;
    let timeCheck = now.getHours() >= parseInt(data.lstarttime.slice(0,2)) && now.getHours() <= parseInt(data.lendtime.slice(0,2))

    /*
    console.log('data.lstarttime : '+data.lstarttime);
    console.log('data.lendtime : '+data.lendtime);
    console.log('now.getTime() : '+now.getHours());
    console.log('timecheck: '+ timeCheck);
    */

    let result =  data.length !== 0;
    return(<>
        { i < 4 ?
                    <div className={"locationComponent"}>
                        <div className={"locationHeader"}>
                            실내 수영장
                        </div>
                        <div className={"locationInfoArea"}>
                            <div className={"locationInfoComponent"}>
                                <div className={"infoText"}>
                                    혼잡도 <div className={"stateBox stateColor1"}></div>
                                </div>
                                <div className={"infoText"}>
                                    예약 인원 : <span className={"stateText"}> { data.lresvList.length }  </span>
                                </div>
                                <div className={"infoText"}>
                                    운영상태 <br/>  <span className={"stateText"}>예약제 운영중</span>
                                </div>
                            </div>

                            <div className={"locationInfoComponent"}>
                                <div className={"infoText"}>
                                    최대 수용 인원 : <span className={"stateText"}>50</span>
                                </div>
                                <div className={"infoText"}>
                                    이용료 [ 성인 / 아동 ] <br/> <span className={"stateText"}> 35,000원 / 20,000원 </span>
                                </div>
                                <div className={"infoText"}>
                                    운영 시간<br/> <span className={"stateText"}>09:00 ~ 20:00</span>
                                </div>
                            </div>
                        </div>

                    </div> : null }
                   {/* <div className={"locationComponent"}>
                        <div className={"locationHeader"}>
                            다이닝
                        </div>
                        <div className={"locationInfoArea"}>
                            <div className={"locationInfoComponent"}>
                                <div className={"infoText"}>
                                    혼잡도 <div className={"stateBox stateColor3"}></div>
                                </div>
                                <div className={"infoText"}>
                                    예약 인원 : <span className={"stateText"}> 42 </span>
                                </div>
                                <div className={"infoText"}>
                                    운영상태 <br/>  <span className={"stateText"}>디너 예약제 운영중</span>
                                </div>
                            </div>

                            <div className={"locationInfoComponent"}>
                                <div className={"infoText"}>
                                    최대 수용 인원 : <span className={"stateText"}>50</span>
                                </div>
                                <div className={"infoText"}>
                                    이용료 [ 성인 / 아동 ] <br/> <span className={"stateText"}> 120,000원 / 60,000원 </span>
                                </div>
                                <div className={"infoText"}>
                                    운영 시간<br/> <span className={"stateText"}>17:00 ~ 21:00</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className={"locationComponent"}>
                        <div className={"locationHeader"}>
                            피트니스
                        </div>
                        <div className={"locationInfoArea"}>
                            <div className={"locationInfoComponent"}>
                                <div className={"infoText"}>
                                    혼잡도 <div className={"stateBox stateColor2"}></div>
                                </div>
                                <div className={"infoText"}>
                                    예약 인원 : <span className={"stateText"}> 35 </span>
                                </div>
                                <div className={"infoText"}>
                                    운영상태 <br/>  <span className={"stateText"}>예약제 운영중</span>
                                </div>
                            </div>

                            <div className={"locationInfoComponent"}>
                                <div className={"infoText"}>
                                    최대 수용 인원 : <span className={"stateText"}>50</span>
                                </div>
                                <div className={"infoText"}>
                                    이용료 : <span className={"stateText"}> 50,000원 </span>
                                </div>
                                <div className={"infoText"}>
                                    운영 시간<br/> <span className={"stateText"}>09:00 ~ 21:00</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className={"locationComponent"}>
                        <div className={"locationHeader"}>
                            실내골프장
                        </div>
                        <div className={"locationInfoArea"}>
                            <div className={"locationInfoComponent"}>
                                <div className={"infoText"}>
                                    혼잡도 <div className={"stateBox stateColor2"}></div>
                                </div>
                                <div className={"infoText"}>
                                    예약 인원 : <span className={"stateText"}> 33 </span>
                                </div>
                                <div className={"infoText"}>
                                    운영상태 <br/>  <span className={"stateText"}>예약제 운영중</span>
                                </div>
                            </div>

                            <div className={"locationInfoComponent"}>
                                <div className={"infoText"}>
                                    최대 수용 인원 : <span className={"stateText"}>50</span>
                                </div>
                                <div className={"infoText"}>
                                    이용료 : <span className={"stateText"}> 50,000원 </span>
                                </div>
                                <div className={"infoText"}>
                                    운영 시간<br/> <span className={"stateText"}>09:00 ~ 21:00</span>
                                </div>
                            </div>
                        </div>
                    </div>*/}

        </>)

}