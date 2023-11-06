/* 레코드 컴포넌트 */

export default function Record(props){

    const whatDateTime22 = () => {
        let data = props.props.rrcheckout.split("T");
        return (data[0] + " " + data[1]);
    }
    // 체크아웃 시간 포맷함수
    function rrcheckoutDateTime(){
        let data = props.props.rrcheckout.split("T");
        return (data[0] + " " + data[1]);
    }
    // 체크인 시간 포맷함수
    function rrcheckinDateTime(){
        let data = props.props.rrcheckin.split("T");
        return (data[0] + " " + data[1]);
    }

    return(<>
     <div className={"tableRecord"}>
          <span className={"guestRoomNum"}>{props.props.rno}</span>
          <span className={"guestRoomGrade"}>{props.props.gname}</span>
          <span className={"guestRoomStart"}>{props.props.rrstartdate}</span>
          <span className={"guestRoomEnd"}>{props.props.rrenddate}</span>
          <span className={"guestRoomName"}>{props.props.mname}</span>
          <span className={"guestRoomPhone"}>{props.props.mphone}</span>
         <span className={"guestRoomCheckIn"}>{rrcheckinDateTime()}</span>
         <span className={"guestRoomCheckOut"}>{props.props.rrcheckout == null ? '-' : rrcheckoutDateTime() }</span>
     </div>
    </>)
}

