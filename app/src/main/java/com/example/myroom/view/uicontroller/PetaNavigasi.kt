package com.example.myroom.view.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myroom.view.route.DestinasiEntry
import com.example.myroom.view.route.DestinasiHome
import com.example.myroom.view.HomeScreen
import com.example.myroom.view.EntrySiswaScreen
import androidx.navigation.navArgument
import com.example.myroom.view.DetailSiswaScreen
import com.example.myroom.view.EditSiswaScreen
import com.example.myroom.view.route.DestinasiDetailSiswa
import com.example.myroom.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.myroom.view.route.DestinasiEditSiswa

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier) {
    HostNavigasi(navController = navController, modifier = modifier)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    @Composable
    fun HostNavigasi(
navController: NavHostController,
modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = DestinasiHome.route, modifier = modifier) {

        composable(route = DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {navController.navigate(route = DestinasiEntry.route)},
                navigateToItemDetail = {
                    navController.navigate("${DestinasiDetailSiswa.route}/${it}")
                })
        }
        composable(route = DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }
        composable(route= DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(itemIdArg){
                type = NavType.IntType
            })) {
            DetailSiswaScreen(
                navigateToEditItem = {navController.navigate("${DestinasiEditSiswa.route}/${it}")},
                navigateBack = {navController.navigateUp()}
            )
        }
        composable(route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEditSiswa.itemIdArg){
                type = NavType.IntType
            })) {
            EditSiswaScreen(
                navigateBack = {navController.popBackStack()},
                onNavigateUp = {navController.navigateUp()}
            )
        }
    }
}