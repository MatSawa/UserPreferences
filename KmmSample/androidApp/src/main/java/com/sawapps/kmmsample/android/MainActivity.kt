package com.sawapps.kmmsample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sawapps.kmmsample.UserRepository
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val viewModel: FormViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FormView(model = viewModel)
                }
            }
        }
    }
}

@Composable
fun FormView(model: FormViewModel) {
    val viewState by model.viewState

    Column {
        TextField(
            value = viewState.text,
            onValueChange = model::onTextChanged,
            label = { Text("Enter text here") }
        )
        Button(
            onClick = model::onSaveClick,
            enabled = viewState.isSaveEnabled
        ) {
            Text("Save")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditTextViewPreview() {
    val model = FormViewModel(PreviewUserRepository())
    MyApplicationTheme {
        FormView(model)
    }
}

private class PreviewUserRepository : UserRepository {
    override var userName: String
        get() = ""
        set(value) {}
}