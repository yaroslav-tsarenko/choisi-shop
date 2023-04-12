'use strict';
import './style.css'
import './Box.css';
const {createElement: e} = React;
const productApi = axios.create({
    baseURL: 'http://localhost:8080'
});
const ProductList = () => {

    let product = {
        id: null,
        name: null,
        description: null
    }


    const [products, setProducts] = React.useState([]);
    const [inputName, setName] = React.useState("");
    const [inputDescription, setDescription] = React.useState("");

    const Box = () => (
        <div className="Box">
            <p className="Box_content"> Styling React Components </p>
        </div>
    );

    export default Box;

    React.useEffect(() => {
        productApi.get('/products')
            .then(function (response) {
                setProducts(response.data);
            })
    }, []);

    const handleProductNameInput = (event) => {
        let name = event.target.value;
        setName(name);
    };

    const handleProductDescriptionInput = (event) => {
        let desc = event.target.value;
        setDescription(desc);
    };

    const handleAddTodo = () => {
        if (inputName === "" || inputDescription === "") {
            window.alert("Input all fields")
        } else {
            product.id = new Date().getTime();
            product.name = inputName;
            product.description = inputDescription;
            setName("");
            setDescription("");
            productApi.post('/products', product)
                .then(function (response) {
                    console.log(response);
                    setProducts([...products, product]);
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    };
    const handleDeleteTodo = (index) => {
        const newTodos = [...products];
        newTodos.splice(index, 1);
        setProducts(newTodos);
    };
    return (
        <div>
            <h1>Product List</h1>
            <div>
                <input
                    type="text"
                    value={inputName}
                    onChange={(event) => handleProductNameInput(event)}
                />
                <input
                    type="text"
                    value={inputDescription}
                    onChange={(event) => handleProductDescriptionInput(event)}
                />
                <button onClick={handleAddTodo}>Add</button>
            </div>
            <ul>
                {products.map((product, index) => (
                    <li key={index}>
                        <div className={"product"}>
                            <div>{product.id}</div>
                            <div>{product.name}</div>
                            <div>{product.description}</div>
                        </div>
                        <button onClick={() => handleDeleteTodo(index)}>Delete</button>
                    </li>
                ))}
            </ul>

        </div>
    );
};

const domContainer = document.querySelector('#root');
ReactDOM.render(e(ProductList), domContainer);