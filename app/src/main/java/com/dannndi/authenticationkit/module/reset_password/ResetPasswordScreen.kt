package com.dannndi.authenticationkit.module.reset_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dannndi.authenticationkit.R
import com.dannndi.authenticationkit.ui.component.AppTextField

@Composable
fun ResetPasswordScreen(navController: NavHostController) {
    val focusManager = LocalFocusManager.current

    var password by remember { mutableStateOf("") }
    var passwordObscure by remember { mutableStateOf(true) }

    var passwordConfirm by remember { mutableStateOf("") }
    var passwordConfirmObscure by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Button"
                    )
                }
            }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Box(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.ill_reset_password),
                contentDescription = "Reset Password Illustration",
                modifier = Modifier
                    .weight(4.5f)
                    .padding(horizontal = 32.dp),
                contentScale = ContentScale.Fit,
            )
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.weight(5.5f)
            ) {
                Text(
                    text = "Reset\nPassword ?", style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Box(modifier = Modifier.height(16.dp))
                AppTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    hint = "New Password",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "New Password Field",
                        )
                    },
                    trailingIcon = {
                        Icon(painter = if (passwordObscure) painterResource(id = R.drawable.ic_outline_visibility) else painterResource(
                            id = R.drawable.ic_outline_visibility_off
                        ), contentDescription = "Show New Password", modifier = Modifier.clickable {
                            passwordObscure = !passwordObscure
                        })
                    },
                    obscure = passwordObscure,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    )
                )
                Box(modifier = Modifier.height(16.dp))
                AppTextField(
                    value = passwordConfirm,
                    onValueChange = {
                        passwordConfirm = it
                    },
                    hint = "Re-enter New Password",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = " Re-enter New Password Field",
                        )
                    },
                    trailingIcon = {
                        Icon(painter = if (passwordConfirmObscure) painterResource(id = R.drawable.ic_outline_visibility) else painterResource(
                            id = R.drawable.ic_outline_visibility_off
                        ), contentDescription = "Show Re-entered New Password", modifier = Modifier.clickable {
                            passwordConfirmObscure = !passwordConfirmObscure
                        })
                    },
                    obscure = passwordConfirmObscure,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    )
                )
                Box(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Submit", style = MaterialTheme.typography.body1
                    )
                }
                Box(modifier = Modifier.height(16.dp))
            }
        }
    }
}