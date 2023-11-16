
import GraphComponent from "./GraphComponent";
import {useState} from "react";

export default function OperationalStatistics(){

    let[ category, setCategory ] = useState({
        wholeCategory: "sales",
        dateCategory: ""
    })

    console.log(category)
    /* 조건에 따른 select 랜더링 위해 선언 */
    let selecties = [
        <select>
            <option value={"year"}>년 별</option>
            <option value={"month"}>월 별</option>
            <option value={"week"}>주간</option>
        </select>
        ,
        <select>
            <option value={"year"}>년 별</option>
            <option value={"month"}>월 별</option>
        </select>
        ,
        /* 년도 캘린더 */
        () => {
            let year = new Date().getFullYear()
            //let optionHtml =
            for( let i = (year - 20); i <= year + 3; i++ ){

            }
        }
    ]
    return(<>
        <div>
            <div>
                <select onChange={ (e) => setCategory({...category, wholeCategory: e.target.value})  }>
                    <option value={"sales"}>매출</option>
                    <option value={"expenditure"}>지출</option>
                    <option value={"totalUser"}>이용자수</option>
                </select>
                {
                    (()=>{
                        /* 현재 선택된 카테고리가 매출, 지출, 이용자에 따라서 배열 인덱스 반환 */
                        return category.wholeCategory === "sales" ? selecties[0]
                            :  category.wholeCategory === "expenditure" ? selecties[1]
                            :  selecties[0]
                    })()
                }
            </div>


            <GraphComponent props={""}/>

        </div>

    </>)
}