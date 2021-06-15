package domain.entities

class ApuestaAbs(jugada: JugadaAbs, montoApostado: Int){
  def getJugada(): JugadaAbs = jugada
  def getMontoApostado(): Int = montoApostado
}
