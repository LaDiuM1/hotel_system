export default function Login(){
    return(<>
        <div>
            <div className={"loginWrap"}>
                <div>
                    <h1>Hotel Management</h1>
                    <input type={"text"} placeholder={"사원번호"}></input><br/>
                    <input type={"password"} placeholder={"비밀번호"}></input>
                </div>
                <div className={"loginBtnBox"}>
                    <button type={"button"} className={"loginBtn"}>login</button>
                </div>
            </div>
        </div>
    </>)
}