import styles from '../css/location/locationManagement.css'
import {useEffect, useState} from "react";
import axios from "axios";
import LocationComponent from "./LocationComponent";

export default function LocationManagement() {

    const [data, setData] = useState([]);


    useEffect( () => {
        axios
            .get('http://localhost:80/location')
            .then( r => {

                let dataArr = [] ;
                let diningObj = { '다이닝' : [] } ;

                r.data.forEach( p => {
                    if(p.lname.indexOf('다이닝') === -1){
                        dataArr.push(p);
                    }else{
                        diningObj.다이닝.push(p);
                    }
                })
                dataArr.push(diningObj);
                console.dir(dataArr)

                setData(r.data)
            })

    }, [])

    return(<>

        <div className={"webConteiner"}>
            <div className={"locationContent"}>
                <div className={"componentArea"}>

                    {

                        data.map( (p, i) => {
                            return(<>
                                { data.length !== 0 ? <LocationComponent data={ data } i = {i} /> : null }
                            </>)
                        })


                    }
                </div>
            </div>
        </div>


        </>)

}