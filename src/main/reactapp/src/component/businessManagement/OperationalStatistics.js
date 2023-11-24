
import GraphComponent from "./GraphComponent";
import {useEffect, useState} from "react";
import styles from '../css/businessManagement/hotelStatistics.css'
import axios from "axios";
export default function OperationalStatistics(){

    let[ category, setCategory ] = useState({
        wholeCategory: "sales",
        dateCategory: "year",
        divisionMonth: new Date().getFullYear(),
        divisionWeek: new Date().getMonth()
    })
    let[ statistics, setStatistics ] = useState( data )
    const getStatistics = () => {
        axios
            .get('/operationStatistics', {params: category}  )
            .then( response => {
                setStatistics( response.data )
            } )
    }
    useEffect(() => {getStatistics()}, [category]);

    /* selectBox에 전달 위한 함수 */
    const changeCategory = (e) => setCategory({...category, dateCategory: e.target.value});
    /* 년도 캘린더에 전달 위한 함수 */
    const changeYear = (e) => setCategory({...category, divisionMonth: e.target.value})
    /* 개월 캘린더에 전달 위한 함수 */
    const changeMonth = (e) => setCategory({...category, divisionWeek: e.target.value})

    return(<>
        <div className={"operationalWrap"}>
            <div className={"dateSearchWrap"}>
                <select onChange={ (e) => setCategory({...category, wholeCategory: e.target.value, dateCategory: "year"})  }>
                    <option value={"sales"}>매출</option>
                    <option value={"totalUser"}>이용자수</option>
                </select>
                {/* /* 현재 선택된 카테고리(매출, 지출, 이용자수)에 따라 년 별, 월별, 주간별 selectbox 랜더링 */}
                {
                    (()=>{
                        /* 현재 선택된 카테고리가 매출, 지출, 이용자에 따라서 다르게 랜더링*/
                        return category.wholeCategory === "sales" ? <Selecties_1 dateCategory={category.dateCategory} changeCategory = { changeCategory } />
                            :  category.wholeCategory === "expenditure" ? <Selecties_2 changeCategory = { changeCategory } />
                            :   <Selecties_1 dateCategory={category.dateCategory} changeCategory = { changeCategory } />
                    })()
                }
                {/* 24번째 코드와 연계됨. 현재 선택된 날짜 구별이 월 별이라면 연도에 관한 selectbox 추가로 랜더링  */}
                {
                    (()=>{
                        /* 현재 선택된 date카테고리에 따라서 select 출력*/
                        return category.dateCategory === "month" ?  <Selecties_3 category={category} changeYear = { changeYear }/>
                            : category.dateCategory === "week" ? <Selecties_3 category={category} changeYear = { changeYear }/>
                                : null
                    })()
                }
                {/* 24, 33번째 코드와 연계. 현재 선택된 날짜 구별이 주간 별이라면 년도 select와 더불어 개월에 관한 selectbox 추가로 랜더링  */}
                {
                    (()=>{
                        return category.dateCategory === "week" ?  <Selecties_4 category={category} changeYear = { changeMonth }/>
                            : null
                    })()
                }
            </div>
            <div className={"graphWrap"}>
                <GraphComponent data={statistics}/>
            </div>


        </div>

    </>)
}


/* 년,월,주간 */
function Selecties_1( props ){
    return(<>
        <select value={props.dateCategory} onChange={ props.changeCategory }>
            <option value={"year"}>년 별</option>
            <option value={"month"}>월 별</option>
            <option value={"week"}>주간 별</option>
        </select>
    </>)
}

/* 년, 월 */
function Selecties_2( props ){
    return(<>
        <select onChange={ props.changeCategory }>
            <option value={"year"}>년 별</option>
            <option value={"month"}>월 별</option>
        </select>
    </>)
}

/*  년도 캘린더 컴포넌트(년도 별 선택 시) */
function Selecties_3( props ){
    /* 년도 캘린더 */
    const setYearCalender = () => {
        let nowYear = new Date().getFullYear()
        let selectHtml = []
        /* 현재 날짜 기점으로 캘린더 만들기 -20부터 +3까지 */
        for( let startYear = (nowYear - 20); startYear <= (nowYear + 3); startYear++ )
            selectHtml.push( <option key={startYear} value={startYear}>{startYear}년</option> )

        return selectHtml;
    }

    return(<>
        <select value={props.category.divisionMonth} onChange={ props.changeYear }>
            {setYearCalender()}
        </select>
    </>)
}
/*  개월 캘린더 컴포넌트(주간 선택시) */
function Selecties_4( props ){
    const setMonthCalender = () => {
        let months = []
        /* 현재 날짜 기점으로 캘린더 만들기 -20부터 +3까지 */
        for( let startMonth = 1; startMonth <= 12; startMonth++ )
            months.push( <option key={startMonth} value={startMonth}>{startMonth}월</option> )
        return months;
    }
    return(<>
        <select value={props.category.divisionWeek} onChange={ props.changeYear }>
            {setMonthCalender()}
        </select>
    </>)
}
/* 테스트용 임시 데이터 */
let data = [
    {
        "id": "japan",
        "color": "hsl(202, 70%, 50%)",
        "data": [
            {
                "x": "plane",
                "y": 44
            },
            {
                "x": "helicopter",
                "y": 211
            },
            {
                "x": "boat",
                "y": 227
            },
            {
                "x": "train",
                "y": 33
            },
            {
                "x": "subway",
                "y": 299
            },
        ]
    },
    {
        "id": "france",
        "color": "hsl(339, 70%, 50%)",
        "data": [
            {
                "x": "plane",
                "y": 221
            },
            {
                "x": "helicopter",
                "y": 101
            },
            {
                "x": "boat",
                "y": 220
            },
            {
                "x": "train",
                "y": 276
            },
            {
                "x": "subway",
                "y": 46
            }
        ]
    },
    {
        "id": "us",
        "color": "hsl(52, 70%, 50%)",
        "data": [
            {
                "x": "plane",
                "y": 3
            },
            {
                "x": "helicopter",
                "y": 53
            },
            {
                "x": "boat",
                "y": 40
            },
            {
                "x": "train",
                "y": 204
            },
            {
                "x": "subway",
                "y": 120
            },
            {
                "x": "bus",
                "y": 246
            },
            {
                "x": "car",
                "y": 164
            },
            {
                "x": "moto",
                "y": 28
            },
            {
                "x": "bicycle",
                "y": 120
            },
            {
                "x": "horse",
                "y": 201
            },
            {
                "x": "skateboard",
                "y": 282
            },
            {
                "x": "others",
                "y": 248
            }
        ]
    },
    {
        "id": "germany",
        "color": "hsl(286, 70%, 50%)",
        "data": [
            {
                "x": "plane",
                "y": 21
            },
            {
                "x": "helicopter",
                "y": 26
            },
            {
                "x": "boat",
                "y": 134
            },
            {
                "x": "train",
                "y": 35
            },
            {
                "x": "subway",
                "y": 153
            },
            {
                "x": "bus",
                "y": 283
            },
            {
                "x": "car",
                "y": 247
            },
            {
                "x": "moto",
                "y": 104
            },
            {
                "x": "bicycle",
                "y": 226
            },
            {
                "x": "horse",
                "y": 100
            },
            {
                "x": "skateboard",
                "y": 236
            },
            {
                "x": "others",
                "y": 140
            }
        ]
    }
]
