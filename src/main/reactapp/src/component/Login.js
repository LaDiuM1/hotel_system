import {useState} from "react";
import axios from "axios";

export default function Login(){

    let[ inputInfo, setInputInfo ] = useState({
        eno: "",
        epwd: ""
    });
    // 로그인 시 시큐리티 폼전송
    const onLogin = (e) => {
        let loginForm = document.querySelectorAll('.loginForm')[0];
        let loginFormData = new FormData( loginForm );
        axios
            .post("/member/login", loginFormData)
            .then( response => {
                if(response.data)
                    window.location.href = "/"
            })
    }

    console.log(inputInfo)
    return(<>
            <div className={"loginWrap"}>
                <form className={"loginForm"}>
                    <h1>Hotel Management</h1>
                    <input type={"text"} value={inputInfo.eno} placeholder={"사원번호"} name={"eno"}
                           onChange={ (e)=>{setInputInfo({...inputInfo,eno:e.target.value})} }></input><br/>
                    <input type={"password"} value={inputInfo.epwd} placeholder={"비밀번호"} name={"epwd"}
                           onChange={ (e)=>{setInputInfo({...inputInfo,epwd:e.target.value})} }></input>
                </form>
                <div className={"loginBtnBox"}>
                    <button type={"button"} className={"loginBtn"}
                            onClick={ (e) => onLogin(e) }>login</button>
                </div>
            </div>
    </>)
}