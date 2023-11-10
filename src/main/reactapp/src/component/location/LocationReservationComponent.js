/* 레코드 컴포넌트 */
export default function Record(props){
    // 예약 시간 포맷함수
    function formatLrtime(){
        let data = props.props.lrtime.split("T");
        return (data[0] + " " + data[1].slice(0, -10));
    }
    return(<>
        <div className={"tableRecord"}>
            <span className={"lname"}>{props.props.lname}</span>
            <span className={"lrstate"}>{props.props.lrstate}</span>
            <span className={"lrmname"}>{props.props.mname}</span>
            <span className={"lrmphone"}>{props.props.mphone}</span>
            <span className={"lrtime"}>{formatLrtime()}</span>
        </div>
    </>)
}

