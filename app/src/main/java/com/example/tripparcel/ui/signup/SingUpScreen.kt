package com.example.tripparcel.ui.signup

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import androidx.navigation.compose.rememberNavController
import com.example.tripparcel.R
import com.example.tripparcel.ui.login.itemSpacing
import com.example.tripparcel.ui.theme.TripParcelTheme
import com.example.tripparcel.ui.view.composants.HeaderText
import com.example.tripparcel.ui.view.composants.LoginTextField

@Composable
fun SignUpScreen(
    onSignUpClick:() -> Unit,
    onLoginClick:() -> Unit,
    onPolicyClick:() -> Unit
){
    val (firstName, onFirstNameChange) = rememberSaveable {
        mutableStateOf("")
    }
    val (lastName, onLastNameChange) = rememberSaveable {
        mutableStateOf("")
    }
    val (email, onEmailChange) = rememberSaveable {
        mutableStateOf("")
    }
    val (password, onPasswordChange) = rememberSaveable {
        mutableStateOf("")
    }
    val (confirmPassword, onConfirmPasswordChange) = rememberSaveable {
        mutableStateOf("")
    }
    val (checked, onCheckChange) = rememberSaveable {
        mutableStateOf(false)
    }
    val imageLogo = painterResource(R.drawable.logo)
    var isPasswordSame by remember { mutableStateOf(false) }
    val isFieldsNotEmpty = firstName.isNotEmpty() && lastName.isNotEmpty()&&
            email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 10.dp,
                start = 17.dp,
                end = 17.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(isPasswordSame) {
            Text("Les mots de passe ne sont pas identiques", color = MaterialTheme.colorScheme.error)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(
                    top = 45.dp,
                    start = 17.dp,
                    end = 17.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painter = imageLogo, contentDescription = "logo de l'application")
        }

        Spacer(Modifier.height(itemSpacing))
        Text(
            text = "Création de Compte",
            modifier = Modifier
                .padding(
                    top = 12.dp,
                    start = 30.dp,
                    end = 17.dp,
                    bottom = 10.dp
                )
                .align(alignment = Alignment.Start),
            style = TextStyle(fontSize = 35.sp)
        )
        Spacer(Modifier.height(itemSpacing))
        //Nom
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            value = firstName,
            onValueChange = onFirstNameChange,
            labelText = "Nom de famille",
            leadingIcon = Icons.Default.Person
        )
        Spacer(Modifier.height(itemSpacing))

        //Prenom
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            value = lastName,
            onValueChange = onLastNameChange,
            labelText = "Prénom",
            leadingIcon = Icons.Default.Person
        )
        Spacer(Modifier.height(itemSpacing))

        //Email
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = onEmailChange,
            labelText = "Email",
            leadingIcon = Icons.Default.Email
        )
        Spacer(Modifier.height(itemSpacing))

        //Password
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = onPasswordChange,
            labelText = "Mot de passe",
            leadingIcon = Icons.Default.Lock,
            keyboardType = KeyboardType.Password,
            isPassword = true
        )
        Spacer(Modifier.height(itemSpacing))

        //password confirm
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            value = confirmPassword,
            onValueChange = onConfirmPasswordChange,
            labelText = "Confirme le mot de passe",
            leadingIcon = Icons.Default.Lock,
            keyboardType = KeyboardType.Password,
            isPassword = true
        )
        Spacer(Modifier.height(itemSpacing))

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = checked, onCheckedChange = onCheckChange)
            Text(
                text = "J'accepte les conditions générales d'utilisation",
                color = Color.Red
                )
        }

        Spacer(Modifier.height(itemSpacing))
        //Boutton
        Button(
            onClick = {
              isPasswordSame = password != confirmPassword
                if(!isPasswordSame){
                    onSignUpClick()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 22.dp
                )
                .height(60.dp),
            enabled = isFieldsNotEmpty,
            shape = RoundedCornerShape(0.dp),
            colors = with(ButtonDefaults) { buttonColors(Color.Red) },
        ) {
            Text(
                text = "Enregistrer",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        Spacer(Modifier.height(itemSpacing))
        val context = LocalContext.current
        val singTx = "Se connecter"
        val signInAnnotation = buildAnnotatedString {
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.onBackground)){
                append("Vous avez déja un compte?")
            }
            append(" ")
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)){
                pushStringAnnotation(singTx, singTx)
                append(singTx)
            }

        }
        ClickableText(
            signInAnnotation,
        ) { offset ->
            signInAnnotation.getStringAnnotations(offset, offset).forEach {
                if(it.tag == singTx){
                    Toast.makeText(context, "Vous voulez vous connecter", Toast.LENGTH_SHORT).show()
                    onLoginClick()
                }
            }
        }

    }

}


@Preview(showSystemUi = true)
@Composable
fun PrevSignUp(){
    TripParcelTheme {
        SignUpScreen({}, {},{})
    }
}