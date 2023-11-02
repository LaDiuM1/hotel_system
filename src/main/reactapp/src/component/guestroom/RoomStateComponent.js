

export default function RoomStateComponent( props ){
        let prop = props.component[0];
        let roomInfo = prop.roomInfo;
    return(<>
            <td className={"floor"}>{prop.floor}F</td>
            {
                    roomInfo.map((p, i) => {
                            return (<>
                                    <td className={`roomComponent ${roomInfo[i].state === 1 ? "state1" : roomInfo[i].state === 2 ? "state2" : "state3"}`}>{roomInfo[i].roomNumber}</td>
                                    {i === 4 || i === 8 || i === 11 || i === 13 ? <td className="roomComponentSpacing"></td> : null}
                            </>)


                    })

            }

        </>)



}