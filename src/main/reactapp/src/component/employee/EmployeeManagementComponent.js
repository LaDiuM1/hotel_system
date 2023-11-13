

export default function EmployeeManagementComponent(props){
    // 입사일 포맷함수
/*    function formatLrtime(){
        let data = props.props.cdate.split("T");
        return (data[0] + " " + data[1].slice(0, -10));
    }*/
    return(<>
        <div className={"tableRecord"}>
            <span className={"eno"}>{props.props.eno}</span>
            <span className={"mname"}>{props.props.mname}</span>
            <span className={"msex"}>{props.props.msex}</span>
            <span className={"mbirth"}>{props.props.mbirth}</span>
            <span className={"rphone"}>{props.props.mphone}</span>
            <span className={"pname"}>{props.props.pname_fk}</span>
            <span className={"dcode"}>{props.props.dname}</span>
            <span className={"eaddress"}>{props.props.eaddress}</span>
            <span className={"mregiste"}>{}</span>
        </div>
    </>)
}