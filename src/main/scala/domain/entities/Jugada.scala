package domain.entities
import domain.entities.Juego

abstract class Jugada {
  def ponderarResultado(resultadoJuego: Int): (Int => Int)
}


