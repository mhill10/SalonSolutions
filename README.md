# Matthew Hill Individual Project: Salon Solutions

This repository will serve as the showcase for Matthew Hill's Enterprise Java Individual Project: Salon Solutions...
a web-based platform for salon owners, their aspiring stylists, and clientele.


### Problem Statement
For decades, Salon Owners and Stylists have been at the mercy of scheduling and training software
that often only partially serves their needs.  Often, software that would best serve such needs is
not affordable from an individual or small business standpoint. Furthermore, whatever software in
this realm that is affordable does not fully account for the nuances of a Salon Owner/Stylist
experience, especially in this recent rapid expansion of sole proprietorships (booth/chair
rentals) that are taking the place of the traditional "Employer-Employee" Salon model.

For example, major players in this arena include Envision and Rosy, the desktop versions of which
are not priced within reach for many Salon owners, and whose affordable "Cloud" versions
showcase lackluster performance and user experience for Stylists and Salon Guests alike, especially
on mobile devices.  This is often because such solutions are "one size fits all" applications that
 are marketed to not only beauty salons, but spas, yoga and fitness centers, massage parlors, and
 other business that, although similar in structure, are different enough to make the user
 experience feel "clunky" and under-served.  Moreover, feature requests from users are often
 ignored by such companies, including requests to better protect/anonymize Stylists for online
 booking via an optional "Nickname", rather than posting said Stylists' proper names to the web
 (which can lead to unwanted and potentially dangerous attention).

Lastly, these softwares, although they may help with scheduling and financial forecasting, are not
structured in a way to maximally promote the financial goals of neither the Salon Owner, nor the
stylist(s).  Ideally, such software would help guide stylists and guests to make reservations in
such a way so as to maximize the time and earning potential of each stylist (per preferences/goals
specified in the back-end of the application).

For example, if the most lucrative service a stylist offers is a "Foil-Color-Cut" which takes a
minimum of 2.5 hours with a 45 minutes break in the middle of the service for processing time, then
the software should seek to maximize the opportunities to book such services, while suggesting simpler
and less time-intensive services (like men's cuts) to take place during aforementioned processing
windows.  By taking financial goals and strategies into account during the scheduling process, instead
of defaulting to a "first-come, first-served" model, regardless of the service requested, the
Salon Owner and Stylist are empowered to maximize their earnings potential while still making their
best efforts to meet all client needs and requests, but at times that make sense for the Salon's schedule
as well as the client's schedule.

Lastly, Owners need effective ways to communicate lessons via PDF and Video to their employees, so
as to promote a "culture of education" within their Salon, keeping all team members up
with the latest styles and trends.

I propose to create a web-based, Java 8 application that serves the purposes outlined above.


Existing Examples Named Above:
Envision: https://www.envisiongo.com/features.html#Client-Tracking
Rosy: https://www.rosysalonsoftware.com/?utm_source=Capterra&utm_medium=Salon&utm_campaign=Rosy_Home_Page&gdmsite=GetApp


Salon Solutions - Wireframe Drafts: https://app.moqups.com/izDhRK8VUK/view/page/aa9df7b72

### Project Technologies/Techniques
* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/read/update/delete (crud) of all data
  * User role: create trail, create trail report, edit data they have entered previously
  * All: anyone can view trail information (no login)
* Database
  * MySQL
  * Store users and roles
  * Store all data for the trails and reports
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * NOAA for weather conditions at a trail location, including snow depth
* CSS
  * Bootstrap or Materialize
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting.
* Hosting
  * AWS
* Independent Research Topic/s
  * CI tools in AWS
  * Materialize