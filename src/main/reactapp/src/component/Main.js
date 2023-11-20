
import './css/Main.css'
export default function Main(){

    return(<>
        <div className="mainContainer">
            <div className="mainContent">
                <h1>Welcome to Hotel management System</h1>
                <div>
                    <a href={"/reservation"}><p>객실 예약 정보</p></a>
                    <a href={"/locationReservation"}><p>시설 예약 정보</p></a>
                    <a href={"/roomManagement"}><p>객실 이용 현황</p></a>
                    <a href={"/locationManagement"}><p>시설 이용 현황</p></a>
                    <a href={"/employeeManagement"}><p>직원 관리</p></a>
                </div>
            </div>
        </div>
    </>)
}