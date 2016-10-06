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

  def observableExample = Action{
    Ok(views.html.observableExample("observable example"))
  }

  def visibleBinding =Action{
    Ok(views.html.visibleBinding("visible binding example"))
  }

  def htmlBinding =Action{
    Ok(views.html.htmlBinding("htnl binding example"))
  }

  def foreachBinding =Action{
    Ok(views.html.foreachBinding("foreach binding example"))
  }

  def customBinding = Action {
    Ok(views.html.customBinding("custom binding"))
  }

  def studentsDetails = Action {
    Ok(views.html.student("student details"))
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
