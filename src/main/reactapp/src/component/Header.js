

import './css/header.css'
export default function Header(){

    return(<>
        {/* 이름 구역 */}
         <div className={"profile"}>
             <span className={"mname"}>홍길동님</span>
             <span className={"mno"}>사원번호 : 20221020</span>
             <span className={"tier"}>등급 : 관리자</span>
         </div>
        <div className={"headerContainer"}>
        </div>

    </>)
}