import './Menu.css'
import MenuProduct from "./MenuProduct";
import {useEffect, useState} from "react";
import {GetMenuData} from "../../../services/WebServices";

export default function Menu() {

	const [menuData, setMenuData] = useState([])

	useEffect(() => {
		console.log("GetMenuData().then(data => setMenuData(data)) ");
		GetMenuData().then(data => {setMenuData(data); console.log(JSON.stringify(data))}) // debug by xina
	}, [])
	
	const menuItems = menuData ? menuData.map((menuItemData, index) =>
			<MenuProduct key={index} data={menuItemData}/>) :
		null;

	return (
		<section className='menu'>
			<div className='content'>
				{menuItems}
			</div>
		</section>
	)
}