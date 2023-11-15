import graghImg1 from '../img/gragh1.png'
import graghImg2 from '../img/gragh2.png'

import styles from '../css/revenue/revenueManagement.css'

export default function RevenueManagement(){
    return(<>
            <div className={"revenueContainer"}> {/* 페이지 전체 구역 */}
                <div className={"revenueContent"}> {/* 컨텐츠 표시 구역*/}
                    <button style={{ backgroundImage: `url(${graghImg1})` }} type={"button"} className={"selectAreaBtn"}> { /* 기능 선택 버튼 구역 */}
                        호텔 통계 정보

                    </button>  { /* 기능 선택 버튼 종료 */}

                    <button style={{ backgroundImage: `url(${graghImg2})` }} type={"button"} className={"selectAreaBtn"}> { /* 기능 선택 버튼 구역 */}
                        운영 관리

                    </button> { /* 기능 선택 버튼 종료 */}


                </div>  {/* 컨텐츠 표시 구역 종료*/}
            </div>  {/* 페이지 전체 구역 종료 */}
        </>)
}