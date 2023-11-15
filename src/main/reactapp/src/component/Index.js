// 리액트 라우터 라이브러리
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
import EmployeeManagement from "./employee/EmployeeManagement";
import EmployeeRegister from "./employee/EmployeeRegister";
import {useState} from "react";
import Login from './Login'
import BusinessManagement from "./businessManagement/BusinessManagement";
import OperationalManagement from "./businessManagement/OperationalManagement";
import OperationalStatistics from "./businessManagement/OperationalStatistics";

export default function Index(){
    let[ loginState, setLoginState ] = useState({})

    return(<>
        <div className={'webContainer'}>
            <BrowserRouter>
                    <Sidebar/>
                <div className={"main"}>
                        <Header/>
                    <div className={"content"}>
                        <Routes>{/*라우트 구역*/}
                            <Route path={"/"} element={<Main/>}></Route>
                            <Route path={"/login"} element={<Login/>}></Route>
                            <Route path={"/reservation"} element={<Reservation/>}></Route>
                            <Route path={"/roomManagement"} element={<RoomManagement/>}></Route>
                            <Route path={"/locationReservation"} element={<LocationReservation/>}></Route>
                            <Route path={"/locationManagement"} element={<LocationManagement/>}></Route>
                            <Route path={"/employeeManagement"} element={<EmployeeManagement/>}></Route>
                            <Route path={"/employeeRegister"} element={<EmployeeRegister/>}></Route>
                            <Route path={"/revenueManagement"} element={<BusinessManagement/>}></Route>
                            <Route path={"/operationalManagement"} element={<OperationalManagement/>}></Route>
                            <Route path={"/operationalStatistics"} element={<OperationalStatistics/>}></Route>
                        </Routes>
                    </div>
                </div>
            </BrowserRouter>
        </div>

    </>)
}


