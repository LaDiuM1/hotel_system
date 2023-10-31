/* 사이드바 컴포넌트 */
import styles from './css/sidebar.css'
import {Link} from 'react-router-dom'

import {useState} from "react";
export default function Sidebar(){
    let[ color, setColor ] = useState("");

    function changeColor( color ){
        setColor(color);
    }
    return(<>
            <div className={"sidebar"}>
                <div className={"categoryMenu"}>
                    <div className={"mainText"}> <Link to={"/"} onClick={(e)=>{changeColor( 0 )}}>관리 메뉴</Link> </div>
                    <div className={"category " + ( color == 1 ? "active" : "" )} onClick={(e)=>{changeColor( 1 )}}> <Link to={"/reservation"}>객실 예약 관리</Link> </div>
                    <div className={"category " + ( color == 2 ? "active" : "" )}  onClick={(e)=>{changeColor( 2 )}}> 시설 예약 관리 </div>
                    <div className={"category " + ( color == 3 ? "active" : "" )}  onClick={(e)=>{changeColor( 3)}}><Link to={"/roomManagement"}>객실 관리</Link> </div>
                    <div className={"category " + ( color == 4 ? "active" : "" )}  onClick={(e)=>{changeColor( 4 )}}> 시설 관리 </div>
                    <div className={"category " + ( color == 5 ? "active" : "" )}  onClick={(e)=>{changeColor( 5 )}}> 직원 관리 </div>
                    <div className={"category " + ( color == 6 ? "active" : "" )}  onClick={(e)=>{changeColor( 6 )}}> 매출 관리 </div>
                </div>
            </div>
        </>)

}