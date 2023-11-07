import {useState} from "react";
import axios from "axios";
import Modal from "react-bootstrap/Modal";


export default function RoomStateComponent( props ){
    const reservInfo = props.reservInfo;
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
                .put('http://localhost:80/guestRoom', data)
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
        {state === 1 ?
        <Modal
            show={show}
            onHide={handleClose}
            size="lg"
        >
            <Modal.Header closeButton>
                <Modal.Title><div className={"modalTitle"}><h3>{rno}호 객실 정보</h3></div></Modal.Title>
            </Modal.Header>

            <Modal.Body className={"modalBody"}>
                <div className={"modalContent"}>
                    <div className={"memberInfo"}>
                        <h3>객실 이용자 정보</h3>
                        <div className={"modalText"}> 성함 : {reservInfo.mname} </div>
                        <div className={"modalText"}> 전화번호 : {reservInfo.mphone.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3')} </div>
                        <div className={"modalText"}> 예약 시작 날짜 : {reservInfo.rrstartdate} </div>
                        <div className={"modalText"}> 예약 종료 날짜 : {reservInfo.rrenddate} </div>
                        <div className={"modalText"}> 체크인 시간 :  {reservInfo.rrcheckin.replace("T"," ")} </div>
                    </div>
                </div>

            </Modal.Body>

            <Modal.Footer>
                <button className={"modalButton"} onClick={handleClose}>
                    닫기
                </button>
            </Modal.Footer>
        </Modal> : null
    }
    </>)

}