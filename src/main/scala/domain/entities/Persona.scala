package domain.entities

class Persona (var edad: Integer, var dinero: Integer){

  def cumpliAnio = {
    edad += 1
  }
  
}
