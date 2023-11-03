/* 레코드 컴포넌트 */

export default function Record(props){
    console.log(props.props.rrcheckout);
    return(<>
     <div className={"tableRecord"}>
          <span className={"guestRoomNum"}>{props.props.rno}</span>
          <span className={"guestRoomGrade"}>{props.props.gname}</span>
          <span className={"guestRoomStart"}>{props.props.rrstartdate}</span>
          <span className={"guestRoomEnd"}>{props.props.rrenddate}</span>
          <span className={"guestRoomName"}>{props.props.mname}</span>
          <span className={"guestRoomPhone"}>{props.props.mphone}</span>
         <span className={"guestRoomCheckIn"}>{props.props.rrcheckin}</span>
         <span className={"guestRoomCheckOut"}>{props.props.rrcheckout == null ? '-' : props.props.rrcheckout}</span>
     </div>
    </>)
}


