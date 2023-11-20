

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
                     <span className={"headerName"}>정희수님</span>
                     <span className={"enum"}>사원번호 : 20221020</span>
                     <span>
                         <span className={"departmentName"}>총괄부</span><span className={"positionName"}>사장</span>
                     </span>

                 </div>
                <div className={"headerContainer"}>
                </div>
            </div>
        </>)
}