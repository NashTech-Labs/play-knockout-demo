package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */

case class User(firstName: String,
                lastName: String,
                email: String)

case class Location(lat: Double, long: Double)

class HomeController @Inject() extends Controller {

  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
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
