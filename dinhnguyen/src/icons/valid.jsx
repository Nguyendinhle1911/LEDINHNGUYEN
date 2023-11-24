import {IconConText} from"react-icons";
import {facheckCircle} from"react-icons/fa"


export default function ErrorIcom(){
    return(
        <IconConText.provider value = {{color:"forestgreen",size:"17rem"}}>
        <facheckCircle/>
        </IconConText.provider>
    );
}