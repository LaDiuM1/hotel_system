import styles from '../css/employee/employeeRegister.css'
import React, {useState} from "react";
import Modal from "react-bootstrap/Modal";
import LocationComponent from "../location/LocationComponent";
import refrashBtn from "../img/refresh_btn.png";

// 직원 등록 컴포넌트
export default function EmployeeRegister(){
    // 모달창 상태 관리 함수
    const [show, setShow] = useState(false);

    //모달창 닫는 함수
    const handleClose = () => setShow(false);
    //모당창 여는 함수
    const handleShow = () => setShow(true);

    // 3개로 나뉘어져 있는 전화번호 값 관리용 상태 함수
    const [phoneValue, setPhoneValue] = useState([ '', '', '' ] )

    /* input data 관리용 함수 */
    const [ inputData, setInputData] = useState(
        {
            mname: '',
            msex: '남',  /* 초기값 지정 */
            mbirth: '',
            mphone: '',
            eaddress: '',
            ejoin: '',
            ecode: '01' /* 초기값 지정 */
        }
    )

    const registerEmployee = () => {
        // 객체에 공백 문자가 있으면 종료
        for( let p of Object.values(inputData)){
            if(p.length === 0){
                alert('항목을 모두 입력해 주세요');
                return;
            }
        }

        if(phoneValue[0] < 2) { alert('항목을 모두 입력해 주세요'); return; }
        else if (phoneValue[1] < 3) { alert('항목을 모두 입력해 주세요'); return; }
        else if (phoneValue[2] < 3) { alert('항목을 모두 입력해 주세요'); return; }




    }

    // 사용자의 입력 값과 클래스 이름을 받아 input 데이터 객체에 클래스 이름에 해당 하는 속성 값 변경
    const inputValueChange = e =>{
        let className = e.target.className;
        let value = e.target.value;
        console.log(e)

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
            // 그 외에는 일치하는 속성에 입력된 값 저장
            let updateInputData = { ...inputData, [className]: value };
            setInputData(updateInputData);
            console.log(inputData);

        }

    }

    return(<>
        <button onClick={handleShow} type={"button"}>직원 등록</button>
        <Modal /* 모달창 상태 변경 구역 */
            show={show}
            onHide={handleClose}
            backdrop="static"
            keyboard={false}
        >

        <Modal.Body className={"modalArea"}>
                <div className={"registerArea"}> {/* 직원 등록 입력 구역 */}
                    <div className={"memberInfoArea"}> {/* 회원 공통 정보 입력 구역*/}
                        <h5>직원 등록</h5>
                        <div className={"itemBlock"}>
                            <div className={"textArea"}>성명</div> {/* 이름, 성별 구역 */}
                            <div className={"nameInputArea"}>
                                <div><input onChange={inputValueChange} className={"mname"} maxlength={20} type={"text"}></input></div>
                                <div className={"textArea"} style={{marginLeft:"15px", width:"30%"}}>성별</div>
                                <div className={"radioArea"}>
                                    남<input onChange={inputValueChange} className={"msex"} type={"radio"} name={"msex"} value={"남"} defaultChecked={"defaultChecked"}></input>
                                    여<input onChange={inputValueChange} className={"msex"} type={"radio"} name={"msex"} value={"여"}></input>
                                </div>
                            </div>
                        </div>
                        <div className={"itemBlock"}>
                            <div className={"textArea"}>생년월일</div>
                            <div className={"inputArea"}>
                                <input onChange={inputValueChange} className={"mbirth"} type={"date"}></input>
                            </div>
                        </div>
                        <div className={"itemBlock"}>
                            <div className={"textArea"}>전화번호</div>
                            <div className={"inputArea phoneNoArea"}>
                                {/* 최대 자릿수 제한 */}
                                <input
                                    onInput={(e) => {
                                        if (e.target.value.length > e.target.maxLength)
                                            e.target.value = e.target.value.slice(0, e.target.maxLength);
                                    }}
                                    maxlength={3}
                                    onChange={inputValueChange} className={"mphone part1"} type={"number"}></input>
                                <h4>-</h4>
                                <input
                                    onInput={(e) => {
                                        if (e.target.value.length > e.target.maxLength)
                                            e.target.value = e.target.value.slice(0, e.target.maxLength);
                                    }}
                                    maxlength={4}
                                    onChange={inputValueChange} className={"mphone part2"} type={"number"}></input>
                                <h4>-</h4>
                                <input
                                    onInput={(e) => {
                                        if (e.target.value.length > e.target.maxLength)
                                            e.target.value = e.target.value.slice(0, e.target.maxLength);
                                    }}
                                    maxlength={4}
                                    onChange={inputValueChange} className={"mphone part3"} type={"number"}></input>
                            </div>
                        </div>
                        <div className={"itemBlock"}>
                            <div className={"textArea"}>주소</div>
                            <div className={"inputArea"}><input onChange={inputValueChange} className={"eaddress"} maxlength={50} type={"text"}></input></div>
                        </div>
                        <div className={"itemBlock"}>
                            <div className={"textArea"}>입사일</div>
                            <div className={"inputArea"}>
                                <input onChange={inputValueChange} className={"ejoin"} type={"date"}></input>
                            </div>
                        </div>
                        <div className={"itemBlock"}>
                            <div className={"textArea"}>부서</div>
                            <div className={"inputArea"}>
                                <select onChange={inputValueChange} className={"department"} defaultValue='01'>
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
        </Modal.Body>
            <Modal.Footer>
                <div className={"buttonArea"}>
                    <button onClick={registerEmployee} className={"regiSubmitBtn"} type={"button"}>등록</button>
                    <button onClick={handleClose} type={"button"}>취소</button>
                </div>
            </Modal.Footer>
        </Modal>
            </>)
}