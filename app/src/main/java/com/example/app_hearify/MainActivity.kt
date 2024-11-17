package com.example.app_hearify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.app_hearify.ui.theme.App_HearifyTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_HearifyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    LoginConstraint(0, Modifier)
                }
            }
        }
    }
}


@Composable
fun LoginConstraint(
    @DrawableRes logo: Int, //logo app
    modifier: Modifier = Modifier.fillMaxSize().background(color = Color.Red)
) {

    ConstraintLayout(
        modifier = modifier
            .background(
                color = colorResource(id = R.color.white), shape = RectangleShape
            )
            .border(width = 5.dp, color = colorResource(id = R.color.purple_700))
            .fillMaxSize()
    ) {
        //var verticalGuideline05 = createGuidelineFromTop(0.05f)
        var verticalGuideline30 = createGuidelineFromTop(0.3f)
        //var horizontalGuideLine50 = createGuidelineFromStart(0.5f)
        var verticalGuideline25 = createGuidelineFromTop((0.25f))


        val (logoRef, textRef, usernameRef, passwordRef, loginButtonRef) = createRefs()
        //ref cho logo, welcome-Login, o nhap username-password

        //logo
        Logo(
            modifier = Modifier.constrainAs(logoRef) {
                top.linkTo(verticalGuideline25)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(verticalGuideline30)

                height = Dimension.value(200.dp)
                width = Dimension.fillToConstraints
            },
        )

        //chu LOGIN
        Greeting("LOGIN", TextStyle(
            color = colorResource(id = R.color.app_name_color),
            fontStyle = FontStyle.Normal,
            fontSize = 40.sp,
        ), Modifier.constrainAs(textRef) {
            top.linkTo(logoRef.bottom, margin = 10.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        //username input
        InputField(label = "Username",
            placeholder = "Enter your username",
            modifier = Modifier.constrainAs(usernameRef) {
                top.linkTo(textRef.bottom, margin = 24.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })


        //password input
        InputField(label = "Password",
            placeholder = "Enter your password",
            isPassword = true,
            modifier = Modifier.constrainAs(passwordRef) {
                top.linkTo(usernameRef.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })


        //login button
        LoginButton("LOGIN", Modifier.constrainAs(loginButtonRef) {
            top.linkTo(passwordRef.bottom, margin = 10.dp)
            start.linkTo(parent.start, margin = 40.dp)
            end.linkTo(parent.end, margin = 40.dp)

        })
    }
}


@Composable
fun Logo(modifier: Modifier) {
    return Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null,
        contentScale = ContentScale.Fit
    )
}

@Composable
fun Greeting(input: String, style: TextStyle, modifier: Modifier) {
    Text(
        text = input, modifier = modifier, style = style
    )
}

@Composable
fun LoginButton(input: String = "empty", modifier: Modifier = Modifier) {
    return Button(
        modifier = modifier, onClick = {}, shape = RoundedCornerShape(24.dp)

    ) {
        Text(text = input)
        Icon(Icons.Filled.CheckCircle, contentDescription = null)
    }
}

@Composable
fun InputField(
    label: String, placeholder: String, isPassword: Boolean = false, modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf("") }
    TextField(value = text,
        onValueChange = { text = it },
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Red,
            focusedLeadingIconColor = colorResource(id = R.color.app_name_color),
            focusedTrailingIconColor = colorResource(id = R.color.app_name_color),
            unfocusedLabelColor = Color.White,
            focusedLabelColor = colorResource(id = R.color.app_name_color),
            cursorColor = colorResource(id = R.color.app_name_color),
            unfocusedContainerColor = colorResource(id = R.color.unfocused_container_background),
            focusedContainerColor = colorResource(id = R.color.container_background)
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = if (isPassword) ImeAction.Done else ImeAction.Next
        ),
        keyboardActions = KeyboardActions.Default
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginLayoutPreview() {
    App_HearifyTheme() {
        LoginConstraint(
            logo = R.drawable.logo, modifier = Modifier.fillMaxSize()
        )
    }
}



