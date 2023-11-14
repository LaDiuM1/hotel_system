
import Record from "../room/RecordComponent";
import styles from '../css/employee/employeeRegister.css'
import style from '../css/employee/employeeManagement.css'
import axios from "axios";
import EmployeeManagementComponent from "./EmployeeManagementComponent";
import React, {useEffect, useState} from "react";
import Modal from "react-bootstrap/Modal";
import modal from "bootstrap/js/src/modal";

export default function EmployeeManagement(){

    // 검색, 페이지 관련 상태변수
    let[ info, setInfo ] = useState({
        depart: "",         // 부서
        position: "",       // 직책
        keyword: "",        // 검색 키워드
        searchType: "eno",     // 검색 타입(사번,사원명,사원 전화번호)
        // 페이징과 정렬 객체
        pageAndSort: {
            //페이징 관련
            nowPage: 1,
            limitPage: 10,
            /* 정렬 관련 */
            cname:"",
            isSorted: false
        }
    })

    // 페이징, 검색 결과 데이터 담겨있는 상태변수 (paggingResult는 이후 직원 리스트 담김)
    let[ resultData, setResultData ] = useState( { paggingResult:[]} )
    // 검색 함수
    const onSearch = ()=>{
        axios
            .post("http://localhost:80/employeeManegement", info)
            .then( response => {setResultData(response.data); console.log(response.data)})
    }
    useEffect(() => {
        onSearch(); console.log( info )
    }, [info]);

    // 페이징 관련 함수 =========================
    function pageBtn() {

        let htmlArr = [];
        // 버튼 랜더링
        for (let i = resultData.startBtn; i <= resultData.endBtn; i++) {
            htmlArr.push(<button className={i === info.pageAndSort.nowPage ? "pageActive" : ""} type={"button"} key={i}
                                 onClick={() => {
                                     setInfo({
                                         ...info,
                                         pageAndSort: {...info.pageAndSort, nowPage: i}
                                     });
                                 }}>{i}</button>)
        }
        if (htmlArr.length === 0) htmlArr.push(<button type={"button"} key={1}>{1}</button>)
        else return htmlArr;
    }
    // 검색 결과 총 사이즈 가져오는 함수
    function getTotalSize(){
        if(resultData.paggingResult.length === 0) return 0;
        return resultData.totalSize;
    }
    // 모달창 상태 관리
    const [show, setShow] = useState(false);

    //모달창 닫는 함수
    const handleClose = () => setShow(false);


    //모당창 여는 함수
    const handleShow = (i) => {
        // 모달창 상태 변경
        setShow(true);

        // 직원 정보 갱신, 모달에 직원 정보 랜더링 위함
        const pname = document.querySelector(`.select${i} .pname`).innerHTML;
        const dcode = document.querySelector(`.select${i} .dcode`).innerHTML;
        // setState
        setModalEmployeeInfo(
            {
                ...modalEmployeeInfo,
                    eno: document.querySelector(`.select${i} .eno`).innerHTML,
                    mname: document.querySelector(`.select${i} .emname`).innerHTML,
                    depart: dcode,
                    position: pname,
                    afterDepart: dcode,
                    afterPosition: pname
                });
    }
    // 모달 내부에 사용할 데이터( 클릭한 직원 정보 )
    let[ modalEmployeeInfo, setModalEmployeeInfo ] = useState( {
        eno:"",
        mname:"",
        depart: "",
        position: "",
        afterDepart:"",
        afterPosition:""
    })

    /* ----------------- 직원 등록 모달 함수 구역 start ----------------- */
    // 직원 등록 모달창 상태 관리
    const [show2, setShow2] = useState(false);
    // 직원 등록 모달창 클로즈
    const handleClose2 = () => setShow2(false);
    // 직원 등록 모달창 오픈
    const handleShow2 = () => setShow2(true);

    // 3개로 나뉘어져 있는 전화번호 값 관리용 상태 함수
    const [phoneValue, setPhoneValue] = useState([ '', '', '' ] )

    // 초기화용 객체
    const initialValue = {
        mname: '',
        msex: '남성',  /* 성별 초기값 지정 */
        mbirth: '',
        mphone: '',
        ejoin: '',
        eaddress: '',
        dcode: '01' /* 부서 코드 초기값 지정 */
    };

    /* input data 관리용 함수 */
    const [ inputData, setInputData] = useState(initialValue);


    const employeeRegister = () => {
        // 객체에 공백 문자가 있으면 종료
        for( let p of Object.values(inputData)){
            if(p.length === 0){
                alert('항목을 모두 입력해 주세요');
                return;
            }
        }
        // 전화번호 유효성 검사
        if(phoneValue[0] < 2 || phoneValue[1] < 3 || phoneValue[2] < 3 )
        { alert('항목을 모두 입력해 주세요'); return; }

        // dto 연관 관계 필드 구조에 맞게 inputData 변경
        const updateTransData = {
            ejoin : inputData.ejoin,
            eaddress : inputData.eaddress,
            memberInfoDto: {
                mname : inputData.mname,
                msex : inputData.msex,
                mbirth : inputData.mbirth,
                mphone : inputData.mphone },
            departmentDto: {
                dcode : inputData.dcode }
        }

        // 입력 데이터 초기화
        setInputData(initialValue);

        axios
            .post('http://localhost:80/employeeRegister', updateTransData )
            .then( r => {
                if(r) { alert('회원 등록을 완료하였습니다.'); handleClose2() }
            })

    }

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

        }else{
            // 그 외에는 일치하는 속성에 입력된 값 저장
            let updateInputData = { ...inputData, [className]: value };
            setInputData(updateInputData);

        }

    }

    /* ----------------- 직원 등록 모달 함수 구역 end ----------------- */



    console.log( modalEmployeeInfo.afterDepart === "")
    return(<>
        <div className={"reservationContainer"}>
            <div className={"reservationWrap"}>
                <div className={"employeeSearchWrap"}>
                    {/* 검색 구역 ======================================================*/}
                    <div className={"search_Box"}>
                        <select className={"departmentBox"}
                                onChange={ e =>
                                    setInfo({
                                        ...info
                                        , depart: e.target.value}
                                    )}>
                            <option value={""}>부서</option>
                            <option value={"서비스"}>서비스</option>
                            <option value={"시설관리"}>시설관리</option>
                            <option value={"호텔조리"}>호텔조리</option>
                            <option value={"마케팅"}>마케팅</option>
                            <option value={"총무"}>총무</option>
                            <option value={"인사"}>인사</option>
                            <option value={"운영"}>운영</option>
                        </select>
                        <select className={"positionBox"}
                                onChange={ e =>
                                    setInfo({
                                        ...info
                                        , position: e.target.value}
                                    )}>
                            <option value={""}>직책</option>
                            <option value={"사원"}>사원</option>
                            <option value={"주임"}>주임</option>
                            <option value={"대리"}>대리</option>
                            <option value={"과장"}>과장</option>
                            <option value={"차장"}>차장</option>
                            <option value={"부장"}>부장</option>
                            <option value={"이사"}>이사</option>
                            <option value={"사장"}>사장</option>
                        </select>
                        <input className={"employSearchInput"} type={"text"} placeholder={"검색"}
                               onChange={(e)=>{setInfo({
                                    ...info,
                                     keyword: e.target.value
                                })}}/>
                        <select className={"employSearchBox"}
                                onChange={ e =>
                                    setInfo({
                                        ...info
                                        , searchType: e.target.value}
                                    )}>
                            <option value={"eno"}>사원번호</option>
                            <option value={"mname"}>사원명</option>
                            <option value={"mphone"}>전화번호</option>
                        </select>
                        <button onClick={handleShow2} className={"registerBtn"} type={"button"}>직원 등록</button>
                    </div>

                    <div className={"totalRecordBox"}>
                        <div className={"totalRecordWrap"}>
                            총 검색 게시물 수 : <span>{getTotalSize()}</span>
                        </div>
                        {/* 출력할 레코드 수 select*/}
                        <select onChange={(e)=>{setInfo({
                            ...info,
                            pageAndSort:{
                                ...info.pageAndSort
                                ,limitPage: e.target.value }
                        })}}>
                            <option value={10}>10</option>
                            <option value={15}>15</option>
                            <option value={20}>20</option>
                        </select>
                    </div>
                </div>
                {/* 검색 구역 끝 ======================================================*/}
                <div className={"tableWrap"}>
                    {/* 테이블 컬럼 명 */}
                    <div className={"tableColumn"}>
                        {
                            (()=>{
                                let tableColumn = [
                                    {className:"eno" ,ctitle:"사원번호",cname:"eno"},
                                    {className:"emname" ,ctitle:"사원명",cname:"mname"},
                                    {className:"emsex" ,ctitle:"성별",cname:"msex"},
                                    {className:"mbirth" ,ctitle:"생년월일",cname:"mbirth"},
                                    {className:"rphone" ,ctitle:"전화번호",cname:"rphone"},
                                    {className:"pname" ,ctitle:"직책",cname:"pname"},
                                    {className:"dcode" ,ctitle:"부서",cname:"dcode"},
                                    {className:"eaddress" ,ctitle:"주소",cname:"eaddress"},
                                    {className:"ejoin" ,ctitle:"입사일",cname:"ejoin"}
                                ]
                                let htmlArr = [];
                                //
                                for(let i = 0; i < tableColumn.length; i++){
                                    htmlArr.push( <span key={i} className={tableColumn[i].className}>{tableColumn[i].ctitle}<span className={"sortPointer"}
                                    >↑↓</span></span> )
                                }
                                return htmlArr;
                            })()
                        }
                    </div>
                    {/* 레코드 구역 */}
                    {/* 모달 사용하기 위해 컴포넌트 사용 X */}
                    {
                        (() => {

                            let htmlArr = []
                            // 검색 결과 리스트 반복문
                            let data = resultData.paggingResult
                                for( let i = 0; i < data.length; i++){
                                    htmlArr.push( <div className={`tableRecord select` + i}
                                                       key={i} onClick={ () => {
                                        handleShow(i)
                                    }}>
                                            <span className={`eno`} key={ data[i].eno}>{data[i].eno}</span>
                                            <span className={`emname`} key={data[i].mname}>{data[i].mname}</span>
                                            <span className={`emsex`} key={data[i].msex}>{data[i].msex}</span>
                                            <span className={`mbirth`} key={data[i].mbirth}>{data[i].mbirth}</span>
                                            <span className={`rphone`} key={data[i].mphone}>{data[i].mphone}</span>
                                            <span className={`pname`} key={data[i].pname_fk}>{data[i].pname_fk}</span>
                                            <span className={`dcode`} key={data[i].dname}>{data[i].dname}</span>
                                            <span className={`eaddress`} key={data[i].eaddress}>{data[i].eaddress}</span>
                                            <span className={`ejoin`} key={data[i].ejoin}>{data[i].ejoin}</span>
                                        </div>
                                    )
                                }
                                return htmlArr
                        })()
                    }
                </div>
                {/* 페이지 공간 */}
                <div className={"tablePage"}>
                    <button type={"button"} onClick={ () => {
                        let page = info.pageAndSort.nowPage;
                        setInfo({
                            ...info,
                            pageAndSort: {
                                ...info.pageAndSort,
                                nowPage: page <= 1 ? page : page - 1
                            }
                        });
                    } }> &lt; </button>
                    {/* 페이지 버튼*/}
                    {
                        pageBtn()
                    }
                    <button type={"button"} onClick={ () => {
                        let page = info.pageAndSort.nowPage;
                        setInfo({
                            ...info,
                            pageAndSort: {
                                ...info.pageAndSort,
                                nowPage: page >= resultData.totalPage ? page : page + 1
                            }
                        });
                    } }> &gt; </button>
                </div>
            </div>
        </div>
        {/* 모달창 상태 변경 구역 */}
        <Modal
            show={show}
            onHide={handleClose}
            size="lg"
        >
            <Modal.Body className={"employeeModalBody"}>
                <div className={"employeeModal"}>
                    <div className={"employeeBeforeInfo"}>
                        <h4>직원 정보</h4>
                        <div className={"employeeInfoWrap"}>
                            <span>이름</span>
                            <span>{modalEmployeeInfo.mname}</span>
                        </div>
                        <div className={"employeeInfoWrap"}>
                            <span>직책</span>
                            <span> {modalEmployeeInfo.position} </span></div>
                        <div className={"employeeInfoWrap"}>
                            <span>부서</span>
                            <span> {modalEmployeeInfo.depart} </span>
                        </div>
                    </div>
                    <div className={"pointerWrap"}>

                        <p> ‣ </p>

                    </div>
                    <div className={"employeeAfterInfo"}>
                        <h4>변경 후 직원 정보</h4>
                        <div className={"employeeInfoWrap"}>
                            <span>이름</span>
                            <span>{modalEmployeeInfo.mname}</span>
                        </div>
                        <select defaultValue={modalEmployeeInfo.position}
                                onChange={ (e) =>
                                    setModalEmployeeInfo({...modalEmployeeInfo,afterPosition: e.target.value})
                        }>
                            <option value={""}>직책</option>
                            <option value={"사원"}>사원</option>
                            <option value={"주임"}>주임</option>
                            <option value={"대리"}>대리</option>
                            <option value={"과장"}>과장</option>
                            <option value={"차장"}>차장</option>
                            <option value={"부장"}>부장</option>
                            <option value={"이사"}>이사</option>
                            <option value={"사장"}>사장</option>
                        </select>
                        <select defaultValue={modalEmployeeInfo.depart}
                                onChange={ (e) =>
                                    setModalEmployeeInfo({...modalEmployeeInfo,afterDepart: e.target.value})
                        }>
                            <option value={""}>부서</option>
                            <option value={"서비스"}>서비스</option>
                            <option value={"시설관리"}>시설관리</option>
                            <option value={"호텔조리"}>호텔조리</option>
                            <option value={"마케팅"}>마케팅</option>
                            <option value={"총무"}>총무</option>
                            <option value={"인사"}>인사</option>
                            <option value={"운영"}>운영</option>
                        </select>
                    </div>
                </div>
            </Modal.Body>
            <Modal.Footer> {/* 버튼 출력 구역 */}
                <button className={"modalButton checkoutBtn"} onClick={ ()=> {
                    // 둘 다 변경사항 없을 시 return
                    if( modalEmployeeInfo.depart === modalEmployeeInfo.afterDepart
                        && modalEmployeeInfo.position === modalEmployeeInfo.afterPosition
                        || ( modalEmployeeInfo.afterDepart === ""
                        || modalEmployeeInfo.afterPosition === "")
                    )
                        return alert("변경 사항이 없습니다.");

                    // 수정 사항 put 메서드 전송
                    axios
                        .put("http://localhost:80/employeeManegement/updateEmployee" ,
                            {
                                    eno: modalEmployeeInfo.eno ,
                                    departmentDto:{
                                        dname:modalEmployeeInfo.afterDepart
                                    },
                                    positionDto: {
                                        pname: modalEmployeeInfo.afterPosition
                                    }
                                })
                        .then(response=>{
                            if(response.data){
                                alert("수정성공");
                                handleClose();
                                onSearch()
                            }
                            else alert("수정실패")
                        })
                } }>
                    수정
                </button>
                <button className={"modalButton"} onClick={handleClose}>
                    닫기
                </button>


            </Modal.Footer>

        </Modal>


        {/* 직원 등록 모달창 구역 시작*/}

        <Modal
            show={show2}
            onHide={handleClose2}
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
                                <div><input onChange={inputValueChange} className={"mname"} maxLength={20} type={"text"}></input></div>
                                <div className={"textArea"} style={{marginLeft:"15px", width:"30%"}}>성별</div>
                                <div className={"radioArea"}>
                                    남<input onChange={inputValueChange} className={"msex"} type={"radio"} name={"msex"} value={"남성"} defaultChecked={"defaultChecked"}></input>
                                    여<input onChange={inputValueChange} className={"msex"} type={"radio"} name={"msex"} value={"여성"}></input>
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
                                    maxLength={3}
                                    onChange={inputValueChange} className={"mphone part1"} type={"number"}></input>
                                <h4>-</h4>
                                <input
                                    onInput={(e) => {
                                        if (e.target.value.length > e.target.maxLength)
                                            e.target.value = e.target.value.slice(0, e.target.maxLength);
                                    }}
                                    maxLength={4}
                                    onChange={inputValueChange} className={"mphone part2"} type={"number"}></input>
                                <h4>-</h4>
                                <input
                                    onInput={(e) => {
                                        if (e.target.value.length > e.target.maxLength)
                                            e.target.value = e.target.value.slice(0, e.target.maxLength);
                                    }}
                                    maxLength={4}
                                    onChange={inputValueChange} className={"mphone part3"} type={"number"}></input>
                            </div>
                        </div>
                        <div className={"itemBlock"}>
                            <div className={"textArea"}>주소</div>
                            <div className={"inputArea"}><input onChange={inputValueChange} className={"eaddress"} maxLength={50} type={"text"}></input></div>
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
                                <select onChange={inputValueChange} className={"dcode"} defaultValue='01'>
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
                    <button onClick={employeeRegister} className={"regiSubmitBtn"} type={"button"}>등록</button>
                    <button onClick={handleClose2} type={"button"}>취소</button>
                </div>
            </Modal.Footer>
        </Modal>
        {/* 직원 등록 모달창 구역 종료*/}

    </>)
}