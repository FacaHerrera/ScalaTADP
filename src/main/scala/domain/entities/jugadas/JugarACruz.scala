package domain.entities.jugadas

import domain.entities.Jugada

class JugadaACruz extends Jugada {
  def ponderarResultado(resultadoJuego: Int): (Int => Int) = {
    resultadoJuego match {
      case 0 => return (monto: Int) => monto * 2
      case 1 => return (monto: Int) => 0
    }
  }
}
