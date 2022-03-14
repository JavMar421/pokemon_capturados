package com.example.pokemon

import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import java.io.File
import kotlin.system.exitProcess

class CajaController() {

    @FXML
    private lateinit var nombrePokemon:Label
    @FXML
    private lateinit var imagenPokemon:ImageView
    @FXML
    private lateinit var siguientePokemon:Label

    class InterfazPokemon(var nombrePokemon: Label, var imagenPokemon: ImageView)
    var i = 0
    fun initialize(){
        println(listaCapturados.get(i).nombreCap)
        nombrePokemon.text=(listaCapturados.get(i).nombreCap+" lucho contra "+ listaCapturados.get(i).nombrePelea+" fue necesario lanzar "+ listaCapturados.get(i).intentos+" pokeballs y le hizo "+ listaCapturados.get(i).vida+" puntos de daño antes de ser capturado")
        var filePokemon= File(listaCapturados.get(i).image)
        imagenPokemon.image= Image(filePokemon.toURI().toString())

    }


    @FXML
    fun siguienteCliked(){
        println("$i "+ listaCapturados.size)
        if (i< listaCapturados.size-1)
        {i++}
        else {i=0}
        initialize()

    }




    var pokemonSeleccionadoController=PokemonSeleccionadoController()
    var seleccionDePokemonController=SeleccionDePokemonController()

    var pokecapturado=PokeEnemy("","",0,0,0,true,0)

    fun enviarDatosMochila(seleccionMohcilaController: PokemonSeleccionadoController){
        this.pokemonSeleccionadoController=seleccionMohcilaController
    }
    fun enviarDatosMochila2(seleccionMochilaController: SeleccionDePokemonController){
        this.seleccionDePokemonController=seleccionMochilaController
    }

    fun cargarPokemonMochila(pokemon :PokeEnemy) {
        pokemon.capturado=true
        pokecapturado = pokemon
    }

}