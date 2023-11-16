
import GraphComponent from "./GraphComponent";
import {useState} from "react";
import styles from '../css/businessManagement/hotelStatistics.css'
export default function OperationalStatistics(){

    let[ category, setCategory ] = useState({
        wholeCategory: "sales",
        dateCategory: "year",
        divisionMonth: new Date().getFullYear(),
        divisionWeek: new Date().getMonth()
    })
    /* 테스트 콘솔로그 */
    console.log(category)
    /* selectBox에 전달 위한 함수 */
    const changeCategory = (e) => setCategory({...category, dateCategory: e.target.value});
    /* 년도 캘린더에 전달 위한 함수 */
    const changeYear = (e) => setCategory({...category, divisionMonth: e.target.value})
    /* 개월 캘린더에 전달 위한 함수 */
    const changeMonth = (e) => setCategory({...category, divisionWeek: e.target.value})
    return(<>
        <div className={"operationalWrap"}>
            <div>
                <select onChange={ (e) => setCategory({...category, wholeCategory: e.target.value})  }>
                    <option value={"sales"}>매출</option>
                    <option value={"expenditure"}>지출</option>
                    <option value={"totalUser"}>이용자수</option>
                </select>
                {/* /* 현재 선택된 카테고리(매출, 지출, 이용자수)에 따라 년 별, 월별, 주간별 selectbox 랜더링 */}
                {
                    (()=>{
                        /* 현재 선택된 카테고리가 매출, 지출, 이용자에 따라서 다르게 랜더링*/
                        return category.wholeCategory === "sales" ? <Selecties_1 changeCategory = { changeCategory } />
                            :  category.wholeCategory === "expenditure" ? <Selecties_2 changeCategory = { changeCategory } />
                            :   <Selecties_1 changeCategory = { changeCategory } />
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
            <div>
                <GraphComponent props={""}/>
            </div>


        </div>

    </>)
}


/* 년,월,주간 */
function Selecties_1( props ){
    return(<>
        <select onChange={ props.changeCategory }>
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