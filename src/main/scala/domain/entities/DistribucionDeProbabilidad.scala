package domain.entities

type Resultado = (Suceso, Int)

class DistribucionDeProbabilidad(sucesos: Set[Resultado]) {

  def getSucesosPosibles(): Set[Suceso] = {
    sucesos.filter(resultado => resultado._2 != 0).map((suceso, _) => suceso)
  }

  def getProbabilidadDe(suceso: Suceso): Int = {
    sucesos.filter(suc => suc._1.eq(suceso)).head._2
  }
}

//abstract class DistribucionDeProbabilidad(sucesos: Set[Suceso]) {
//
//  var resultados: Set[Resultado]
//
//  def getSucesosPosibles(): Set[Suceso] = {
//    resultados.filter(resultado => resultado._2 != 0).map((suceso, _) => suceso)
//  }
//
//  def getProbabilidadDe(suceso: Suceso): Float = {
//    resultados.filter(suc => suc._1.eq(suceso)).head._2
//  }
//}
