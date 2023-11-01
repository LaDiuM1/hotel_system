import styles from '../css/guestroom/roomManagement.css'
import RoomStateComponent from "./RoomStateComponent";


export default function RoomManagement(){
    let i = 4
    let j = 4
    let k = 1
    let component = [
        { floor: i++, roomInfo : [
            {state: 1, roomNumber: j + "" + k++},
            {state: 1, roomNumber: j + "" + k++},
            {state: 1, roomNumber: j + "" + k++},
            {state: 0, roomNumber: j + "" + k++},
            {state: 1, roomNumber: j + "" + k++},
            {state: 0, roomNumber: j + "" + k++},
            {state: 0, roomNumber: j + "" + k++},
            {state: 2, roomNumber: j + "" + k++},
            {state: 0, roomNumber: j + "" + k++},
            {state: 0, roomNumber: j + "" + k++},
            {state: 0, roomNumber: j + "" + k++},
            {state: 1, roomNumber: j + "" + k++},
            {state: 1, roomNumber: j + "" + k++},
            {state: 0, roomNumber: j + "" + k++},
            {state: 1, roomNumber: j + "" + k++}
            ]
        }
    ]





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

                        <tr><RoomStateComponent component = {component}/></tr>
                        <tr><RoomStateComponent component = {component}/></tr>
                        <tr><RoomStateComponent component = {component}/></tr>
                        <tr><RoomStateComponent component = {component}/></tr>
                        <tr><RoomStateComponent component = {component}/></tr>
                        <tr><RoomStateComponent component = {component}/></tr>
                        <tr><RoomStateComponent component = {component}/></tr>
                        <tr><RoomStateComponent component = {component}/></tr>
                        <tr><RoomStateComponent component = {component}/></tr>
                        <tr><RoomStateComponent component = {component}/></tr>

                        </tbody>






                    </table>
                </div>


            </div>



        </>)

}

