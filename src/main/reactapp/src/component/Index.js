// 리액트 라우터 라이브러리
import{ BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import './css/index.css'
import Header from './Header'
import Sidebar from './Sidebar'
import Main from "./Main";
import './css/Login.css'

let page = Index;

function Index(props){
    return(<>
        <div className={'webContainer'}>
            <BrowserRouter>
                <div className={"sidebar"}>
                    <Sidebar/>
                </div>
                <div className={"main"}>
                    <div className={"header"}>
                        <Header/>
                    </div>
                    <div className={"content"}>
                        <Main/>
                    </div>
                </div>

                <Routes>


                </Routes>
            </BrowserRouter>
        </div>
    </>)
}
function Login(){
    return(<>
        <div>
            <div className={"loginWrap"}>
                <div>
                    <h1>Hotel Management</h1>
                    <input type={"text"} placeholder={"사원번호"}></input><br/>
                    <input type={"password"} placeholder={"비밀번호"}></input>
                </div>
                <div className={"loginBtnBox"}>
                    <button type={"button"} className={"loginBtn"}>login</button>
                </div>
            </div>
        </div>
    </>)
}
export default page;
