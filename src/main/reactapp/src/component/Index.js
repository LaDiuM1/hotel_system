// 리액트 라우터 라이브러리
import{ BrowserRouter, Routes, Route, Link } from 'react-router-dom';

import Header from './Header'
import SideCategory from './SideCategory'
let page =
function Index(props){
    return(<>
        <div className={'webContainer'}>
            <BrowserRouter>
                <Header/>
                <div className={}>
                    <SideCategory/>
                    <Routes>


                    </Routes>
                </div>
            </BrowserRouter>
        </div>
    </>)
}
function Login(){
    return(<>

    </>)
}
export default page;

