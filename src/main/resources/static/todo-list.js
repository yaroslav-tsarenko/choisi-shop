'use strict';

const e = React.createElement;

const ProductList = () => {

    const [inputName, inputDescription, inputPrice, setInputName, setDescription, setInputPrice] = React.useState([]);

    const handleInputName = (event) => {
        setInputName(event.target.value);
    };
    const handleInputDescription = (event) => {
        setDescription(event.target.value);
    };
    const handleInputPrice = (event) => {
        setInputPrice(event.target.value);
    };

    const handleAddProduct = () => {
        if (inputName.trim() && inputDescription.trim() && inputPrice.trim()) {
            setProducts([...products, {
                name: inputName.trim(),
                description: inputDescription.trim(),
                price: inputPrice.trim()
            }]);
            setInputName('');
            setDescription('');
            setInputPrice('');
        }
    };

    const handleDeleteProduct = (index) => {
        const newProduct = [...products];
        newProduct.splice(index, 1);
        setProducts(newProduct);
    };

    return (
        <div>
            <h1>Sell your product</h1>
            <div>
                <h3>Name of your Product</h3>
                <input
                    type="text"
                    value={inputName}
                    onChange={handleInputName}
                />
                <h3>Product description</h3>
                <input
                    type="text"
                    value={inputDescription}
                    onChange={handleInputDescription}
                />
                <h3>Product price</h3>
                <input
                    type="number"
                    value={inputPrice}
                    onChange={handleInputPrice}
                />
                <button onClick={handleAddProduct}>Add Product</button>
            </div>
            <ul>
                {products.map((name, description, price, index) => (
                    <li key={index}>
                        <div>Name: {name.name}</div>
                        <div>Description: {description.description}</div>
                        <div>Price: {price.price}</div>
                        <button onClick={() => handleDeleteProduct(index)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

const domContainer = document.querySelector('#root');
ReactDOM.render(e(ProductList), domContainer);
