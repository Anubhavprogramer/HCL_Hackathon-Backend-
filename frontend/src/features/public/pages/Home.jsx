import { createInitialMockData } from '../../../utils/mockData';
import { Navbar } from '../../../components/layout';
import { PageHeader, ProductCard } from '../../../components/common';
import '../../../app/styles/app.css';

function AllProducts() {
	const { products } = createInitialMockData();

	const publicNavItems = [
		{ to: '/', label: '🏠 Home' },
		{ to: '/login', label: '🔐 Login' },
		{ to: '/customer/home', label: '🛒 Customer' },
		{ to: '/seller/dashboard', label: '🏪 Seller' }
	];

	return (
		<div className="app-shell">
			<Navbar navItems={publicNavItems} />

			<main className="app-content">
				<section className="panel">
					<PageHeader title="All Products" subtitle={`${products.length} items available`} />

					<div className="card-grid">
						{products.map((product) => (
							<ProductCard key={product.id} product={product} onAdd={() => {}} />
						))}
					</div>
				</section>
			</main>
		</div>
	);
}

export default AllProducts;