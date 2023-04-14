'use strict';
const {createElement: e} = React;

let product = {
    id: null,
    name: null,
    description: null,
    price: null
}

const ProductList = () => {
    const [products, setProducts] = React.useState([]);
    const [inputName, setName] = React.useState("");
    const [inputDescription, setDescription] = React.useState("");
    const [inputPrice, setPrice] = React.useState("");

    React.useEffect(() => {
        restApi.get('/products')
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

    const handleProductPriceInput = (event) => {
        let price = event.target.value;
        setPrice(price);
    };

    const handleAddTodo = () => {
        if (inputName === "" || inputDescription === "") {
            window.alert("Input all fields")
        } else {
            product.id = new Date().getTime();
            product.name = inputName;
            product.description = inputDescription;
            product.price = inputPrice;
            setName("");
            setDescription("");
            setPrice("");
            restApi.post('/products', product)
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
    const selectCurrency = (event) => {
    };


    return (
        <div className={"product-additional-container"}>
            <h1 className={"product-placement-title"}>PRODUCT PLACEMENT</h1>
            <button className={"upload-product-photo"}>
                <h2 className={"upload-photo-title"}>
                    <i className="uil uil-plus-circle"></i>
                    UPLOAD PHOTO
                </h2>
            </button>
            <div>
                <input className={"input-product"}
                       type="text"
                       value={inputName}
                       placeholder={"Name"}
                       onChange={(event) => handleProductNameInput(event)}
                />
                <input className={"input-product"}
                       type="text"
                       value={inputDescription}
                       placeholder={"Description"}
                       onChange={(event) => handleProductDescriptionInput(event)}
                />
                <input className={"input-price-product"}
                       type="number"
                       value={inputPrice}
                       placeholder={"Price"}
                       onChange={(event) => handleProductPriceInput(event)}
                />

                <button className={"adding-product-button"} onClick={handleAddTodo}>ADD</button>

            </div>
            <ul>
                {products.map((product, index) => (
                    <li key={index}>
                        <div className={"product"}>
                            <div>{product.id}</div>
                            <div>{product.name}</div>
                            <div>{product.description}</div>
                            <div>{product.price}</div>
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