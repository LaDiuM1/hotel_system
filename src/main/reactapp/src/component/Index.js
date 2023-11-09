// 리액트 라우터 라이브러리
import React from 'react';
import{ BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import './css/index.css'
import Header from './Header'
import Sidebar from './Sidebar'
import Main from "./Main";
import './css/Login.css'
import RoomManagement from "./room/RoomManagement";
import Reservation from "./room/RoomReservation"
import 'bootstrap/dist/css/bootstrap.css';
import LocationReservation from './location/LocationReservation'
import LocationManagement from "./location/LocationManagement";

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
                        <Routes>{/*라우트 구역*/}
                            <Route path={"/"} element={<Main/>}></Route>
                            <Route path={"/reservation"} element={<Reservation/>}></Route>
                            <Route path={"/roomManagement"} element={<RoomManagement/>}></Route>
                            <Route path={"/locationReservation"} element={<LocationReservation/>}></Route>
                            <Route path={"/locationManagement"} element={<LocationManagement/>}></Route>
                        </Routes>
                    </div>

                </div>
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

