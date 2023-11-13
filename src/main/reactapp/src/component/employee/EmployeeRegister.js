import styles from '../css/employee/employeeRegister.css'
import React, {useState} from "react";
import LocationComponent from "../location/LocationComponent";
import refrashBtn from "../img/refresh_btn.png";

// 직원 등록 컴포넌트
export default function EmployeeRegister(){
    // 3개로 나뉘어져 있는 전화번호 관리용 상태 함수
    const [phoneValue, setPhoneValue] = useState([ '', '', '' ] )
    /* input data 관리용 함수 */
    const [ inputData, setInputData] = useState(
        {
            mname: '',
            msex: '',
            mbirth: '',
            mphone: '',
            eaddress: '',
            ejoin: '',
            ecode: ''
        }
    )

    // 사용자의 입력 값과 클래스 이름을 받아 input 데이터 객체에 클래스 이름에 해당 하는 속성 값 변경
    const inputValueChange = e =>{
        let className = e.target.className;
        let value = e.target.value;

        // 입력 값이 전화번호일 경우
        if (className.includes('mphone')) {
            // 3개로 분할되어 있는 input box 값을 각 배열 순서에 맞춰서 저장
            if (className.includes('part1')) {
                phoneValue[0] = value;
            } else if (className.includes('part2')) {
                phoneValue[1] = value;
            } else if (className.includes('part3')) {
                phoneValue[2] = value;
            }
            let updateInputData= { ...inputData};
            // 전송 데이터 객체 전화번호 속성에 배열 값을 합하여 저장
            updateInputData.mphone = phoneValue[0]+phoneValue[1]+phoneValue[2]
            setInputData(updateInputData);

            console.log(inputData);
        }else{

            let updateInputData = { ...inputData, [className]: value };
            setInputData(updateInputData);
            console.log(inputData);

        }

    }




    return(<>
        <div className={"webConteiner"}>
            <div className={"registerContent"}> {/* 직원 등록 전체 구역*/}
                <div className={"registerArea"}> {/* 직원 등록 입력 구역 */}
                    <div className={"memberInfoArea"}> {/* 회원 공통 정보 입력 구역*/}
                        <h5>인적 정보</h5>
                        <div className={"itemBlock"}>
                            <div className={"textArea"}>성명</div> {/* 이름, 성별 구역 */}
                            <div className={"nameInputArea"}>
                                <div><input onKeyUp={inputValueChange} className={"mname"} type={"text"}></input></div>
                                <div className={"textArea"} style={{marginLeft:"15px", width:"30%"}}>성별</div>
                                <div className={"radioArea"}>
                                    남<input className={"radioBox"} type={"radio"} name={"msex"} value={"남"} defaultChecked={"defaultChecked"}></input>
                                    여<input className={"radioBox"} type={"radio"} name={"msex"} value={"여"}></input>
                                </div>
                            </div>
                        </div>
                        <div className={"itemBlock"}>
                            <div className={"textArea"}>생년월일</div>
                            <div className={"inputArea"}>
                                <input className={"mbirth"} type={"date"}></input>
                            </div>
                        </div>
                        <div className={"itemBlock"}>
                            <div className={"textArea"}>전화번호</div>
                            <div className={"inputArea phoneNoArea"}>
                                <input onKeyUp={inputValueChange} className={"mphone part1"} type={"number"}></input>
                                <h4>-</h4>
                                <input onKeyUp={inputValueChange} className={"mphone part2"} type={"number"}></input>
                                <h4>-</h4>
                                <input onKeyUp={inputValueChange} className={"mphone part3"} type={"number"}></input>
                            </div>
                        </div>
                        <div className={"itemBlock"}>
                            <div className={"textArea"}>주소</div>
                            <div className={"inputArea"}><input onKeyDown={inputValueChange} className={"eaddress"} type={"text"}></input></div>
                        </div>

                    </div>
                    <div className={"employeeArea"}> {/* 직원 정보 입력 구역*/}
                        <h5>입사 정보</h5>
                        <div className={"itemBlock"}>
                            <div className={"textArea"}>입사년월일</div>
                            <div className={"inputArea"}>
                                <input className={"ejoin"} type={"date"}></input>
                            </div>
                        </div>
                        <div className={"itemBlock"}>
                            <div className={"textArea"}>부서</div>
                            <div className={"inputArea"}>
                                <select className={"department"} defaultValue='01'>
                                    <option value={'01'}>서비스</option>
                                    <option value={'02'}>시설관리</option>
                                    <option value={'03'}>호텔조리</option>
                                    <option value={'04'}>마케팅</option>
                                    <option value={'05'}>총무</option>
                                    <option value={'06'}>인사</option>
                                    <option value={'07'}>총괄</option>
                                </select>
                            </div>
                        </div>

                    </div>

                </div>
                <div className={"buttonArea"}>
                    <button className={"regiSubmitBtn"} type={"button"}>등록</button>
                    <button className={"regiCencleBtn"} type={"button"}>취소</button>
                </div>

            </div>
        </div>






        </>)
}