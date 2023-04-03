'use strict';

const e = React.createElement;
const axios = axios.create({
    baseURL: 'http://localhost:8080/products',
    timeout: 1000,
    headers: {'X-Custom-Header': 'foobar'}
});
const TodoList = () => {
    const [todos, setTodos] = React.useState([]);
    const [inputValue, setInputValue] = React.useState('');

    const handleInputChange = (event) => {
        let inputValue = event.target.value;
        console.log("INPUT: ", inputValue);
        setInputValue(inputValue);
    };

    const handleAddTodo = (inputTodo) => {
        if (inputTodo !== "") {
            console.log("INPUT: ", inputTodo);
            todos.push(inputTodo)
            setTodos(todos);
            setInputValue('');
        }
    };

    const handleDeleteTodo = (index) => {
        const newTodos = [...todos];
        console.log("Delete: ", index);
        newTodos.splice(index, 1);
        setTodos(newTodos);
    };

    return (
        <div>
            <h1>Todo List</h1>
            <div>
                <input
                    type="text"
                    value={inputValue}
                    onChange={(event) => handleInputChange(event)}
                />
                <button onClick={() => handleAddTodo(inputValue)}>Add</button>
            </div>
            <ul>
                {todos.map((todo, index) => (
                    <li key={index}>
                        <div><p>id: </p>{index}</div>
                        {todo}
                        <button onClick={() => handleDeleteTodo(index)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

const domContainer = document.querySelector('#product-list');
ReactDOM.render(e(TodoList), domContainer);