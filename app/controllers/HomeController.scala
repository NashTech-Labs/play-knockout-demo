package controllers

import javax.inject._

import play.api.libs.json._
import play.api.mvc._

case class User(firstName: String,
                lastName: String,
                email: String)

case class Location(lat: Double, long: Double)

class HomeController @Inject() extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def example = Action {
    Ok(views.html.user("example1"))
  }

  def observableExample = Action{
    Ok(views.html.observableExample("example2"))
  }

  def userDetail = Action {
    implicit val userInfo = new Writes[User] {
      def writes(user: User) = Json.obj(
        "firstName" -> user.firstName,
        "lastName" -> user.lastName,
        "email" -> user.email
      )
    }
    val user = Json.toJson(User("testfirst", "testLast", "test@example.com"))
    Ok(user)
  }

}
