'use strict';

const e = React.createElement;

const ProductList = () => {
    const [todos, setTodos] = React.useState([]);
    const [inputName, setInputName] = React.useState('');
    const [inputDescription, setDescription] = React.useState('');
    const [inputPrice, setInputPrice] = React.useState('');


    const handleInputName = (event) => {
        setInputName(event.target.value);
    };
    const handleInputDescription = (event) => {
        setDescription(event.target.value);
    };
    const handleInputPrice = (event) => {
        setInputPrice(event.target.value);
    };

    const handleAddTodo = () => {
        if (inputName.trim() && inputDescription.trim() && inputPrice.trim()) {
            setTodos([...todos, {name: inputName.trim(), description: inputDescription.trim(), price: inputPrice.trim()}]);
            setInputName('');
            setDescription('');
            setInputPrice('');
        }
    };

    const handleDeleteTodo = (index) => {
        const newTodos = [...todos];
        newTodos.splice(index, 1);
        setTodos(newTodos);
    };

    return (
        <div>
            <h1>Sell your product</h1>
            <div>
                <h3>Name of your Product</h3>
                <input
                    type="text"
                    name={"search"}
                    value={inputName}
                    onChange={handleInputName}
                />
                <h3>Product description</h3>
                <input
                    type="text"
                    name={"search"}
                    id={"search-field"}
                    value={inputDescription}
                    onChange={handleInputDescription}
                />
                <h3>Product price</h3>
                <input
                    type="number"
                    value={inputPrice}
                    onChange={handleInputPrice}
                />
                <button onClick={handleAddTodo}>Add Product</button>
            </div>
            <ul>
                {todos.map((item, index) => (
                    <li key={index}>
                        <div>Name: {item.name}</div>
                        <div>Description: {item.description}</div>
                        <div>Price: {item.price}</div>
                        <button onClick={() => handleDeleteTodo(index)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

const domContainer = document.querySelector('#root');
ReactDOM.render(e(ProductList), domContainer);
