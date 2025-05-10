package dev.gersonchaev.esanchancaspc01.Presentacion.Catalogo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import dev.gersonchaev.esanchancaspc01.Presentacion.MenuPrincipal.MenuPrincipalScreen
import dev.gersonchaev.esanchancaspc01.ui.theme.ESanchancasPC01Theme

data class Producto(
    val nombre: String,
    val precio: Double,
    val categoria: String,
    val imagenUrl: String
)

@Composable
fun CatalogoScreen(navController: NavController) {
    val productos = listOf(
        Producto("Laptop HP Pavilion", 999.99, "Laptop", "https://m.media-amazon.com/images/I/71uX9d5C4yL._AC_UF894,1000_QL80_.jpg"),
        Producto("Smartphone Samsung Galaxy S23", 799.00, "Smartphone", "https://i5.walmartimages.com/seo/Smartphone-Samsung-Galaxy-S23-FE-128GB-Mint_c9033e3d-508e-40af-b09a-957328110d12.269606f229d2c37b6a902874b52c3064.png"),
        Producto("Auriculares Sony WH-1000XM5", 349.50, "Accesorio", "https://images.musicstore.de/images/0960/sony-wh-1000xm5-black_1_acc_studi-332928_0.jpg"),
        Producto("Smartwatch Apple Watch Series 8", 429.00, "Accesorio", "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/watch-card-40-s8-202209_GEO_CO?wid=396&hei=472&fmt=p-jpg&qlt=95&.v=1661701638085"),
        Producto("Tablet Apple iPad Air", 599.99, "Tablet", "https://www.apple.com/v/ipad-air/ad/images/overview/design/colors_blue__e88v4w43m12i_large.jpg"),
        Producto("Monitor Dell UltraSharp", 299.00, "Monitor", "https://m.media-amazon.com/images/I/61U951983DL._AC_UF1000,1000_QL80_.jpg")
    )

    val totalPrecio = productos.sumOf { it.precio }

    ESanchancasPC01Theme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Catálogo de Productos Tecnológicos") })
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(16.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier.weight(1f)
                    ) {
                        items(productos) { producto ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                elevation = 4.dp
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Image(
                                        painter = rememberImagePainter(producto.imagenUrl),
                                        contentDescription = producto.nombre,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(150.dp)
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(text = producto.nombre, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                                    Text(text = "Precio: $${"%.2f".format(producto.precio)}")
                                    Text(text = "Categoría: ${producto.categoria}")
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Total Acumulado: $${"%.2f".format(totalPrecio)}", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { navController.navigate(MenuPrincipalScreen.route) },
                        modifier = Modifier.align(androidx.compose.ui.Alignment.CenterHorizontally)
                    ) {
                        Text("Regresar al Menú Principal")
                    }
                }
            }
        )
    }
}