package domain

import domain.entities._
import domain.entities.jugadas._
import domain.entities.juegos._
import org.junit.Test
import org.junit.Assert._
import org.junit.Before
import domain.entities.DistribucionDeProbabilidad
import domain.entities.resultadosCaraOCruz.{Cara, Cruz}

class CaraOCruzTest {
  var persona:Persona = null
  var jugarACara: Jugada = null
  var apostarACara: Apuesta = null
  var caraOCruz: CaraOCruz = null
  var distribucionNormal: DistribucionDeProbabilidad = null
  var cara: Resultado = null
  var cruz: Resultado = null
  var jugarACruz: JugadaAbs = null
  var apostarACruz: ApuestaAbs = null

  @Before
  def setup() = {
    cara = (Cara, 50)
    cruz = (Cruz, 50)

    jugarACara = new JugadaACara();
    apostarACara = new Apuesta(jugarACara, 2000)

    jugarACruz = new JugadaAbs((monto: Int) => monto * 2, (monto: Int) => 0, Cruz)
    apostarACruz = new ApuestaAbs(jugarACruz, 4000)

    distribucionNormal = new DistribucionDeProbabilidad(Set(cara, cruz))
    caraOCruz = new CaraOCruz(distribucionNormal)
  }

  @Test
  def duplicarJugandoACara_test() = {
    var funcion: Int => Int =  jugarACara.ponderarResultado(1)
    assertEquals(2000, funcion.apply(1000))
  }

  @Test
  def perderJugandoACara_test() = {
    var funcion: Int => Int =  jugarACara.ponderarResultado(0)
    assertEquals(0, funcion.apply(1000))
  }

  @Test
  def duplicarApostandoACara_test() = {
    var funcion: Int => Int =  apostarACara.getJugada().ponderarResultado(1)
    assertEquals(4000, funcion.apply(apostarACara.getMontoApostado()))
  }

  @Test
  def perderApostandoACara_test() = {
    var funcion: Int => Int =  apostarACara.getJugada().ponderarResultado(0)
    assertEquals(0, funcion.apply(apostarACara.getMontoApostado()))
  }

  @Test
  def elCaraOCruzTiene2SucesosPosibles_test() = {
    var dist: DistribucionDeProbabilidad = caraOCruz.getDistribucion()
    assertEquals(2, dist.getSucesosPosibles().size)
    assertEquals(Cara, dist.getSucesosPosibles().head)
  }

  @Test
  def laProbaDeQueSalgaCaraEs50_test() = {
    var dist: DistribucionDeProbabilidad = caraOCruz.getDistribucion()
    assertEquals(50, dist.getProbabilidadDe(Cara))
  }

  @Test
  def ganaJugandoACruzConGenerica_test() = {
    var funcion: Int => Int =  apostarACruz.getJugada().ponderarResultado(Cruz)
    assertEquals(8000, funcion.apply(apostarACruz.getMontoApostado()))
  }

  @Test
  def pierdeJugandoACruzConGenerica_test() = {
    var funcion: Int => Int =  apostarACruz.getJugada().ponderarResultado(Cara)
    assertEquals(0, funcion.apply(apostarACruz.getMontoApostado()))
  }

}