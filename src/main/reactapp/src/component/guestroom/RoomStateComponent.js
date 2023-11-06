import {useState} from "react";
import axios from "axios";
import Modal from "react-bootstrap/Modal";


export default function RoomStateComponent( props ){
    const [show, setShow] = useState(false);

    const [state, setState] = useState(props.state)
    const [rno, setRno] = useState(props.rno)

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);


    const updateState = () => {
        let isState = state === 2;
        let alarm = isState ? "사용 불가로 바꾸시겠습니까?" : "사용 가능으로 바꾸시겠습니까?";

        let data = { rno : rno, rstate : isState ? 0 : 1 }

        if(window.confirm(alarm)){
            axios
                .put('/guestRoom', data)
                .then(r => {
                    if(r) { alert("객실 상태를 변경하였습니다.") }
                    setState(isState ? 3 : 2);
                })

        }



    }


    return(<>

        {/* 사용중 : 1 공실 : 2 사용불가 :3 */}
        <td onClick={ state === 1 ? handleShow : updateState }
            className={`roomComponent ${ state === 1 ? "state1" : state === 2 ? "state2" : "state3"}`}>
            { rno }
        </td>

        <Modal
            show={show}
            onHide={handleClose}
            size="lg"
            backdrop={false}
            keyboard={false}
        >
            <Modal.Header closeButton>
                <Modal.Title><div className={"modalTitle"}><h3>504호 객실 정보</h3></div></Modal.Title>
            </Modal.Header>

            <Modal.Body className={"modalBody"}>
                <div className={"modalContent"}>
                    <div className={"stateInfo"}>
                        <h3> 객실 상태 정보 </h3>
                        <div className={"modalText"}> 현재 객실 투숙 인원 : 5명 </div>
                        <div className={"modalText"}> 객실 상태 : 사용 가능 </div>
                    </div>
                    <div className={"memberInfo"}>
                        <h3>객실 이용자 정보</h3>
                        <div className={"modalText"}> 성함 : 김길태 </div>
                        <div className={"modalText"}> 전화번호 : 010-3397-2236 </div>
                        <div className={"modalText"}> 예약 시작 날짜 : 2023-09-22 </div>
                        <div className={"modalText"}> 예약 종료 날짜 : 2023-09-25 </div>
                        <div className={"modalText"}> 체크인 시간 : 2023-09-22 09:32 </div>
                    </div>
                </div>

            </Modal.Body>

            <Modal.Footer>
                <button className={"modalButton"} onClick={handleClose}>
                    닫기
                </button>
            </Modal.Footer>
        </Modal>

    </>)

}