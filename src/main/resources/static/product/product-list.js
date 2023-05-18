'use strict';

const {createElement: e} = React;

let product = {
    id: null,
    name: null,
    description: null,
    price: null,
}



const inputFileImage = document.getElementById("input-file-uploader");


const ProductList = () => {
    const [products, setProducts] = React.useState([]);
    const [inputName, setName] = React.useState("");
    const [inputDescription, setDescription] = React.useState("");
    const [inputAmount, setAmount] = React.useState("");
    const [inputDiscount, setDiscount] = React.useState("");
    const [inputPrice, setPrice] = React.useState("");
    const [inputImage, setInputImage] = React.useState("");

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

    const handleProductAmountInput = (event) => {
        let amount = event.target.value;
        setAmount(amount);
    };

    const handleProductDiscountInput = (event) => {
        let discount = event.target.value;
        setDiscount(discount);
    };


    const handleAddTodo = () => {
        if (inputName === "" || inputDescription === "") {
            window.alert("Input all fields")
        } else {
            product.name = inputName;
            product.description = inputDescription;
            product.price = inputPrice;
            product.amount = inputAmount;
            product.discount = inputDiscount;
            setName("");
            setDescription("");
            setPrice("");
            restApi.post('/products', product)
                .then(function (response) {
                    console.log('SAVED:', response.data);
                    setProducts([...products, response.data]);
                })
                .catch(function (error) {
                    console.log(error);
                });

        }
        console.log(products);
        //
    };

    const handleDeleteTodo = (index, id) => {
        restApi.delete('/products/' + id);
        console.log("delete action")

        // setProducts(products.slice(0,index));
        const newTodos = [...products];
        newTodos.splice(index, 1);
        setProducts(newTodos);
    };

    const handleEditList = (index, id) => {
        const newTodos = [...products];
        newTodos.splice(index, 1);
        setProducts(newTodos);
    };

    const handleImageChange = (event) => {
        setInputImage(event.target.files[0]);
        console.log(event.target.files[0])
    }

    const handleSubmitImage = (event) => {
        event.preventDefault();
        const formData = new FormData();
        formData.append("file", inputImage);
        restApi.post("/files", formData,
            {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
            .then((response) => {
                let fileId = response.data;
                console.log("Success: ", fileId)
            })
            .catch((error) => {
                console.error("Error: ", error);
            });
    }


    return (

        <div className="product-manager">

            <div className={"div-button"}>
                <h1 className={"product-placement-title"}>PRODUCT PLACEMENT</h1>
                <form onSubmit={handleSubmitImage}>
                        <label htmlFor="input-file-uploader" className="upload-product-photo">
                            <p>
                                <i className="uil uil-upload"></i>
                                UPLOAD FILE
                            </p>
                        </label>
                        <input
                            className="input-file"
                            type="file"
                            id="input-file-uploader"
                            style={{display: 'none'}}
                            onChange={handleImageChange}
                        />
                        <button type="submit">Submit</button>
                </form>
            </div>

            <div className={"refactor-fields"}>


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
                <div className="refactor-fields-properties">
                    <input className={"input-price-product"}
                           type="number"
                           value={inputPrice}
                           placeholder={"Price"}
                           onChange={(event) => handleProductPriceInput(event)}

                    />
                    <i className="fas fa-hryvnia"></i>
                    <input className={"input-amount-product"}
                           type="number"
                           value={inputAmount}
                           placeholder={"Amount"}
                           onChange={(event) => handleProductAmountInput(event)}

                    />
                    <i className="uil uil-list-ol-alt"></i>
                    <input className={"input-discount-product"}
                           type="number"
                           value={inputDiscount}
                           placeholder={"Discount"}
                           onChange={(event) => handleProductDiscountInput(event)}

                    />
                    <i className="uil uil-percentage"></i>
                </div>

                <div className={"button-container"}>
                    <button className={"adding-product-button"} onClick={handleAddTodo}>ADD</button>
                </div>
            </div>

            <div className={"product-list"}>

                <div className={"list-title-container"}>
                    <h2>RECENTLY ADDED PRODUCTS</h2>
                </div>

                <div className={"products-titles"}>
                    <div className={"product-illustration-title"}><h4> Illustration: </h4></div>
                    <div className={"product-name-title"}><h4> Name: </h4></div>
                    <div className={"product-price-title"}><h4> Price: </h4></div>
                    <div className={"product-id-title"}><h4> Id: </h4></div>
                </div>
                <div className={"added-product-container"}>
                    {products.map((product, index) => (
                        <ProductItem
                            key={index}
                            index={index}
                            product={product}
                            deleteFunc={handleDeleteTodo}
                        />
                    ))}
                </div>
            </div>
        </div>

    );
};

const ProductItem = (props) => {

    function handleEditList(index, id) {

    }

    function handleDeleteTodo(index, id) {
        props.deleteFunc(index, id);
    }

    return (

        <div key={props.index} className={"product-additional-list"}>
            <div className={"props-added-photo-button-container"}>
            </div>
            <div className={"props-product-name"}>{props.product.name}</div>
            <div className={"props-product-price"}>{props.product.price}<p>₴</p></div>
            <div className={"props-product-id"}>{props.product.id}</div>

            <div className={"refactor-buttons"}>
                <div className={"delete-button-container"}>
                    <button className={"delete-button"} onClick={() => handleDeleteTodo(props.index, props.product.id)}>
                        <i className="uil uil-trash-alt"></i>
                    </button>

                </div>
                <div className={"edit-button-container"}>
                    <button className={"edit-button"} onClick={() => handleEditList(props.index, props.product.id)}><i
                        className="uil uil-edit"></i>
                    </button>
                </div>


            </div>

        </div>
    );
}

const domContainer = document.querySelector('#root');
ReactDOM.render(e(ProductList), domContainer);