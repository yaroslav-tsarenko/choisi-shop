'use strict';

const e = React.createElement;

const TodoList = () => {
  const [todos, setTodos] = React.useState([]);
  const [inputValue, setInputValue] = React.useState('');

  const handleInputChange = (event) => {
    setInputValue(event.target.value);
  };

  const handleAddTodo = () => {
    if (inputValue.trim()) {
      setTodos([...todos, inputValue.trim()]);
      setInputValue('');
    }
  };
//
  const handleDeleteTodo = (index) => {
    const newTodos = [...todos];
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
              onChange={handleInputChange}
          />
          <button onClick={handleAddTodo}>Add</button>
        </div>
        <ul>
          {todos.map((todo, index) => (
              <li key={index}>
                {todo}
                <button onClick={() => handleDeleteTodo(index)}>Delete</button>
              </li>
          ))}
        </ul>
      </div>
  );
};

const domContainer = document.querySelector('#root');
ReactDOM.render(e(TodoList), domContainer);