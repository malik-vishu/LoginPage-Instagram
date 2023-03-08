package com.example.instadmscreen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instadmscreen.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen() {
    var userName by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var passwordVisible by remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxHeight()) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(modifier = Modifier.padding(top = 180.dp)) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.instalogo1),
                        contentDescription = "Instagram Text Logo"
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 20.dp)
                            .alpha(0.4f)
                            .align(Alignment.CenterHorizontally),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(
                                0xFFebeef2
                            )
                        ),
                        value = userName,
                        onValueChange = { userName = it },
                        placeholder = {
                            Text(
                                text = "Phone number, username or email",
                                style = TextStyle(fontSize = 11.sp)
                            )
                        })
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 20.dp)
                            .alpha(0.4f)
                            .align(Alignment.CenterHorizontally),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(
                                0xFFebeef2
                            )
                        ),
                        value = password,
                        onValueChange = {  password = it },
                        placeholder = {
                            Text(
                                text = "Password",
                                style = TextStyle(fontSize = 11.sp)
                            )
                        },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            val image = if (passwordVisible)
                                Icons.Filled.Visibility
                            else Icons.Filled.VisibilityOff

                            val description =
                                if (passwordVisible) "Hide password" else "Show password"

                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(imageVector = image, contentDescription = description)
                            }
                        })
                    Column(
                        horizontalAlignment = Alignment.End, modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp, end = 15.dp)
                    ) {
                        Text(
                            text = "Forgot password?",
                            color = Color(0xFF0098fe),
                            modifier = Modifier.clickable { })
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .alpha(0.6f)
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF0098fe))
                    ) {
                        Text(text = "Log In", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Divider(
                            modifier = Modifier
                                .padding(20.dp)
                                .width(150.dp), thickness = 1.dp, color = Color.LightGray
                        )
                        Text(text = "OR")
                        Divider(
                            modifier = Modifier
                                .padding(20.dp)
                                .width(150.dp), thickness = 1.dp, color = Color.LightGray
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.facebooklogo),
                            modifier = Modifier
                                .padding(end = 2.dp)
                                .size(29.dp),
                            contentDescription = "Facebook logo"
                        )
                        Text(
                            text = "Continue as ABC",
                            color = Color(0xFF0098fe),
                            letterSpacing = 0.5.sp,
                            fontSize = typography.body1.fontSize,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            Column(
                modifier = Modifier.padding(top = 150.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Divider(modifier = Modifier, color = Color.LightGray)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.LightGray)) {
                        append(
                            "Don't have an account?"
                        )
                    }
                    withStyle(style = SpanStyle(color = Color(0xFF0098fe))) {
                        append(" Sign Up.")
                    }
                })

            }
        }

    }
}