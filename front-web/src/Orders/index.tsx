import ProductsList from './ProductsList';
import StepsHeader from './StepsHeader';
import { useEffect, useState } from 'react';
import './styles.css';
import { Product } from './types';
import { fetchProducts } from '../api';
import OrderLocation from './OrderLocation';

function Orders () {
    const [products, setProducts] = useState<Product[]>([]);    
    console.log(products);

    useEffect(() => {
        fetchProducts()
            .then(response => setProducts(response.data))
            .catch(error => console.log(error));
    }, []);

    return(
        <div className='orders-container'>
            <StepsHeader />
            <ProductsList products={products} />
            <OrderLocation />
        </div>
    );
}
export default Orders;