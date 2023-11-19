import coffee1 from "../../../../assets/coffee/coffee1.png";
import './Slides.css'

export default function Slide1() {
    return (
        <>
            <div className='pizza-slide pizza-slide1'>
                <div className='content'>
                <span className='subheading'>Welcome</span>
                    <span className='title'>Coffee</span>
                    <span className='description'>Coffee Coffee Coffee Coffee Coffee Coffee Coffee.</span>
                </div>
                <img width={'60%'} src={coffee1} alt=""/>
            </div>
        </>
    )
}