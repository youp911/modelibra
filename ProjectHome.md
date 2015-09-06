Modelibra is a software family of tools and frameworks to support domain-driven development in Java: a graphical tool for model design and code generation, a domain model framework, a web component framework based on Wicket for rapid development of dynamic web applications, and a GUI component framework based on Swing for rapid development of dynamic client applications. The family backbone is the domain model framework that carries the family name.

Modelibra is well suited for prototypes and student projects. The creator of Modelibra is eager to help professors that are willing to use Modelibra in their courses.

How to start using Modelibra?

First, install the latest version of Java JDK. Second, install the latest version of Eclipse IDE for Java Developers. Third, install the latest version of the Eclipse plugin for the Subversion repository called Subclipse: Help/Install New Software.../Eclipse update site URL for Subclipse.

Finally, open two new perspectives in Eclipse by using Window/Open Perspective/Other... :

> SVN Repository Exploring

> Team Synchronizing

In the SVN perspective connect to the Modelibra's repository by using File/New/Other.../SVN/Checkout projects from SVN/Next :

> Create a new repository location/Next

> URL: http://modelibra.googlecode.com/svn/trunk/

> In the trunk directory, select an Eclipse project (a folder with the .project file)

> Check out first ModelibraWicketCss and ModelibraWicketSkeleton projects

> In other projects run copy-css.xml and copy-lib.xml Ant scripts for missing files

> Check out Doc/ModelibraIntroBook and read it with OpenOffice.


