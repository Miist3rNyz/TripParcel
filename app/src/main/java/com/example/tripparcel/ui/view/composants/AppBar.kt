package com.example.tripparcel.ui.view.composants

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tripparcel.ui.theme.TripParcelTheme
import com.example.tripparcel.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),

            title = {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(id = R.string.logo_content_description),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(150.dp)
                )

            },
            actions = {
                Column(modifier = Modifier.padding(end =24.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        contentDescription = stringResource(id = R.string.logo_content_description),
                    )
                }
            },


            )

    }

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}