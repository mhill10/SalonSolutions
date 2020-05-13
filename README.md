# Matthew Hill Individual Project: Salon Solutions

This repository will serve as the showcase for Matthew Hill's Enterprise Java Individual Project: Salon Solutions...
a web-based platform for salon individual owners/hairstylists and their clientele.

Initial Video walkthrough demo (as of Monday, May 11, 2020): https://youtu.be/s-FcfY1Ctl0
Final Video Update (as of Wednesday, May 13, 2020): https://youtu.be/f1spV_ETeCU


### Problem Statement
For decades, Salon Owners and Stylists have been at the mercy of scheduling and training softwares
that often only partially serve their needs.  Often, software that would best serve such needs is
not affordable from an individual or small-business standpoint. Furthermore, whatever software in
this realm that is affordable does not fully account for the nuances of a Salon Owner/Stylist
experience, especially in this recent rapid expansion of sole proprietorships (booth/chair
rentals) that are taking the place of the traditional "Employer-Employee"/"Salon Owner with Many Stylists" Salon model.

For example, major players in this arena include Envision and Rosy, the desktop versions of which
are not priced within reach for many small, one-person Salon operations. Furthermore, the slightly more
affordable "Cloud" versions showcase lackluster performance and user experience for Stylists and
Salon Owners alike, especially on mobile devices.  This is often because such solutions emanate from
a "one size fits all" approach that is marketed to not only beauty salons, but spas, yoga studios,
fitness centers, massage parlors, and other business that, although similar in structure, are different
enough to make the user experience for Salon stakeholders feel "clunky" and under-served.

Furthermore, these softwares, although they may help with scheduling and financial forecasting, are not
structured in a way to maximally promote the financial goals of the Salon Owners/Stylists.  Ideally, such
software would guide would-be Salon Salons to select appointment times that not only are convenient for said
salon, but that also serve to strategically benefit the stylists earning potential that day (per preferences/goals
specified in the back-end of the application).

For example, if the most lucrative service a stylist offers is a "Foil-Color-Cut" which takes a
minimum of 2.5 hours with a 45 minute break in the middle of the service for processing time, then
the software should seek to maximize the opportunities to book such services, while suggesting simpler
and less time-intensive services (like short-hair cuts) to take place during aforementioned processing
windows.  By taking financial goals and strategies into account during the scheduling process, instead
of defaulting to a "first-come, first-served" model, regardless of the service requested, the
Salon Owner and Stylist are empowered to maximize their earnings potential while still making their
best efforts to meet all client needs and requests, but at times that make sense for the Salon's schedule
as well as the client's schedule.

Stretch Goal: Lastly, Stylists need effective ways to communicate lessons via PDF and Video to their salons, to help
keep them looking their best between visits, as well as ways to track what said salons are saying about them on
social media/keep tabs on how a salon's look changes between Salon visits via the salon's social media
posts, so that a stylist might better advise on what to do about outgrowth, etc before a salon's next
appointment.  Seems that Facebook/Instagram/Google-YouTube integration of various levels of complexity might be
particularly advantageous for this purpose, as well as to make logging-in and booking appointments easier for salons.

I propose to create a web-based, Java 11 application that serves the purposes outlined above.


Existing Examples Named Above:
Envision: https://www.envisiongo.com/features.html#Client-Tracking
Rosy: https://www.rosysalonsoftware.com/?utm_source=Capterra&utm_medium=Salon&utm_campaign=Rosy_Home_Page&gdmsite=GetApp


Salon Solutions - Wireframe Drafts: https://app.moqups.com/izDhRK8VUK/view/page/aa9df7b72

### Project Technologies/Techniques
* Security/Authentication
  * Tomcat's JDBC Realm Authentication - j_security_check
  * Admin role: create/read/update/delete (CRUD) of all data
  * User role: create user (self as guest), create, edit, delete reservations, view previous and upcoming reservations, edit certain user profile data
  * All: anyone can view services offered, pricing, and About Us without requiring a login
* Database
  * MySQL
  * Store users and roles
  * Store all data for services offered with default timing and description, log of reservations to be parsed by userId for individual guests or as one large log for admin
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * Google Calendar API via Service Account Authorized to Add/Edit/Delete reservations on private Google Calendar on behalf of Web Application
* CSS
  * Bootstrap
* Data Validation
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at an info/debug level can be turned on to facilitate trouble-shooting.
* Hosting
  * AWS
* Independent Research Topic/s
* Continuous Integration - Continuous Deployment (CI-CD) using GitHub Actions to communicate to AWS EC2 Instance
* Virtual Hosting to point custom domain name to AWS EC2 Instance
* Unit Testing
    * JUnit tests to achieve 80%+ code coverage
* IDE: IntelliJ IDEA
