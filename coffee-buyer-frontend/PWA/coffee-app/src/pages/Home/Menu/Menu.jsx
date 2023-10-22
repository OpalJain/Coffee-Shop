import './Menu.css'
import MenuProduct from "./MenuProduct";
import {useEffect, useState} from "react";
import {GetMenuData} from "../../../services/WebServices";

export default function Menu() {

	const [menuData, setMenuData] = useState([])

	useEffect(() => {
		console.log("GetMenuData().then(data => setMenuData(data)) ");
		GetMenuData().then(data => {setMenuData(data); console.log(data)}) // debug by xina
	}, [])
	/*const menuItemData1 = {
		id: 1,
		name: 'Coffee Item',
		description: 'This is a delicious cup of coffee.',
		image: "coffee-cup.svg",
		price: 40
	  };
	  const menuItemData2 = {
		id: 2,
		name: 'Coffee Item',
		description: 'This is a delicious cup of coffee.',
		image: "coffee-cup.svg",
		price: 30
	  };

	var menuData = [
		menuItemData1,menuItemData2,menuItemData2,menuItemData2,menuItemData2,menuItemData1
	  ];*/

	
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