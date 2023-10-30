// 리액트 라우터 라이브러리
import{ BrowserRouter, Routes, Route, Link } from 'react-router-dom';

import Header from './Header'
import SideCategory from './SideCategory'
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import styles from './css/Login.css'

let page = Login;

function Index(props){
    return(<>
        <div className={'webContainer'}>
{/*            <BrowserRouter>
                <Header/>
                <div className={}>
                    <SideCategory/>
                    <Routes>
                    </Routes>
                </div>
            </BrowserRouter> */}
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

