/* 사이드바 컴포넌트 */
import styles from './css/sidebar.css'
import {Link} from 'react-router-dom'
import {useState} from "react";
import Record from "./guestroom/RecordComponent"
export default function Sidebar(){


    return(<>
            <div className={"sidebar"}>


                <Record />



            </div>
        </>)

}