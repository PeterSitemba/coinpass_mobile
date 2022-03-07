package com.coinpassmobile.ui.screens.login

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinpassmobile.R
import com.coinpassmobile.ui.components.CoinpassBlueButton
import com.coinpassmobile.ui.components.CoinpassPasswordTextField
import com.coinpassmobile.ui.components.CoinpassTextField
import com.coinpassmobile.ui.theme.*
import com.coinpassmobile.utils.Constants

@Composable
fun LoginScreen() {

    CoinpassMobileTheme {

        Surface(
            color = MaterialTheme.colors.background
        ) {

            var emailInput by rememberSaveable { mutableStateOf("") }
            var passwordInput by rememberSaveable { mutableStateOf("") }
            var error by rememberSaveable { mutableStateOf(false) }
            var signInClickEvent by rememberSaveable { mutableStateOf(false) }

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(R.string.logo),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = margin_xLarge)
                    .size(width = 176.dp, height = 35.dp)
            )

            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = stringResource(R.string.login_header),
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = margin_xxLarge,
                            end = margin_xxLarge,
                            top = margin_from_sign_header
                        )
                ) {
                    Text(
                        text = stringResource(R.string.email_header),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = margin_large)
                    )

                    CoinpassTextField(
                        text = emailInput,
                        labelText = stringResource(R.string.hint_email_address),
                        onTextChanged = {
                            emailInput = it
                            error = false
                            signInClickEvent = false
                        },
                        keyboardType = KeyboardType.Email,
                        hasError = error,
                        signInClicked = signInClickEvent,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = margin_xLarge)
                    )

                    Text(
                        text = stringResource(R.string.password_header),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = margin_large)
                    )

                    CoinpassPasswordTextField(
                        text = passwordInput,
                        hasError = error,
                        labelText = stringResource(R.string.hint_password),
                        signInClicked = signInClickEvent,
                        onTextChanged = {
                            passwordInput = it
                            error = false
                            signInClickEvent = false
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    Text(
                        text = stringResource(R.string.forgot_password),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = margin_large),
                        style = MaterialTheme.typography.caption,
                        color = CoinpassBlueText,
                        textAlign = TextAlign.End
                    )


                    AnimatedVisibility(visible = error) {
                        Text(
                            text = stringResource(R.string.invalid_input),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = margin_large),
                            style = MaterialTheme.typography.caption,
                            color = TextInvalidInput
                        )

                    }

                }


            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = margin_xxLarge, end = margin_xxLarge, bottom = margin_xxLarge),
                verticalArrangement = Arrangement.Bottom
            ) {


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = margin_large)
                ) {
                    Text(
                        text = stringResource(R.string.no_account),
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.align(alignment = Alignment.BottomStart)
                    )

                    Text(
                        text = stringResource(R.string.sign_up),
                        style = MaterialTheme.typography.caption,
                        color = CoinpassBlueText,
                        textAlign = TextAlign.End,
                        modifier = Modifier.align(alignment = Alignment.BottomEnd)


                    )
                }

                CoinpassBlueButton(text = stringResource(R.string.sign_in), onClick = {
                    error =
                        emailInput != "test@gmail.com" || passwordInput != "test123" || emailInput.isEmpty() || passwordInput.isEmpty()

                    signInClickEvent = true
                })
            }


        }

    }


}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginScreen()
}