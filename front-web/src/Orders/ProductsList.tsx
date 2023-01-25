import ProductsCard from "./ProductCard";
import { Product } from "./types";

type Props = {
    products: Product[];
}

function ProductsList ({ products }: Props) {
    return(
        <div className='orders-list-container'>
            <div className="orders-list-items">
                {products.map(product => (
                    <ProductsCard key={product.id} product={product} /> 
                ))}               
            </div>
        </div>
    );
}
export default ProductsList;