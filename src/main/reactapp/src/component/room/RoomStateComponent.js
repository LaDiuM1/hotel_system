import {useState} from "react";
import axios from "axios";
import Modal from "react-bootstrap/Modal";


export default function RoomStateComponent( props ){
    // 객실 예약 정보 공통 함수에 저장
    const reservInfo = props.reservInfo;
    // 모달창 상태 관리
    const [show, setShow] = useState(false);
    // 개별 객실 상태 관리
    const [state, setState] = useState(props.state)
    // 객실 번호 상태 관리
    const [rno, setRno] = useState(props.rno)

    //모달창 닫는 함수
    const handleClose = () => setShow(false);
    //모당창 여는 함수
    const handleShow = () => setShow(true);


    // 객실 상태를 사용가능 / 사용불가 스위치 해주는 함수
    const updateState = () => {
        // 개별 객실 상태 사용 가능 여부를 논리 값 저장
        let isState = state === 2;
        // 객실 상태에 따른 출력 멘트 구분하여 저장
        let alarm = isState ? "사용 불가로 바꾸시겠습니까?" : "사용 가능으로 바꾸시겠습니까?";
        // 객실 상태 변경용 데이터 객체를 객실 상태에 따라 다르게 저장
        let data = {rno: rno, rstate: isState ? 0 : 1}
        // 확인창 출력, 메시지 내용은 상태에 따라 구분하여 저장된 문자열 변수 사용
        if (window.confirm(alarm)) {
            axios
                .put('http://localhost:80/guestRoom', data)
                .then(r => {
                    if (r) {
                        alert("객실 상태를 변경하였습니다.")
                    }
                    // 객실 상태에 따라 현재 상태를 바꾸어 저장
                    setState(isState ? 3 : 2);
                })

        }
    }
    // 퇴실 처리를 위한 함수
    const checkout = (rrno) => {
        // 확인창 출력
        if (window.confirm("퇴실 처리하시겠습니까?")) {
            axios   // onclick에서 객실 번호를 매개변수로 받아 퇴실 처리용 컨트롤러로 전달
                .get('http://localhost:80/guestRoom/checkout', {params: { 'rrno' : rrno }})
                .then(r => {
                    if (r) {
                        alert("퇴실 처리하였습니다.")
                    }
                    setState(2);
                })
        }

    }





    return(<>

        {/* 사용중 : 1 공실 : 2 사용불가 :3 */}
        <td onClick={ state === 1 ? handleShow : updateState }
            className={`roomComponent ${ state === 1 ? "state1" : state === 2 ? "state2" : "state3"}`}>
            { rno }
        </td>
        {state === 1 &&
        <Modal /* 모달창 상태 변경 구역 */
            show={show}
            onHide={handleClose}
        >

            <Modal.Body className={"modalBody"}>
                <div className={"modalContent"}>
                    <div className={"memberInfo"}>
                        <h3>{rno}호 객실 이용자 정보</h3> {/* 객실 이용자 출력 구역 */}
                        <div className={"modalText"}> 성함 : {reservInfo.mname} </div>
                        <div className={"modalText"}> 전화번호 : {reservInfo.mphone.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3')} </div>
                        <div className={"modalText"}> 예약 시작 날짜 : {reservInfo.rrstartdate} </div>
                        <div className={"modalText"}> 예약 종료 날짜 : {reservInfo.rrenddate} </div>
                        <div className={"modalText"}> 체크인 시간 :  {reservInfo.rrcheckin.replace("T"," ")} </div>
                    </div>
                </div>


            </Modal.Body>
            <Modal.Footer> {/* 버튼 출력 구역 */}
                <button className={"modalButton checkoutBtn"} onClick={() => checkout(reservInfo.rrno)}>
                    퇴실
                </button>
                <button className={"modalButton"} onClick={handleClose}>
                    닫기
                </button>


            </Modal.Footer>

        </Modal>
    }
    </>)

}