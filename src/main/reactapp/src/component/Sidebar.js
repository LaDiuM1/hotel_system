/* 사이드바 컴포넌트 */
import styles from './css/sidebar.css'

export default function Sidebar(){

    return(<>
            <div className={"sidebar"}>

                <div className={"mainText"}> 관리 메뉴 </div>

                <div className={"categoryMenu"}>
                    <div className={"category"}> 객실 예약 관리 </div>
                    <div className={"category"}> 시설 예약 관리 </div>
                    <div className={"category"}> 객실 관리 </div>
                    <div className={"category"}> 시설 관리 </div>
                    <div className={"category"}> 직원 관리 </div>
                    <div className={"category"}> 매출 관리 </div>
                </div>


            </div>
        </>)

}