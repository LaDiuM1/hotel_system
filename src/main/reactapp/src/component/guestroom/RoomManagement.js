import styles from '../css/guestroom/roomManagement.css'
import RoomStateComponent from "./RoomStateComponent";
import {useEffect, useState} from "react";
import axios from "axios";


export default function RoomManagement(){
    let [roomStateData, setRoomStateData] = useState([]);

    useEffect(  () => {
          axios
            .get('/guestRoom')
            .then(r => {
                console.dir(r.data)
                setRoomStateData(r.data);

            })

    }, [])


    return(<>
            <div className={"webConteiner"}>

                <div className={"contentArea"}>
                    <div className={"guide"}>
                        <div className={"color1"}></div>입실
                        <div className={"color2"}></div>공실
                        <div className={"color3"}></div>사용불가
                    </div>
                    <table className={"roomStateTable"}>

                        <colgroup>
                            <col style={{ width: '80px' }} />
                        </colgroup>

                        <tr>
                            <th> </th>
                            <th colSpan={5}>
                                <div className="contentName">
                                    Standard
                                </div>
                            </th>
                            <th></th>
                            <th colSpan={4}>
                                <div className="contentName">
                                    Deluxe
                                </div>
                            </th>
                            <th></th>
                            <th colSpan={3}>
                                <div className="contentName">
                                    Suite
                                </div>
                            </th>
                            <th></th>
                            <th colSpan={2}>
                                <div className="contentName4">
                                    Premier
                                </div>
                            </th>
                            <th></th>
                            <th>
                                <div className="contentName5">
                                    Royal
                                </div>
                            </th>
                        </tr>
                        <tbody> {/* 객실 개별 컴포넌트 표시 구역*/}
                        {

                            roomStateData.map( (p, i) => {
                                return(<>
                                    {  i %15 === 0 ? <td className={"floor"}>{Math.floor(p.rno / 100)}F</td> : null }
                                    {  <RoomStateComponent state = {p.rstate} rno = {p.rno} />  }
                                    { i%15 === 4 || i%15 === 8 || i%15 === 11 || i%15 === 13 ? <td className={"roomComponentSpacing"}></td> : null }
                                    { (i+1) % 15 === 0 ? <tr></tr> : null }
                                </>)


                            })

                        }

                        </tbody>






                    </table>
                </div>


            </div>



        </>)

}

