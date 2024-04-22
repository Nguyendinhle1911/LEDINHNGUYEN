export default function button(props){
    return(
        <button className={'btn ${props.disabled ? "disabled":""}'}
        onClick={props.onClick}
        disabled={props.disabled}
        >
            {props.text}
        </button>
        
    );
}