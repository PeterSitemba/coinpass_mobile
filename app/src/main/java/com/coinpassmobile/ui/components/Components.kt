package com.coinpassmobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coinpassmobile.ui.theme.CoinpassMobileTheme
import com.coinpassmobile.ui.theme.*


@Composable
fun CoinpassBlueButton(onClick: () -> Unit, text: String) {

    CoinpassMobileTheme {

        val buttonColors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary
        )

        Button(
            onClick = onClick,
            Modifier
                .fillMaxWidth()
                .size(width = 350.dp, height = 61.dp),
            colors = buttonColors,
            shape = MaterialTheme.shapes.large
        ) {
            Text(text = text)
        }

    }


}

@Composable
fun CoinpassTextField(
    text: String,
    modifier: Modifier = Modifier,
    semanticContentDescription: String = "",
    labelText: String = "",
    onTextChanged: (text: String) -> Unit,
    hasError: Boolean = false,
    keyboardType: KeyboardType,
    signInClicked : Boolean = false
) {
    val focusManager = LocalFocusManager.current

    if(signInClicked) focusManager.clearFocus()

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier
                .background(color = TextInputBackground)
                .fillMaxWidth()
                .semantics { contentDescription = semanticContentDescription },
            value = text,
            onValueChange = onTextChanged,
            placeholder = {
                Text(
                    text = labelText,
                    color = TextInputHintColor,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Default
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            singleLine = true,
            isError = hasError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = TextInputBoarderColor,
                errorBorderColor = TextInputErrorBoarderColor,
                unfocusedBorderColor = TextInputBoarderColor,
                textColor = Color.White,
                cursorColor = Color.White,
            ),
            shape = MaterialTheme.shapes.large
        )
    }
}

@Composable
fun CoinpassPasswordTextField(
    text: String,
    modifier: Modifier = Modifier,
    semanticContentDescription: String = "",
    labelText: String = "",
    onTextChanged: (text: String) -> Unit,
    hasError: Boolean = false,
    signInClicked : Boolean = false
) {
    val focusManager = LocalFocusManager.current
    if(signInClicked) focusManager.clearFocus()

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier
                .background(color = TextInputBackground)
                .fillMaxWidth()
                .semantics { contentDescription = semanticContentDescription },
            value = text,
            onValueChange = onTextChanged,
            placeholder = {
                Text(
                    text = labelText,
                    color = TextInputHintColor,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Default
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            singleLine = true,
            isError = hasError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = TextInputBoarderColor,
                errorBorderColor = TextInputErrorBoarderColor,
                unfocusedBorderColor = TextInputBoarderColor,
                textColor = Color.White,
                cursorColor = Color.White,
            ),
            shape = MaterialTheme.shapes.large,
            visualTransformation = PasswordVisualTransformation()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ComponentsPreview() {

    //CoinpassBlueButton(null, "Sign in")
}