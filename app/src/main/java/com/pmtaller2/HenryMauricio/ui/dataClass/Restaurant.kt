package com.pmtaller2.HenryMauricio.ui.dataClass

data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val categories: List<String>,
    val menu: List<Dish>
)

val foodCategories = listOf("Pizzas", "Hamburguesas", "Sushi", "Taco")


val restaurants = listOf(
    Restaurant(
        id = 1,
        name = "Pizza Planet",
        description = "Las mejores pizzas del universo",
        imageUrl = "https://www.sortirambnens.com/wp-content/uploads/2019/02/pizza-de-peperoni.jpg",
        categories = listOf("Pizzas", "Comida Italiana", "Vegetariano"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Pizza Pepperoni",
                description = "Clásica pizza con pepperoni y queso",
                imageUrl = "https://example.com/pepperoni.jpg"
            ),
            Dish(
                id = 2,
                name = "Pizza Vegetariana",
                description = "Pizza saludavle con verduras frescas",
                imageUrl = "https://www.revistapancaliente.co/wp-content/uploads/2024/09/Pizza_vegetariana.jpg"
            )
        )
    ),
    Restaurant(
        id = 2,
        name = "Burger King Kong",
        description = "Las hamburguesas más monstruosas",
        imageUrl = "https://example.com/burger.png",
        categories = listOf("Hamburguesas", "Comida Rápida", "Vegetariano"),
        menu = listOf(
            Dish(
                id = 3,
                name = "Hamburguesa doble queso",
                description = "Doble carne, oble queso, doble sabor.",
                imageUrl = "https://static.wixstatic.com/media/29cc8e_aaad1f9b690b4176a0cef213b971f787~mv2.jpg/v1/fill/w_568,h_378,al_c,q_80,usm_0.66_1.00_0.01,enc_avif,quality_auto/29cc8e_aaad1f9b690b4176a0cef213b971f787~mv2.jpg"
            ),
            Dish(
                id = 4,
                name = "Hamburguesa Vegana",
                description = "Una opción deliciosa y saludable",
                imageUrl = "https://www.vitamixespana.com/recetas/wp-content/uploads/2020/04/hamburguesa-vegana-de-arroz-y-calabacin-des-1.jpg"
            )
        )
    ),
    Restaurant(
        id = 3,
        name = "Pizza Volcánica",
        description = "¡Explosión de sabor en cada rebanada!",
        imageUrl = "https://example.com/pizza.png",
        categories = listOf("Pizzas", "Italiana", "Vegetariano"),
        menu = listOf(
            Dish(
                id = 5,
                name = "Pizza Cuatro Quesos",
                description = "Mozzarella, cheddar, azul y parmesano derretidos.",
                imageUrl = "https://example.com/cuatroquesos.jpg"
            ),
            Dish(
                id = 6,
                name = "Pizza Veggie Deluxe",
                description = "Pimientos, champiñones, cebolla y aceitunas.",
                imageUrl = "https://example.com/veggiepizza.jpg"
            )
        )
    ),
    Restaurant(
        id = 4,
        name = "Sushi Samurai",
        description = "Sushi fresco y auténtico directo de Japón",
        imageUrl = "https://example.com/sushi.png",
        categories = listOf("Sushi", "Japonesa", "Mariscos"),
        menu = listOf(
            Dish(
                id = 7,
                name = "Sushi de Salmón",
                description = "Salmón fresco sobre arroz con alga nori.",
                imageUrl = "https://example.com/salmon.jpg"
            ),
            Dish(
                id = 8,
                name = "Roll Vegano",
                description = "Aguacate, pepino y zanahoria en rollo de arroz.",
                imageUrl = "https://example.com/veganroll.jpg"
            )
        )
    ),
    Restaurant(
        id = 5,
        name = "Taco Tornado",
        description = "Auténticos tacos con sabor de México",
        imageUrl = "https://example.com/taco.png",
        categories = listOf("Tacos", "Mexicana", "Picante"),
        menu = listOf(
            Dish(
                id = 9,
                name = "Taco al Pastor",
                description = "Carne marinada con piña y salsa especial.",
                imageUrl = "https://example.com/pastor.jpg"
            ),
            Dish(
                id = 10,
                name = "Taco de Nopales",
                description = "Taco vegetariano con nopales y frijoles.",
                imageUrl = "https://example.com/nopales.jpg"
            )
        )
    )

)