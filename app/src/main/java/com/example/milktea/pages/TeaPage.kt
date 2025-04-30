package com.example.milktea.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.milktea.R
import com.example.milktea.component.HomeMenu
import com.example.milktea.component.TopBarHeader

@Composable
fun TeaPage(modifier: Modifier = Modifier, navController: NavController) {

    val scrollState = rememberScrollState()
    Scaffold (
        topBar = {
            TopBarHeader(name = "Drink Details", navController = navController)
        },
        bottomBar = {
            ButtonCart()
        },
        content = {
                innerPadding->
            Box(
                modifier = Modifier.padding(innerPadding)
            ){
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    TeaCard()
                    SizeButtons()
                    IceLevelButtons()
                    SugarLevel()
                    Toppings()

                }

            }
        }
    )
}

@Composable
fun TeaCard(modifier: Modifier = Modifier) {

    var isHeartClicked by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier.fillMaxWidth()
            .background(Color.Gray)
            .height(400.dp),
        content = {
            Column{
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "Milktea Picture",
                    modifier = Modifier.fillMaxWidth().height(240.dp),
                    contentScale = ContentScale.FillBounds
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    content = {
                        Column(
                            content = {
                                Text(
                                    text = "Brown Sugar Boba",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 25.sp,
                                    maxLines = 1,
                                    modifier = Modifier.padding(vertical = 5.dp)
                                )
                                Text(
                                    text = "⭐ 4.8 (120 reviews)",
                                    fontSize = 18.sp
                                )

                            }
                        )
                        IconButton(
                            onClick = {
                                isHeartClicked = !isHeartClicked
                            },
                            content = {
                                Icon(
                                    imageVector = if (isHeartClicked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                    contentDescription = "Heart Icon"
                                )
                            }
                        )

                    }
                )
                Text(
                    "Milktes Juice is a refreshing blend of creamy milk and sweet fruit flavors, perfect for a cool, energizing treat anytime of day",
                    maxLines = 3,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
                )
            }
        }
    )
}

@Composable
fun SizeButtons(modifier: Modifier = Modifier) {
    var selectedSize by remember { mutableStateOf("Small") }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
    ){
        Text("Size",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 10.dp)
            )
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            TextButton(
                onClick = {
                    selectedSize = "Small"
                },
                modifier = Modifier
                    .width(100.dp)
                    .background(
                        color = if (selectedSize == "Small") Color.Gray else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)),
                content = {
                    Text("Small",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (selectedSize == "Small") Color.White else Color.Gray
                    )
                }
            )
            TextButton(
                onClick = {
                    selectedSize = "Medium"
                },
                modifier = Modifier
                    .width(100.dp)
                    .background(
                        color = if (selectedSize == "Medium") Color.Gray else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)),
                content = {
                    Text("Medium",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (selectedSize == "Medium") Color.White else Color.Gray
                    )
                }
            )
            TextButton(
                onClick = {
                    selectedSize = "Large"
                },
                modifier = Modifier
                    .width(100.dp)
                    .background(
                        color = if (selectedSize == "Large") Color.Gray else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)),
                content = {
                    Text("Large",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (selectedSize == "Large") Color.White else Color.Gray)
                }
            )

        }
    }
    
}

@Composable
fun IceLevelButtons(modifier: Modifier = Modifier) {
    var selectedLevel by remember { mutableStateOf("Regular") }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
    ){
        Text("Ice Level",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            TextButton(
                onClick = {
                    selectedLevel = "No Ice"
                },
                modifier = Modifier
                    .width(70.dp)
                    .background(
                        color = if (selectedLevel == "No Ice") Color.Gray else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)),
                content = {
                    Text("No ice",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color =  if (selectedLevel == "No Ice") Color.White else Color.Gray)
                }
            )
            TextButton(
                onClick = {
                    selectedLevel = "Less"
                },
                modifier = Modifier
                    .width(70.dp)
                    .background(
                        color = if (selectedLevel == "Less") Color.Gray else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)),
                content = {
                    Text("Less",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color =  if (selectedLevel == "Less") Color.White else Color.Gray
                    )
                }
            )
            TextButton(
                onClick = {
                    selectedLevel = "Regular"
                },
                modifier = Modifier
                    .width(70.dp)
                    .background(
                        color = if (selectedLevel == "Regular") Color.Gray else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)),
                content = {
                    Text("Regular",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color =  if (selectedLevel == "Regular") Color.White else Color.Gray)
                }
            )
            TextButton(
                onClick = {
                    selectedLevel = "Extra"
                },
                modifier = Modifier
                    .width(70.dp)
                    .background(
                        color = if (selectedLevel == "Extra") Color.Gray else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)),
                content = {
                    Text("Extra",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color =  if (selectedLevel == "Extra") Color.White else Color.Gray)
                }
            )

        }
    }
}

@Composable
fun SugarLevel(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableStateOf(100) }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
    ){
        Text("Sugar Level",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            TextButton(
                onClick = {
                    selectedIndex = 0
                },
                modifier = Modifier
                    .width(70.dp)
                    .background(
                        color = if (selectedIndex == 0) Color.Gray else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)),
                content = {
                    Text("0%",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (selectedIndex == 0)Color.White else Color.Gray)
                }
            )
            TextButton(
                onClick = {
                    selectedIndex = 50
                },
                modifier = Modifier
                    .width(70.dp)
                    .background(
                        color = if (selectedIndex == 50) Color.Gray else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)),
                content = {
                    Text("50%",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (selectedIndex == 50) Color.White else Color.Gray
                    )
                }
            )
            TextButton(
                onClick = {
                    selectedIndex = 75
                },
                modifier = Modifier
                    .width(70.dp)
                    .background(
                        color = if (selectedIndex == 75) Color.Gray else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)),
                content = {
                    Text("75%",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (selectedIndex == 75) Color.White  else Color.Gray)
                }
            )
            TextButton(
                onClick = {
                    selectedIndex = 100
                },
                modifier = Modifier
                    .width(70.dp)
                    .background(
                        color = if (selectedIndex == 100) Color.Gray else Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)),
                content = {
                    Text("100%",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (selectedIndex == 100) Color.White else Color.Gray)
                }
            )

        }
    }
}

@Composable
fun Toppings(modifier: Modifier = Modifier) {
    var checked_boba by remember { mutableStateOf(false) }
    var checked_pudding by remember { mutableStateOf(false) }
    var checked_jelly by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Text("Toppings",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 10.dp)
        )
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp, vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
                ) {
                Text(
                    "Extra Boba"
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        "+ ₱100"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Checkbox(
                        checked = checked_boba,
                        onCheckedChange = { checked_boba = it }
                    )
                }
            }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                .padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Pudding"
            )
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    "+ ₱100"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Checkbox(
                    checked = checked_pudding,
                    onCheckedChange = { checked_pudding = it }
                )
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                .padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Grass Jelly"
            )
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    "+ ₱100"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Checkbox(
                    checked = checked_jelly,
                    onCheckedChange = { checked_jelly = it }
                )
            }
        }


    }

}

@Composable
fun ButtonCart(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }


    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text("Total Price")
            Text("₱0.00")
        }
        Row(
            modifier = Modifier.width(190.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            content = {
                TextButton(
                    onClick = {
                        if (count > 0) count--

                    },
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .width(30.dp)
                        .border(2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)),
                    content = {
                        Text("-",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black)
                    }
                )
                TextButton(
                    onClick = {
                    },
                    modifier = Modifier
                        .width(30.dp)
                        .border(2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)),
                    content = {
                        Text(count.toString(),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black)
                    }
                )
                TextButton(
                    onClick = {
                        count++
                    },
                    modifier = Modifier
                        .width(30.dp)
                        .border(2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)),
                    content = {
                        Text("+",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black)
                    }
                )

            }
        )
        TextButton(
            onClick = {

            },
            modifier = Modifier
                .width(100.dp)
                .background(color = Color.Black, shape = RoundedCornerShape(10.dp)),
            contentPadding = PaddingValues(0.dp),
            content = {
                Text("Add to Cart",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
            }
        )

    }
}
