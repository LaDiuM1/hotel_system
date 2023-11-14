import HotelSystem from "./HotelSystem"
import Login from "./Login"
import{ BrowserRouter, Routes, Route, Link } from 'react-router-dom';

export default function Index(){
    return(<>
        <BrowserRouter>
            <Routes>
                <Route path={"/hotelSystem"} element={HotelSystem}></Route>
                <Route path={"/login"} element={Login}></Route>
            </Routes>
        </BrowserRouter>
    </>)
}