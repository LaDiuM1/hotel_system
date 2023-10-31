import styles from '../css/guestroom/roomManagement.css'


export default function RoomManagement(){

    return(<>
            <div className={"webConteiner"}>

                <div className={"contentArea"}>
                    <div className={"guide"}>
                        <div className={"color1"}></div>입실
                        <div className={"color2"}></div>공실
                        <div className={"color3"}></div>사용불가
                    </div>
                    <table className={"roomStateTable"}>

                        <colgroup>
                            <col style={{ width: '80px' }} />
                        </colgroup>

                        <tr>
                            <th> </th>
                            <th colSpan={5}>
                                <div className="contentName">
                                    Standard
                                </div>
                            </th>
                            <th></th>
                            <th colSpan={4}>
                                <div className="contentName">
                                    Deluxe
                                </div>
                            </th>
                            <th></th>
                            <th colSpan={3}>
                                <div className="contentName">
                                    Suite
                                </div>
                            </th>
                            <th></th>
                            <th colSpan={2}>
                                <div className="contentName4">
                                    Premier
                                </div>
                            </th>
                            <th></th>
                            <th>
                                <div className="contentName5">
                                    Royal
                                </div>
                            </th>
                        </tr>
                        <tbody>
                            <tr>
                                <td className={"floor"}>1F</td>
                                <td className={"roomComponent"}>401</td>
                                <td className={"roomComponent"}>402</td>
                                <td className={"roomComponent state1"}>403</td>
                                <td className={"roomComponent"}>404</td>
                                <td className={"roomComponent"}>405</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>406</td>
                                <td className={"roomComponent"}>407</td>
                                <td className={"roomComponent"}>408</td>
                                <td className={"roomComponent"}>409</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>410</td>
                                <td className={"roomComponent"}>411</td>
                                <td className={"roomComponent"}>412</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>413</td>
                                <td className={"roomComponent"}>414</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>415</td>
                            </tr>
                            <tr>
                                <td className={"floor"}>2F</td>
                                <td className={"roomComponent"}>501</td>
                                <td className={"roomComponent"}>502</td>
                                <td className={"roomComponent state2"}>503</td>
                                <td className={"roomComponent"}>504</td>
                                <td className={"roomComponent"}>505</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>506</td>
                                <td className={"roomComponent"}>507</td>
                                <td className={"roomComponent"}>508</td>
                                <td className={"roomComponent"}>509</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>510</td>
                                <td className={"roomComponent"}>511</td>
                                <td className={"roomComponent"}>512</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent state3"}>513</td>
                                <td className={"roomComponent"}>514</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>515</td>
                            </tr>
                            <tr>
                                <td className={"floor"}>3F</td>
                                <td className={"roomComponent"}>401</td>
                                <td className={"roomComponent"}>402</td>
                                <td className={"roomComponent"}>403</td>
                                <td className={"roomComponent"}>404</td>
                                <td className={"roomComponent"}>405</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>406</td>
                                <td className={"roomComponent"}>407</td>
                                <td className={"roomComponent state4"}>408</td>
                                <td className={"roomComponent"}>409</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>410</td>
                                <td className={"roomComponent"}>411</td>
                                <td className={"roomComponent"}>412</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>413</td>
                                <td className={"roomComponent"}>414</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>415</td>
                            </tr>
                            <tr>
                                <td className={"floor"}>4F</td>
                                <td className={"roomComponent"}>501</td>
                                <td className={"roomComponent"}>502</td>
                                <td className={"roomComponent"}>503</td>
                                <td className={"roomComponent"}>504</td>
                                <td className={"roomComponent"}>505</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>506</td>
                                <td className={"roomComponent"}>507</td>
                                <td className={"roomComponent"}>508</td>
                                <td className={"roomComponent"}>509</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>510</td>
                                <td className={"roomComponent"}>511</td>
                                <td className={"roomComponent"}>512</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>513</td>
                                <td className={"roomComponent"}>514</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>515</td>
                            </tr>
                            <tr>
                                <td className={"floor"}>5F</td>
                                <td className={"roomComponent"}>401</td>
                                <td className={"roomComponent"}>402</td>
                                <td className={"roomComponent"}>403</td>
                                <td className={"roomComponent"}>404</td>
                                <td className={"roomComponent"}>405</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>406</td>
                                <td className={"roomComponent"}>407</td>
                                <td className={"roomComponent"}>408</td>
                                <td className={"roomComponent"}>409</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>410</td>
                                <td className={"roomComponent"}>411</td>
                                <td className={"roomComponent"}>412</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>413</td>
                                <td className={"roomComponent"}>414</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>415</td>
                            </tr>
                            <tr>
                                <td className={"floor"}>6F</td>
                                <td className={"roomComponent"}>501</td>
                                <td className={"roomComponent"}>502</td>
                                <td className={"roomComponent"}>503</td>
                                <td className={"roomComponent"}>504</td>
                                <td className={"roomComponent"}>505</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>506</td>
                                <td className={"roomComponent"}>507</td>
                                <td className={"roomComponent"}>508</td>
                                <td className={"roomComponent"}>509</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>510</td>
                                <td className={"roomComponent"}>511</td>
                                <td className={"roomComponent"}>512</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>513</td>
                                <td className={"roomComponent"}>514</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>515</td>
                            </tr>
                            <tr>
                                <td className={"floor"}>7F</td>
                                <td className={"roomComponent"}>401</td>
                                <td className={"roomComponent"}>402</td>
                                <td className={"roomComponent"}>403</td>
                                <td className={"roomComponent"}>404</td>
                                <td className={"roomComponent"}>405</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>406</td>
                                <td className={"roomComponent"}>407</td>
                                <td className={"roomComponent"}>408</td>
                                <td className={"roomComponent"}>409</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>410</td>
                                <td className={"roomComponent"}>411</td>
                                <td className={"roomComponent"}>412</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>413</td>
                                <td className={"roomComponent"}>414</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>415</td>
                            </tr>
                            <tr>
                                <td className={"floor"}>8F</td>
                                <td className={"roomComponent"}>501</td>
                                <td className={"roomComponent"}>502</td>
                                <td className={"roomComponent"}>503</td>
                                <td className={"roomComponent"}>504</td>
                                <td className={"roomComponent"}>505</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>506</td>
                                <td className={"roomComponent"}>507</td>
                                <td className={"roomComponent"}>508</td>
                                <td className={"roomComponent"}>509</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>510</td>
                                <td className={"roomComponent"}>511</td>
                                <td className={"roomComponent"}>512</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>513</td>
                                <td className={"roomComponent"}>514</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>515</td>
                            </tr>
                            <tr>
                                <td className={"floor"}>9F</td>
                                <td className={"roomComponent"}>401</td>
                                <td className={"roomComponent"}>402</td>
                                <td className={"roomComponent"}>403</td>
                                <td className={"roomComponent"}>404</td>
                                <td className={"roomComponent"}>405</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>406</td>
                                <td className={"roomComponent"}>407</td>
                                <td className={"roomComponent"}>408</td>
                                <td className={"roomComponent"}>409</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>410</td>
                                <td className={"roomComponent"}>411</td>
                                <td className={"roomComponent"}>412</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>413</td>
                                <td className={"roomComponent"}>414</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>415</td>
                            </tr>
                            <tr>
                                <td className={"floor"}>10F</td>
                                <td className={"roomComponent"}>501</td>
                                <td className={"roomComponent"}>502</td>
                                <td className={"roomComponent"}>503</td>
                                <td className={"roomComponent"}>504</td>
                                <td className={"roomComponent"}>505</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>506</td>
                                <td className={"roomComponent"}>507</td>
                                <td className={"roomComponent"}>508</td>
                                <td className={"roomComponent"}>509</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>510</td>
                                <td className={"roomComponent"}>511</td>
                                <td className={"roomComponent"}>512</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>513</td>
                                <td className={"roomComponent"}>514</td>
                                <td className={"roomComponentSpacing"}></td>
                                <td className={"roomComponent"}>515</td>
                            </tr>
                        </tbody>






                    </table>
                </div>


            </div>



        </>)

}

