import coffee1 from "../../../../assets/coffee/coffee1.png";
import './Slides.css'

export default function Slide3() {
    return (
        <>
            <div className='pizza-slide pizza-slide2 pizza-slide3'>
                <div className='content'>
                    <span className='subheading'>Welcome</span>
                    <span className='title'>Coffee</span>
                    <span className='description'>Coffee Coffee Coffee Coffee Coffee Coffee Coffee.</span>
                </div>
                <div className='pictures'>
                    <img src={coffee1} alt=""/>
                </div>
            </div>
        </>
    )
}