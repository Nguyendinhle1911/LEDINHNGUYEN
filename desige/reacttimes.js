import{ useState } from 'react';

export default function counter() {
const [count, setCount] = useState(0);

function handleClick() {
    setCount(count + 1);
}

return(
    <button onClick={handleClick}>
        you pressed me {count} time
    </button>
);
}