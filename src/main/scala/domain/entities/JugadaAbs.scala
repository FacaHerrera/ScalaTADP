package domain.entities

class JugadaAbs(ganadora: (Int => Int), perdedora: (Int => Int), apostado: Suceso) {
  def ponderarResultado(resultadoJuego: Suceso): (Int => Int) = {
    resultadoJuego match {
      case `apostado` => ganadora
      case _ => perdedora
    }
  }
}
