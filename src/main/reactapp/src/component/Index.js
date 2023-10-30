// 리액트 라우터 라이브러리
import{ BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import styles from './css/index.css'
import Header from './Header'
import Sidebar from './Sidebar'
import Main from "./Main";





export default function Index(props){
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



