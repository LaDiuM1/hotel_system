
import './css/header.css'
import {useEffect, useState} from "react";
import axios from "axios";
export default function Header(){

    // 로그인 상태 저장하는 상태함수
    let [ login , setLogin ] = useState({
        eno: "",
        departmentDto: {dname:""},
        memberInfoDto: {mname:""},
        positionDto: {pname:""}
    } );
    // 로그인 정보 불러오기
    useEffect( ()=>{
        axios.get('/member/info').then( r => { console.log(r)
            if( r.data != '' ){
                sessionStorage.setItem( 'login_token' , JSON.stringify(r.data) );
                setLogin( JSON.parse( sessionStorage.getItem('login_token') ) );
            }
        } )
    } , [ ] )


    // 현재 url경로가 /login이라면 Sidebar 컴포넌트를 반환X
    const isLoginPage = (window.location.pathname === "/login")
    return(
        isLoginPage ?
            <></>
            :
            <>
            <div className={"header"}>
                 <div className={"profile"}>
                     <span className={"headerName"}>{login.memberInfoDto.mname}님</span>
                     <span className={"enum"}>사원번호 : {login.eno}</span>
                     <span>
                         <span className={"departmentName"}>{login.departmentDto.dname}</span>
                         <span className={"positionName"}>{login.positionDto.pname}</span>
                     </span>

                     <span className={"logoutBtn"}>
                         <button type={"button"} onClick={()=>{
                             axios.get('/member/logout').then( r => { console.log(r)
                                 if( r.data ){
                                     // 세션 제거
                                     sessionStorage.removeItem('login_token')
                                     setLogin( null );
                                     window.location.href = '/login'
                                 }
                             })
                         }}>로그아웃</button>
                     </span>

                 </div>
                <div className={"headerContainer"}></div>
            </div>
        </>)
}