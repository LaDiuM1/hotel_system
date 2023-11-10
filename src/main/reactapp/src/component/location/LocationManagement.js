import styles from '../css/location/locationManagement.css'
import React, {useEffect, useState} from "react";
import axios from "axios";
import LocationComponent from "./LocationComponent";

export default function LocationManagement() {
    // 데이터 상태 저장용 객체
    const [data, setData] = useState([]);

    // 최초 실행 시 호출되는 useEffect
    useEffect( () => {
        // 컴포넌트 상태 표기용 데이터 호출
        const fetchData = () =>{
            axios
            .get('http://localhost:80/location')
            .then( r => {
                /*데이터가 모닝 다이닝, 런치, 디너, 피트니스, 실내수영장, 실내골프장으로 분리되어 있어
                  컴포넌트 사용에 불리하여 다이닝 객체는 하나로 통합하여
                  다이닝,피트니스,실내수영장,실내골프장 배열로 통합된 객체를 만들기 위한 알고리즘*/

                // 반환용 배열 선언
                let dataArr = [] ;
                // 모닝,런치,디너로 분리 되어 있는 객체 합치기 위한 배열 선언
                let diningObj = { 'lname' : [] } ;
                // 이름이 다이닝인지 확인 후 다이닝 일 시 diningObj.lname 속성 배열에 하나씩 추가
                // 아닐 시 dataArr에 추가
                r.data.forEach( p => {
                    if(p.lname.indexOf('다이닝') === -1){
                        dataArr.push(p);
                    }else{
                        diningObj.lname.push(p);
                    }
                })
                // 반환용 배열에 합쳐진 다이닝 객체 추가
                dataArr.push(diningObj);
                // 다이닝부터 표기하기 위해 배열 역순 정렬
                dataArr = dataArr.reverse()
                console.dir(dataArr)
                // 상태 저장용 함수에 객체 대입
                setData(dataArr)
            })
        }
        fetchData(); // 초기 렌더링 시 출력을 위한 함수 호출
        // 이후 10초 간격으로 반복 랜더링
        const intervalId = setInterval(fetchData, 10000);

        // 컴포넌트가 언마운트될 때 타이머 해제
        return () => clearInterval(intervalId);
    }, [])

    return(<>

        <div className={"webConteiner"}>
            <div className={"locationContent"}>
                <div className={"componentArea"}>

                    {

                        data.map( p => {
                            return(<React.Fragment key={p.lname} >
                                {/* 배열 크기가 0이 아닐때만 컴포넌트 호출 / 리랜더링 이전 데이터 사용으로 인한 오류 방지 */}
                                { data.length !== 0 ? <LocationComponent data={ p } /> : null }
                            </React.Fragment>)
                        })

                    }
                </div>
            </div>
        </div>


        </>)

}