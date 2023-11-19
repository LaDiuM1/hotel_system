import React, {useEffect, useState} from "react";
import axios from "axios";
import {Table} from "react-bootstrap";
import Modal from "react-bootstrap/Modal";

export default function PositionUpdate({ dataLoadState, setDataLoadState }){
    // 인사 등급별 평일/주말 요금,최대 인원, 회원권 할인율 변경
    const [originalData, setOriginalData] = useState([]) // 변경 전 / 후 데이터 비교용 초기 데이터
    const [updateData, setUpdateData] = useState([]); // 변경된 데이터 확인용 상태 관리 함수
    const [positionOpData, setPositionOpData] = useState( // 전송 데이터
        [
            {
                'pname' : '',      // 직책명 [PK]
                'psalary' : 0,      // 직책별 월급
                'rhprice' : 0,      // 평일 이용료
                'pannual' : 0,    // 직책별 기본 연차 수
                'pbonus' : 0.0,      // 직책별 상여급 비율
            }
        ]
    );

    // 컴포넌트 생성 시 인사 등급 데이터 호출
    useEffect(() => {
        axios
            .get('http://localhost:80/operationalManagement/getPositionOpData')
            .then( r => {
                // 월급 순 정렬
                r.data.sort(function (a, b) {
                    if (a.psalary > b.psalary) {
                        return 1;
                    }
                    if (a.psalary < b.psalary) {
                        return -1;
                    }
                    return 0;
                })

                // 초기 월급 데이터에 쉼표 적용
                r.data.forEach( p => {
                    p.psalary = p.psalary.toLocaleString();
                })

                setPositionOpData(r.data);  // 변경 관리 함수에 저장
                setOriginalData(r.data);// 초기 데이터 확인 함수에 저장
                setDataLoadState(true); // 데이터 로드 후 출력하는 상위 컴포넌트 관리 함수에 true값 대입
            })
    }, []);


    // 데이터 출력 시 각종 단위를 적용하여 출력하는 함수
    const positionOpDataPrint = (e, i) => {
        let className = e.target.className;
        // 값을 정수와 부동소수점 형태로 치환
        let value = parseFloat(e.target.value.replace(/[^0-9.]/g, ''));
        // 데이터 변경 시 값이 공백이면 0 대입
        if(isNaN(value)) { value = 0 }
        // 백분율 표기를 위해 100배수 표기된 데이터 /100 하여 저장
        if(className.indexOf('pbonus') !== -1){
            value /= 100;
        }

        // 데이터를 콤마 단위로 변환 후 저장하는 객체 선언
        let updatePositionOpData= {...positionOpData[i], [className]: value.toLocaleString()};
        // 원본 배열 객체 복사
        let data = [...positionOpData];
        // 변경된 배열에 변경된 객체 대입
        data[i] = updatePositionOpData;
        // 상태관리 함수에 배열객체 저장
        setPositionOpData(data);

    }
    // 업데이트 요소 클릭 시 정수 데이터로 표현하는 함수
    const positionOpDataChange = (e, i) => {
        let className = e.target.className;
        // 데이터를 정수와 부동소수점으로 치환
        let value = e.target.value.replace(/[^0-9.]/g, '');
        // 데이터 변경 시 값이 공백이면 0 대입
        if(isNaN(value)) { value = 0 }
        // 백분율 표기를 위해 100배수 표기된 데이터 /100 하여 저장
        if(className.indexOf('pbonus') !== -1){
            value /= 100;
        }
        // 변경된 데이터 정수와 부동소수점 형태로 저장하는 객체 선언
        let updatePositionOpData= {...positionOpData[i], [className]: value};
        // 원본 배열 객체 복사
        let data = [...positionOpData];
        // 변경된 배열에 변경된 객체 대입
        data[i] = updatePositionOpData;
        // 상태관리 함수에 배열객체 저장
        setPositionOpData(data);


    }

    // 모달창 관리 함수 영역
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);


    // 모달 오픈 시 변경 데이터 확인 함수
    const updateConfirmModal = () => {
        let itemName = ['직책', '기본 월급', '상여급 비율', '기본 연차']
        console.log(originalData);
        let updateData = [];
        originalData.forEach( (p, i) => {
                Object.values(p).forEach( ( p2, j) => {
                    if( p2 != Object.values(positionOpData[i])[j] ){ // 의도적 약비교

                        console.log('positionOpData[i][j] : '+Object.values(positionOpData[i])[j]);
                        updateData.push (
                            {
                                'grade' : originalData[i].pname,
                                'item': itemName[j],
                                'beforeValue': itemName[j] === '상여급 비율' ? Object.values(p)[j]*100+"%" :
                                    itemName[j] === '기본 월급' ? Object.values(p)[j]+"원" : Object.values(p)[j],
                                'afterValue': itemName[j] === '상여급 비율' ? Object.values(positionOpData[i])[j]*100+"%" :
                                    itemName[j] === '기본 월급' ? Object.values(positionOpData[i])[j]+"원" : Object.values(positionOpData[i])[j]
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

    // 모달창에서 확인 클릭 시 인사 데이터를 최종 업데이트 하는 함수
    const dataUpdate = () =>{
        if(!window.confirm('데이터를 변경하시겠습니까?')){
            return;
        }

        // 배열 객체의 요소에서 쉼표 제거후 데이터 전송
        let jsonData = positionOpData.map(p => {
            const newObj = {};
            Object.entries(p).forEach(([key, value], i) => {
                if (typeof value === 'string' && key.indexOf('pname') === -1) {
                    newObj[key] = parseFloat(value.replace(/,/g, ''));
                } else {
                    newObj[key] = value;
                }
            });
            return newObj;
        });

        axios
            .post('http://localhost:80/operationalManagement/updatePositionOpData', jsonData)
            .then( r => {
                if(r) { alert('변경이 완료되었습니다.'); handleClose();}
                // false의 경우는 트랜잭션 연산 실패하여 롤백하는 케이스
                else{ alert('변경에 실패하였습니다. [관리자 문의]'); }
            })

    }



    return(<>
        <div className={"opPrintArea"}>
            <Table className={"opTable"}>{/* 기능 출력 구역 */}
                <thead>
                <tr>
                    <th>직책</th><th>기본 월급</th><th>기본 연차</th><th>상여급 비율</th>
                </tr>
                </thead>
                <tbody>
                {
                    positionOpData.map( (p, i) => {
                        return(<React.Fragment key={p.pname}>
                            <tr>
                                <td>{p.pname}</td>{/* 클릭 또는 값 변경 시 정수로 표현, 출력 시는 단위 적용*/}
                                <td><input className={"psalary"}
                                           onChange={(e) => positionOpDataChange(e, i)}
                                           onClick={(e) => positionOpDataChange(e, i)}
                                           onBlur={(e) => positionOpDataPrint(e, i)}
                                           type={"text"} value={p.psalary}/></td>
                                <td><input className={"pannual"}
                                           onChange={(e) => positionOpDataChange(e, i)}
                                           onClick={(e) => positionOpDataChange(e, i)}
                                           onBlur={(e) => positionOpDataPrint(e, i)}
                                           type={"text"} value={p.pannual}/></td>
                                <td><input className={"pbonus"}
                                           onChange={(e) => positionOpDataChange(e, i)}
                                           onClick={(e) => positionOpDataChange(e, i)}
                                           onBlur={(e) => positionOpDataPrint(e, i)}
                                           type={"text"} value={(p.pbonus * 100) + '%'}/></td>
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