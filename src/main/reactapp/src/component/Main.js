
import './css/Main.css'
import {useEffect, useState} from "react";
export default function Main(){
    let now = new Date().toLocaleString()
    const [nowTime, setNowTime] = useState(now)

    useEffect( () => {

        const interval = setInterval(() => {
            now = new Date().toLocaleString()
            setNowTime(now);
        }, 1000);

        // 컴포넌트 해제 시 때 타이머 해제
        return () => clearInterval(interval);

    }, [])

    return(<>
        <div className="mainContainer">
            <div className="mainContent">
                <h1>Welcome to Hotel management System</h1>
                <div>
                    <p>{nowTime}</p>
                </div>
            </div>
        </div>
    </>)
}