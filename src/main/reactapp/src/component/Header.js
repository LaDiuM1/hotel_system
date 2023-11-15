

import './css/header.css'
export default function Header(){
    // 현재 url경로가 /login이라면 Sidebar 컴포넌트를 반환X
    const isLoginPage = (window.location.pathname === "/login")
    return(
        isLoginPage ?
            <></>
            :
            <>
            <div className={"header"}>
                 <div className={"profile"}>
                     <span className={"mname"}>홍길동님</span>
                     <span className={"mno"}>사원번호 : 20221020</span>
                     <span className={"tier"}>등급 : 관리자</span>
                 </div>
                <div className={"headerContainer"}>
                </div>
            </div>
        </>)
}