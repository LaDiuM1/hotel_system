import{ BrowserRouter, Routes, Route, Link } from 'react-router-dom';

import Header from './Header'
import SideCategory from './SideCategory'
export default function Index(props){
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