package com.example.tripparcel.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tripparcel.ui.theme.TripParcelTheme
import com.example.tripparcel.ui.view.composants.HeaderText
import com.example.tripparcel.ui.view.composants.LoginTextField

val defaultPadding = 16.dp
val itemSpacing = 8.dp

@Composable
fun LoginScreen(){
    val (userName, setUsername) = rememberSaveable {
        mutableStateOf("")
    }
    val (password, setPassword) = rememberSaveable {
        mutableStateOf("")
    }
    val (checked, onCheckChange) = rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(defaultPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        HeaderText(
            text = "Connexion",
            modifier = Modifier
                .padding(vertical = defaultPadding)
                .align(alignment = Alignment.Start)
        )
//Username
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName,
            onValueChange = setUsername,
            labelText = "Email",
            leadingIcon = Icons.Default.Person,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(Modifier.height(itemSpacing))
//password
        LoginTextField(
            value = password,
            onValueChange = setPassword,
            labelText = "Mot de passe",
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(Modifier.height(itemSpacing))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = checked, onCheckedChange = onCheckChange)
                Text(text = "Se souvenir de moi")
            }
            TextButton(onClick = { }) {
                Text(text = "Mot de passe oublié?")
            }
        }
        Spacer(Modifier.height(itemSpacing))

        Button(onClick = {},modifier = Modifier.fillMaxWidth()) {
            Text(text = "Connexion")
        }
    }
}









@Preview(showSystemUi = true)
@Composable
fun PrevLoginScreen(){
    TripParcelTheme {
        LoginScreen()
    }
}

