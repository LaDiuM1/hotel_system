/* 사이드바 컴포넌트 */
import styles from './css/sidebar.css'
import {Link} from 'react-router-dom'

import {useState} from "react";
export default function Sidebar(){
    let[ color, setColor ] = useState("");

    function changeColor( color ){
        setColor(color);
    }
    // 현재 url경로가 /login이라면 Sidebar 컴포넌트를 반환X
    const isLoginPage = (window.location.pathname === "/login")
    return(
        isLoginPage ?
            <></>
            :
        <>

            <div className={"sidebar"}>
                <div className={"categoryMenu"}>
                    <div className={"mainText"}> <Link to={"/"} onClick={(e)=>{changeColor( 0 )}}>관리 메뉴</Link> </div>
                    <Link to={"/reservation"} className={"category " + ( color == 1 ? "active" : "" )} onClick={(e)=>{changeColor( 1 )}}> 객실 예약 정보</Link>
                    <Link to={"/locationReservation"} className={"category " + ( color == 2 ? "active" : "" )}  onClick={(e)=>{changeColor( 2 )}}> 시설 예약 정보 </Link>
                    <Link to={"/roomManagement"} className={"category " + ( color == 3 ? "active" : "" )}  onClick={(e)=>{changeColor( 3)}}>객실 이용 현황</Link>
                    <Link to={"/locationManagement"} className={"category " + ( color == 4 ? "active" : "" )}  onClick={(e)=>{changeColor( 4 )}}> 시설 이용 현황 </Link>
                    <Link to={"/EmployeeManagement"} className={"category " + ( color == 5 ? "active" : "" )}  onClick={(e)=>{changeColor( 5 )}}> 직원 관리 </Link>
                    <Link to={"/EmployeeRegister"} className={"category " + ( color == 8 ? "active" : "" )}  onClick={(e)=>{changeColor( 8 )}}> 직원 등록 (임시) </Link>
                    <Link to={"/"} className={"category " + ( color == 6 ? "active" : "" )}  onClick={(e)=>{changeColor( 6 )}}> 매출 관리 </Link>
                    <Link to={"/"} className={"category " + ( color == 7 ? "active" : "" )}  onClick={(e)=>{changeColor( 7 )}}> 운영 관리 </Link>
                </div>
            </div>
        </>
    )
}