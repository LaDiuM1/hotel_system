/* 사이드바 컴포넌트 */
import styles from './css/sidebar.css'
import {Link} from 'react-router-dom'

export default function Sidebar(){
    // 현재 주소 페이지
    const currentPage = window.location.pathname;
    
    // 현재 url경로가 /login이라면 Sidebar 컴포넌트를 반환X
    const isLoginPage = (currentPage === "/login")
    return(
        isLoginPage ?
            <></>
            :
        <>

            <div className={"sidebar"}>
                <div className={"categoryMenu"}>
                    <div className={"mainText"}> <a href={"/"}>관리 메뉴</a> </div>
                    <a href={"/reservation"} className={"category " + ( currentPage.startsWith("/reservation") ? "active" : "" )}> 객실 예약 정보</a>
                    <a href={"/locationReservation"} className={"category " + ( currentPage.startsWith("/locationReservation") ? "active" : "" )}> 시설 예약 정보 </a>
                    <a href={"/roomManagement"} className={"category " + ( currentPage.startsWith("/roomManagement") ? "active" : "" )}>객실 이용 현황</a>
                    <a href={"/locationManagement"} className={"category " + ( currentPage.startsWith("/locationManagement") ? "active" : "" )}> 시설 이용 현황 </a>
                    <a href={"/employeeManagement"} className={"category " + ( currentPage.startsWith("/employeeManagement") ? "active" : "" )}> 직원 관리 </a>
                    <a href={"/revenueManagement"} className={"category " + (
                        (currentPage.startsWith("/revenueManagement") || currentPage.startsWith("/operationalStatistics") ||  currentPage.startsWith("/operationalManagement"))
                            ? "active" : "" )}> 경영 관리 </a>
                </div>
            </div>
        </>
    )
}