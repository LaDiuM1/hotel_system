

export default function RoomStateComponent( props ){

    return(<>

           <td className={`roomComponent ${ props.state === 1 ? "state1" : props.state === 2 ? "state2" : "state3"}`}>{ props.rno }</td>

        </>)



}