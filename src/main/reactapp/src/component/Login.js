import {useState} from "react";
import axios from "axios";

export default function Login(){

    let[ inputInfo, setInputInfo ] = useState({
        eno: "",
        empw: ""
    });

    return(<>
            <div className={"loginWrap"}>
                <div>
                    <h1>Hotel Management</h1>
                    <input type={"text"} placeholder={"사원번호"} onChange={ (e)=>{setInputInfo({...inputInfo,eno:e.target.value})} }></input><br/>
                    <input type={"password"} placeholder={"비밀번호"}  onChange={ (e)=>{setInputInfo({...inputInfo,empw:e.target.value})} }></input>
                </div>
                <div className={"loginBtnBox"}>
                    <button type={"button"} className={"loginBtn"}
                            onClick={ (e)=>
                        axios
                            .post("/member/login", inputInfo)
                            .then( response=>{alert("성공")})
                    }>login</button>
                </div>
            </div>
    </>)
}