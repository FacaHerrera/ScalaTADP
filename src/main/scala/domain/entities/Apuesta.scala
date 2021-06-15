package domain.entities

import domain.entities.Jugada

class Apuesta(jugada: Jugada, montoApostado: Int){
  def getJugada(): Jugada = return jugada
  def getMontoApostado(): Int = return montoApostado
}
