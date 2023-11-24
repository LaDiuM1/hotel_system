import React, {useEffect, useState} from "react";
import axios from "axios";
import {Table} from "react-bootstrap";
import Modal from "react-bootstrap/Modal";

export default function RoomUpdate({ dataLoadState, setDataLoadState }){
    // 객실 등급별 평일/주말 요금,최대 인원, 회원권 할인율 변경
    const [originalData, setOriginalData] = useState([]) // 변경 전 / 후 데이터 비교용 초기 데이터
    const [updateData, setUpdateData] = useState([]); // 변경된 데이터 확인용 상태 관리 함수
    const [roomOpData, setRoomOpData] = useState( // 전송 데이터
        [
            {
                'rgname' : '',      // 객실 등급명 [PK]
                'rwprice' : 0,      // 주말 이용료
                'rhprice' : 0,      // 평일 이용료
                'rgmaxcapa' : 0,    // 등급별 최대 수용 인원
                'drate' : 0.0,      // 등급별 회원권 할인율
            }
        ]
    );

    // 컴포넌트 생성 시 객실 등급 데이터 호출
    useEffect(() => {
        axios
            .get('/operationalManagement/getRoomOpData')
            .then( r => {
                // 객실 요금이 낮은 순으로 정렬
                r.data.sort(function (a, b) {
                    if (a.rwprice > b.rwprice) {
                        return 1;
                    }
                    if (a.rwprice < b.rwprice) {
                        return -1;
                    }
                    return 0;
                })

                // 초기 가격 데이터에 쉼표 적용
                r.data.forEach( p => {
                    p.rwprice = p.rwprice.toLocaleString();
                    p.rhprice = p.rhprice.toLocaleString();
                })

                setRoomOpData(r.data);  // 변경 관리 함수에 저장
                setOriginalData(r.data);// 초기 데이터 확인 함수에 저장
                setDataLoadState(true); // 데이터 로드 후 출력하는 상위 컴포넌트 관리 함수에 true값 대입
            })
    }, []);


    // 데이터 출력 시 각종 단위를 적용하여 출력하는 함수
    const roomOpDataPrint = (e, i) => {
        let className = e.target.className;
        // 값을 정수와 부동소수점 형태로 치환
        let value = parseFloat(e.target.value.replace(/[^0-9.]/g, ''));
        // 데이터 변경 시 값이 공백이면 0 대입
        if(isNaN(value)) { value = 0 }
        // 백분율 표기를 위해 100배수 표기된 데이터 /100 하여 저장
        if(className.indexOf('drate') !== -1){
            value /= 100;
        }

        // 데이터를 콤마 단위로 변환 후 저장하는 객체 선언
        let updateRoomOpData= {...roomOpData[i], [className]: value.toLocaleString()};
        // 원본 배열 객체 복사
        let data = [...roomOpData];
        // 변경된 배열에 변경된 객체 대입
        data[i] = updateRoomOpData;
        // 상태관리 함수에 배열객체 저장
        setRoomOpData(data);

    }
    // 업데이트 요소 클릭 시 정수 데이터로 표현하는 함수
    const roomOpDataChange = (e, i) => {
        let className = e.target.className;
        // 데이터를 정수와 부동소수점으로 치환
        let value = e.target.value.replace(/[^0-9.]/g, '');
        // 데이터 변경 시 값이 공백이면 0 대입
        if(isNaN(value)) { value = 0 }
        // 백분율 표기를 위해 100배수 표기된 데이터 /100 하여 저장
        if(className.indexOf('drate') !== -1){
            value /= 100;
        }
        // 변경된 데이터 정수와 부동소수점 형태로 저장하는 객체 선언
        let updateRoomOpData= {...roomOpData[i], [className]: value};
        // 원본 배열 객체 복사
        let data = [...roomOpData];
        // 변경된 배열에 변경된 객체 대입
        data[i] = updateRoomOpData;
        // 상태관리 함수에 배열객체 저장
        setRoomOpData(data);


    }

    // 모달창 관리 함수 영역
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);


    // 모달 오픈 시 변경 데이터 확인 함수
    const updateConfirmModal = () => {
        let itemName = ['등급', '주말 요금', '평일 요금', '최대 인원', '회원권 할인율' ]

        let updateData = [];
        originalData.forEach( (p, i) => {
                Object.values(p).forEach( ( p2, j) => {
                    if( p2 != Object.values(roomOpData[i])[j] ){ // 의도적 약비교

                        console.log('roomOpData[i][j] : '+Object.values(roomOpData[i])[j]);
                        updateData.push (
                            {
                                'grade' : originalData[i].rgname,
                                'item': itemName[j],
                                'beforeValue': itemName[j] === '회원권 할인율' ? Object.values(p)[j]*100+"%" :
                                    itemName[j] === '최대 인원' ? Object.values(p)[j]+"명" :
                                    itemName[j] === '등급' ? Object.values(p)[j] : Object.values(p)[j]+"원",
                                'afterValue': itemName[j] === '회원권 할인율' ? Object.values(roomOpData[i])[j]*100+"%" :
                                    itemName[j] === '최대 인원' ? Object.values(roomOpData[i])[j]+"명" :
                                    itemName[j] === '등급' ? Object.values(roomOpData[i])[j] : Object.values(roomOpData[i])[j]+"원"
                            })


                    }
                })

            })
        if(updateData.length === 0){
            alert('변경 데이터가 없습니다.')
            return;
        }
        setUpdateData(updateData);
        handleShow();
    }

    // 모달창에서 확인 클릭 시 객실 데이터를 최종 업데이트 하는 함수
    const dataUpdate = () =>{
        if(!window.confirm('데이터를 변경하시겠습니까?')){
            return;
        }

        // 배열 객체의 요소에서 쉼표 제거후 데이터 전송
        let jsonData = roomOpData.map(p => {
            const newObj = {};
            Object.entries(p).forEach(([key, value], i) => {
                if (typeof value === 'string' && key.indexOf('rgname') === -1) {
                    newObj[key] = parseFloat(value.replace(/,/g, ''));
                } else {
                    newObj[key] = value;
                }
            });
            return newObj;
        });

        axios
            .post('/operationalManagement/updateRoomOpData', jsonData)
            .then( r => {
                if(r) { alert('변경이 완료되었습니다.'); window.location.reload(); }
                // false의 경우는 트랜잭션 연산 실패하여 롤백하는 케이스
                else{ alert('변경에 실패하였습니다. [관리자 문의]'); }
            })

    }



    return(<>
        <div className={"opPrintArea"}>
            <Table className={"opTable"}>{/* 기능 출력 구역 */}
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
                                <td>{p.rgname}</td>{/* 클릭 또는 값 변경 시 정수로 표현, 출력 시는 단위 적용*/}
                                <td><input className={"rhprice"}
                                           onChange={(e) => roomOpDataChange(e, i)}
                                           onClick={(e) => roomOpDataChange(e, i)}
                                           onBlur={(e) => roomOpDataPrint(e, i)}
                                           type={"text"} value={p.rhprice}/></td>
                                <td><input className={"rwprice"}
                                           onChange={(e) => roomOpDataChange(e, i)}
                                           onClick={(e) => roomOpDataChange(e, i)}
                                           onBlur={(e) => roomOpDataPrint(e, i)}
                                           type={"text"} value={p.rwprice}/></td>
                                <td><input className={"rgmaxcapa"}
                                           onChange={(e) => roomOpDataChange(e, i)}
                                           onClick={(e) => roomOpDataChange(e, i)}
                                           onBlur={(e) => roomOpDataPrint(e, i)}
                                           type={"text"} value={p.rgmaxcapa + '명'}/></td>
                                <td><input className={"drate"}
                                           onChange={(e) => roomOpDataChange(e, i)}
                                           onClick={(e) => roomOpDataChange(e, i)}
                                           onBlur={(e) => roomOpDataPrint(e, i)}
                                           type={"text"} value={(p.drate * 100) + '%'}/></td>
                            </tr>
                        </React.Fragment>)
                    })
                }
                </tbody>
            </Table>
            <div className={"opButtonArea"}>
                <button onClick={updateConfirmModal} type={"button"}>변경 확인</button>
                <button type={"button"} onClick={() => window.location.reload()}>취소</button>
            </div>

        </div> {/*기능 출력 구역 종료*/}

        <Modal /* 모달창 상태 변경 구역 */
            show={show}
            onHide={handleClose}
            backdrop="static"
            size={'lg'}
        >

            <Modal.Body className={"modalArea"}>
                <div className={"opUpdateContent"}>{/* 운영 변경 데이터 전/후 출력 구역*/}
                    <div className={"compareContent"}>{/* 업데이트 전 출력 */}
                        <h4 className={"compareTitle"}>변경 전</h4>
                        <Table className={"opTable"}>{/* 기능 출력 구역 */}
                            <thead>
                            <tr>
                                <th>등급</th><th>변경 항목</th><th>변경 값</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                updateData.map( (p) => {// 변경된 데이터만 저장된 updateData 객체에서 변경 전 데이터만 추출 후 출력
                                    return(<React.Fragment key={p.grade}>
                                        <tr>
                                            <td>{p.grade}</td>
                                            <td>{p.item}</td>
                                            <td>{p.beforeValue}</td>
                                        </tr>
                                    </React.Fragment>)
                                })
                            }
                            </tbody>
                        </Table>
                    </div>
                    <div className={"compareContent"}>{/* 예상 업데이트 후 출력 */}
                        <h4 className={"compareTitle"}>변경 후</h4>
                        <Table className={"opTable"}>{/* 기능 출력 구역 */}
                            <thead>
                            <tr>
                                <th>등급</th><th>변경 항목</th><th>변경 값</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                updateData.map( (p) => {// 변경된 데이터만 저장된 updateData 객체에서 변경 후 데이터만 추출 후 출력  
                                    return(<React.Fragment key={p.grade}>
                                        <tr>
                                            <td>{p.grade}</td>
                                            <td>{p.item}</td>
                                            <td>{p.afterValue}</td>
                                        </tr>
                                    </React.Fragment>)
                                })
                            }
                            </tbody>
                        </Table>
                    </div>
                </div>
            </Modal.Body>
            <Modal.Footer>
                <div className={"buttonArea"}>
                    <button onClick={dataUpdate} className={"regiSubmitBtn"} type={"button"}>변경</button>
                    <button onClick={handleClose} type={"button"}>취소</button>
                </div>
            </Modal.Footer>
        </Modal>

    </>)
}